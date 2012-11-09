package App.service;

import App.model.Game;
import App.model.Player.Player;
import App.model.Universe.Planet;
import App.model.Universe.PlanetarySystem;
import App.view.Display;
import App.view.SidePanels.MessageType;

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
	public static boolean goToPlanet(Planet p) {

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
				Display.playMiniGame(); // MiniGame puts the results in the message panel

			}
            else {

				// set a failure message
				Display.setMessage("You need " + ((int)distance - currentPlayer.getFuel()) + " more fuel to travel to Planet " + p.getName() + ".", MessageType.BAD);
                return false;
			}
		}
        // set a standard travel message
        Display.setMessage("You traveled to Planet " + p.getName() + "!", MessageType.GOOD);
        return true;



	}
}