package App.model;

/**
 * User: marky
 * Date: 10/21/12
 * Time: 5:58 PM
 */
abstract public class TradeGood {

    protected String name;
    protected TradeGoodType tradeGoodType;
    protected Enum tradeGoodSubName;

    public boolean equals(Tradeable tradeable){
        return tradeable.getName().equals(name);
    }

    public TradeGood(TradeGoodType tradeGoodType, Enum tradeGoodSubName){
        this.tradeGoodType = tradeGoodType;
        this.tradeGoodSubName = tradeGoodSubName;
    }

    public String getName(){
        return name;
    }

}
