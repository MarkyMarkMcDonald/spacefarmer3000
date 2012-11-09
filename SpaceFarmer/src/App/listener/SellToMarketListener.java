package App.listener;

import App.model.Game;
import App.model.MarketPlace;
import App.model.TradeGoods.Tradable;
import App.service.TransactionService;
import App.view.BuyingPanel;
import App.view.Display;
import App.view.PlayersInformationSidePanel;

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
	        String message = TransactionService.sellToMarket(Game.getCurrentPlayer(), marketPlace, price, quantityAsInt, good);
	        errorMessage.setText(message);
	        errorMessage.setVisible(true);
	
	        // update view if there are no errors
	        if (!message.contains("You need")){
	            int previousQuantity = Integer.parseInt(shownQuantity.getText());
	            int changedQuantity = Integer.parseInt(message.split(" ")[2]);
	            String newQuantity = Integer.toString(previousQuantity - changedQuantity);
	            shownQuantity.setText(newQuantity);
	
	            buyingPanel.setMarket(marketPlace);
	
	            PlayersInformationSidePanel playersInformationSidePanel = (PlayersInformationSidePanel) Display.getSidePanel("Bot");
	            playersInformationSidePanel.updateBasedOnAllPlayers();
	        }
        } else {
	        errorMessage.setText("Quantity must be a number.");
	        errorMessage.setVisible(true);
        }
    }
}
