/*This file holds the MarketScreen class, which represents the
 * MarketPlace Screen in the game.
 */
package app.view.market;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.listener.ToggleBuyingAndSellingListener;
import app.model.Game;
import app.model.Inventory;
import app.model.MarketPlace;
import app.view.CardName;
import app.view.Screen;

/**
 * This screen represents a marketplace with multiple buying/selling venues.
 * (WIP)
 * 
 * @author Ivory Assan, Mark McDonald
 * @version 1.0
 */
public class MarketScreen extends Screen {

	/**
	 * BuyingPanel associated with this MarketScreen.
	 */
	private BuyingPanel buyingPanel;

	/**
	 * SellingPanel associated with this MarketScreen.
	 */
	private SellingPanel sellingPanel;

	/**
	 * ToggleBuyingAndSellingListener associated with this Screen.
	 */
	private ToggleBuyingAndSellingListener toggleBuyingAndSellingListener;

	/**
	 * Error message label.
	 */
	private JLabel errorMessage;

	/**
	 * Constructs a MarketScreen with default values.
	 */
	public MarketScreen() {
		name = CardName.MARKETPLACE_CARD;
		errorMessage = new JLabel();
		errorMessage.setVisible(false);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		final JLabel lblMarketPlace = new JLabel("Market Place");
		add(lblMarketPlace);
		add(errorMessage);

		buyingPanel = new BuyingPanel(errorMessage);
		sellingPanel = new SellingPanel(errorMessage);
		sellingPanel.setVisible(false);

		final JButton toggleBuyAndSellButton = new JButton("Sell To Market");
		toggleBuyingAndSellingListener = new ToggleBuyingAndSellingListener(
				toggleBuyAndSellButton, buyingPanel, sellingPanel, null, null);
		toggleBuyAndSellButton
				.addActionListener(toggleBuyingAndSellingListener);

		add(toggleBuyAndSellButton);

		final JPanel transactionPanel = new JPanel();
		transactionPanel.setLayout(new BoxLayout(transactionPanel,
				BoxLayout.X_AXIS));
		transactionPanel.add(buyingPanel);
		transactionPanel.add(sellingPanel);
		add(transactionPanel);
	}

	/**
	 * Constructs a MarketScreen using a MarketPlace.
	 * @param marketPlace MarketPlace with which to construct the MarketScreen.
	 */
	public MarketScreen(MarketPlace marketPlace) {
		this();
		updateMarketPlace(marketPlace);
	}

	/**
	 * Updates which MarketPlace this Screen displays.
	 * @param marketPlace MarketPlace with which to display information.
	 */
	public void updateMarketPlace(MarketPlace marketPlace) {

		final Inventory currentPlayersInventory = Game.getCurrentPlayer()
				.getInventory();

		buyingPanel.setMarket(marketPlace);
		sellingPanel.setMarketPlaceAndInventory(marketPlace,
				currentPlayersInventory);

		toggleBuyingAndSellingListener.setMarketPlace(marketPlace);
		toggleBuyingAndSellingListener.setInventory(currentPlayersInventory);
		if (errorMessage != null) {
			errorMessage.setVisible(false);
		}
	}

}
