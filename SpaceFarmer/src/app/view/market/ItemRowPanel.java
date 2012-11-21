// $codepro.audit.disable staticMemberAccess

/* staticMemberAccess is disabled for this file because each instance of this violation
 * is a natural use of static constant access used in constructing swing containers.
 */

/**
 * This file holds the class ItemRowPanel, which
 * represents an item row in the market view.
 */
package app.view.market;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.listener.TransactionListener;

/**
 * This inner JPanel holds the item rows used in the BuyingPanel.
 * 
 * @author Mark McDonald
 * @version 1.0
 */
public class ItemRowPanel extends JPanel {

	/**
	 * Width of this panel.
	 */
	private static final int ITEM_ROW_WIDTH = 500;

	/**
	 * Height of this panel.
	 */
	private static final int ITEM_ROW_HEIGHT = 30;

	/**
	 * Columns in buy text field.
	 */
	private static final int BUY_COLUMNS = 7;
	
	/**
	 * Rows in the grid of the panel.
	 */
	private static final int GRID_ROWS = 1;
	
	/**
	 * Columns in the grid of the panel.
	 */
	private static final int GRID_COLUMNS = 5;

	/**
	 * Text field containing text representing how much a Player wants to buy of
	 * a good.
	 */
	private final JTextField txtToBuy;

	/**
	 * Constructs an ItemRowPanel using the necessary characteristics.
	 * @param name Name of the item.
	 * @param numAvail Number available of the item.
	 * @param price Price of the item.
	 * @param actionText Action text of the item.
	 * @param transactionListener TransactionListener associated with this panel.
	 */
	public ItemRowPanel(String name, int numAvail, int price,
			String actionText, TransactionListener transactionListener) {
		setLayout(new GridLayout(GRID_ROWS, GRID_COLUMNS));
		setPreferredSize(new Dimension(ITEM_ROW_WIDTH, ITEM_ROW_HEIGHT));

		final JLabel lblName = new JLabel(name);
		lblName.setHorizontalAlignment(JLabel.CENTER);
		add(lblName);

		final JLabel lblAvailable = new JLabel(Integer.toString(numAvail));
		lblAvailable.setHorizontalAlignment(JLabel.CENTER);

		add(lblAvailable);

		final JLabel lblPrice = new JLabel("$" + Integer.toString(price));
		lblPrice.setHorizontalAlignment(JLabel.CENTER);
		add(lblPrice);

		txtToBuy = new JTextField();
		txtToBuy.setText("0");
		txtToBuy.setColumns(BUY_COLUMNS);
		txtToBuy.setHorizontalAlignment(JTextField.CENTER);
		add(txtToBuy);

		final JButton btnBuy = new JButton(actionText);
		transactionListener.setQuantity(txtToBuy);
		transactionListener.setShownQuantity(lblAvailable);
		btnBuy.addActionListener(transactionListener);
		add(btnBuy);
	}
}
