/* This file holds the BuyingPanel class, which
 * represents the panel present when buying items.
 */
package app.view.market;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.listener.BuyFromMarketListener;
import app.model.MarketPlace;
import app.model.tradegoods.Tradable;

/**
 * This Panel represents the purchasing view when on a planet.
 * 
 * @author Mark McDonald
 * @version 1.0
 */
public class BuyingPanel extends JPanel {
	
	/**
	 * Width of the items panel.
	 */
	private static final int ITEMS_WIDTH = 500;
	
	/**
	 * Height of the items panel.
	 */
	private static final int ITEMS_HEIGHT = 2000;
	
	/**
	 * Threshold for red.
	 */
	private static final int RED_THRESHOLD = 150;
	
	/**
	 * Threshold for green.
	 */
	private static final int GREEN_THRESHOLD = 50;
	
	/**
	 * JPanel which holds the items.
	 */
	private final JPanel items;

	/**
	 * JLabel which displays any error messages.
	 */
	private JLabel errorMessage;

	/**
	 * Create the panel.
	 * @param errorMessage Error message label to assign to the panel.
	 */
	public BuyingPanel(JLabel errorMessage) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setAlignmentY(Component.TOP_ALIGNMENT);
		this.errorMessage = errorMessage;
		final JPanel headings = new HeadingPanel("Item", "# Available",
				"Buying Price", "# to Buy");
		add(headings);

		items = new JPanel();
		add(items);
	}

	/**
	 * This gets rid of all the old items in the buying panel and replaces them
	 * with the updated items
	 * 
	 * @param marketPlace
	 *            to be used to determine item quantities and prices
	 */
	public void setMarket(MarketPlace marketPlace) {
		items.removeAll();
		items.setLayout(new BoxLayout(items, BoxLayout.Y_AXIS));
		items.setPreferredSize(new Dimension(ITEMS_WIDTH, ITEMS_HEIGHT));

		for (Map.Entry<Tradable, Integer> item : marketPlace.getQuantityMap()
				.entrySet()) {
			JPanel rowPanel = new JPanel();
			Tradable itemInfo = item.getKey();
			int quantityAvailable = item.getValue();
			String itemName = itemInfo.getName();
			int itemPrice = marketPlace.getPriceMap().get(itemInfo);

			ItemRowPanel row = new ItemRowPanel(itemName, quantityAvailable,
					itemPrice, "Buy!", new BuyFromMarketListener(marketPlace,
							itemPrice, itemInfo, errorMessage, this));

			// Set item's bg color based on comparison of market price and base
			// price
			int ratio = itemPrice / itemInfo.getBasePrice() * 100; // $codepro.audit.disable numericLiterals
			if (ratio < GREEN_THRESHOLD) {
				row.setBackground(Color.green);
			} else if (ratio >= GREEN_THRESHOLD && ratio <= RED_THRESHOLD) {
				row.setBackground(Color.yellow);
			} else {
				row.setBackground(Color.red);
			}

			row.setAlignmentX(Component.RIGHT_ALIGNMENT);
			row.setAlignmentY(Component.TOP_ALIGNMENT);

			rowPanel.add(row);
			items.add(rowPanel);
		}
	}

	/**
	 * Sets the errorMessage.
	 * @param errorMessage JLabel to set the error message to.
	 */
	public void setErrorMessage(JLabel errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
