package App.view;

/**
 * Created with Eclipse.
 *
 */

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MarketScreen extends JPanel {

	/**
	 * Create the panel.
	 */
	public MarketScreen() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JLabel lblMarketPlace = new JLabel("Market Place");
		panel.add(lblMarketPlace);
		
		BuyingScreen buyingScreen = new BuyingScreen();
		add(buyingScreen);
		
		SellingScreen sellingScreen = new SellingScreen();
		add(sellingScreen);
		

	}

}
