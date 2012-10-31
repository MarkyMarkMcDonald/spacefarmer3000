package App.view;

import App.listener.TransactionListener;

import javax.swing.*;

public class ItemRowPanel extends JPanel {
	private JTextField txtToBuy;

	/**
	 * Create the panel.
	 */
	public ItemRowPanel(String name, int numAvail, int price, String actionText, TransactionListener transactionListener) {
		
		JLabel lblName = new JLabel(name);
		add(lblName);
		
		JLabel lblAvailable = new JLabel(Integer.toString(numAvail));
		add(lblAvailable);

        JLabel lblPrice = new JLabel(Integer.toString(price));
        add(lblPrice);

		txtToBuy = new JTextField();
		txtToBuy.setText("0");
		add(txtToBuy);
		txtToBuy.setColumns(7);
		
		JButton btnBuy = new JButton(actionText);
        transactionListener.setQuantity(txtToBuy);
        transactionListener.setShownQuantity(lblAvailable);
        btnBuy.addActionListener(transactionListener);
		add(btnBuy);

	}

}
