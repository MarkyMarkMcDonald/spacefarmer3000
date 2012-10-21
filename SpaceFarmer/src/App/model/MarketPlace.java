package App.model;

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
	private Planet planet; 
	
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
		this.planet=planet;
	}
	public void setQuantity(TradeGoodType goodType, int quantity)
	{
		quantityMap.put(goodType,quantity);
	}
	
	public void changeQuantity(TradeGoodType goodType, int amount)
	{
		quantityMap.put(goodType, quantityMap.get(goodType)+amount);
	}
	
	public void updatePrices()
	{
		for (TradeGoodType t: TradeGoodType.values())
		{
			priceMap.put(t, t.calculatePrice(planet));
		}
	}
}
