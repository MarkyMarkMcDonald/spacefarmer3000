package App.view;

import App.listener.TransportationListener;
import App.model.Game;
import App.model.Universe.Planet;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA. User: mark.mcdonald Date: 10/24/12 Time: 5:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlanetInformationScreen extends Screen {
	private PlanetInfoLabel nameLabel;

	private JButton travelButton;

	private TransportationListener transportationListener;

	public PlanetInformationScreen() {
		name = CardName.PLANET_INFORMATION_CARD;

		travelButton = new JButton("Travel Here");
		transportationListener = new TransportationListener();
		travelButton.addActionListener(transportationListener);
		travelButton.setVisible(false);
		add(travelButton);

		nameLabel = new PlanetInfoLabel();
		add(nameLabel);
	}

	public void update(Planet planet) {
		nameLabel.updateBasedOnPlanet(planet);
		transportationListener.setPlanet(planet);
		// If the player isn't on this planet, create and reveal the components
		// for traveling there
		if (!Game.getCurrentPlanet().equals(planet)) {
			travelButton.setVisible(true);
		} else {
			travelButton.setVisible(false);
		}
	}

}
