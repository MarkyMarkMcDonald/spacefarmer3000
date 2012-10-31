package App.listener;

import App.model.Game;
import App.model.MarketPlace;
import App.model.Tradable;
import App.service.TransactionService;

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

    public SellToMarketListener(MarketPlace marketPlace, int price, Tradable good, JLabel errorMessage) {
        super(marketPlace, price, good, errorMessage);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        super.actionPerformed(actionEvent);
        String message = TransactionService.sellToMarket(Game.getCurrentPlayer(), marketPlace, price, quantityAsInt, good);
        errorMessage.setText(message);
        errorMessage.setVisible(true);
    }

}
