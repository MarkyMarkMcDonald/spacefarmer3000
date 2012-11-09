package App.listener;

import App.model.MarketPlace;
import App.model.TradeGoods.Tradable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: mark.mcdonald
 * Date: 10/31/12
 * Time: 2:07 AM
 * To change this template use File | Settings | File Templates.
 */
abstract public class TransactionListener implements ActionListener{
    protected MarketPlace marketPlace;
    protected int price;
    protected Tradable good;
    protected JTextField quantity;
    protected JLabel errorMessage;
    protected int quantityAsInt;
    protected JLabel shownQuantity;

    protected TransactionListener(MarketPlace marketPlace, int price, Tradable good, JLabel errorMessage) {
        this.marketPlace = marketPlace;
        this.price = price;
        this.good = good;
        this.errorMessage = errorMessage;
    }

    public void setQuantity(JTextField quantity) {
        this.quantity = quantity;
    }

    public void setShownQuantity(JLabel shownQuantity) {
        this.shownQuantity = shownQuantity;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        quantityAsInt = Integer.parseInt(quantity.getText());
    }

}
