package App.listener;

import App.model.Game;
import App.model.MarketPlace;
import App.model.TradeGoods.Tradable;
import App.service.TransactionService;
import App.view.Display;
import App.view.SidePanels.PlayersInformationSidePanel;
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
	        String message = TransactionService.buyFromMarket(Game.getCurrentPlayer(), marketPlace, price, quantityAsInt, good);
	        errorMessage.setText(message);
	        errorMessage.setVisible(true);
	        
	        // update views if there weren't errors
	        if (!message.contains("You need")){
	            int previousQuantity = Integer.parseInt(shownQuantity.getText());
	            int changedQuantity = Integer.parseInt(message.split(" ")[2]);
	            String newQuantity = Integer.toString(previousQuantity - changedQuantity);
	            shownQuantity.setText(newQuantity);
	
	            sellingPanel.setMarketPlaceAndInventory(marketPlace,Game.getCurrentPlayer().getInventory());
	
	            PlayersInformationSidePanel playersInformationSidePanel = (PlayersInformationSidePanel) Display.getSidePanel("Bot");
	            playersInformationSidePanel.updateBasedOnAllPlayers();
	        }
        } else {
            errorMessage.setText("Quantity must be a number.");
            errorMessage.setVisible(true);
        }
    }
}
