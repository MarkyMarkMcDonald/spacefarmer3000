package App.view;

import App.listener.SellToMarketListener;
import App.model.MarketPlace;
import App.model.Tradable;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Map;

public class BuyingPanel extends JPanel {
    private JList items;
	/**
	 * Create the panel.
	 */
	public BuyingPanel(MarketPlace marketPlace) {
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

        setMarket(marketPlace);
	}


    public void setMarket(MarketPlace marketPlace){
        items = new JList();
        for (Map.Entry<Tradable, Integer> item : marketPlace.getQuantityMap().entrySet()){
            Tradable itemInfo = item.getKey();
            int quantityAvailable = item.getValue();
            String itemName = itemInfo.getName();
            int itemPrice = itemInfo.getBasePrice();
            ItemRowPanel row = new ItemRowPanel(itemName, quantityAvailable,itemPrice,"Sell!",new SellToMarketListener(marketPlace,itemPrice,itemInfo,quantityAvailable));
            items.add(row);
        }
        items.setBorder(new LineBorder(Color.black));
        add(items);
    }

}
