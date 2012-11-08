package App.view;

import App.listener.ToggleBuyingAndSellingListener;
import App.model.Game;
import App.model.Inventory;
import App.model.MarketPlace;

import javax.swing.*;


/**
 * This screen represents a marketplace with multiple buying/selling venues. (WIP)
 * @author Ivory Assan, Mark McDonald
 */
public class MarketScreen extends Screen {

    private BuyingPanel buyingPanel;
    private SellingPanel sellingPanel;
    private ToggleBuyingAndSellingListener toggleBuyingAndSellingListener;
    private JLabel errorMessage;

    public MarketScreen(){
        name = CardName.MARKETPLACE_CARD;
        errorMessage = new JLabel();
        errorMessage.setVisible(false);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel lblMarketPlace = new JLabel("Market Place");
        add(lblMarketPlace);
        add(errorMessage);

        buyingPanel = new BuyingPanel(errorMessage);
        sellingPanel = new SellingPanel(errorMessage);
        sellingPanel.setVisible(false);

        JButton toggleBuyAndSellButton = new JButton("Sell To Market");
        toggleBuyingAndSellingListener = new ToggleBuyingAndSellingListener(toggleBuyAndSellButton,buyingPanel,sellingPanel,null,null);
        toggleBuyAndSellButton.addActionListener(toggleBuyingAndSellingListener);

        add(toggleBuyAndSellButton);

        JPanel transactionPanel = new JPanel();
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
        buyingPanel.setSellingPanel(sellingPanel);
        sellingPanel.setBuyingPanel(buyingPanel);

        Inventory currentPlayersInventory = Game.getCurrentPlayer().getInventory();

        buyingPanel.setMarket(marketPlace);
        sellingPanel.setMarketPlaceAndInventory(marketPlace, currentPlayersInventory);

        toggleBuyingAndSellingListener.setMarketPlace(marketPlace);
        toggleBuyingAndSellingListener.setInventory(currentPlayersInventory);
        if (errorMessage != null) {
            errorMessage.setVisible(false);
        }
    }

}
