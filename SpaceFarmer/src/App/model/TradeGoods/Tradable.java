package App.model.TradeGoods;

/**
 * Created with IntelliJ IDEA.
 * User: Marky
 * Date: 9/22/12
 * Time: 12:31 AM
 * To change this template use File | Settings | File Templates.
 */
public interface Tradable {

    public boolean equals(Tradable tradable);
    

    public int getBasePrice();

    public String getName();
}