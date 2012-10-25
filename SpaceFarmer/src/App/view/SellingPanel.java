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
    private JList items;
	/**
	 * Create the panel.
	 */
	public SellingPanel(Inventory inventory, MarketPlace marketPlace) {
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

        setMarketPlaceAndInventory(marketPlace,inventory);
	}

    public void setMarketPlaceAndInventory(MarketPlace marketPlace, Inventory inventory){
        items = new JList();
        for (Map.Entry<Tradable, Integer> item : inventory.getInventoryEntries()){
            Tradable itemInfo = item.getKey();
            int quantityAvailable = item.getValue();
            String itemName = itemInfo.getName();
            int itemPrice = itemInfo.getBasePrice();
            ItemRowPanel row = new ItemRowPanel(itemName, quantityAvailable,itemPrice,"Sell!",new SellToMarketListener(marketPlace,itemPrice,itemInfo,quantityAvailable));
            items.add(row);
        }
        add(items);
    }

}
