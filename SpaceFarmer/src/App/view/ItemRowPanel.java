package App.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class ItemRowPanel extends JPanel {
	private JTextField txtToBuy;

	/**
	 * Create the panel.
	 */
	public ItemRowPanel(String name, int numAvail, int price, String actionText, ActionListener actionTextListener) {
		
		JLabel lblName = new JLabel(name);
		add(lblName);
		
		JLabel lblAvailable = new JLabel(Integer.toString(numAvail));
		add(lblAvailable);

        JLabel lblPrice = new JLabel(Integer.toString(price));
        add(lblPrice);

		txtToBuy = new JTextField();
		txtToBuy.setText("0");
		add(txtToBuy);
		txtToBuy.setColumns(10);
		
		JButton btnBuy = new JButton(actionText);
        btnBuy.addActionListener(actionTextListener);
		add(btnBuy);

	}

}
