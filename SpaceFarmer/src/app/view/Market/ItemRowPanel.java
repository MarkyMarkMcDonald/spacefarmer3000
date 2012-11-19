package app.view.Market;

import app.listener.TransactionListener;

import javax.swing.*;
import java.awt.*;

/**
 * This inner JPanel holds the item rows used in the BuyingPanel.
 * 
 * @author Mark McDonald
 */
public class ItemRowPanel extends JPanel {
	private JTextField txtToBuy;

	/**
	 * Create the panel.
	 */
	public ItemRowPanel(String name, int numAvail, int price,
			String actionText, TransactionListener transactionListener) {
		setLayout(new GridLayout(1, 5));
		setPreferredSize(new Dimension(500, 30));

		JLabel lblName = new JLabel(name);
		lblName.setHorizontalAlignment(JLabel.CENTER);
		add(lblName);

		JLabel lblAvailable = new JLabel(Integer.toString(numAvail));
		lblAvailable.setHorizontalAlignment(JLabel.CENTER);

		add(lblAvailable);

		JLabel lblPrice = new JLabel("$" + Integer.toString(price));
		lblPrice.setHorizontalAlignment(JLabel.CENTER);
		add(lblPrice);

		txtToBuy = new JTextField();
		txtToBuy.setText("0");
		txtToBuy.setColumns(7);
		txtToBuy.setHorizontalAlignment(JTextField.CENTER);
		add(txtToBuy);

		JButton btnBuy = new JButton(actionText);
		transactionListener.setQuantity(txtToBuy);
		transactionListener.setShownQuantity(lblAvailable);
		btnBuy.addActionListener(transactionListener);
		add(btnBuy);
	}
}
