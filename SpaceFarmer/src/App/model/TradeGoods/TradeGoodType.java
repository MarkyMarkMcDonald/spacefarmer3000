package App.model.TradeGoods;

import App.model.Event;
import App.model.Universe.Planet;
import App.model.Universe.ResourceType;
import App.model.Universe.TechnologyLevel;
import App.service.Randomizer;
import Conf.TradeGoodNames.*;

import static App.model.Universe.TechnologyLevel.*;
import static App.model.Universe.ResourceType.*;
import static App.model.Event.*;
/**
 * Created with IntelliJ IDEA.
 * User: Marky
 * Date: 9/22/12
 * Time: 12:31 AM
 * To change this template use File | Settings | File Templates.
 */

public enum TradeGoodType {
	
    //        NAME      Possible SubNames               MTLP            MTLU                 TTP BASE  IPL VAR            IE             CR         ER  MTL  MTH
	
	WATER(    "Water",      Water.values(),     PRE_AGRICULTURE,  PRE_AGRICULTURE,       MEDIEVAL,  30,   3,  4,      DROUGHT,  LOTS_OF_WATER,      DESERT,  30,  50),
	
	FURS(     "Furs",       Furs.values(),      PRE_AGRICULTURE,  PRE_AGRICULTURE,PRE_AGRICULTURE, 250,  10, 10,         COLD,     RICH_FAUNA,    LIFELESS, 230, 280),
	
	FOOD(     "Food",       Food.values(),      AGRICULTURE,        PRE_AGRICULTURE,    AGRICULTURE, 100,   5,  5,     CROPFAIL,      RICH_SOIL,   POOR_SOIL,  90, 160),
	
	ORE(      "Ore",        Ore.values(),       MEDIEVAL,         MEDIEVAL,    RENAISSANCE, 350,  20, 10,          WAR,   MINERAL_RICH,MINERAL_POOR, 350, 420),
	
	GAMES(    "Games",      Games.values(),     RENAISSANCE,      AGRICULTURE,POST_INDUSTRIAL, 250, -10,  5,      BOREDOM,       ARTISTIC,        NONE, 160, 270),
	
	FIREARMS( "Firearms",    Firearms.values(), RENAISSANCE,      AGRICULTURE,     INDUSTRIAL,1250, -75,100,          WAR,        WARLIKE,        NONE, 600,1100),
	
	MEDICINE( "Medicine",   Medicine.values(),  EARLY_INDUSTRIAL,  AGRICULTURE,POST_INDUSTRIAL, 650, -20, 10,       PLAGUE,  LOTS_OF_HERBS,        NONE, 400, 700),
	
	MACHINES( "Machines",   Machines.values(),  EARLY_INDUSTRIAL,   RENAISSANCE,     INDUSTRIAL, 900, -30,  5,LACKOFWORKERS,           NONE,        NONE, 600, 800),
	
	NARCOTICS("Narcotics",  Narcotics.values(), INDUSTRIAL,      PRE_AGRICULTURE,     INDUSTRIAL,3500,-125,150,      BOREDOM,WEIRD_MUSHROOMS,        NONE,2000,3000),
	
	ROBOTS(   "Robots",     Robots.values(),    POST_INDUSTRIAL,   EARLY_INDUSTRIAL,        HI_TECH,5000,-150,100,LACKOFWORKERS,           NONE,        NONE,3500,5000);
	
	private static final double INCREASE_AMOUNT=1.5;
	
	private static final double REDUCED_QUANTITY=.5;
	
	private static final double INCREASED_QUANTITY=1.5;
	
	private static final int AVERAGE_QUANTITY=100;
	
	private static final int MINIMUM_QUANTITY=20;
	
	private static final double TECH_LEVEL_INCREASE=1.5;
	
    private String name;
    
    private Enum[] subNames;

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

	public String getName() {
		return name;
	}

    public Enum[] getSubNames(){
        return subNames;
    }

    public int getBasePrice(){
        return basePrice;
    }

	private TradeGoodType(String name, Enum[] subNames, TechnologyLevel minToProduce,
                          TechnologyLevel minToSell, TechnologyLevel mostProduced,
                          int basePrice, int increasePerLevel, int variance,
                          Event priceIncrease, ResourceType lowCondition,
                          ResourceType highCondition, int minTrader, int maxTrader) {
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
        this.subNames = subNames;
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
	public int calculatePrice(Planet planet) {
		int price;
		TechnologyLevel techLevel=planet.getTechnologyLevel();
		Event event=planet.getEvent();
		price=basePrice;
	    price+=Randomizer.nextInt(2*variance)-variance;
	    price+=increasePerLevel*(techLevel.ordinal()-minToProduce.ordinal());
		if (priceIncrease.ordinal() == event.ordinal()) {
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
	public int determineQuantity(Planet planet) {
		ResourceType resource=planet.getResourceType();
		TechnologyLevel techLevel=planet.getTechnologyLevel();
		int quantity;
		if (lowCondition.ordinal()==resource.ordinal()) {
			quantity= (int) (REDUCED_QUANTITY*(Randomizer.nextInt(AVERAGE_QUANTITY-MINIMUM_QUANTITY)+MINIMUM_QUANTITY));
		}
		else if (highCondition.ordinal()==resource.ordinal()) {
			quantity= (int) (INCREASED_QUANTITY*(Randomizer.nextInt(AVERAGE_QUANTITY-MINIMUM_QUANTITY)+MINIMUM_QUANTITY));
		}
		else {
			quantity = (int) (Randomizer.nextInt(AVERAGE_QUANTITY-MINIMUM_QUANTITY)+MINIMUM_QUANTITY);
		}
		
		if (techLevel.ordinal() == mostProduced.ordinal()) {
			quantity= (int) (quantity*TECH_LEVEL_INCREASE);
		}
		return quantity;
	}
	
	/*
	 * Determines whether this good will appear in the MarketPlace
	 * @param techLevel TechnologyLevel of the Planet.
	 * @return true if the good will appear, false otherwise.
	 */
	public boolean buyable(Planet planet) {
        return planet.getTechnologyLevel().ordinal() >= minToProduce.ordinal();
	}
	
	/*
	 * Determines whether a sell was successful. If so,
	 * the quantity is decreased appropriately.
	 * @param techLevel TechnologyLevel of the Planet.
	 * @param quantity Amount being sold.
	 * @return true if the good was sold, false otherwise.
	 */
	public boolean sellable(Planet planet) {
        return planet.getTechnologyLevel().ordinal() >= minToSell.ordinal();
	}
}
