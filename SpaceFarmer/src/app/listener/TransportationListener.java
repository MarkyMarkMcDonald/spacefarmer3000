/*This file holds the TransportationListener class*/
package app.listener;

import java.awt.event.ActionEvent;

import app.model.Game;
import app.model.universe.Planet;
import app.service.Randomizer;
import app.service.TransportationService;
import app.view.CardName;
import app.view.Display;
import app.view.PlanetInformationScreen;
import app.view.sidepanels.TravelSidePanel;

/**
 * This class listens for a Player moving to another Planet.
 * 
 * @author Mark
 * @version 1.0
 * 
 */
public class TransportationListener extends ContinueListener {

	/**
	 * The Planet to which this ActionListener is tied
	 */
	private Planet planet;

	/**
	 * Set up this TransportationListener object.
	 */
	public TransportationListener() {
		cardToMoveTo = CardName.PLANET_INFORMATION_CARD;
	}

	/**
	 * This constructor associates the listener with the combo.
	 * 
	 * @param planet
	 *            The Planet to travel to if successful.
	 */
	public TransportationListener(Planet planet) {
		cardToMoveTo = CardName.PLANET_INFORMATION_CARD;

		this.planet = planet;
	}

	/**
	 * Travel to a planet by calling the method in TransportationService.
	 * 
	 * @param e
	 *            Unused.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		final String displayString;
		final boolean successfulFlight = TransportationService
				.hasGoneToPlanet(planet);
		if (successfulFlight) {
			// Hide the Planet Travel Pane
			final TravelSidePanel travelPanel = (TravelSidePanel) Display
					.getSidePanel("Right");
			travelPanel.setVisible(false);

			// Update what planet the player is now on
			final PlanetInformationScreen planetInfo = (PlanetInformationScreen) Display
					.getCard(cardToMoveTo.toString());
			planetInfo.update(planet);

			displayString = Randomizer.giveEvent(Game.getCurrentPlayer(),
					conf.GameVariables.RANDOM_EVENT_CHANCE);
			if (displayString != null) {
				Display.addToMessage(displayString);
			}

			Display.updatePlayersInfo();

			progressDisplay();
		}
	}

	/**
	 * Set the Planet to travel to.
	 * 
	 * @param planet
	 *            The Planet to travel to if the transportation is successful.
	 */
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}

	/**
	 * @return Information about this object as a String.
	 */
	@Override
	public String toString() {
		return "TransportationListener";
	}
}