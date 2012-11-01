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
    private SellingPanel sellingPanel;



    /**
	 * Create the panel.
	 */
	public BuyingPanel(JLabel errorMessage) {
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
		
		JLabel lblAvailable = new JLabel("Buying Price");
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
     * This gets rid of all the old items in the buying panel and replaces them with the updated items
     * @param marketPlace to be used to determine item quantities and prices
     */
    public void setMarket(MarketPlace marketPlace){
        items.removeAll();
        items.setLayout(new BoxLayout(items,BoxLayout.Y_AXIS));

        for (Map.Entry<Tradable, Integer> item : marketPlace.getQuantityMap().entrySet()){
            JPanel rowPanel = new JPanel();
            Tradable itemInfo = item.getKey();
            int quantityAvailable = item.getValue();
            String itemName = itemInfo.getName();
            int itemPrice = marketPlace.getPriceMap().get(itemInfo);
            ItemRowPanel row = new ItemRowPanel(itemName, quantityAvailable,itemPrice,"Buy!", new BuyFromMarketListener(marketPlace,itemPrice,itemInfo,errorMessage, sellingPanel));
            rowPanel.add(row);
            items.add(rowPanel);
        }
        items.setBorder(new LineBorder(Color.black));

        add("items", items);
    }

    public void setErrorMessage(JLabel errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setSellingPanel(SellingPanel sellingPanel) {
        this.sellingPanel = sellingPanel;
    }
}
