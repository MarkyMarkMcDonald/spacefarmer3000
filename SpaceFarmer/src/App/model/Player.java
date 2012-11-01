package App.model;

import App.factory.ShipFactory;
import Conf.GameVariables;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a Player.
 * Information Holder
 *
 * User: Mark McDaniel, Andrew Wilder
 * Date: 9/22/12
 * Time: 12:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class Player {
    private PlayerType playerType;
    private String name;

    private Ship ship;
    private int money, fuel;
    private Map<SkillType, Integer> skillLevels;
    private Inventory inventory;
    private Planet currentPlanet;

    public Player(){
    }

    public Player(String name, int piloting, int trading, int engineering, int fighting) {
		super();
		this.name = name;
		skillLevels = new HashMap<SkillType, Integer>();
        skillLevels.put(SkillType.PILOTING,piloting);
		skillLevels.put(SkillType.TRADING,trading);
		skillLevels.put(SkillType.ENGINEERING,engineering);
		skillLevels.put(SkillType.FIGHTING,fighting);
		this.money= GameVariables.playerStartingMoney;
		this.ship= ShipFactory.getShip(ShipModel.GNAT);
        this.fuel = ship.getMaxFuel();
	}

    public void changeMoney(int amount){
        money += amount;
    }

    //--Accessors and Modifiers
    public Planet getCurrentPlanet() {
        return currentPlanet;
    }

    public void setCurrentPlanet(Planet currentPlanet) {
        this.currentPlanet = currentPlanet;
    }

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Map<SkillType, Integer> getSkillLevels() {
        return skillLevels;
    }

    public void setSkillLevels(Map<SkillType, Integer> skillLevels) {
        this.skillLevels = skillLevels;
    }
    
    public int getFuel() {
    	return fuel;
    }
    
    public void setFuel(int fuel) {
    	this.fuel = fuel;
    }
}
