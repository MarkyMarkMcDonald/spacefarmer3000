package App.service;

import java.awt.geom.Point2D;

import App.model.Game;
import App.model.Planet;
import App.model.PlanetarySystem;
import App.model.Player;
import App.view.Display;

/**
 * This class handles moving between planets.
 * @author Andrew Wilder
 */
public class TransportationService {
	
	/**
	 * Travel to a Planet.
	 * @param p The Planet to travel to.
	 */
	public static void goToPlanet(Planet p) {

		// Get data required to make the decision to travel
		Player currentPlayer = Game.getCurrentPlayer();
		PlanetarySystem newSystem = p.getPlanetarySystem();
		PlanetarySystem currSystem = currentPlayer.getCurrentPlanet().getPlanetarySystem();
		double distance = Point2D.distance(currSystem.getX(), currSystem.getY(), newSystem.getX(), newSystem.getY());
		
		// If the planet is in the same system
		if(newSystem != currSystem) {
			
			// Travel to the planet
			currentPlayer.setCurrentPlanet(p);
		} else { // If the planet is in a different system
			
			// Check for enough fuel to make the journey
			if(currentPlayer.getFuel() >= distance) {
				
				// Travel to the planet
				currentPlayer.setCurrentPlanet(p);
				
				// Decrease fuel level
				currentPlayer.setFuel(currentPlayer.getFuel() - (int)distance);
				
				// Play asteroid dodge minigame
				Display.playMiniGame(); // Results from the minigame are handled in Display.exitGame()
			} else {
				// Travel unsuccessful
				
				// TODO: Give a message to the user that you couldn't travel
			}
		}
	}
}