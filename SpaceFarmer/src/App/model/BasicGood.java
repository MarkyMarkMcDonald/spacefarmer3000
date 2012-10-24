package App.model;

/**
 * User: marky
 * Date: 10/22/12
 * Time: 3:15 PM
 */
public class BasicGood extends  TradeGood implements Tradeable {
    public BasicGood(TradeGoodType tradeGoodType, Enum tradeGoodSubName){
        super(tradeGoodType, tradeGoodSubName);
        this.name = tradeGoodSubName.toString();
    }


}
