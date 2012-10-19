import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.Timer;
import javax.swing.JPanel;


public class MiniGamePanel extends JPanel implements KeyListener, ActionListener {

	private static final long serialVersionUID = -8514340587959703646L;
	private static final int SHIP_SIZE = 64,
			                 ASTEROID_SIZE = 42,
			                 ASTEROID_COUNT = 30,
			                 SAFETY_DIST = 225,
							 SHIP_GFX_SIZE = 64,
							 ASTEROID_GFX_SIZE = 42;
	private static final double SPEED = 5.5,
			                    TURN_AMOUNT = 0.05,
			                    TOLERANCE = 7,
			                    ASTEROID_SPEED = 0.9,
	                            ASTEROID_ROTATION = 0.015;
	private ArrayList<Asteroid> asteroids;
	private double shipX, shipY, shipAngle; // degrees
	private Timer timer;
	private boolean holdingLeft, holdingRight;
	private MiniGameFrame frame;
	private BufferedImage shipGFX, asteroidGFX, bgGFX;
	
	public MiniGamePanel(MiniGameFrame frame) {
		this.frame = frame;
		timer = new Timer(30, this);
		setFocusable(true);
		addKeyListener(this);
		
		// Create graphics for drawing to screen
		File shipFile = new File("img\\Ship.png"), asteroidFile = new File("img\\Asteroid.png"), bgFile = new File("img\\BG.jpg");
		try {
			BufferedImage in1 = ImageIO.read(shipFile), in2 = ImageIO.read(asteroidFile), in3 = ImageIO.read(bgFile);
			shipGFX = new BufferedImage(in1.getWidth(), in1.getHeight(), BufferedImage.TYPE_INT_ARGB);
		    asteroidGFX = new BufferedImage(in2.getWidth(), in2.getHeight(), BufferedImage.TYPE_INT_ARGB);
		    bgGFX = new BufferedImage(in3.getWidth(), in3.getHeight(), BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2d = shipGFX.createGraphics();
			g2d.drawImage(in1, 0, 0, null);
			g2d = asteroidGFX.createGraphics();
			g2d.drawImage(in2, 0, 0, null);
			g2d = bgGFX.createGraphics();
			g2d.drawImage(in3, 0, 0, null);
			g2d.dispose();
		} catch (IOException e) {
			System.out.println("File IO error while loading graphics!");
			this.shipGFX = new BufferedImage(SHIP_GFX_SIZE, SHIP_GFX_SIZE, BufferedImage.TYPE_INT_ARGB);
			this.asteroidGFX = new BufferedImage(ASTEROID_GFX_SIZE, ASTEROID_GFX_SIZE, BufferedImage.TYPE_INT_ARGB);
		}
	}
	
	public void setup() {
		shipX = SHIP_SIZE / 2 + ASTEROID_SIZE;
		shipY = getHeight() / 2;
		shipAngle = 0;
		asteroids = new ArrayList<Asteroid>();
		holdingLeft = false;
		holdingRight = false;
		
		Random rand = new Random();
		for(int i = 0; i < ASTEROID_COUNT; ++i) {
			Point p = new Point(rand.nextInt(800), rand.nextInt(600));
			if(Point2D.distance(shipX, shipY, p.x, p.y) < SAFETY_DIST) {
				--i;
			} else {
				asteroids.add(new Asteroid(p.x, p.y, rand.nextDouble() * 2 * Math.PI, rand.nextDouble() * 2 * Math.PI, rand.nextBoolean()));
			}
		}
	}
	
	public boolean playGame() {
		timer.start();
		requestFocus();
		return true;
	}
	
	private void endGame(boolean success) {
		timer.stop();
		frame.returnToTitle(success);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D screen = (Graphics2D)g;
		screen.setColor(Color.BLACK);
		//screen.fillRect(0, 0, getWidth(), getHeight());
		screen.drawImage(bgGFX, 0, 0, null);
		screen.setColor(Color.WHITE);
		
		// Draw asteroids
		for(Asteroid a : asteroids) {
			//screen.fillOval((int)(a.x - ASTEROID_SIZE / 2), (int)(a.y - ASTEROID_SIZE / 2), ASTEROID_SIZE, ASTEROID_SIZE);
			AffineTransform orig = screen.getTransform();
			screen.rotate(a.r, (int)a.x, (int)a.y);
			screen.drawImage(asteroidGFX, (int)(a.x - ASTEROID_SIZE / 2), (int)(a.y - ASTEROID_SIZE / 2), null);
			screen.setTransform(orig);
		}
		
		// Draw ship
		screen.setColor(Color.BLUE);
		//screen.fillOval((int)(shipX - SHIP_SIZE / 2), (int)(shipY - SHIP_SIZE / 2), SHIP_SIZE, SHIP_SIZE);
		AffineTransform orig = screen.getTransform();
		screen.rotate(shipAngle, shipX, shipY);
		screen.drawImage(shipGFX, (int)(shipX - SHIP_SIZE / 2), (int)(shipY - SHIP_SIZE / 2), null);
		screen.setTransform(orig);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Update ship angle
		if(holdingLeft) {
			shipAngle += 2 * Math.PI - TURN_AMOUNT;
		}
		if(holdingRight) {
			shipAngle += TURN_AMOUNT;
		}
		if(shipAngle > 2 * Math.PI) {
			shipAngle -= 2 * Math.PI;
		} else if(shipAngle < 0) {
			shipAngle += 2 * Math.PI;
		}
		
		// Update ship position
		shipX += Math.cos(shipAngle) * SPEED;
		shipY += Math.sin(shipAngle) * SPEED;
		
		// Used to remove asteroids that leave off the left side of the screen
		ArrayList<Asteroid> removeList = new ArrayList<Asteroid>();
		
		// Detect collision with asteroids and update their position
		for(Asteroid a : asteroids) {
			if(Point2D.distance(shipX, shipY, a.x, a.y) - (SHIP_SIZE + ASTEROID_SIZE) / 2 < -TOLERANCE) {
				endGame(false);
			} else {
				a.x += Math.cos(a.a) * ASTEROID_SPEED;
				// Leaving off the left removes the asteroid
				if(a.x < 0) {
					removeList.add(a);
				}
				// Leaving off the right wraps the asteroid
				a.x %= getWidth();
				// Leaving off the top or bottom wraps the asteroid
				a.y = (a.y + Math.sin(a.a) * ASTEROID_SPEED + getHeight()) % getHeight();
				
				// Rotate the asteroid
				if(a.direction) {
					a.r += ASTEROID_ROTATION;
					if(a.r >= 2 * Math.PI) {
						a.r -= 2 * Math.PI;
					}
				} else {
					a.r -= ASTEROID_ROTATION;
					if(a.r < 0) {
						a.r += 2 * Math.PI;
					}
				}
			}
		}
		
		// Remove asteroids that leave off the left side of the screen so they don't pop up on the right side and kill the player
		for(Asteroid a : removeList) {
			asteroids.remove(a);
		}
		
		// Detect flying out of bounds
		if(shipX + SHIP_SIZE / 2 < 0) {
			endGame(false);
		} else if(shipY + SHIP_SIZE / 2 < 0) {
			endGame(false);
		} else if(shipY - SHIP_SIZE / 2 > getHeight()) {
			endGame(false);
		} else if(shipX - SHIP_SIZE / 2 > getWidth()) {
			endGame(true);
		}
		
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			holdingLeft = true;
		} else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			holdingRight = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			holdingLeft = false;
		} else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			holdingRight = false;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {}

	private class Asteroid {
		public double x, y, a, r;
		boolean direction;
		public Asteroid(double x, double y, double a, double r, boolean direction) {
			this.x = x;
			this.y = y;
			this.a = a;
			this.r = r;
			this.direction = direction;
		}
	}
}
