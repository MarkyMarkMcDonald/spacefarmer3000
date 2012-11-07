package App.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;

import javax.swing.*;

import App.factory.UniverseFactory;
import App.model.Game;
import App.model.Planet;
import App.model.PlanetarySystem;
import Conf.GameVariables;

/**
 * This class acts as the screen handling travel between planets and systems. (WIP)
 * @author Andrew Wilder
 */
public class IntersystemTravelScreen extends Screen {

	/**
	 * Create the panel.
	 */
	public IntersystemTravelScreen() {
		name = CardName.INTERSYSTEM_TRAVEL_CARD;
//      JLabel tempLabel = new JLabel("A random picture of planets should be here");
//      add(tempLabel);
	}

	/**
	 * Draw a grid with the quadrants for the universe, and each system in the quadrants.
	 */
	private static final int PLANET_SIZE = 30;
	private static final Color[] planetColors = {Color.BLUE,Color.GRAY,Color.GREEN,Color.ORANGE,Color.RED,Color.CYAN,Color.DARK_GRAY,Color.LIGHT_GRAY};
	public void paintComponent(Graphics g) {
		
		// Draw black over the background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		// Draw quadrant lines
		g.setColor(Color.WHITE);
		for(int i = 1; i < GameVariables.universeColumns; ++i) {
			g.drawLine(i * getWidth() / GameVariables.universeColumns, 0, i * getWidth() / GameVariables.universeColumns, getHeight() - 1);
		}
		for(int i = 1; i < GameVariables.universeRows; ++i) {
			g.drawLine(0, i * getHeight() / GameVariables.universeRows, getWidth() - 1, i * getHeight() / GameVariables.universeRows);
		}
		
		// Draw the planetary systems
		ArrayList[][] systemList = new ArrayList[GameVariables.universeRows][GameVariables.universeColumns];
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
						
						// If this is the planet the ship is on, draw the ship
						if(Game.getCurrentPlanet().equals(p)) {
							int[] polyX = {planX, planX + 10, planX, planX - 10}, polyY = {planY - 10, planY + 10, planY, planY + 10};
							g.setColor(Color.BLACK);
							g.fillPolygon(polyX, polyY, 4);
							g.setColor(Color.CYAN);
							g.drawOval(planX - PLANET_SIZE / 2 - 5, planY - PLANET_SIZE / 2 - 5, PLANET_SIZE + 10, PLANET_SIZE + 10);
						}
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
							
							// If this is the planet the ship is on, draw the ship
							if(Game.getCurrentPlanet().equals(p)) {
								int[] polyX = {planX, planX + 10, planX, planX - 10}, polyY = {planY - 10, planY + 10, planY, planY + 10};
								g.setColor(Color.BLACK);
								g.fillPolygon(polyX, polyY, 4);
								g.setColor(Color.CYAN);
								g.drawOval(planX - PLANET_SIZE / 2 - 5, planY - PLANET_SIZE / 2 - 5, PLANET_SIZE + 10, PLANET_SIZE + 10);
							}
						}
						thetaQ += Math.PI * 2 / systemList[i][j].size();
					}
				}
			}
		}
	}
}
