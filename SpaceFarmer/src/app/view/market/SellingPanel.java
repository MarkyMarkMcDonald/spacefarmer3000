// $codepro.audit.disable lossOfPrecisionInCast
package app.view.market;

import app.listener.SellToMarketListener;
import app.model.Inventory;
import app.model.MarketPlace;
import app.model.tradegoods.Tradable;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

/**
 * This screen represents the area in which goods are sold.
 * 
 * @author Mark McDonald
 */
public class SellingPanel extends JPanel {

	private JPanel items;

	private JLabel errorMessage;

	private BuyingPanel buyingPanel;

	/**
	 * Create the panel.
	 */
	public SellingPanel(JLabel errorMessage) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.errorMessage = errorMessage;
		JPanel headings = new HeadingPanel("Item", "# Available",
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
					itemInfo) * 0.95);
			ItemRowPanel row = new ItemRowPanel(itemName, quantityAvailable,
					itemPrice, "Sell!", new SellToMarketListener(marketPlace,
							inventory, itemPrice, itemInfo, errorMessage, this));

			// Set item's background color based on comparison of market price
			// and base price
			int ratio = itemPrice / itemInfo.getBasePrice() * 100;
			if (ratio < 50) {
				row.setBackground(Color.red);
			} else if (ratio >= 50 && ratio <= 150) {
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

	public void setErrorMessage(JLabel errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setBuyingPanel(BuyingPanel buyingPanel) {
		this.buyingPanel = buyingPanel;
	}

}
