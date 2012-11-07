package App.listener;

import App.model.Planet;
import App.service.TransportationService;
import App.view.*;

import java.awt.event.ActionEvent;

public class TransportationListener extends ContinueListener{

	// The Planet to which this ActionListener is tied
	private Planet planet;
	
	/**
	 * This constructor associates the listener with the combo .
	 */
	public TransportationListener(Planet planet) {
		this.planet = planet;
        cardToMoveTo = CardName.PLANET_INFORMATION_CARD;
	}
	
	/**
	 * Travel to a planet by calling the method in TransportationService.
	 * @param e Unused.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
        String message = TransportationService.goToPlanet(planet);
        if (message.contains("You traveled to")){
            // Hide the Planet Travel Pane
            TravelSidePanel travelPanel = (TravelSidePanel) Display.getSidePanel("Right");
            travelPanel.setVisible(false);

            // Update what planet the player is now on
            PlanetInformationScreen planetInfo = (PlanetInformationScreen) Display.getCard(cardToMoveTo.toString());
            planetInfo.update(planet);
            PlayersInformationSidePanel playersInfo =  (PlayersInformationSidePanel) Display.getSidePanel("Bottom");
            playersInfo.updateBasedOnAllPlayers();

            progressDisplay();
        }
	}
}