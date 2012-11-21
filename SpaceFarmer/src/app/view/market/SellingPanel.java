// $codepro.audit.disable lossOfPrecisionInCast
/*This file holds the SellingPanel class, which represents
 * the user interface where goods may be sold.
 */
package app.view.market;

import java.awt.Color;
import java.awt.Component;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.listener.SellToMarketListener;
import app.model.Inventory;
import app.model.MarketPlace;
import app.model.tradegoods.Tradable;

/**
 * This screen represents the area in which goods are sold.
 * 
 * @author Mark McDonald
 * @version 1.0
 */
public class SellingPanel extends JPanel {
	
	/**
	 * Amount by which prices are reduced when selling.
	 */
	private static final double PRICE_REDUCTION = 0.95;

	/**
	 * Threshold for displaying item name in red.
	 */
	private static final int RED_THRESHOLD = 50;
	
	/**
	 * Threshold for displaying item name in green.
	 */
	private static final int GREEN_THRESHOLD = 150;
	
	/**
	 * JPanel containing the display of sellable items.
	 */
	private final JPanel items;

	/**
	 * JLabel containing any error messages.
	 */
	private JLabel errorMessage;

	/**
	 * Creates the panel using an error message.
	 * @param errorMessage Error message to assign to this SellingPanel.
	 */
	public SellingPanel(JLabel errorMessage) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.errorMessage = errorMessage;
		final JPanel headings = new HeadingPanel("Item", "# Available",
				"Selling Price", "# to Sell");
		add(headings);

		items = new JPanel();
		add(items);
	}

	/**
	 * Set up the marketplace for viewing.
	 * 
	 * @param marketPlace
	 *            The marketPlace object for this Planet representing statistics
	 *            influencing the prices.
	 * @param inventory
	 *            The Player's inventory that will interact with the market.
	 */
	public void setMarketPlaceAndInventory(MarketPlace marketPlace,
			Inventory inventory) {
		items.removeAll();
		items.setLayout(new BoxLayout(items, BoxLayout.Y_AXIS));

		for (Map.Entry<Tradable, Integer> item : inventory
				.getInventoryEntries()) {
			JPanel rowPanel = new JPanel();
			Tradable itemInfo = item.getKey();
			int quantityAvailable = item.getValue();
			String itemName = itemInfo.getName();
			// can only sell items at 95% market prices
			int itemPrice = (int) Math.floor(marketPlace.getPriceMap().get(
					itemInfo) * PRICE_REDUCTION);
			ItemRowPanel row = new ItemRowPanel(itemName, quantityAvailable,
					itemPrice, "Sell!", new SellToMarketListener(marketPlace,
							inventory, itemPrice, itemInfo, errorMessage, this));

			// Set item's background color based on comparison of market price
			// and base price
			int ratio = itemPrice / itemInfo.getBasePrice() * 100; // $codepro.audit.disable numericLiterals
			if (ratio < RED_THRESHOLD) {
				row.setBackground(Color.red);
			} else if (ratio >= RED_THRESHOLD && ratio <= GREEN_THRESHOLD) {
				row.setBackground(Color.yellow);
			} else {
				row.setBackground(Color.green);
			}

			row.setAlignmentX(Component.RIGHT_ALIGNMENT);
			row.setAlignmentY(Component.TOP_ALIGNMENT);

			rowPanel.add(row);
			items.add(rowPanel);
		}
	}

	/**
	 * @param errorMessage ErrorMessage to set for this SellingPanel.
	 */
	public void setErrorMessage(JLabel errorMessage) {
		this.errorMessage = errorMessage;
	}

}
