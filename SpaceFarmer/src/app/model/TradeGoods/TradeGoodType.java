package app.model.TradeGoods;

import static app.model.Event.BOREDOM;
import static app.model.Event.COLD;
import static app.model.Event.CROPFAIL;
import static app.model.Event.DROUGHT;
import static app.model.Event.LACKOFWORKERS;
import static app.model.Event.PLAGUE;
import static app.model.Event.WAR;
import static app.model.Universe.ResourceType.ARTISTIC;
import static app.model.Universe.ResourceType.DESERT;
import static app.model.Universe.ResourceType.LIFELESS;
import static app.model.Universe.ResourceType.LOTS_OF_HERBS;
import static app.model.Universe.ResourceType.LOTS_OF_WATER;
import static app.model.Universe.ResourceType.MINERAL_POOR;
import static app.model.Universe.ResourceType.MINERAL_RICH;
import static app.model.Universe.ResourceType.NONE;
import static app.model.Universe.ResourceType.POOR_SOIL;
import static app.model.Universe.ResourceType.RICH_FAUNA;
import static app.model.Universe.ResourceType.RICH_SOIL;
import static app.model.Universe.ResourceType.WARLIKE;
import static app.model.Universe.ResourceType.WEIRD_MUSHROOMS;
import static app.model.Universe.TechnologyLevel.AGRICULTURE;
import static app.model.Universe.TechnologyLevel.EARLY_INDUSTRIAL;
import static app.model.Universe.TechnologyLevel.HI_TECH;
import static app.model.Universe.TechnologyLevel.INDUSTRIAL;
import static app.model.Universe.TechnologyLevel.MEDIEVAL;
import static app.model.Universe.TechnologyLevel.POST_INDUSTRIAL;
import static app.model.Universe.TechnologyLevel.PRE_AGRICULTURE;
import static app.model.Universe.TechnologyLevel.RENAISSANCE;

import java.util.EnumSet;

import app.model.Event;
import app.model.Universe.Planet;
import app.model.Universe.ResourceType;
import app.model.Universe.TechnologyLevel;
import app.service.Randomizer;
import conf.TradeGoodNames.Firearms;
import conf.TradeGoodNames.Food;
import conf.TradeGoodNames.Furs;
import conf.TradeGoodNames.Games;
import conf.TradeGoodNames.Machines;
import conf.TradeGoodNames.Medicine;
import conf.TradeGoodNames.Narcotics;
import conf.TradeGoodNames.Ore;
import conf.TradeGoodNames.Robots;
import conf.TradeGoodNames.Water;

/**
 * Created with IntelliJ IDEA. User: Marky Date: 9/22/12 Time: 12:31 AM To
 * change this template use File | Settings | File Templates.
 */

public enum TradeGoodType {

	WATER, FURS, FOOD, ORE, GAMES, FIREARMS, MDEDICINE, MACHINES, NARCOTICS, ROBOTS;

	/**
	 * Amount by which the price of a good increases in a price increase Event.
	 */
	private static final double INCREASE_AMOUNT = 1.5;

	/**
	 * Amount by which the quantity of a good is reduced in a low condition
	 * ResourceType.
	 */
	private static final double REDUCED_QUANTITY = .5;

	/**
	 * Amount by which the quantity of a good is increased in a high condition
	 * ResourceType.
	 */
	private static final double INCREASED_QUANTITY = 1.5;

	/**
	 * Maximum default quantity of a good in a MarketPlace.
	 */
	private static final int MAXIMUM_QUANTITY = 100;

	/**
	 * Minimum default quantity of a good in a MarketPlace.
	 */
	private static final int MINIMUM_QUANTITY = 20;

	/**
	 * Amount by which the quantity of a good is increased in a favoring
	 * TechnologyLevel.
	 */
	private static final double TECH_LEVEL_INCREASE = 1.5;

	/**
	 * Number which determines the range of the variance.
	 */
	private static final int VARIANCE_AMOUNT = 2;

	/**
	 * Argument to be put in Randomizer.nextInt for randomizing the quantity.
	 */
	private static final int QUANTITY_INPUT = MAXIMUM_QUANTITY
			- MINIMUM_QUANTITY + 1;

	/**
	 * The names of the TradeGoodTypes.
	 */
	public static final String[] NAME_CONSTANTS = 
		{ "Water,Furs,Food,Ore,Games,Firearms,Medicine,Machines,Narcotics,Robots" };

	/**
	 * The enumerated subNames of the TradeGoodTypes.
	 */
	public static final Enum<?>[][] SUBNAMES_CONSTANTS = { Water.values(),
			Furs.values(), Food.values(), Ore.values(), Games.values(),
			Firearms.values(), Medicine.values(), Machines.values(),
			Narcotics.values(), Robots.values() };

	/**
	 * The minimum technology levels to produce the TradeGoodTypes.
	 */
	public static final TechnologyLevel[] MINIMUM_LEVEL_TO_PRODUCE = {
			PRE_AGRICULTURE, PRE_AGRICULTURE, AGRICULTURE, MEDIEVAL,
			RENAISSANCE, RENAISSANCE, EARLY_INDUSTRIAL, EARLY_INDUSTRIAL,
			INDUSTRIAL, POST_INDUSTRIAL };

	/**
	 * The minimum TechnologyLevels to sell the TradeGoodTypes to the
	 * MarketPlace.
	 */
	public static final TechnologyLevel[] MINIMUM_LEVEL_TO_SELL = {
			PRE_AGRICULTURE, PRE_AGRICULTURE, PRE_AGRICULTURE, MEDIEVAL,
			AGRICULTURE, AGRICULTURE, AGRICULTURE, RENAISSANCE,
			PRE_AGRICULTURE, EARLY_INDUSTRIAL, };

	/**
	 * The TechnologyLevels in which most of the TradeGoodTypes are produced.
	 */
	public static final TechnologyLevel[] MOST_PRODUCED = { MEDIEVAL,
			PRE_AGRICULTURE, AGRICULTURE, RENAISSANCE, POST_INDUSTRIAL,
			INDUSTRIAL, POST_INDUSTRIAL, INDUSTRIAL, INDUSTRIAL, HI_TECH };

	/**
	 * The base price of the TradeGoodTypes.
	 */
	public static final int[] BASE_PRICE = { 30, 250, 100, 350, 250, 1250, 650,
			900, 3500, 5000 };

	/**
	 * The amount by which the price of a TradeGoodType is increased per
	 * TechnologyLevel.
	 */
	public static final int[] INCREASE_PER_LEVEL = { 3, 10, 5, 20, -10, -75,
			-20, -30, -125, -150 };

	/**
	 * The variance of the price of the TradeGoodTypes.
	 */
	public static final int[] VARIANCE_CONSTANTS = { 4, 10, 5, 10, 5, 100, 10,
			5, 150, 100 };

	/**
	 * The increased price Events of the TradeGoodTypes.
	 */
	public static final Event[] INCREASE_EVENT = { DROUGHT, COLD, CROPFAIL,
			WAR, BOREDOM, WAR, PLAGUE, LACKOFWORKERS, BOREDOM, LACKOFWORKERS };

	/**
	 * The low quantity ResourceType conditions of the TradeGoodTypes.
	 */
	public static final ResourceType[] LOW_CONDITION = { LOTS_OF_WATER,
			RICH_FAUNA, RICH_SOIL, MINERAL_RICH, ARTISTIC, WARLIKE,
			LOTS_OF_HERBS, NONE, WEIRD_MUSHROOMS, NONE };

	/**
	 * The high quantity ResourceType conditions of the TradeGoodTypes.
	 */
	public static final ResourceType[] HIGH_CONDITION = { DESERT, LIFELESS,
			POOR_SOIL, MINERAL_POOR, NONE, NONE, NONE, NONE, NONE, NONE };

	static {
		for (TradeGoodType goods : EnumSet.allOf(TradeGoodType.class)) {
			int position = goods.ordinal();
			goods.name = NAME_CONSTANTS[position];
			goods.subNames = SUBNAMES_CONSTANTS[position];
			goods.minToProduce = MINIMUM_LEVEL_TO_PRODUCE[position];
			goods.minToSell = MINIMUM_LEVEL_TO_SELL[position];
			goods.mostProduced = MOST_PRODUCED[position];
			goods.basePrice = BASE_PRICE[position];
			goods.increasePerLevel = INCREASE_PER_LEVEL[position];
			goods.variance = VARIANCE_CONSTANTS[position];
			goods.priceIncrease = INCREASE_EVENT[position];
			goods.lowCondition = LOW_CONDITION[position];
			goods.highCondition = HIGH_CONDITION[position];
		}
	}

	/**
	 * Name of the TradeGoodType.
	 */
	private String name;

	/**
	 * Enumerated subnames associated with the TradeGoodType.
	 */
	private Enum<?>[] subNames;

	/**
	 * Minimum TechnologyLevel to produce this TradeGoodType.
	 */
	private TechnologyLevel minToProduce;

	/**
	 * Minimum TechnologyLevel to sell this TradeGoodType.
	 */
	private TechnologyLevel minToSell;

	/**
	 * TechnologyLevel in which more of this TradeGoodType is produced.
	 */
	private TechnologyLevel mostProduced;

	/**
	 * Base price of this TradeGoodType.
	 */
	private int basePrice;

	/**
	 * Price increase per TechnologyLevel of this TradeGoodType.
	 */
	private int increasePerLevel;

	/**
	 * Variance in price of this TradeGoodType.
	 */
	private int variance;

	/**
	 * Event in which the price of this TradeGoodType is increased.
	 */
	private Event priceIncrease;

	/**
	 * ResourceType in which less of this TradeGoodType is present.
	 */
	private ResourceType lowCondition;

	/**
	 * ResourceType in which more of this TradeGoodType is present.
	 */
	private ResourceType highCondition;

	/**
	 * Gives the name of this TradeGoodType.
	 * 
	 * @return String representation of the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gives the enumerated subnames of this TradeGoodType.
	 * 
	 * @return Enum<?>[] representing the subnames.
	 */
	public Enum<?>[] getSubNames() {
		return subNames;
	}

	/**
	 * Gives the base price of this TradeGoodType.
	 * 
	 * @return Integer representing the base price.
	 */
	public int getBasePrice() {
		return basePrice;
	}

	// TODO: Move this into another class
	/**
	 * Calculates the price of the TradeGood using information about the Planet
	 * it is on. Should be called whenever a Player lands on a Planet to vary
	 * the absolute price of the good.
	 * 
	 * @param planet
	 *            Planet on which the price is to be calculated.
	 * @return Modified price of the TradeGood.
	 */
	public int calculatePrice(Planet planet) {
		int price;
		final TechnologyLevel techLevel = planet.getTechnologyLevel();
		final Event event = planet.getEvent();
		price = basePrice;
		price += Randomizer.nextInt(VARIANCE_AMOUNT * variance) - variance;
		price += increasePerLevel
				* (techLevel.ordinal() - minToProduce.ordinal());
		if (priceIncrease.ordinal() == event.ordinal()) {
			price = (int) (price * INCREASE_AMOUNT);
		}
		return price;
	}

	// TODO: Move this into another class... Maybe planet creation?
	/**
	 * This setQuantity sets the quantity based on information from the Planet
	 * rather than a given Integer.
	 * 
	 * @param planet
	 *            Planet on which the quantity is to be determined.
	 * @return Initial quantity of the TradeGood.
	 */
	public int determineQuantity(Planet planet) {
		final ResourceType resource = planet.getResourceType();
		final TechnologyLevel techLevel = planet.getTechnologyLevel();
		int quantity;
		if (lowCondition.ordinal() == resource.ordinal()) {
			quantity = (int) (REDUCED_QUANTITY * (Randomizer
					.nextInt(QUANTITY_INPUT) + MINIMUM_QUANTITY));
		} else if (highCondition.ordinal() == resource.ordinal()) {
			quantity = (int) (INCREASED_QUANTITY * (Randomizer
					.nextInt(QUANTITY_INPUT) + MINIMUM_QUANTITY));
		} else {
			quantity = (Randomizer.nextInt(QUANTITY_INPUT) + MINIMUM_QUANTITY);
		}

		if (techLevel.ordinal() == mostProduced.ordinal()) {
			quantity = (int) (quantity * TECH_LEVEL_INCREASE);
		}
		return quantity;
	}

	/**
	 * Determines whether this good will appear in the MarketPlace
	 * 
	 * @param planet
	 *            Planet on which to check if the good is buyable.
	 * 
	 * @return true if the good will appear, false otherwise.
	 */
	public boolean isBuyable(Planet planet) {
		return planet.getTechnologyLevel().ordinal() >= minToProduce.ordinal();
	}

	/**
	 * Determines whether a TradeGood can be sold.
	 * 
	 * @param planet
	 *            Planet on which to check if the TradeGood can be sold.
	 * @return true if the TradeGood can be sold, false otherwise.
	 */
	public boolean isSellable(Planet planet) {
		return planet.getTechnologyLevel().ordinal() >= minToSell.ordinal();
	}
}
