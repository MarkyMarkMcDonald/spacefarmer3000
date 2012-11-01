package App.view;

import App.model.Game;
import App.model.MarketPlace;

import javax.swing.*;

/**
 * This screen represents a marketplace with multiple buying/selling venues. (WIP)
 * @author Ivory Assan, Mark McDonald
 */
public class MarketScreen extends Screen {

    private MarketPlace marketPlace;
    private BuyingPanel buyingPanel;
    private SellingPanel sellingPanel;
    private JPanel transactionPanel;
    private JLabel errorMessage;

    public MarketScreen(){
        name = CardName.MARKETPLACE_CARD;
        errorMessage = new JLabel();
        errorMessage.setVisible(false);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel lblMarketPlace = new JLabel("Market Place");
        add(lblMarketPlace);

        buyingPanel = new BuyingPanel(errorMessage);
        sellingPanel = new SellingPanel(errorMessage);

        transactionPanel = new JPanel();
        transactionPanel.setLayout(new BoxLayout(transactionPanel, BoxLayout.X_AXIS));
        transactionPanel.add(buyingPanel);
        transactionPanel.add(sellingPanel);
        add(transactionPanel);
    }

	/**
	 * Create the panel.
	 */
	public MarketScreen(MarketPlace marketPlace) {
        this();
        updateMarketPlace(marketPlace);
	}


    public void updateMarketPlace(MarketPlace marketPlace) {
        this.marketPlace = marketPlace;

        buyingPanel.setSellingPanel(sellingPanel);
        sellingPanel.setBuyingPanel(buyingPanel);
        buyingPanel.setMarket(marketPlace);
        sellingPanel.setMarketPlaceAndInventory(marketPlace,Game.getCurrentPlayer().getInventory());

    }

}
