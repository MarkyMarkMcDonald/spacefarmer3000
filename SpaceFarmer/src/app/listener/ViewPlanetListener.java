/*This file holds the ViewPlanetListener class*/
package app.listener;

import java.awt.event.ActionEvent;

import javax.swing.JComboBox;

import app.factory.UniverseFactory;
import app.model.universe.Planet;
import app.view.CardName;
import app.view.Display;
import app.view.PlanetInformationScreen;

/**
 * Created with IntelliJ IDEA. User: mark.mcdonald Date: 11/7/12 Time: 1:05 AM
 * To change this template use File | Settings | File Templates.
 * 
 * @author Mark
 * @version 1
 */
public class ViewPlanetListener extends ContinueListener {

	/**
	 * A combo box containing the planet choices for this ViewPlanetListener to
	 * use.
	 */
	private final JComboBox planetChoices;

	/**
	 * Set up this ViewPlanetListener object.
	 * 
	 * @param planetChoices
	 *            A combo box containing the Planet choices.
	 */
	public ViewPlanetListener(JComboBox planetChoices) {
		cardToMoveTo = CardName.PLANET_INFORMATION_CARD;
		this.planetChoices = planetChoices;
	}

	/**
	 * action listener for the information screen
	 * 
	 * @param e
	 *            Unused
	 */
	public void actionPerformed(ActionEvent e) {
		final PlanetInformationScreen planetInfoScreen = (PlanetInformationScreen) Display
				.getCard(cardToMoveTo.toString());
		final String selectedPlanetName = (String) planetChoices
				.getSelectedItem();
		final Planet selectedPlanet = UniverseFactory
				.getPlanet(selectedPlanetName);
		planetInfoScreen.updateFromPlanet(selectedPlanet);

		progressDisplay();
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "ViewPlanetListener";
	}
}
