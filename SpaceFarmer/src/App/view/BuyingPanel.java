package App.view;

import App.listener.BuyFromMarketListener;
import App.model.MarketPlace;
import App.model.TradeGoods.Tradable;

import javax.swing.*;
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
        setAlignmentY(Component.TOP_ALIGNMENT);
        this.errorMessage = errorMessage;
        JPanel headings = new HeadingPanel("Item","# Available", "Buying Price", "# to Buy");
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

            // Set item's background color based on comparison of market price and base price
            int ratio =  itemPrice / itemInfo.getBasePrice() * 100;
            if (ratio < 50){
                row.setBackground(Color.green);
            }
            else if (ratio >= 50 && ratio <= 150){
                row.setBackground(Color.yellow);
            }
            else {
                row.setBackground(Color.red);
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

    public void setSellingPanel(SellingPanel sellingPanel) {
        this.sellingPanel = sellingPanel;
    }
}
