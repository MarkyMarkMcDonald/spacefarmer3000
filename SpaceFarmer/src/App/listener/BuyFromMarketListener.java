package App.listener;

import App.model.Game;
import App.model.MarketPlace;
import App.model.TradeGoods.Tradable;
import App.service.TransactionService;
import App.view.Display;
import App.view.Market.SellingPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created with IntelliJ IDEA.
 * User: mark.mcdonald
 * Date: 10/24/12
 * Time: 5:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class BuyFromMarketListener extends TransactionListener{

    private SellingPanel sellingPanel;

    public BuyFromMarketListener(MarketPlace marketPlace, int price, Tradable good, JLabel errorMessage, SellingPanel sellingPanel) {
        super(marketPlace, price, good, errorMessage);
        this.sellingPanel= sellingPanel;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        super.actionPerformed(actionEvent);
        
        // Do not buy something if there's a format mismatch
        if(quantityAsInt >= 0) {
	        boolean transactionSuccess= TransactionService.buyFromMarket(Game.getCurrentPlayer(), marketPlace, price, quantityAsInt, good);

	        // update views if there weren't errors
	        if (transactionSuccess){
	            sellingPanel.setMarketPlaceAndInventory(marketPlace,Game.getCurrentPlayer().getInventory());
	
	            Display.updatePlayersInfo();
	        }
        } else {
            errorMessage.setText("Quantity must be a number.");
            errorMessage.setVisible(true);
        }
    }
}
