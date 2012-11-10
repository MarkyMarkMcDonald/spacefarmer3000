package App.listener;

import App.model.Universe.Planet;
import App.service.TransportationService;
import App.view.CardName;
import App.view.Display;
import App.view.PlanetInformationScreen;
import App.view.SidePanels.TravelSidePanel;

import java.awt.event.ActionEvent;

public class TransportationListener extends ContinueListener{

	// The Planet to which this ActionListener is tied
	private Planet planet;


    public TransportationListener() {
        cardToMoveTo = CardName.PLANET_INFORMATION_CARD;

    }

    /**
	 * This constructor associates the listener with the combo .
	 */
	public TransportationListener(Planet planet) {
        cardToMoveTo = CardName.PLANET_INFORMATION_CARD;

        this.planet = planet;
    }
	
	/**
	 * Travel to a planet by calling the method in TransportationService.
	 * @param e Unused.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
        boolean successfulFlight = TransportationService.goToPlanet(planet);
        if (successfulFlight){
            // Hide the Planet Travel Pane
            TravelSidePanel travelPanel = (TravelSidePanel) Display.getSidePanel("Right");
            travelPanel.setVisible(false);

            // Update what planet the player is now on
            PlanetInformationScreen planetInfo = (PlanetInformationScreen) Display.getCard(cardToMoveTo.toString());
            planetInfo.update(planet);

            Display.updatePlayersInfo();

            progressDisplay();
        }
	}

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }
}