package App.listener;

import App.factory.UniverseFactory;
import App.model.Planet;
import App.service.TransportationService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransportationListener implements ActionListener {

	// The Planet to which this ActionListener is tied
	private JComboBox planetChoice;
	
	/**
	 * This constructor associates the listener with the combo .
	 */
	public TransportationListener(JComboBox planetChoice) {
		this.planetChoice = planetChoice;
	}
	
	/**
	 * Travel to a planet by calling the method in TransportationService.
	 * @param e Unused.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String planetName = (String) planetChoice.getSelectedItem();
        Planet planet = UniverseFactory.getPlanet(planetName);
        TransportationService.goToPlanet(planet);
	}
}