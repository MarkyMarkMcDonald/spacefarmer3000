package App.model;

import static App.model.Event.BOREDOM;
import static App.model.Event.COLD;
import static App.model.Event.CROPFAIL;
import static App.model.Event.DROUGHT;
import static App.model.Event.LACKOFWORKERS;
import static App.model.Event.PLAGUE;
import static App.model.Event.WAR;
import static App.model.ResourceType.ARTISTIC;
import static App.model.ResourceType.DESERT;
import static App.model.ResourceType.LIFELESS;
import static App.model.ResourceType.LOTS_OF_HERBS;
import static App.model.ResourceType.LOTS_OF_WATER;
import static App.model.ResourceType.MINERAL_POOR;
import static App.model.ResourceType.MINERAL_RICH;
import static App.model.ResourceType.NONE;
import static App.model.ResourceType.POOR_SOIL;
import static App.model.ResourceType.RICH_FAUNA;
import static App.model.ResourceType.RICH_SOIL;
import static App.model.ResourceType.WARLIKE;
import static App.model.ResourceType.WEIRD_MUSHROOMS;
import static App.model.TechnologyLevel.AGRICULTURE;
import static App.model.TechnologyLevel.EARLY_INDUSTRIAL;
import static App.model.TechnologyLevel.HI_TECH;
import static App.model.TechnologyLevel.INDUSTRIAL;
import static App.model.TechnologyLevel.MEDIEVAL;
import static App.model.TechnologyLevel.POST_INDUSTRIAL;
import static App.model.TechnologyLevel.PRE_AGRICULTURE;
import static App.model.TechnologyLevel.RENAISSANCE;
import static App.model.Category.*;

import java.util.Locale.Category;

import App.factory.TradeGoodFactory;
import App.service.Randomizer;
/**
 * Created with IntelliJ IDEA.
 * User: Marky
 * Date: 9/22/12
 * Time: 12:31 AM
 * To change this template use File | Settings | File Templates.
 */

public enum TradeGoodType {
	
    //        NAME                   MTLP            MTLU                 TTP BASE  IPL VAR            IE             CR         ER  MTL  MTH   CATEGORY
	
	WATER(    "Water",    PRE_AGRICULTURE,  PRE_AGRICULTURE,       MEDIEVAL,  30,   3,  4,      DROUGHT,  LOTS_OF_WATER,      DESERT,  30,  50,NATURALRESOURCE),
	
	FURS(     "Furs",     PRE_AGRICULTURE,  PRE_AGRICULTURE,PRE_AGRICULTURE, 250,  10, 10,         COLD,     RICH_FAUNA,    LIFELESS, 230, 280,NATURALRESOURCE),
																																						
	BANANAS(  "Bananas",      AGRICULTURE,  PRE_AGRICULTURE,    AGRICULTURE, 50,   4,  4,     CROPFAIL,      RICH_SOIL,   POOR_SOIL,  40, 80,FOOD),
			
	APPLES(   "Apples",       AGRICULTURE,  PRE_AGRICULTURE,    AGRICULTURE, 100,   5,  5,     CROPFAIL,      RICH_SOIL,   POOR_SOIL,  90, 160,FOOD),
		
	POTATOES( "Potatoes",     AGRICULTURE,  PRE_AGRICULTURE,    AGRICULTURE, 150,   7,  7,     CROPFAIL,      RICH_SOIL,   POOR_SOIL,  130, 200,FOOD),
		
	CORN(     "Corn",         AGRICULTURE,  PRE_AGRICULTURE,    AGRICULTURE, 200,   10,  10,     CROPFAIL,      RICH_SOIL,   POOR_SOIL,  180, 250,FOOD),
																													
	ORE(      "Ore",             MEDIEVAL,         MEDIEVAL,    RENAISSANCE, 350,  20, 10,          WAR,   MINERAL_RICH,MINERAL_POOR, 350, 420,NATURALRESOURCE),
		
	GAMES(    "Games",        RENAISSANCE,      AGRICULTURE,POST_INDUSTRIAL, 250, -10,  5,      BOREDOM,       ARTISTIC,        NONE, 160, 270,INDUSTRIALGOOD),
		
	FIREARMS( "Firearms",     RENAISSANCE,      AGRICULTURE,     INDUSTRIAL,1250, -75,100,          WAR,        WARLIKE,        NONE, 600,1100,INDUSTRIALGOOD),
		
	MEDICINE( "Medicine",EARLY_INDUSTRIAL,      AGRICULTURE,POST_INDUSTRIAL, 650, -20, 10,       PLAGUE,  LOTS_OF_HERBS,        NONE, 400, 700,INDUSTRIALGOOD),
		
	MACHINES( "Machines",EARLY_INDUSTRIAL,      RENAISSANCE,     INDUSTRIAL, 900, -30,  5,LACKOFWORKERS,           NONE,        NONE, 600, 800,INDUSTRIALGOOD),
		
	NARCOTICS("Narcotics",     INDUSTRIAL,  PRE_AGRICULTURE,     INDUSTRIAL,3500,-125,150,      BOREDOM,WEIRD_MUSHROOMS,        NONE,2000,3000,INDUSTRIALGOOD),
		
	ROBOTS(   "Robots",    POST_INDUSTRIAL,EARLY_INDUSTRIAL,        HI_TECH,5000,-150,100,LACKOFWORKERS,           NONE,        NONE,3500,5000,INDUSTRIALGOOD);
		
	private static final double INCREASE_AMOUNT=1.5;
	
	private static final double REDUCED_QUANTITY=.5;
	private static final double INCREASED_QUANTITY=1.5;
	private static final int MAXIMUM_QUANTITY=100;
	private static final int MINIMUM_QUANTITY=20;
	private static final double TECH_LEVEL_INCREASE=1.5;
	
	private String name;
	
	private TechnologyLevel minToProduce;
	private TechnologyLevel minToSell;
	private TechnologyLevel mostProduced;
	
	private int basePrice;
	private int increasePerLevel;
	private int variance;
	
	private Event priceIncrease;
	private ResourceType lowCondition;
	private ResourceType highCondition;
	
	private int minTrader;
	private int maxTrader;
	
	private Category category;
	
	

	public String getName() {
		return name;
	}
	
	public Category getCategory() {
		return category;
	}


	
	

    


	private TradeGoodType(String name, TechnologyLevel minToProduce,
			TechnologyLevel minToSell, TechnologyLevel mostProduced,
			int basePrice, int increasePerLevel, int variance,
			Event priceIncrease, ResourceType lowCondition,
			ResourceType highCondition, int minTrader, int maxTrader,
			Category category) {
		this.name = name;
		this.minToProduce = minToProduce;
		this.minToSell = minToSell;
		this.mostProduced = mostProduced;
		this.basePrice = basePrice;
		this.increasePerLevel = increasePerLevel;
		this.variance = variance;
		this.priceIncrease = priceIncrease;
		this.lowCondition = lowCondition;
		this.highCondition = highCondition;
		this.minTrader = minTrader;
		this.maxTrader = maxTrader;
		this.category = category;
	}
	

	// TODO: Move this into another class
	/*
     * Calculates the price of the TradeGood using information
     * about the Planet it is on.
     * Should be called whenever a Player lands on a Planet to
     * vary the absolute price of the good.
     * @param event Event the Planet is currently experiencing.
     * @param techLevel TechnologyLevel of the Planet.
     */
	public int calculatePrice(Planet planet)
	{
		int price;
		TechnologyLevel techLevel=planet.getTechnologyLevel();
		Event event=planet.getEvent();
		price=basePrice;
	    price+=Randomizer.nextInt(2*variance)-variance;
	    price+=increasePerLevel*(techLevel.ordinal()-minToProduce.ordinal());
		if (priceIncrease.ordinal() == event.ordinal())
		{
			price=(int) (price*INCREASE_AMOUNT);
		}
	    return price;
	}
	
	// TODO: Move this into another class... Maybe planet creation?
	/*
	 * This setQuantity sets the quantity based on information from
	 * the Planet rather than a given int.
	 * @param resource The ResourceType of the Planet.
	 * @param techLevel The TechnologyLevel of the Planet.
	 */
	public int determineQuantity(Planet planet)
	{
		ResourceType resource=planet.getResourceType();
		TechnologyLevel techLevel=planet.getTechnologyLevel();
		int quantity;
		if (lowCondition.ordinal()==resource.ordinal())
		{
			quantity= (int) (REDUCED_QUANTITY*(Randomizer.nextInt(MAXIMUM_QUANTITY-MINIMUM_QUANTITY)+MINIMUM_QUANTITY));
		}
		else if (highCondition.ordinal()==resource.ordinal())
		{
			quantity= (int) (INCREASED_QUANTITY*(Randomizer.nextInt(MAXIMUM_QUANTITY-MINIMUM_QUANTITY)+MINIMUM_QUANTITY));
		}
		else
		{
			quantity = (int) (Randomizer.nextInt(MAXIMUM_QUANTITY-MINIMUM_QUANTITY)+MINIMUM_QUANTITY);
		}
		
		if (techLevel.ordinal() == mostProduced.ordinal())
		{
			quantity= (int) (quantity*TECH_LEVEL_INCREASE);
		}
		return quantity;
	}
	
	/*
	 * Determines whether this good will appear in the MarketPlace
	 * @param techLevel TechnologyLevel of the Planet.
	 * @return true if the good will appear, false otherwise.
	 */
	public boolean buyable(Planet planet)
	{
		if (planet.getTechnologyLevel().ordinal() >= minToProduce.ordinal())
			return true;
		else
			return false;
	}
	
	/*
	 * Determines whether a sell was successful. If so,
	 * the quantity is decreased appropriately.
	 * @param techLevel TechnologyLevel of the Planet.
	 * @param quantity Amount being sold.
	 * @return true if the good was sold, false otherwise.
	 */
	public boolean sellable(Planet planet)
	{
		if (planet.getTechnologyLevel().ordinal() >= minToSell.ordinal())
		{
			return true;
		}	
		else
			return false;
	}
	
	public TradeGood generateInstance()
	{
		return TradeGoodFactory.getTradeGood(this);
	}
	
}
