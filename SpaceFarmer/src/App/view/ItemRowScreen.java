package App.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ItemRowScreen extends JPanel {
	private JTextField txtToBuy;

	/**
	 * Create the panel.
	 */
	public ItemRowScreen() {
		
		JLabel lblName = new JLabel("Name");
		add(lblName);
		
		JLabel lblAvailable = new JLabel("# Available");
		add(lblAvailable);
		
		txtToBuy = new JTextField();
		txtToBuy.setText("# To Buy");
		add(txtToBuy);
		txtToBuy.setColumns(10);
		
		JButton btnBuy = new JButton("Buy!");
		add(btnBuy);

	}

}
