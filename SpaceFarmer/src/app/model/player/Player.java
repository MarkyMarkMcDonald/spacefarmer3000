/*This file holds the class Player, which represents a Player
 * playing the game.
 */
package app.model.player;

import java.util.HashMap;
import java.util.Map;

import app.factory.ShipFactory;
import app.model.Inventory;
import app.model.Ship;
import app.model.ShipModel;
import app.model.universe.Planet;
import conf.GameVariables;

/**
 * Represents a Player. Information Holder
 * 
 * User: Mark McDaniel, Andrew Wilder Date: 9/22/12 Time: 12:33 AM To change
 * this template use File | Settings | File Templates.
 * 
 * @author Mark,Andrew
 * @version 1.0
 */
public class Player {
	// Commenting out unused fields/methods for now.
	// private PlayerType playerType;
	// private int difficulty;

	/**
	 * Name of the Player.
	 */
	private String name;

	/**
	 * Ship belonging to the Player.
	 */
	private Ship ship;

	/**
	 * Money and fuel belonging to the Player.
	 */
	private int money, fuel;

	/**
	 * Map from the Player's SkillType to its Integer value.
	 */
	private Map<SkillType, Integer> skillLevels;

	/**
	 * Inventory associated with the Player.
	 */
	private Inventory inventory;

	/**
	 * Planet the Player is currently on.
	 */
	private Planet currentPlanet;

	/**
	 * Creates a Player with no initialized characteristics.
	 */
	public Player() { // $codepro.audit.disable emptyMethod
	}

	/**
	 * Constructs a Player using its name and stats.
	 * 
	 * @param name
	 *            Name of the Player.
	 * @param piloting
	 *            Piloting skill of the Player
	 * @param trading
	 *            Trading skill of the Player.
	 * @param engineering
	 *            Engineering skill of the Player
	 * @param fighting
	 *            Fighting skill of the Player.
	 */
	public Player(String name, int piloting, int trading, int engineering,
			int fighting) {
		this.name = name;
		skillLevels = new HashMap<SkillType, Integer>();
		skillLevels.put(SkillType.PILOTING, piloting);
		skillLevels.put(SkillType.TRADING, trading);
		skillLevels.put(SkillType.ENGINEERING, engineering);
		skillLevels.put(SkillType.FIGHTING, fighting);
		this.money = GameVariables.PLAYER_STARTING_MONEY;
		this.ship = ShipFactory.getShip(ShipModel.GNAT);
		this.fuel = ship.getMaxFuel();
	}

	/**
	 * Adds amount to the Player's money total.
	 * 
	 * @param amount
	 *            Amount to be added.
	 */
	public void changeMoney(int amount) {
		money += amount;
	}

	// --Accessors and Modifiers
	/**
	 * @return The Planet the Player is currently on.
	 */
	public Planet getCurrentPlanet() {
		return currentPlanet;
	}

	/**
	 * @param currentPlanet
	 *            Planet for the Player's current Planet to be set to.
	 */
	public void setCurrentPlanet(Planet currentPlanet) {
		this.currentPlanet = currentPlanet;
	}

	/**
	 * @return The Player's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            Name to be set to for the Player.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return The Player's Ship.
	 */
	public Ship getShip() {
		return ship;
	}

	/**
	 * @param ship
	 *            Ship to be set to for the Player.
	 */
	public void setShip(Ship ship) {
		this.ship = ship;
	}

	/**
	 * @return The Player's money.
	 */
	public int getMoney() {
		return money;
	}

	/**
	 * @param money
	 *            Money to be set to for the Player.
	 */
	public void setMoney(int money) {
		this.money = money;
	}

	/**
	 * @return The Player's inventory.
	 */
	public Inventory getInventory() {
		return inventory;
	}

	/**
	 * @param inventory
	 *            Inventory to be set to for the Player.
	 */
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	/**
	 * @return Map of the Player's skillTypes to their Integer values.
	 */
	public Map<SkillType, Integer> getSkillLevels() {
		return skillLevels;
	}

	/**
	 * @param skillLevels
	 *            SkillType Integer map to be set to for the Player.
	 */
	public void setSkillLevels(Map<SkillType, Integer> skillLevels) {
		this.skillLevels = skillLevels;
	}

	/**
	 * @return Amount of fuel the Player has.
	 */
	public int getFuel() {
		return fuel;
	}

	/**
	 * @param fuel
	 *            Fuel to be set to for the Player.
	 */
	public void setFuel(int fuel) {
		if (fuel < 0) {
			this.fuel = 0;
		}
		this.fuel = fuel;
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "Player";
	}
}
