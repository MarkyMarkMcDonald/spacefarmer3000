package app.listener;

import app.model.EventFunction;
import app.model.Game;
import app.model.Universe.Planet;
import app.service.Randomizer;
import app.service.TransportationService;
import app.view.CardName;
import app.view.Display;
import app.view.PlanetInformationScreen;
import app.view.SidePanels.TravelSidePanel;

import java.awt.event.ActionEvent;

public class TransportationListener extends ContinueListener {

	// The Planet to which this ActionListener is tied
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
		boolean successfulFlight = TransportationService.goToPlanet(planet);
		if (successfulFlight) {
			// Hide the Planet Travel Pane
			TravelSidePanel travelPanel = (TravelSidePanel) Display
					.getSidePanel("Right");
			travelPanel.setVisible(false);

			// Update what planet the player is now on
			PlanetInformationScreen planetInfo = (PlanetInformationScreen) Display
					.getCard(cardToMoveTo.toString());
			planetInfo.update(planet);

			int eventRoll = Randomizer.nextInt(5);
			switch (eventRoll) {
			case 0:
			case 1:
				EventFunction.WinEvent winEvent = new EventFunction.WinEvent();
				winEvent.function(Game.getCurrentPlayer());
				Display.addToMessage(" You found some items floating in space!");
				break;
			case 2:
			case 3:
				EventFunction.LoseEvent loseEvent = new EventFunction.LoseEvent();
				loseEvent.function(Game.getCurrentPlayer());
				Display.addToMessage(" You lost some items to pirates on the journey!");
				break;
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
	public String toString() {
		return "TransportationListener";
	}
}