package App.model;

/**
 * User: marky
 * Date: 10/21/12
 * Time: 5:58 PM
 */
abstract public class TradeGood {

    protected String name;
    protected TradeGoodType tradeGoodType;
    protected Enum tradeGoodSubname;

    public boolean equals(Tradeable tradeable){
        return tradeable.getName().equals(name);
    }

    public String getName(){
        return name;
    }

}
