package App.view;

import App.listener.SellToMarketListener;
import App.model.Inventory;
import App.model.MarketPlace;
import App.model.Tradable;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Map;

/**
 * This screen represents the area in which goods are sold.
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

        JPanel headings = new JPanel();
        headings.setLayout(new BoxLayout(headings, BoxLayout.X_AXIS));

		JLabel lblItem = new JLabel("Item");
        headings.add(lblItem);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
        headings.add(horizontalStrut);
		
		JLabel lblBuyingPrice = new JLabel("# Available");
        headings.add(lblBuyingPrice);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
        headings.add(horizontalStrut_1);
		
		JLabel lblAvailable = new JLabel("Selling Price");
        headings.add(lblAvailable);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
        headings.add(horizontalStrut_2);
		
		JLabel lblToBuy = new JLabel("# to Buy");
        headings.add(lblToBuy);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
        headings.add(horizontalStrut_3);

        add(headings);

        items = new JPanel();
        add(items);

	}

	/**
	 * Set up the marketplace for viewing.
	 * @param marketPlace The marketPlace object for this Planet representing statistics influencing the prices.
	 * @param inventory The Player's inventory that will interact with the market.
	 */
    public void setMarketPlaceAndInventory(MarketPlace marketPlace, Inventory inventory){

        items.removeAll();
        items.setLayout(new BoxLayout(items, BoxLayout.Y_AXIS));

        for (Map.Entry<Tradable, Integer> item : inventory.getInventoryEntries()){
            JPanel rowPanel = new JPanel();
            Tradable itemInfo = item.getKey();
            int quantityAvailable = item.getValue();
            String itemName = itemInfo.getName();
            // can only sell items at 95% market prices
            int itemPrice = (int) Math.floor(marketPlace.getPriceMap().get(itemInfo) * .95);
            ItemRowPanel row = new ItemRowPanel(itemName, quantityAvailable,itemPrice,"Sell!",new SellToMarketListener(marketPlace,itemPrice,itemInfo, errorMessage, buyingPanel));
            rowPanel.add(row);
            items.add(rowPanel);
        }
        items.setBorder(new LineBorder(Color.black));
    }

    public void setErrorMessage(JLabel errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setBuyingPanel(BuyingPanel buyingPanel) {
        this.buyingPanel = buyingPanel;
    }

}
