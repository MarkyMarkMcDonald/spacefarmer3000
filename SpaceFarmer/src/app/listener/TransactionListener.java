package App.listener;

import App.model.MarketPlace;
import App.model.TradeGoods.Tradable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA. User: mark.mcdonald Date: 10/31/12 Time: 2:07 AM
 * To change this template use File | Settings | File Templates.
 */
abstract public class TransactionListener implements ActionListener {
	protected MarketPlace marketPlace;

	protected int price;

	protected Tradable good;

	protected JTextField quantity;

	protected JLabel errorMessage;

	protected int quantityAsInt;

	protected JLabel shownQuantity;

	/**
	 * Set up this TransactionListener object.
	 * 
	 * @param marketPlace
	 *            The current MarketPlace with which this Listener will
	 *            interact.
	 * @param price
	 *            The price of the Transaction.
	 * @param good
	 *            The good being handled.
	 * @param errorMessage
	 *            The error to display if unsuccessful.
	 */
	protected TransactionListener(MarketPlace marketPlace, int price,
			Tradable good, JLabel errorMessage) {
		this.marketPlace = marketPlace;
		this.price = price;
		this.good = good;
		this.errorMessage = errorMessage;
	}

	/**
	 * Set the quantity that this Transaction deals with.
	 * 
	 * @param quantity
	 *            The text field containing the amount for the Transaction.
	 */
	public void setQuantity(JTextField quantity) {
		this.quantity = quantity;
	}

	/**
	 * Set the quantity being displayed to the user.
	 * 
	 * @param shownQuantity
	 *            The label containing the quantity to show.
	 */
	public void setShownQuantity(JLabel shownQuantity) {
		this.shownQuantity = shownQuantity;
	}

	/**
	 * Attempt to perform a Transaction.
	 * 
	 * @param actionEvent
	 *            The instance of ActionEvent associated with this invocation.
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if (Pattern.matches("[0-9]+", quantity.getText())) {
			quantityAsInt = Integer.parseInt(quantity.getText());
		} else {
			quantityAsInt = -1;
		}
	}
}