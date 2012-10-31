package App.view;

import App.listener.TransactionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * This inner JPanel holds the item rows used in the BuyingPanel.
 * @author Mark McDonald
 */
public class ItemRowPanel extends JPanel {
	private JTextField txtToBuy;

	/**
	 * Create the panel.
	 */
	public ItemRowPanel(String name, int numAvail, int price, String actionText, TransactionListener transactionListener) {
		JLabel lblName = new JLabel(name);
        lblName.setMinimumSize(new Dimension(50, 10));
        lblName.setMaximumSize(new Dimension(50, 10));
        lblName.setHorizontalAlignment(JLabel.LEFT);
        lblName.setBorder(new LineBorder(Color.black));
		add(lblName);
		
		JLabel lblAvailable = new JLabel(Integer.toString(numAvail));
        lblName.setMinimumSize(new Dimension(20,10));
        lblName.setHorizontalAlignment(JLabel.LEFT);
        add(lblAvailable);

        JLabel lblPrice = new JLabel(Integer.toString(price));
        lblName.setMinimumSize(new Dimension(20,10));
        lblName.setHorizontalAlignment(JLabel.LEFT);
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
