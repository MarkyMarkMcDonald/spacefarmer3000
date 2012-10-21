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
	
	private Map<TradeGood,Integer> priceMap;
	private Map<TradeGood,Integer> quantityMap;
	private Planet planet; 
	
	public MarketPlace(Planet planet)
	{
		priceMap=new HashMap<TradeGood,Integer>(TradeGood.values().length);
		quantityMap=new HashMap<TradeGood,Integer>(TradeGood.values().length);
		for (TradeGood t: TradeGood.values())
		{
			if (t.buyable(planet))
				quantityMap.put(t, t.determineQuantity(planet));
			else
				quantityMap.put(t, 0);
			priceMap.put(t, t.calculatePrice(planet));
				
		}
		this.planet=planet;
	}
	public void setQuantity(TradeGood good, int quantity)
	{
		quantityMap.put(good,quantity);
	}
	
	public void changeQuantity(TradeGood good, int amount)
	{
		quantityMap.put(good, quantityMap.get(good)+amount);
	}
	
	public void updatePrices()
	{
		for (TradeGood t: TradeGood.values())
		{
			priceMap.put(t, t.calculatePrice(planet));
		}
	}
}
