// $codepro.audit.disable lossOfPrecisionInCast
/* This file holds the class PlanetInfoLabel, which represents
 * a JLabel holding Planet information.
 */
package app.view;

import java.awt.geom.Point2D;

import javax.swing.JButton;
import javax.swing.JLabel;

import app.model.Game;
import app.model.universe.Planet;
import app.model.universe.PlanetarySystem;

/**
 * Created with IntelliJ IDEA. User: mark.mcdonald Date: 11/9/12 Time: 3:05 PM
 * To change this template use File | Settings | File Templates.
 * @author Mark
 * @version 1.0
 */
public class PlanetInfoLabel extends JLabel {

	/**
	 * Constructs a new PlanetInfoLabel from nothing.
	 */
	public PlanetInfoLabel() {
		final JButton testBut = new JButton("Testing");
		add(testBut);
	}

	/**
	 * Constructs a new PlanetInfoLabel from a Planet.
	 * @param planet Planet to construct the labe from.
	 */
	public PlanetInfoLabel(Planet planet) {
		this();
		updateBasedOnPlanet(planet);
	}

	/**
	 * Updates the label based off a Planet.
	 * @param planet Planet through which to update the label.
	 */
	public void updateBasedOnPlanet(Planet planet) {
		boolean isCurrentPlanet = Game.getCurrentPlanet().equals(planet);
		final String name = planet.getName();
		final String currentEvent = planet.getEvent().getName();
		final String resources = planet.getResourceType().getName();
		final String technology = planet.getTechnologyLevel().getName();
		final String political = planet.getPoliticalSystem().getName();
		// Add the amount of fuel required to travel
		final PlanetarySystem currentPlanetarySystem = Game.getCurrentPlanet()
				.getPlanetarySystem();
		final PlanetarySystem destinationPlanetarySystem = planet
				.getPlanetarySystem();

		String requiredFuel;
		if (currentPlanetarySystem.equals(destinationPlanetarySystem)) {
			requiredFuel = "0";
		} else {
			requiredFuel = Integer.toString((int) Point2D.distance(
					currentPlanetarySystem.getX(),
					currentPlanetarySystem.getY(),
					destinationPlanetarySystem.getX(),
					destinationPlanetarySystem.getY()));
		}

		// A string builder might be better here, but we aren't doing anything
		// intensive
		final String br = "<BR>";
		String html = "<html><p>";

		html += "Planet " + name + br;
		html += "Resources: " + resources + br;
		html += "Technology: " + technology + br;
		html += "Political System: " + political + br;
		html += "Current Event:  " + currentEvent;
		if (!isCurrentPlanet) {
			html += br + "Fuel Needed: " + requiredFuel;
		}
		html += "</p></html>";

		setText(html);

	}

}
