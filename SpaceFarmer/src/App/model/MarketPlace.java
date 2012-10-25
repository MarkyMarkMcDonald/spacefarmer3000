package App.model;

import App.service.Randomizer;

import java.util.HashMap;
import java.util.Map;
/**
 * Created with IntelliJ IDEA.
 * User: Marky
 * Date: 9/22/12
 * Time: 12:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class MarketPlace {
	
	private Map<Tradable,Integer> priceMap;
	private Map<Tradable,Integer> quantityMap;

	public MarketPlace(Planet planet)
	{
        priceMap = new HashMap<Tradable, Integer>();
        quantityMap = new HashMap<Tradable, Integer>();
        for (TradeGoodType tradeGoodType : TradeGoodType.values()){
            for (Enum subName : tradeGoodType.getSubNames()){
                if (Randomizer.determineSuccess(.5)){
                    BasicGood good = new BasicGood(tradeGoodType, subName);
                    
                    int quantity = tradeGoodType.determineQuantity(planet);
                    int cost = tradeGoodType.calculatePrice(planet);
                    //Note: prices are already varied in calculatePrice
                    //int finalCost = baseCost + Randomizer.nextInt((int) (baseCost * .05));
                    priceMap.put(good,cost);
                    quantityMap.put(good,quantity);
                }
            }
        }
	}
	
	/*
	 * Sets a TradeGoodType to a given quantity.
	 */
	public void setQuantity(Tradable Tradable, int quantity)
	{
		quantityMap.put(Tradable,quantity);
	}
	
	/*
	 * Alters the quantity of a TradeGoodType by a particular amount.
	 */
	public void changeQuantity(Tradable Tradable, int amount)
	{
		quantityMap.put(Tradable, quantityMap.get(Tradable)+amount);
	}
	
	/*
	 * Varies each of the TradeGoodTypes prices based on the Planet
	 * the MarketPlace is on.
	 */
	public void updatePrices(Planet planet){
//	{
//		for (Tradable t: priceMap.keySet().toArray(new Tradable[0]))
//			priceMap.put(t, t.calculatePrice(planet));
		//Required calculatePrice in Tradable inferface.
		//TODO: This! (this is bad practice btw, don't make these like this)
	}

    public Map<Tradable, Integer> getPriceMap(){
        return priceMap;
    }

    public Map<Tradable, Integer> getQuantityMap() {
        return quantityMap;
    }
}
