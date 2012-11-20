package app.listener;

import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import app.model.Game;
import app.model.Inventory;
import app.model.MarketPlace;
import app.model.tradegoods.Tradable;
import app.service.TransactionService;
import app.view.Display;
import app.view.market.SellingPanel;
import app.view.sidepanels.MessageType;

/**
 * Created with IntelliJ IDEA. User: mark.mcdonald Date: 10/24/12 Time: 5:36 PM
 * To change this template use File | Settings | File Templates.
 * 
 * @author Mark
 * @version 1.0
 */
public class SellToMarketListener extends TransactionListener {

	/**
	 * The SellingPanel with which this Listener is associated.
	 */
	private final SellingPanel sellingPanel;

	/**
	 * The Inventory of the current Player.
	 */
	private final Inventory inventory;

	/**
	 * Set up this SellToMarketListener object.
	 * 
	 * @param marketPlace
	 *            The MarketPlace to which a good will be sold.
	 * @param inventory
	 *            The Inventory of the current Player.
	 * @param price
	 *            The price by which the Player will sell to the market.
	 * @param good
	 *            The good that the Player will sell to the market.
	 * @param errorMessage
	 *            The error message to display if unsuccessful.
	 * @param sellingPanel
	 *            The SellingPanel with which this Listener is associated.
	 */
	public SellToMarketListener(MarketPlace marketPlace, Inventory inventory,
			int price, Tradable good, JLabel errorMessage,
			SellingPanel sellingPanel) {
		super(marketPlace, price, good, errorMessage);
		this.sellingPanel = sellingPanel;
		this.inventory = inventory;
	}

	/**
	 * Attempt to sell something to the market.
	 * 
	 * @param actionEvent
	 *            The instance of ActionEvent associated with this invocation.
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		super.actionPerformed(actionEvent);

		// Check for format mismatch
		if (quantityAsInt >= 0) {
			final boolean transactionIsSuccessful = TransactionService
					.sellToMarket(Game.getCurrentPlayer(), marketPlace, price,
							quantityAsInt, good);

			// update view if there are no errors
			if (transactionIsSuccessful) {
				sellingPanel.setMarketPlaceAndInventory(marketPlace, inventory);
				Display.updatePlayersInfo();
			}
		} else {
			Display.setMessage("Quantity must be a number.", MessageType.ERROR);
		}
	}

	/**
	 * @return Information about this object as a String.
	 */
	@Override
	public String toString() {
		return "SellToMarketListener";
	}
}
