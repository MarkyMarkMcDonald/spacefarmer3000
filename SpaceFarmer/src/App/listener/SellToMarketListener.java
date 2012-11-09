package App.listener;

import App.model.Game;
import App.model.MarketPlace;
import App.model.TradeGoods.Tradable;
import App.service.TransactionService;
import App.view.Display;
import App.view.Market.BuyingPanel;
import App.view.SidePanels.MessageType;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created with IntelliJ IDEA.
 * User: mark.mcdonald
 * Date: 10/24/12
 * Time: 5:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class SellToMarketListener extends TransactionListener {
    private BuyingPanel buyingPanel;

    public SellToMarketListener(MarketPlace marketPlace, int price, Tradable good, JLabel errorMessage, BuyingPanel buyingPanel) {
        super(marketPlace, price, good, errorMessage);
        this.buyingPanel = buyingPanel;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        super.actionPerformed(actionEvent);
        
        // Do nothing is there's a format mismatch
        if(quantityAsInt >= 0) {
	        boolean transactionIsSuccessful = TransactionService.sellToMarket(Game.getCurrentPlayer(), marketPlace, price, quantityAsInt, good);

	        // update view if there are no errors
	        if (transactionIsSuccessful){
	            buyingPanel.setMarket(marketPlace);

	            Display.updatePlayersInfo();
	        }
        } else {
	        Display.setMessage("Quantity must be a number.", MessageType.ERROR);
        }
    }
}
