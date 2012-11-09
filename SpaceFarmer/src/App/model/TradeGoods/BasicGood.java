package App.model.TradeGoods;

/**
 * User: marky
 * Date: 10/22/12
 * Time: 3:15 PM
 */
public class BasicGood extends TradeGood implements Tradable {
    public BasicGood(TradeGoodType tradeGoodType, Enum<?> tradeGoodSubName){
        super(tradeGoodType, tradeGoodSubName);
        this.name = tradeGoodSubName.toString();
    }
    public boolean equals(Object object){
        return super.equals(object);
    }
}
