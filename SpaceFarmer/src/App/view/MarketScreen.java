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
    private JLabel errorMessage;

    public MarketScreen(){
        name = CardName.MARKETPLACE_CARD;
        errorMessage = new JLabel();
        errorMessage.setVisible(false);
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

        errorMessage = new JLabel();
        add(errorMessage);
        errorMessage.setVisible(false);

        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JLabel lblMarketPlace = new JLabel("Market Place");
		panel.add(lblMarketPlace);

        setMarketPlace(marketPlace);

	}

    public MarketPlace getMarketPlace() {
        return marketPlace;
    }

    public void setMarketPlace(MarketPlace marketPlace) {
        this.marketPlace = marketPlace;

        buyingPanel = new BuyingPanel(errorMessage);
        sellingPanel = new SellingPanel(errorMessage);
        buyingPanel.setSellingPanel(sellingPanel);
        sellingPanel.setBuyingPanel(buyingPanel);
        buyingPanel.setMarket(marketPlace);
        sellingPanel.setMarketPlaceAndInventory(marketPlace,Game.getCurrentPlayer().getInventory());

        add(Box.createVerticalStrut(20));
        add("buy",buyingPanel);

        add(Box.createVerticalStrut(20));
        add("sell",sellingPanel);

    }

}
