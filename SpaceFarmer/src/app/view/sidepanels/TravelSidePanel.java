/* This file holds the TravelSidePanel class, which
 * represents a SidePanel associated with traveling.
 */
package app.view.sidepanels;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;

import app.listener.TransportationListener;
import app.model.Game;
import app.model.universe.Planet;
import app.view.PlanetInfoLabel;

/**
 * Created with IntelliJ IDEA. User: mark.mcdonald Date: 11/6/12 Time: 1:17 AM
 * To change this template use File | Settings | File Templates.
 * 
 * @author Mark
 * @version 1.0
 */
public class TravelSidePanel extends SidePanel {

	/**
	 * Values for the width and height of the panel.
	 */
	private static final int TRAVEL_WIDTH = 250, TRAVEL_HEIGHT = 2000;
	
	/**
	 * Label containing planet information.
	 */
	private final PlanetInfoLabel planetInfoLabel;

	/**
	 * Button used to travel.
	 */
	private final JButton travelButton;

	/**
	 * TransportationListener associated with this panel.
	 */
	private final TransportationListener transportationListener;

	/**
	 * Constructs a TraveSidePanel using default values.
	 */
	public TravelSidePanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(TRAVEL_WIDTH, TRAVEL_HEIGHT));
		planetInfoLabel = new PlanetInfoLabel();
		add(planetInfoLabel);
		transportationListener = new TransportationListener();
		travelButton = new JButton("Go!");
		travelButton.addActionListener(transportationListener);
		travelButton.setVisible(false);
		add(travelButton);
	}

	/**
	 * Updates the TravelSidePanel based on the current Planet.
	 * 
	 * @param planet
	 *            Planet with which to update the panel.
	 */
	public void updateBasedOnPlanet(Planet planet) {
		boolean isCurrentPlanet = Game.getCurrentPlanet().equals(planet);
		if (!isCurrentPlanet) {
			travelButton.setVisible(true);
		} else {
			travelButton.setVisible(false);
		}
		transportationListener.setPlanet(planet);
		planetInfoLabel.updateBasedOnPlanet(planet);
	}
}
