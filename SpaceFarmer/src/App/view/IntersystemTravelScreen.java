package App.view;

import App.factory.UniverseFactory;
import App.model.Game;
import App.model.Universe.Planet;
import App.model.Universe.PlanetarySystem;
import Conf.GameVariables;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class acts as the screen handling travel between planets and systems. (WIP)
 * @author Andrew Wilder
 */
public class IntersystemTravelScreen extends Screen implements MouseListener {

	/**
	 * Create the panel.
	 */
	public IntersystemTravelScreen() {
		name = CardName.INTERSYSTEM_TRAVEL_CARD;
		addMouseListener(this);
	}

	/**
	 * Draw a grid with the quadrants for the universe, and each system in the quadrants.
	 */
	private static final int PLANET_SIZE = 30;
	private static final Color[] planetColors = {Color.BLUE,Color.GRAY,Color.GREEN,Color.ORANGE,Color.RED,Color.CYAN,Color.DARK_GRAY,Color.LIGHT_GRAY};
	private static Map<Point, Planet> planetLocations;
	private static Planet selectedPlanet;
	public void paintComponent(Graphics g) {
		
		// Draw black over the background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		// Draw the planetary systems
		ArrayList[][] systemList = new ArrayList[GameVariables.universeRows][GameVariables.universeColumns];
		planetLocations = new HashMap<Point, Planet>();
		for(int i = 0; i < GameVariables.universeRows; ++i) {
			for(int j = 0; j < GameVariables.universeColumns; ++j) {
				systemList[i][j] = new ArrayList<PlanetarySystem>();
			}
		}
		for(PlanetarySystem ps : UniverseFactory.getPlanetarySystems().values()) {
			systemList[ps.getY() / GameVariables.quadrantYDimension][ps.getX() / GameVariables.quadrantXDimension].add(ps);
		}
		for(int i = 0; i < GameVariables.universeRows; ++i) {
			for(int j = 0; j < GameVariables.universeColumns; ++j) {
				if(systemList[i][j].size() == 1) {
					g.setColor(Color.WHITE);
					
					// Get dimensions of the system to draw
					PlanetarySystem ps = (PlanetarySystem)systemList[i][j].get(0);
					int sysX = (int)((0.5 + j) * getWidth() / GameVariables.universeColumns);
					int sysY = (int)((0.5 + i) * getHeight() / GameVariables.universeRows);
					int sysD = (int)(0.75 * Math.min(getWidth() / GameVariables.universeColumns, getHeight() / GameVariables.universeRows));
					g.drawOval(sysX - sysD / 2, sysY - sysD / 2, sysD, sysD);
					g.drawString(ps.getName(), sysX - ps.getName().length() * 3, sysY);
					
					// Draw the planets
					double thetaS = Math.PI / 4;
					for(Planet p : ps.getPlanets().values()) {
						int planX = (int)(sysX + Math.cos(thetaS) * (sysD / 2));
						int planY = (int)(sysY + Math.sin(thetaS) * (sysD / 2));
						g.setColor(planetColors[Math.abs(p.getName().hashCode()) % planetColors.length]);
						g.fillOval(planX - PLANET_SIZE / 2, planY - PLANET_SIZE / 2, PLANET_SIZE, PLANET_SIZE);
						g.setColor(Color.WHITE);
						g.drawString(p.getName(), planX + PLANET_SIZE / 2 + 5, planY);
						thetaS += Math.PI * 2 / ps.getPlanets().values().size();
						
						// Add planet location to ArrayList for capturing mouse clicks on it
						planetLocations.put(new Point(planX, planY), p);
						
						// If this is the planet the ship is on, draw the ship
						if(Game.getCurrentPlanet().equals(p)) {
							int[] polyX = {planX, planX + 10, planX, planX - 10}, polyY = {planY - 10, planY + 10, planY, planY + 10};
							g.setColor(Color.BLACK);
							g.fillPolygon(polyX, polyY, 4);
							g.setColor(Color.CYAN);
							g.drawOval(planX - PLANET_SIZE / 2 - 5, planY - PLANET_SIZE / 2 - 5, PLANET_SIZE + 10, PLANET_SIZE + 10);
						}
						
						// If this is the currently selected planet, draw info
						// TODO draw planet info
					}
				} else {
					
					// Locate the center of this quadrant
					int qX = (int)((0.5 + j) * getWidth() / GameVariables.universeColumns);
					int qY = (int)((0.5 + i) * getHeight() / GameVariables.universeRows);
					int qD = (int)(0.7 * Math.min(getWidth() / GameVariables.universeColumns, getHeight() / GameVariables.universeRows));
				
					// For each system...
					double thetaQ = Math.PI / 4;
					for(Object o : systemList[i][j]) {
						g.setColor(Color.WHITE);
						PlanetarySystem ps = (PlanetarySystem)o;
						
						// Get dimensions of the system to draw
						int sysX = (int)(qX + Math.cos(thetaQ) * (qD / 2));
						int sysY = (int)(qY + Math.sin(thetaQ) * (qD / 2));
						int sysD = qD * 3 / 5;
						g.drawOval(sysX - sysD / 2, sysY - sysD / 2, sysD, sysD);
						g.drawString(ps.getName(), sysX - ps.getName().length() * 3, sysY);
						
						// Draw the planets
						double thetaS = Math.PI / 4;
						for(Planet p : ps.getPlanets().values()) {
							int planX = (int)(sysX + Math.cos(thetaS) * (sysD / 2));
							int planY = (int)(sysY + Math.sin(thetaS) * (sysD / 2));
							g.setColor(planetColors[Math.abs(p.getName().hashCode()) % planetColors.length]);
							g.fillOval(planX - PLANET_SIZE / 2, planY - PLANET_SIZE / 2, PLANET_SIZE, PLANET_SIZE);
							g.setColor(Color.WHITE);
							g.drawString(p.getName(), planX + PLANET_SIZE / 2 + 5, planY);
							thetaS += Math.PI * 2 / ps.getPlanets().values().size();
							
							// Add planet location to ArrayList for capturing mouse clicks on it
							planetLocations.put(new Point(planX, planY), p);
							
							// If this is the planet the ship is on, draw the ship
							if(Game.getCurrentPlanet().equals(p)) {
								int[] polyX = {planX, planX + 10, planX, planX - 10}, polyY = {planY - 10, planY + 10, planY, planY + 10};
								g.setColor(Color.BLACK);
								g.fillPolygon(polyX, polyY, 4);
								g.setColor(Color.CYAN);
								g.drawOval(planX - PLANET_SIZE / 2 - 5, planY - PLANET_SIZE / 2 - 5, PLANET_SIZE + 10, PLANET_SIZE + 10);
							}
							
							// If this is the currently selected planet, draw info
							// TODO draw planet info
						}
						thetaQ += Math.PI * 2 / systemList[i][j].size();
					}
				}
			}
		}
	}

	/**
	 * Captures mouse clicks to determine if a planet has been clicked.
	 * @param e The data associated with this mouse click.
	 */
	public void mousePressed(MouseEvent e) {
		boolean clickedPlanet = false;
		
		// Iterate over each point 
		for(Point p : planetLocations.keySet()) {
			if(p.distance(e.getX(), e.getY()) < PLANET_SIZE / 2) {
				clickedPlanet = true;
				
				// Player clicked on a planet
				if(planetLocations.get(p).equals(selectedPlanet)) {
					selectedPlanet = null;
					
					// TODO go to planet info page
					
					
					System.out.println("Going to planet info page for " + planetLocations.get(p).getName());
				} else {
					selectedPlanet = planetLocations.get(p);
					repaint();
					
					System.out.println("Selected planet " + planetLocations.get(p).getName());
				}
			}
		}
		
		// If a planet wasn't clicked, deselect planet
		if(!clickedPlanet) {
			selectedPlanet = null;
		}
	}
	
	public void mouseClicked(MouseEvent arg0) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
}
