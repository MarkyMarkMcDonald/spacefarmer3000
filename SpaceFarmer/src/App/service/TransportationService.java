package App.service;

import App.model.Game;
import App.model.Planet;
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
		// TODO check conditions that allow travel between planets
		
		/* Need to check the current player's fuel level
		 * Compare the player's fuel level against what is needed to reach Planet p
		 */
		Player currentPlayer = Game.getCurrentPlayer();
		
		boolean condition = true;
		if(condition) {
			// Travel successful
			
			// If p is not in the Player's current Planetary System, then activate minigame
			if(p.getPlanetarySystem().equals(currentPlayer.getCurrentPlanet().getPlanetarySystem())) {
				Display.playMiniGame(); // Results from the minigame are handled in Display.exitGame()
			}
		} else {
			// Travel unsuccessful
			
			// TODO: Give a message to the user that you couldn't travel
		}
	}
}