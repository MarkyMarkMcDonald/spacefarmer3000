/**
 * File comment here, bro
 */

package app.view;

import app.factory.UniverseFactory;
import app.model.Game;
import app.model.universe.Planet;
import app.model.universe.PlanetarySystem;
import conf.GameVariables;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class acts as the screen handling travel between planets and systems.
 * 
 * @author Andrew Wilder
 * @version 1.0
 */
public class IntersystemTravelScreen extends Screen implements MouseListener {

	/**
	 * Prevent serializable warning.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public IntersystemTravelScreen() {
		name = CardName.INTERSYSTEM_TRAVEL_CARD;
		doNonFinalMethods(this);
	}
	
	/**
	 * Perform non-final methods for the constructor.
	 * @param its The IntersystemTravelScreen to construct.
	 */
	private final static void doNonFinalMethods(IntersystemTravelScreen its) {
		its.addMouseListener(its);
	}

	/**
	 * Draw a grid with the quadrants for the universe, and each system in the
	 * quadrants.
	 */
	private static final int PLANET_SIZE = 30, PLANET_SIZE_HALF = PLANET_SIZE >> 1,
			THREE = 3;
	
	/** Static final double values */
	private static final double ROUND_HALF = 0.5, DIAMETER1 = 0.75;

	/** Colors used when drawing the planets */
	private static final Color[] PLANET_COLORS = { Color.BLUE, Color.GRAY,
			Color.GREEN, Color.ORANGE, Color.RED, Color.CYAN, Color.DARK_GRAY,
			Color.LIGHT_GRAY };

	/** A mapping of Points onto Planets at their location used for capturing clicks */
	private static Map<Point, Planet> PlanetLocations;

	/** The currently selected planet (by clicking) */
	private static Planet SelectedPlanet;

	/**
	 * Draw the universe.
	 * @param g The Graphics context onto which the universe will be drawn.
	 */
	@Override
	public void paintComponent(Graphics g) {

		// Draw black over the background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

		// Draw the planetary systems
		ArrayList[][] systemList = 
			new ArrayList[GameVariables.UNIVERSE_ROWS][GameVariables.UNIVERSE_COLUMNS];
		PlanetLocations = new HashMap<Point, Planet>();
		for (int i = 0; i < GameVariables.UNIVERSE_ROWS; ++i) {
			for (int j = 0; j < GameVariables.UNIVERSE_COLUMNS; ++j) {
				systemList[i][j] = new ArrayList<PlanetarySystem>();
			}
		}
		for (PlanetarySystem ps : UniverseFactory.getPlanetarySystems()
				.values()) {
			systemList[ps.getY() / GameVariables.QUADRANT_Y_DIMENSION][ps.getX()
					/ GameVariables.QUADRANT_X_DIMENSION].add(ps);
		}
		for (int i = 0; i < GameVariables.UNIVERSE_ROWS; ++i) {
			for (int j = 0; j < GameVariables.UNIVERSE_COLUMNS; ++j) {
				if (systemList[i][j].size() == 1) {
					g.setColor(Color.WHITE);

					// Get dimensions of the system to draw
					PlanetarySystem ps = (PlanetarySystem) systemList[i][j]
							.get(0);
					int sysX = (int) ((ROUND_HALF + j) * getWidth() / 
							GameVariables.UNIVERSE_COLUMNS);
					int sysY = (int) ((ROUND_HALF + i) * getHeight() / 
							GameVariables.UNIVERSE_ROWS);
					int sysD = (int) (DIAMETER1 * Math.min(getWidth()
							/ GameVariables.UNIVERSE_COLUMNS, getHeight()
							/ GameVariables.UNIVERSE_ROWS));
					g.drawOval(sysX - (sysD >> 1), sysY - (sysD >> 1), sysD, sysD);
					g.drawString(ps.getName(),
							sysX - ps.getName().length() * THREE, sysY);

					// Draw the planets
					double thetaS = Math.PI / 4;
					for (Planet p : ps.getPlanets().values()) {
						int planX = (int) (sysX + Math.cos(thetaS) * (sysD / 2));
						int planY = (int) (sysY + Math.sin(thetaS) * (sysD / 2));
						g.setColor(PLANET_COLORS[Math
								.abs(p.getName().hashCode())
								% PLANET_COLORS.length]);
						g.fillOval(planX - PLANET_SIZE_HALF, planY - PLANET_SIZE
								/ 2, PLANET_SIZE, PLANET_SIZE);
						g.setColor(Color.WHITE);
						g.drawString(p.getName(), planX + PLANET_SIZE_HALF + 5,
								planY);
						thetaS += Math.PI * 2 / ps.getPlanets().values().size();

						// Add planet location to ArrayList for capturing mouse
						// clicks on it
						PlanetLocations.put(new Point(planX, planY), p);

						// If this is the planet the ship is on, draw the ship
						if (Game.getCurrentPlanet().equals(p)) {
							int[] polyX = { planX, planX + 10, planX,
									planX - 10 }, polyY = { planY - 10,
									planY + 10, planY, planY + 10 };
							g.setColor(Color.BLACK);
							g.fillPolygon(polyX, polyY, 4);
							g.setColor(Color.CYAN);
							g.drawOval(planX - PLANET_SIZE_HALF - 5, planY
									- PLANET_SIZE_HALF - 5, PLANET_SIZE + 10,
									PLANET_SIZE + 10);
						}
					}
				} else {

					// Locate the center of this quadrant
					int qX = (int) ((0.5 + j) * getWidth() / 
							GameVariables.UNIVERSE_COLUMNS);
					int qY = (int) ((0.5 + i) * getHeight() / GameVariables.UNIVERSE_ROWS);
					int qD = (int) (0.7 * Math.min(getWidth()
							/ GameVariables.UNIVERSE_COLUMNS, getHeight()
							/ GameVariables.UNIVERSE_ROWS));

					// For each system...
					double thetaQ = Math.PI / 4;
					for (Object o : systemList[i][j]) {
						g.setColor(Color.WHITE);
						PlanetarySystem ps = (PlanetarySystem) o;

						// Get dimensions of the system to draw
						int sysX = (int) (qX + Math.cos(thetaQ) * (qD / 2));
						int sysY = (int) (qY + Math.sin(thetaQ) * (qD / 2));
						int sysD = qD * 3 / 5;
						g.drawOval(sysX - sysD / 2, sysY - sysD / 2, sysD, sysD);
						g.drawString(ps.getName(), sysX - ps.getName().length()
								* 3, sysY);

						// Draw the planets
						double thetaS = Math.PI / 4;
						for (Planet p : ps.getPlanets().values()) {
							int planX = (int) (sysX + Math.cos(thetaS)
									* (sysD / 2));
							int planY = (int) (sysY + Math.sin(thetaS)
									* (sysD / 2));
							g.setColor(PLANET_COLORS[Math.abs(p.getName()
									.hashCode()) % PLANET_COLORS.length]);
							g.fillOval(planX - PLANET_SIZE_HALF, planY
									- PLANET_SIZE_HALF, PLANET_SIZE, PLANET_SIZE);
							g.setColor(Color.WHITE);
							g.drawString(p.getName(), planX + PLANET_SIZE_HALF
									+ 5, planY);
							thetaS += Math.PI * 2
									/ ps.getPlanets().values().size();

							// Add planet location to ArrayList for capturing
							// mouse clicks on it
							PlanetLocations.put(new Point(planX, planY), p);

							// If this is the planet the ship is on, draw the
							// ship
							if (Game.getCurrentPlanet().equals(p)) {
								int[] polyX = { planX, planX + 10, planX,
										planX - 10 }, polyY = { planY - 10,
										planY + 10, planY, planY + 10 };
								g.setColor(Color.BLACK);
								g.fillPolygon(polyX, polyY, 4);
								g.setColor(Color.CYAN);
								g.drawOval(planX - PLANET_SIZE_HALF - 5, planY
										- PLANET_SIZE_HALF - 5,
										PLANET_SIZE + 10, PLANET_SIZE + 10);
							}
						}
						thetaQ += Math.PI * 2 / systemList[i][j].size();
					}
				}
			}
		}
	}

	/**
	 * Captures mouse clicks to determine if a planet has been clicked.
	 * 
	 * @param e
	 *            The data associated with this mouse click.
	 */
	public void mousePressed(MouseEvent e) {
		boolean clickedPlanet = false;

		// Iterate over each point
		for (Point p : PlanetLocations.keySet()) {
			if (p.distance(e.getX(), e.getY()) < PLANET_SIZE_HALF) {
				clickedPlanet = true;

				SelectedPlanet = PlanetLocations.get(p);

				Display.updatePlanetTravelInfo(SelectedPlanet);
			}
		}

		// If a planet wasn't clicked, deselect planet
		if (!clickedPlanet) {
			SelectedPlanet = null;
			repaint();
		}
	}

	/**
	 * Unused.
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.print("");
	}

	/**
	 * Unused.
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		System.out.print("");
	}

	/**
	 * Unused.
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		System.out.print("");
	}

	/**
	 * Unused.
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {
		System.out.print("");
	}
}
