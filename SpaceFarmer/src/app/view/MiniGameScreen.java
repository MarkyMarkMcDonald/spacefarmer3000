// $codepro.audit.disable lossOfPrecisionInCast, com.instantiations.assist.eclipse.analysis.unusedReturnValue

/* lossOfPrecisionInCast is disabled because the ship's coordinates, speed and direction
 * are stored as doubles, but they must be used as integers in calculations for drawing
 * to the screen. The most convenient way to do this is through casting, and the precision
 * loss in this context is negligible.
 * unusedReturnValue is disabled because the method Graphics.drawImage() returns a boolean
 * whose value is not necessary for program control, but unusedReturnValue complains that
 * all returned boolean values must be used.
 */

/**
 * This file contains the class code responsible for driving the minigame sequence when
 * traveling between different PlanetarySystems.
 */

package app.view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

import resources.MiniGameGFX;
import app.model.Game;
import app.view.sidepanels.MessageSidePanel;
import app.view.sidepanels.MessageType;

/**
 * This class drives the minigame sequence when traveling between planets.
 * 
 * @author Andrew Wilder
 * @version 1.0
 */
public class MiniGameScreen extends JPanel implements KeyListener,
		ActionListener {

	/** Prevents serializable warning */
	private static final long serialVersionUID = -3027504169648377464L;

	/**
	 * Provides interaction between the KeyListener and ActionListener
	 * functionalities of this class
	 */
	private boolean holdingLeft, holdingRight;

	/** Constants that govern the minigame's physics */
	private static final int SHIP_SIZE = 64, SHIP_SIZE_HALF = SHIP_SIZE >> 1,
			ASTEROID_SIZE = 42, ASTEROID_SIZE_HALF = ASTEROID_SIZE >> 1,
			ASTEROID_COUNT = 25, SAFETY_DIST = 200, SHIP_GFX_SIZE = 64,
			ASTEROID_GFX_SIZE = 42, SIMULATION_PERIOD = 30,
			ASTEROID_DENSITY_DIVISOR = 480000, STAR_DENSITY_DIVISOR = 480,
			ANOTHER_CONSTANT = (SHIP_SIZE + ASTEROID_SIZE) >> 1,
			NEGATIVE_ASTEROID_HALF = -ASTEROID_SIZE_HALF;

	/** Constants used by the game */
	private static final double SPEED_CAP = 5.5, TURN_AMOUNT = 0.055,
			TOLERANCE = 7.5, ASTEROID_SPEED = 1.35, ASTEROID_ROTATION = 0.015,
			SHIP_SPEED = 0.1, TWO_PI = 2 * Math.PI;

	/** An ArrayList to hold the Asteroid objects */
	private Collection<Asteroid> asteroids;

	/** An ArrayList to hold the stars for the generated background */
	private Collection<Point> stars;

	/** Variables that control the player's ship */
	private double shipX, shipY, shipAngle, shipSpeed;

	/** A Timer object meant to trigger frames of gameplay in the minigame */
	private final Timer timer;

	/** Instances of the graphics used by the minigame */
	private final BufferedImage shipGFX, asteroidGFX;

	/**
	 * Construct this minigame screen with the appropriate variables.
	 */
	public MiniGameScreen() {

		// Set up listeners
		timer = new Timer(SIMULATION_PERIOD, this);
		doNonStaticMethods(this);

		// Set up BufferedImage graphics
		asteroidGFX = new BufferedImage(ASTEROID_GFX_SIZE, ASTEROID_GFX_SIZE,
				BufferedImage.TYPE_INT_ARGB);
		asteroidGFX.setRGB(0, 0, asteroidGFX.getWidth(),
				asteroidGFX.getHeight(), MiniGameGFX.AsteroidGFX, 0,
				asteroidGFX.getWidth());
		shipGFX = new BufferedImage(SHIP_GFX_SIZE, SHIP_GFX_SIZE,
				BufferedImage.TYPE_INT_ARGB);
		shipGFX.setRGB(0, 0, shipGFX.getWidth(), shipGFX.getHeight(),
				MiniGameGFX.ShipGFX, 0, shipGFX.getWidth());
	}

	/**
	 * Perform the non-final methods required by the constructor.
	 * 
	 * @param mgs
	 *            The instance of MiniGameScreen to complete construction for.
	 */
	private static void doNonStaticMethods(MiniGameScreen mgs) {
		mgs.setFocusable(true);
		mgs.addKeyListener(mgs);
		mgs.setDoubleBuffered(true);
	}

	/**
	 * Simulate the gameplay for one frame.
	 * 
	 * @param e
	 *            The instance of ActionEvent associated with this event
	 *            trigger. Unused.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		// Update ship angle
		if (holdingLeft) {
			shipAngle += TWO_PI - TURN_AMOUNT;
		}
		if (holdingRight) {
			shipAngle += TURN_AMOUNT;
		}
		if (shipAngle > TWO_PI) {
			shipAngle -= TWO_PI;
		} else if (shipAngle < 0) {
			shipAngle += TWO_PI;
		}

		// Update ship speed
		if (shipSpeed < SPEED_CAP) {
			shipSpeed += SHIP_SPEED;
		}

		// Update ship position
		shipX += Math.cos(shipAngle) * shipSpeed;
		shipY += Math.sin(shipAngle) * shipSpeed;

		// Update the asteroid positions and detect collision with the ship
		updateAsteroids();

		// Detect flying out of bounds
		if (shipX + SHIP_SIZE_HALF < 0) {
			endGame(false);
		} else if (shipY + SHIP_SIZE_HALF < 0) {
			endGame(false);
		} else if (shipY - SHIP_SIZE_HALF > getHeight()) {
			endGame(false);
		} else if (shipX - SHIP_SIZE_HALF > getWidth()) {
			endGame(true);
		}

		repaint();
	}

	/**
	 * Update the asteroids' positions and determine collision with the ship.
	 */
	private void updateAsteroids() {
		// Detect collision with asteroids and update their position
		for (Object o : asteroids) {
			Asteroid ast = (Asteroid) o;
			if (Point2D.distance(shipX, shipY, ast.x, ast.y) - ANOTHER_CONSTANT <
					-TOLERANCE) {
				endGame(false);
			} else {
				ast.x += Math.cos(ast.angle) * ASTEROID_SPEED;

				// Leaving off the sides puts it in the middle, top or bottom
				if (ast.x + ASTEROID_SIZE_HALF < 0
						|| ast.x - ASTEROID_SIZE_HALF > getWidth()) {

					ast.x = getWidth() >> 1;
					if (ast.angle < Math.PI) {
						ast.y = ASTEROID_SIZE_HALF + getHeight();
					} else {
						ast.y = NEGATIVE_ASTEROID_HALF;
					}
				}
				ast.y += Math.sin(ast.angle) * ASTEROID_SPEED;

				// Leaving off the top or bottom wraps the asteroid
				if (ast.y + ASTEROID_SIZE_HALF < 0) {
					ast.y += ASTEROID_SIZE + getHeight();
				} else if (ast.y - ASTEROID_SIZE_HALF > getHeight()) {
					ast.y -= ASTEROID_SIZE + getHeight();
				}

				// Rotate the asteroid
				if (ast.direction) {
					ast.rotation += ASTEROID_ROTATION;
					if (ast.rotation >= TWO_PI) {
						ast.rotation -= TWO_PI;
					}
				} else {
					ast.rotation -= ASTEROID_ROTATION;
					if (ast.rotation < 0) {
						ast.rotation += TWO_PI;
					}
				}
			}
		}
	}

	/**
	 * Draw the graphics of the entities for the game.
	 * 
	 * @param g
	 *            The instance of Graphics object associated with this
	 *            Component.
	 */
	@Override
	public void paintComponent(Graphics g) {

		// Draw the background graphics
		final Graphics2D screen = (Graphics2D) g;
		screen.setColor(Color.BLACK);
		screen.fillRect(0, 0, getWidth(), getHeight());
		screen.setColor(Color.WHITE);
		for (Object o : stars) {
			Point point = (Point) o;
			screen.drawRect(point.x, point.y, 0, 0);
		}

		// Draw asteroids
		for (Object o : asteroids) {
			Asteroid ast = (Asteroid) o;
			AffineTransform orig = screen.getTransform();
			screen.rotate(ast.rotation, (int) ast.x, (int) ast.y);
			screen.drawImage(asteroidGFX, (int) (ast.x - ASTEROID_SIZE_HALF),
					(int) (ast.y - ASTEROID_SIZE_HALF), null);
			screen.setTransform(orig);
		}

		// Draw ship
		final AffineTransform orig = screen.getTransform();
		screen.rotate(shipAngle, shipX, shipY);
		screen.drawImage(shipGFX, (int) (shipX - SHIP_SIZE_HALF),
				(int) (shipY - SHIP_SIZE_HALF), null);
		screen.setTransform(orig);

		// Clean up
		Toolkit.getDefaultToolkit().sync();
		screen.dispose();
	}

	/**
	 * Set up the initial variable values and Asteroid list, then start the
	 * simulation.
	 */
	public void startGame() {

		// Set up the variables used by the minigame
		shipX = SHIP_SIZE_HALF;
		shipY = getHeight() >> 1;
		shipAngle = 0;
		shipSpeed = 0;
		asteroids = new ArrayList<Asteroid>();
		stars = new ArrayList<Point>();
		holdingLeft = false;
		holdingRight = false;

		// Randomize the initial locations of the Asteroids
		final Random rand = new Random();
		for (int i = 0; i < ASTEROID_COUNT * getWidth() * getHeight()
				/ ASTEROID_DENSITY_DIVISOR; ++i) {
			Point point = new Point(rand.nextInt(getWidth()),
					rand.nextInt(getHeight()));
			if (Point2D.distance(shipX, shipY, point.x, point.y) < SAFETY_DIST) {
				--i;
			} else {
				asteroids.add(new Asteroid(point.x, point.y, rand.nextDouble()
						* TWO_PI, rand.nextDouble() * TWO_PI, rand
						.nextBoolean()));
			}
		}

		// Generate stars
		for (int i = 0; i < getWidth() * getHeight() / STAR_DENSITY_DIVISOR; ++i) {
			stars.add(new Point(rand.nextInt(getWidth()), rand
					.nextInt(getHeight())));
		}

		// Start the simulation and focus the keyboard input on this panel
		timer.start();
	}

	/**
	 * Ends the game; called by the actionPerformed method.
	 * 
	 * @param success
	 *            true if the Player won, false if they crashed or flew out of
	 *            bounds.
	 */
	private void endGame(boolean success) {
		timer.stop();
		final MessageSidePanel messageSidePanel = (MessageSidePanel) Display
				.getSidePanel("Top");
		String message = "You traveled to Planet "
				+ Game.getCurrentPlanet().getName() + ".";
		if (!success) {
			message += " Unfortunately, you had to use extra fuel "
					+ "after hitting an asteroid.";
		}
		messageSidePanel.setMessage(message, success ? MessageType.GOOD
				: MessageType.BAD);
		Display.exitGame();
	}

	/**
	 * Tells the timer-triggered actionPerformed() method to rotate the ship, if
	 * left or right is pressed.
	 * 
	 * @param e
	 *            The instance of KeyEvent associated with this event call.
	 */
	@Override
	public void keyPressed(KeyEvent e) {

		// Determine if the player pressed either left or right
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			holdingLeft = true;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			holdingRight = true;
		}
	}

	/**
	 * Tells the timer-triggered actionPerformed() method to stop rotating the
	 * ship, if left or right is released.
	 * 
	 * @param e
	 *            The instance of KeyEvent associated with this event call.
	 */
	@Override
	public void keyReleased(KeyEvent e) {

		// Determine if the player released either left or right
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			holdingLeft = false;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			holdingRight = false;
		}
	}

	/**
	 * This method is unused; it exists to fulfill the implementation of
	 * KeyListener.
	 * 
	 * @param arg0
	 *            The instance of KeyEvent associated with this event call.
	 */
	@Override
	public void keyTyped(KeyEvent arg0) {
		// There HAS to be something here or CodePro complains.
		System.out.print("");
	}

	/**
	 * This inner class is simply an association of doubles and a boolean that
	 * make up the properties of an Asteroid object on the minigame screen.
	 * 
	 * @author Andrew Wilder
	 */
	private static class Asteroid {

		/**
		 * X position, Y position, angle of travel (radians), rotational amount
		 * (radians)
		 */
		public double x, y, angle, rotation;

		/** Direction the Asteroid is spinning */
		public boolean direction;

		/**
		 * This constructor creates a new Asteroid object from specified
		 * parameters.
		 * 
		 * @param x
		 *            The initial X position of the Asteroid.
		 * @param y
		 *            The initial Y position fo the Asteroid.
		 * @param a
		 *            The initial direction (in radians) that the Asteroid will
		 *            travel in.
		 * @param r
		 *            The initial rotational amount (in radians) from which the
		 *            Asteroid begins spinning.
		 * @param direction
		 *            The direction the Asteroid will spin.
		 */
		protected Asteroid(double x, double y, double a, double r,
				boolean direction) {
			this.x = x;
			this.y = y;
			this.angle = a;
			this.rotation = r;
			this.direction = direction;
		}

		/**
		 * @return Information about this object as a String.
		 */
		public String toString() {
			return "Asteroid";
		}
	}

	/**
	 * @return Information about this object as a String.
	 */
	@Override
	public String toString() {
		return "MiniGameScreen";
	}
}
