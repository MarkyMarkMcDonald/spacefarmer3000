package App.view;

/**
 * Created with Eclipse.
 *
 */

import App.model.Game;
import App.model.MarketPlace;

import javax.swing.*;
import java.awt.*;

public class MarketScreen extends Screen {

    private MarketPlace marketPlace;
    private BuyingPanel buyingPanel;
    private SellingPanel sellingPanel;

    public MarketScreen(){
        name = CardName.MARKETPLACE_CARD;

        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JLabel lblMarketPlace = new JLabel("Market Place");
        panel.add(lblMarketPlace);
    }

	/**
	 * Create the panel.
	 */
	public MarketScreen(MarketPlace marketPlace) {
        name = CardName.MARKETPLACE_CARD;

		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JLabel lblMarketPlace = new JLabel("Market Place");
		panel.add(lblMarketPlace);
		
		buyingPanel = new BuyingPanel(marketPlace);
		add(buyingPanel);
		
		sellingPanel = new SellingPanel(Game.getCurrentPlayer().getInventory(),marketPlace);
		add(sellingPanel);
	}

    public MarketPlace getMarketPlace() {
        return marketPlace;
    }

    public void setMarketPlace(MarketPlace marketPlace) {
        this.marketPlace = marketPlace;

        buyingPanel = new BuyingPanel(marketPlace);
        add(buyingPanel);

        sellingPanel = new SellingPanel(Game.getCurrentPlayer().getInventory(),marketPlace);
        add(sellingPanel);
    }

}
