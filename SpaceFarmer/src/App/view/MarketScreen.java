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

        Box.createVerticalStrut(20);
		buyingPanel = new BuyingPanel(marketPlace, errorMessage);
		add("buy",buyingPanel);
        add(Box.createVerticalStrut(20));

		sellingPanel = new SellingPanel(Game.getCurrentPlayer().getInventory(),marketPlace, errorMessage);
		add("sell",sellingPanel);

	}

    public MarketPlace getMarketPlace() {
        return marketPlace;
    }

    public void setMarketPlace(MarketPlace marketPlace) {
        this.marketPlace = marketPlace;

        add(Box.createVerticalStrut(20));
        buyingPanel = new BuyingPanel(marketPlace, errorMessage);
        add("buy",buyingPanel);


        add(Box.createVerticalStrut(20));
        sellingPanel = new SellingPanel(Game.getCurrentPlayer().getInventory(),marketPlace, errorMessage);
        add("sell",sellingPanel);

    }

}
