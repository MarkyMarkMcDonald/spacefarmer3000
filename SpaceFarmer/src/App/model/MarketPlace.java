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
	
	private Map<Tradeable,Integer> priceMap;
	private Map<Tradeable,Integer> quantityMap;
	
	public MarketPlace(Planet planet)
	{

	}
	
	/*
	 * Sets a TradeGoodType to a given quantity.
	 */
	public void setQuantity(Tradeable tradeable, int quantity)
	{
		quantityMap.put(tradeable,quantity);
	}
	
	/*
	 * Alters the quantity of a TradeGoodType by a particular amount.
	 */
	public void changeQuantity(Tradeable tradeable, int amount)
	{
		quantityMap.put(tradeable, quantityMap.get(tradeable)+amount);
	}
	
	/*
	 * Varies each of the TradeGoodTypes prices based on the Planet
	 * the MarketPlace is on.
	 */
	public void updatePrices(Planet planet)
	{
		//TODO: This! (this is bad practice btw, don't make thse like this)
	}
}
