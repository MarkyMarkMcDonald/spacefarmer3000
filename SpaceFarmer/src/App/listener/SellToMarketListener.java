package App.listener;

import App.model.Game;
import App.model.Inventory;
import App.model.MarketPlace;
import App.model.TradeGoods.Tradable;
import App.service.TransactionService;
import App.view.Display;
import App.view.Market.SellingPanel;
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
    private SellingPanel sellingPanel;
    private Inventory inventory;

    public SellToMarketListener(MarketPlace marketPlace, Inventory inventory,int price, Tradable good, JLabel errorMessage, SellingPanel sellingPanel) {
        super(marketPlace, price, good, errorMessage);
        this.sellingPanel = sellingPanel;
        this.inventory = inventory;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        super.actionPerformed(actionEvent);
        
        // Check for format mismatch
        if(quantityAsInt >= 0) {
	        boolean transactionIsSuccessful = TransactionService.sellToMarket(Game.getCurrentPlayer(), marketPlace, price, quantityAsInt, good);

	        // update view if there are no errors
	        if (transactionIsSuccessful){
                sellingPanel.setMarketPlaceAndInventory(marketPlace,inventory);
	            Display.updatePlayersInfo();
	        }
        } else {
	        Display.setMessage("Quantity must be a number.", MessageType.ERROR);
        }
    }
}
