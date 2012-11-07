package App.service;

import App.model.Game;
import App.model.Planet;
import App.model.PlanetarySystem;
import App.model.Player;
import App.view.Display;
import App.view.MiniGameScreen;

import java.awt.geom.Point2D;

/**
 * This class handles moving between planets.
 * @author Andrew Wilder
 */
public class TransportationService {
	
	/**
	 * Travel to a Planet.
	 * @param p The Planet to travel to.
	 */
	public static String goToPlanet(Planet p) {

		// Get data required to make the decision to travel
		Player currentPlayer = Game.getCurrentPlayer();
		PlanetarySystem newSystem = p.getPlanetarySystem();
		PlanetarySystem currSystem = currentPlayer.getCurrentPlanet().getPlanetarySystem();
		double distance = Point2D.distance(currSystem.getX(), currSystem.getY(), newSystem.getX(), newSystem.getY());
		
		// The planet is in the same system
		if(newSystem == currSystem) {
			currentPlayer.setCurrentPlanet(p);
		}
        // The planet is in a different system
        else {
			
			// Check if player has enough fuel
			if(currentPlayer.getFuel() >= distance) {
				
				currentPlayer.setCurrentPlanet(p);
				
				// Decrease fuel level
				currentPlayer.setFuel(currentPlayer.getFuel() - (int)distance);
				
				// Play asteroid dodge minigame
				Display.playMiniGame(); // Results from the minigame are saved in MiniGameScreen
			}
            else {

				// Return a failure message
				return "You need " + ((int)distance - currentPlayer.getFuel()) + " more fuel to travel to Planet " + p.getName() + ".";
			}
		}

        // Return a success message
        if (MiniGameScreen.isSuccess()){
            return "You traveled to Planet " + p.getName() + "!";
        }
        else {
            int fuelSpent = Math.min(currentPlayer.getFuel(),20);
            currentPlayer.setFuel(currentPlayer.getFuel() - fuelSpent);
            return "You traveled to Planet " + p.getName() + "!\n Unfortunately, You spent " + fuelSpent + " fuel after hitting an asteroid";
        }

	}
}