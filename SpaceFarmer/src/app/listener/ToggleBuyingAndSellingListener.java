package app.listener;

import app.model.Inventory;
import app.model.MarketPlace;
import app.view.Market.BuyingPanel;
import app.view.Market.SellingPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA. User: mark.mcdonald Date: 11/7/12 Time: 3:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class ToggleBuyingAndSellingListener implements ActionListener {
	private JButton toggleButton;

	private BuyingPanel buyingPanel;

	private SellingPanel sellingPanel;

	private MarketPlace marketPlace;

	private Inventory inventory;

	/**
	 * Set up this ToggleBuyingAndSellingListener object.
	 * 
	 * @param toggleButton
	 *            The Button with which this Listener is associated.
	 * @param buyingPanel
	 *            The buying panel with which this Listener will interact.
	 * @param sellingPanel
	 *            The selling panel with which this Listener will interact.
	 * @param marketPlace
	 *            The marketplace with which this Listener will interact.
	 * @param inventory
	 *            The current Player's inventory.
	 */
	public ToggleBuyingAndSellingListener(JButton toggleButton,
			BuyingPanel buyingPanel, SellingPanel sellingPanel,
			MarketPlace marketPlace, Inventory inventory) {
		this.toggleButton = toggleButton;
		this.buyingPanel = buyingPanel;
		this.sellingPanel = sellingPanel;
		this.marketPlace = marketPlace;
		this.inventory = inventory;
	}

	/**
	 * Toggle between buying and selling panels within a Market.
	 * 
	 * @param actionEvent
	 *            The instance of ActionEvent associated with this invocation.
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		// Switch to Selling Mode
		if (toggleButton.getText().contains("Sell")) {
			toggleButton.setText("Buy From Market");
			buyingPanel.setVisible(false);
			sellingPanel.setMarketPlaceAndInventory(marketPlace, inventory);
			sellingPanel.setVisible(true);
		}
		// Switch to Buying Mode
		else {
			toggleButton.setText("Sell To Market");
			sellingPanel.setVisible(false);
			buyingPanel.setMarket(marketPlace);
			buyingPanel.setVisible(true);
		}
	}

	/**
	 * Set the current Market with which this Listener will interact.
	 * 
	 * @param marketPlace
	 *            The MarketPlace to interact with.
	 */
	public void setMarketPlace(MarketPlace marketPlace) {
		this.marketPlace = marketPlace;
	}

	/**
	 * Set the Inventory of the Player to interact with.
	 * 
	 * @param inventory
	 *            The Inventory of the current Player.
	 */
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "ToggleBuyingAndSellingListener";
	}
}
