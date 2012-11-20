package app.model;

import java.util.HashMap;
import java.util.Map;

import app.model.TradeGoods.BasicGood;
import app.model.TradeGoods.Tradable;
import app.model.TradeGoods.TradeGoodType;
import app.model.Universe.Planet;
import app.service.Randomizer;

/**
 * Created with IntelliJ IDEA. User: Marky Date: 9/22/12 Time: 12:33 AM To
 * change this template use File | Settings | File Templates.
 */
public class MarketPlace {
	private static final int MINIMUM_SUBGOODS = 1;

	private static final int MAXIMUM_SUBGOODS = 1;

	private Map<Tradable, Integer> priceMap;

	private Map<Tradable, Integer> quantityMap;

	public MarketPlace(Planet planet) {
		priceMap = new HashMap<Tradable, Integer>();
		quantityMap = new HashMap<Tradable, Integer>();
		for (TradeGoodType tradeGoodType : TradeGoodType.values()) {
			for (Object subName : Randomizer.randElements(
					tradeGoodType.getSubNames(),
					MINIMUM_SUBGOODS
							+ Randomizer.nextInt(MAXIMUM_SUBGOODS
									- MINIMUM_SUBGOODS + 1))) {
				BasicGood good = new BasicGood(tradeGoodType, (Enum<?>) subName);
				int quantity = tradeGoodType.determineQuantity(planet);
				quantityMap.put(good, quantity);
			}
		}
		// Two for loops, because market will not have every good, but knows the
		// price of all goods.
		for (TradeGoodType tradeGoodType : TradeGoodType.values()) {
			for (Object subName : tradeGoodType.getSubNames()) {
				BasicGood good = new BasicGood(tradeGoodType, (Enum<?>) subName);
				priceMap.put(good, tradeGoodType.calculatePrice(planet));
			}
		}
	}

	/*
	 * Sets a TradeGoodType to a given quantity.
	 */
	public void setQuantity(Tradable tradable, int quantity) {
		quantityMap.put(tradable, quantity);
	}

	/*
	 * Alters the quantity of a TradeGoodType by a particular amount.
	 */
	public void changeQuantity(Tradable tradable, int amount) {
		if (quantityMap.containsKey(tradable)) {
			quantityMap.put(tradable, quantityMap.get(tradable) + amount);
		} else {
			quantityMap.put(tradable, amount);
		}
	}

	/*
	 * Varies each of the TradeGoodTypes prices based on the Planet the
	 * MarketPlace is on.
	 */
	public void updatePrices(Planet planet) {
		// {
		// for (Tradable t: priceMap.keySet().toArray(new Tradable[0]))
		// priceMap.put(t, t.calculatePrice(planet));
		// Required calculatePrice in Tradable inferface.
		// TODO: This! (this is bad practice btw, don't make these like this)
	}

	public Map<Tradable, Integer> getPriceMap() {
		return priceMap;
	}

	public Map<Tradable, Integer> getQuantityMap() {
		return quantityMap;
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "MarketPlace";
	}
}
