package App.view;

import App.listener.BuyFromMarketListener;
import App.model.MarketPlace;
import App.model.Tradable;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Map;

/**
 * This Panel represents the purchasing view when on a planet.
 * @author Mark McDonald
 */
public class BuyingPanel extends JPanel {
    private JPanel items;
    private JLabel errorMessage;
	/**
	 * Create the panel.
	 */
	public BuyingPanel(MarketPlace marketPlace, JLabel errorMessage) {
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

        setMarket(marketPlace);
	}

    /**
     * This gets rid of all the old items in the buying panel and replaces them with the updated items
     * @param marketPlace to be used to determine item quantities and prices
     */
    public void setMarket(MarketPlace marketPlace){
        items = new JPanel();
        items.setLayout(new BoxLayout(items,BoxLayout.Y_AXIS));

        for (Map.Entry<Tradable, Integer> item : marketPlace.getQuantityMap().entrySet()){
            JPanel rowPanel = new JPanel();
            Tradable itemInfo = item.getKey();
            int quantityAvailable = item.getValue();
            String itemName = itemInfo.getName();
            int itemPrice = itemInfo.getBasePrice();
            ItemRowPanel row = new ItemRowPanel(itemName, quantityAvailable,itemPrice,"Buy!",new BuyFromMarketListener(marketPlace,itemPrice,itemInfo,errorMessage));
            rowPanel.add(row);
            items.add(rowPanel);
        }
        items.setBorder(new LineBorder(Color.black));
        add(items);
    }
}
