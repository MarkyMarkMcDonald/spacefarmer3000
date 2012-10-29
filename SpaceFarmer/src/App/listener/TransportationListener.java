package App.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import App.model.Planet;
import App.service.TransportationService;

public class TransportationListener implements ActionListener {

	// The Planet to which this ActionListener is tied
	private Planet thePlanet;
	
	/**
	 * This constructor associates a Planet with the ActionListener.
	 * @param p The Planet to travel to.
	 */
	public TransportationListener(Planet p) {
		thePlanet = p;
	}
	
	/**
	 * Travel to a planet by calling the method in TransportationService.
	 * @param e Unused.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		TransportationService.goToPlanet(thePlanet);
	}
}