/* This file holds the class PlanetInformationScreen, which
 * represents the Screen holding Planet information.
 */
package app.view;

import javax.swing.JButton;

import app.listener.TransportationListener;
import app.model.Game;
import app.model.universe.Planet;

/**
 * Created with IntelliJ IDEA. User: mark.mcdonald Date: 10/24/12 Time: 5:01 PM
 * To change this template use File | Settings | File Templates.
 * @author Mark
 * @version 1.0
 */
public class PlanetInformationScreen extends Screen {
	
	/**
	 * Label containing the Planet information.
	 */
	private final PlanetInfoLabel nameLabel;

	/**
	 * The Travel JButton that a Player clicks to travel.
	 */
	private final JButton travelButton;

	/**
	 * Listener that listens for a Player moving to another Planet.
	 */
	private final TransportationListener transportationListener;

	/**
	 * Creates a PlanetInformationScreen from nothing.
	 */
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

	/**
	 * Creates a PlanetInformationScreen from a Planet.
	 * @param planet Planet with which to create the PlanetInformationScreen.
	 */
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
