// $codepro.audit.disable lossOfPrecisionInCast
/*This file holds the class TransportationService, which is responsible
 * for moving a Player to another Planet.
 */
package app.service;

import app.model.Game;
import app.model.player.Player;
import app.model.universe.Planet;
import app.model.universe.PlanetarySystem;
import app.view.Display;
import app.view.sidepanels.MessageType;

import java.awt.geom.Point2D;

/**
 * This class handles moving between planets.
 * 
 * @author Andrew Wilder
 * @version 1.0
 */
public class TransportationService {

	/**
	 * Travel to a Planet.
	 * 
	 * @param p
	 *            The Planet to travel to.
	 * @return true if the travel was successful, false otherwise.
	 */
	public static boolean hasGoneToPlanet(Planet p) {

		// Get data required to make the decision to travel
		final Player currentPlayer = Game.getCurrentPlayer();
		final PlanetarySystem newSystem = p.getPlanetarySystem();
		final PlanetarySystem currSystem = currentPlayer.getCurrentPlanet()
				.getPlanetarySystem();
		final double distance = Point2D.distance(currSystem.getX(),
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