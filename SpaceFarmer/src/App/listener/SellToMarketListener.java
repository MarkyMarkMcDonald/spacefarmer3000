package App.listener;

import App.model.Game;
import App.model.MarketPlace;
import App.model.Tradable;
import App.service.TransactionService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: mark.mcdonald
 * Date: 10/24/12
 * Time: 5:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class SellToMarketListener implements ActionListener {

    private MarketPlace marketPlace;
    private int price;
    private Tradable good;
    private int quantity;

    public SellToMarketListener(MarketPlace marketPlace, int price, Tradable good, int quantity) {
        this.marketPlace = marketPlace;
        this.price = price;
        this.good = good;
        this.quantity = quantity;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String message = TransactionService.sellToMarket(Game.getCurrentPlayer(),marketPlace,price, quantity,good);
    }
}
