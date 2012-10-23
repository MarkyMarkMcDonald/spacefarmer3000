package App.model;

import java.lang.reflect.InvocationTargetException;
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
	
	private Map<TradeGoodType,Integer> priceMap;
	private Map<TradeGoodType,Integer> quantityMap;
	
	public MarketPlace(Planet planet)
	{
		priceMap=new HashMap<TradeGoodType,Integer>(TradeGoodType.values().length);
		quantityMap=new HashMap<TradeGoodType,Integer>(TradeGoodType.values().length);
		for (TradeGoodType t: TradeGoodType.values())
		{
			if (t.buyable(planet))
				quantityMap.put(t, t.determineQuantity(planet));
			else
				quantityMap.put(t, 0);
			priceMap.put(t, t.calculatePrice(planet));
				
		}
	}
	
	/*
	 * Sets a TradeGoodType to a given quantity.
	 */
	public void setQuantity(TradeGoodType goodType, int quantity)
	{
		quantityMap.put(goodType,quantity);
	}
	
	/*
	 * Alters the quantity of a TradeGoodType by a particular amount.
	 */
	public void changeQuantity(TradeGoodType goodType, int amount)
	{
		quantityMap.put(goodType, quantityMap.get(goodType)+amount);
	}
	
	/*
	 * Varies each of the TradeGoodTypes prices based on the Planet
	 * the MarketPlace is on.
	 */
	public void updatePrices(Planet planet)
	{
		for (TradeGoodType t: TradeGoodType.values())
		{
			priceMap.put(t, t.calculatePrice(planet));
		}
	}
}
