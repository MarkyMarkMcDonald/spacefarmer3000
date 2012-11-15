package App.listener;

import App.model.Game;
import App.model.MarketPlace;
import App.model.TradeGoods.Tradable;
import App.service.TransactionService;
import App.view.Display;
import App.view.Market.BuyingPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created with IntelliJ IDEA. User: mark.mcdonald Date: 10/24/12 Time: 5:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class BuyFromMarketListener extends TransactionListener {

	private BuyingPanel buyingPanel;

	/**
	 * Set up this listener for buying from a market.
	 * 
	 * @param marketPlace
	 *            The market to which this listener is tied.
	 * @param price
	 *            The price of the good with which this listener is associated.
	 * @param good
	 *            The good with which this listener is associated.
	 * @param errorMessage
	 *            The error message to display if the user performs incorrectly.
	 * @param buyingPanel
	 *            A reference to the buying panel this is contained in.
	 */
	public BuyFromMarketListener(MarketPlace marketPlace, int price,
			Tradable good, JLabel errorMessage, BuyingPanel buyingPanel) {
		super(marketPlace, price, good, errorMessage);
		this.buyingPanel = buyingPanel;
	}

	/**
	 * Attempt to make a purchase from the market.
	 * 
	 * @param actionEvent
	 *            The instance of actionEvent associated with this call.
	 */
	public void actionPerformed(ActionEvent actionEvent) {
		super.actionPerformed(actionEvent);

		// Do not buy something if there's a format mismatch
		if (quantityAsInt >= 0) {
			boolean transactionSuccess = TransactionService.buyFromMarket(
					Game.getCurrentPlayer(), marketPlace, price, quantityAsInt,
					good);

			// update views if there weren't errors
			if (transactionSuccess) {
				buyingPanel.setMarket(marketPlace);

				Display.updatePlayersInfo();
			}
		} else {
			errorMessage.setText("Quantity must be a number.");
			errorMessage.setVisible(true);
		}
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "BuyFromMarketListener";
	}
}
