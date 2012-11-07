package App.view;

import javax.swing.*;

/**
 * This class acts as the screen handling travel between planets and systems. (WIP)
 * @author Andrew Wilder
 */
public class IntersystemTravelScreen extends Screen {

	/**
	 * Create the panel.
	 */
	public IntersystemTravelScreen() {
		name = CardName.INTERSYSTEM_TRAVEL_CARD;
        JLabel tempLabel = new JLabel("A random picture of planets should be here");
        add(tempLabel);
	}

}
