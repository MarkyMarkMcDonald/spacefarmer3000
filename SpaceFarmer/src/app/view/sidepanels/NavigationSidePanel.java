/* This file holds the NavigationSidePanel class, which
 * represents the SidePanel used for navigation.
 */
package app.view.sidepanels;

import app.listener.ContinueListener;
import app.listener.EndTurnListener;
import app.model.Game;
import app.view.CardName;
import app.view.Display;
import app.view.PlanetInformationScreen;
import app.view.market.MarketScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created with IntelliJ IDEA. User: mark.mcdonald Date: 10/31/12 Time: 11:12 AM
 * To change this template use File | Settings | File Templates.
 * @author Mark
 * @version 1.0
 */
public class NavigationSidePanel extends JPanel {

	/**
	 * Creates a NavigationSidePanel using default values.
	 */
	public NavigationSidePanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		/**
		 * Current Planet Info
		 */
		final JButton planetInfoBtn = new JButton("Current Planet");
		final ContinueListener goToPlanetInfoListener = new ContinueListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardToMoveTo = CardName.PLANET_INFORMATION_CARD;

				final PlanetInformationScreen planetScreen = 
						(PlanetInformationScreen) Display
						.getCard(CardName.PLANET_INFORMATION_CARD.toString());
				planetScreen.updateFromPlanet(Game.getCurrentPlanet());

				// Hide the Planet Travel Pane
				final TravelSidePanel travelPanel = (TravelSidePanel) Display
						.getSidePanel("Right");
				travelPanel.setVisible(false);

				Display.hideMessage();

				progressDisplay();
			}
		};
		planetInfoBtn.addActionListener(goToPlanetInfoListener);
		add(planetInfoBtn);

		/**
		 * Go to Current Planet's Market Place
		 */
		final JButton marketplaceBtn = new JButton("Marketplace");
		final ContinueListener goToMarketPlaceListener = new ContinueListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardToMoveTo = CardName.MARKETPLACE_CARD;

				final MarketScreen marketScreen = (MarketScreen) Display
						.getCard(CardName.MARKETPLACE_CARD.toString());
				marketScreen.updateMarketPlace(Game.getCurrentMarketPlace());

				// Hide the Planet Travel Pane
				final TravelSidePanel travelPanel = (TravelSidePanel) Display
						.getSidePanel("Right");
				travelPanel.setVisible(false);

				Display.hideMessage();

				progressDisplay();
			}
		};

		marketplaceBtn.addActionListener(goToMarketPlaceListener);
		add(marketplaceBtn);

		/**
		 * Go to current ship's information and peruse upgrade options
		 */

		final JButton endTurnButton = new JButton("End Turn");
        EndTurnListener endTurnListener = new EndTurnListener();
        endTurnButton.addActionListener(endTurnListener);
        add(endTurnButton);

		/**
		 * Travel to a new planet and end the turn
		 */

		final JButton btnTravel = new JButton("Travel");
		final ContinueListener travelListener = new ContinueListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardToMoveTo = CardName.INTERSYSTEM_TRAVEL_CARD;
				final TravelSidePanel travelPanel = (TravelSidePanel) Display
						.getSidePanel("Right");
				travelPanel.setVisible(true);

				// Hide the tutorial message after the first round
				if (Game.getRoundNumber() > 1) {
					Display.hideMessage();
				} else {
					Display.setMessage("Click a Planet to Travel to!",
							MessageType.GOOD);
				}

				progressDisplay();
				System.out.println();
			}
		};
		btnTravel.addActionListener(travelListener);
		add(btnTravel);
	}
}