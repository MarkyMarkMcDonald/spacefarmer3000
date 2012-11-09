package App.listener;

import App.model.Inventory;
import App.model.MarketPlace;
import App.view.Market.BuyingPanel;
import App.view.Market.SellingPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: mark.mcdonald
 * Date: 11/7/12
 * Time: 3:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class ToggleBuyingAndSellingListener implements ActionListener {
    JButton toggleButton;
    BuyingPanel buyingPanel;
    SellingPanel sellingPanel;
    MarketPlace marketPlace;
    Inventory inventory;

    public ToggleBuyingAndSellingListener(JButton toggleButton, BuyingPanel buyingPanel, SellingPanel sellingPanel, MarketPlace marketPlace, Inventory inventory) {
        this.toggleButton = toggleButton;
        this.buyingPanel = buyingPanel;
        this.sellingPanel = sellingPanel;
        this.marketPlace = marketPlace;
        this.inventory = inventory;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        // Switch to Selling Mode
        if (toggleButton.getText().contains("Sell")){
            toggleButton.setText("Buy From Market");
            buyingPanel.setVisible(false);
            sellingPanel.setMarketPlaceAndInventory(marketPlace,inventory);
            sellingPanel.setVisible(true);
        }
        // Switch to Buying Mode
        else {
            toggleButton.setText("Sell To Market");
            sellingPanel.setVisible(false);
            buyingPanel.setMarket(marketPlace);
            buyingPanel.setVisible(true);
        }
    }

    public void setMarketPlace(MarketPlace marketPlace) {
        this.marketPlace = marketPlace;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
