package App.listener;

import App.model.Planet;
import App.service.TransportationService;
import App.view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class TransportationListener extends ContinueListener{

	// The Planet to which this ActionListener is tied
	private Planet planet;

    // message describing result of the travel
    private JLabel message;

    public TransportationListener(JLabel message) {
        cardToMoveTo = CardName.PLANET_INFORMATION_CARD;

        this.message = message;
    }

    /**
	 * This constructor associates the listener with the combo .
	 */
	public TransportationListener(Planet planet, JLabel message) {
        cardToMoveTo = CardName.PLANET_INFORMATION_CARD;

        this.planet = planet;
        this.message = message;
    }
	
	/**
	 * Travel to a planet by calling the method in TransportationService.
	 * @param e Unused.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
        String messageFromService = TransportationService.goToPlanet(planet);
        message.setText(messageFromService);
        message.setVisible(true);
        if (messageFromService.contains("You traveled to")){
            // Hide the Planet Travel Pane
            TravelSidePanel travelPanel = (TravelSidePanel) Display.getSidePanel("Right");
            travelPanel.setVisible(false);

            // Update what planet the player is now on
            PlanetInformationScreen planetInfo = (PlanetInformationScreen) Display.getCard(cardToMoveTo.toString());
            planetInfo.update(planet);
            message.setVisible(true);
            PlayersInformationSidePanel playersInfo =  (PlayersInformationSidePanel) Display.getSidePanel("Bot");
            playersInfo.updateBasedOnAllPlayers();

            progressDisplay();
        }
	}

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }
}