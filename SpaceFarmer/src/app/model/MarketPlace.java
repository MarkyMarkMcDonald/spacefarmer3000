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
 * 
 * @author Mark,Bobbey
 * @version 1.0
 */
public class MarketPlace {
	/**
	 * Minimum subnames of a TradeGood that can appear in the MarketPlace.
	 */
	private static final int MINIMUM_SUBGOODS = 1;

	/**
	 * Maximum subnames of a TradeGood that can appear in the MarketPlace.
	 */
	private static final int MAXIMUM_SUBGOODS = 1;

	/**
	 * Value to be passed in the Randomizer.nextInt to determine how many
	 * subnames appear.
	 */
	private static final int RAND_ARGUMENT = MAXIMUM_SUBGOODS
			- MINIMUM_SUBGOODS + 1;

	/**
	 * Map of the goods in the MarketPlace to their prices.
	 */
	private final Map<Tradable, Integer> priceMap;

	/**
	 * Map of the goods in the MarketPlace to their quantities.
	 */
	private final Map<Tradable, Integer> quantityMap;

	/**
	 * Constructs a MarketPlace using a Planet.
	 * 
	 * @param planet
	 *            Planet from which the MarketPlace is constructed.
	 */
	public MarketPlace(Planet planet) {
		priceMap = new HashMap<Tradable, Integer>();
		quantityMap = new HashMap<Tradable, Integer>();
		for (TradeGoodType tradeGoodType : TradeGoodType.values()) {
			for (Object subName : Randomizer.multiRandElements(
					tradeGoodType.getSubNames(),
					MINIMUM_SUBGOODS
							+ Randomizer.nextInt(RAND_ARGUMENT))) {
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

	/**
	 * Sets a TradeGoodType to a given quantity.
	 * @param tradable TradeGoodType to be modified.
	 * @param quantity Quantity to set it to.
	 */
	public void setQuantity(Tradable tradable, int quantity) {
		quantityMap.put(tradable, quantity);
	}

	/**
	 * Alters the quantity of a TradeGoodType by a particular amount.
	 * @param tradable TradeGoodType to be modified.
	 * @param amount by which to increase the quantity of the TradeGoodType.
	 */
	public void changeQuantity(Tradable tradable, int amount) {
		if (quantityMap.containsKey(tradable)) {
			quantityMap.put(tradable, quantityMap.get(tradable) + amount);
		} else {
			quantityMap.put(tradable, amount);
		}
	}

	/**
	 * Varies each of the TradeGoodTypes prices based on the Planet the
	 * MarketPlace is on.
	 * @param planet Planet on which to vary the prices.
	 */
	public void updatePrices(Planet planet) {
		// {
		// for (Tradable t: priceMap.keySet().toArray(new Tradable[0]))
		// priceMap.put(t, t.calculatePrice(planet));
		// Required calculatePrice in Tradable inferface.
		// TODO: This! (this is bad practice btw, don't make these like this)
	}

	/**
	 * @return Map of the goods in the MarketPlace to the prices.
	 */
	public Map<Tradable, Integer> getPriceMap() {
		return priceMap;
	}

	/**
	 * @return Map of the goods in the MarketPlace to the quantities.
	 */
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
