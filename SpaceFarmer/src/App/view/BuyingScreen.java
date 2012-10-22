package App.view;

import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

public class BuyingScreen extends JPanel {

	/**
	 * Create the panel.
	 */
	public BuyingScreen() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JLabel lblItem = new JLabel("Item");
		add(lblItem);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		add(horizontalStrut);
		
		JLabel lblBuyingPrice = new JLabel("Buying Price");
		add(lblBuyingPrice);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		add(horizontalStrut_1);
		
		JLabel lblAvailable = new JLabel("# Available");
		add(lblAvailable);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		add(horizontalStrut_2);
		
		JLabel lblToBuy = new JLabel("# to Buy");
		add(lblToBuy);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		add(horizontalStrut_3);

	}

}
