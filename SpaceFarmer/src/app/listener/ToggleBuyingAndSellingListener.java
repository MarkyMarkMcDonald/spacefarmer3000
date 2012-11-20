package app.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import app.model.Inventory;
import app.model.MarketPlace;
import app.view.market.BuyingPanel;
import app.view.market.SellingPanel;

/**
 * Created with IntelliJ IDEA. User: mark.mcdonald Date: 11/7/12 Time: 3:52 AM
 * To change this template use File | Settings | File Templates.
 * 
 * @author Mark
 * @version 1.0
 */
public class ToggleBuyingAndSellingListener implements ActionListener {

	/**
	 * The Button with which this Listener is associated.
	 */
	private final JButton toggleButton;

	/**
	 * The buying panel with which this Listener will interact.
	 */
	private final BuyingPanel buyingPanel;

	/**
	 * The selling panel with which this Listener will interact.
	 */
	private final SellingPanel sellingPanel;

	/**
	 * The marketplace with which this Listener will interact.
	 */
	private MarketPlace marketPlace;

	/**
	 * The current Player's inventory.
	 */
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
	@Override
	public String toString() {
		return "ToggleBuyingAndSellingListener";
	}
}
