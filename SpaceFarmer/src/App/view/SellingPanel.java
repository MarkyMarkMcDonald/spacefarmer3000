package App.view;

import App.listener.SellToMarketListener;
import App.model.Inventory;
import App.model.MarketPlace;
import App.model.Tradable;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class SellingPanel extends JPanel {

    private MarketPlace marketPlace;
    private JScrollPane items;
    private JLabel errorMessage;

    /**
	 * Create the panel.
	 */
	public SellingPanel(Inventory inventory, MarketPlace marketPlace, JLabel errorMessage) {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        this.errorMessage = errorMessage;

		JLabel lblItem = new JLabel("Item");
		add(lblItem);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		add(horizontalStrut);
		
		JLabel lblBuyingPrice = new JLabel("# Available");
		add(lblBuyingPrice);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		add(horizontalStrut_1);
		
		JLabel lblAvailable = new JLabel("Buying Price");
		add(lblAvailable);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		add(horizontalStrut_2);
		
		JLabel lblToBuy = new JLabel("# to Buy");
		add(lblToBuy);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		add(horizontalStrut_3);

        setMarketPlaceAndInventory(marketPlace,inventory);
	}

    public void setMarketPlaceAndInventory(MarketPlace marketPlace, Inventory inventory){
        items = new JScrollPane();
        items.setVerticalScrollBar(new JScrollBar());
        items.setMinimumSize(new Dimension(20,20));
        for (Map.Entry<Tradable, Integer> item : inventory.getInventoryEntries()){
            Tradable itemInfo = item.getKey();
            int quantityAvailable = item.getValue();
            String itemName = itemInfo.getName();
            int itemPrice = itemInfo.getBasePrice();
            ItemRowPanel row = new ItemRowPanel(itemName, quantityAvailable,itemPrice,"Sell!",new SellToMarketListener(marketPlace,itemPrice,itemInfo, errorMessage));
            items.add(row);
            items.add(Box.createVerticalStrut(100));
        }
        add("items",items);
    }

}
