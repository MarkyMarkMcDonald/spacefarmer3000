package app.service;

import app.model.Game;
import app.model.Player.Player;
import app.model.Universe.Planet;
import app.model.Universe.PlanetarySystem;
import app.view.Display;
import app.view.SidePanels.MessageType;

import java.awt.geom.Point2D;

/**
 * This class handles moving between planets.
 * 
 * @author Andrew Wilder
 */
public class TransportationService {

	/**
	 * Travel to a Planet.
	 * 
	 * @param p
	 *            The Planet to travel to.
	 */
	public static boolean goToPlanet(Planet p) {

		// Get data required to make the decision to travel
		Player currentPlayer = Game.getCurrentPlayer();
		PlanetarySystem newSystem = p.getPlanetarySystem();
		PlanetarySystem currSystem = currentPlayer.getCurrentPlanet()
				.getPlanetarySystem();
		double distance = Point2D.distance(currSystem.getX(),
				currSystem.getY(), newSystem.getX(), newSystem.getY());

		// The planet is in the same system
		if (newSystem.equals(currSystem)) {
			currentPlayer.setCurrentPlanet(p);
		}
		// The planet is in a different system
		else {

			// Check if player has enough fuel
			if (currentPlayer.getFuel() >= distance) {

				currentPlayer.setCurrentPlanet(p);

				// Decrease fuel level
				currentPlayer.setFuel(currentPlayer.getFuel() - (int) distance);

				// Play asteroid dodge minigame
				Display.playMiniGame(); // MiniGame puts the results in the
										// message panel

			} else {

				// set a failure message
				Display.setMessage(
						"You need "
								+ ((int) distance - currentPlayer.getFuel())
								+ " more fuel to travel to Planet "
								+ p.getName() + ".", MessageType.ERROR);
				return false;
			}
		}
		// set a standard travel message
		Display.setMessage("You traveled to Planet " + p.getName() + "!",
				MessageType.GOOD);
		return true;
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "TransportationService";
	}
}