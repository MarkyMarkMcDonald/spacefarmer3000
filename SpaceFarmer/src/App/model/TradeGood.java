package App.model;

/**
 * User: marky
 * Date: 10/21/12
 * Time: 5:58 PM
 */
abstract public class TradeGood {

    protected String name;
    protected TradeGoodType tradeGoodType;

    public boolean equals(TradeGood tradeGood){
        return tradeGood.getName().equals(name);
    }
    
    public TradeGood(TradeGoodType tradeGoodType)
    {
    	name=tradeGoodType.getName();
    	this.tradeGoodType=tradeGoodType;
    }

    public String getName(){
        return name;
    }

    public int calculatePrice(Planet planet)
    {
    	return tradeGoodType.calculatePrice(planet);
    }
    
    public int determineQuantity(Planet planet)
    {
    	return tradeGoodType.determineQuantity(planet);
    }
}
