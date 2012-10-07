package App.model;

import App.factory.ShipFactory;

import java.util.List;

/**
 * Represents a Player.
 * Information Holder
 *
 * User: Marky
 * Date: 9/22/12
 * Time: 12:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class Player {
    private String name;
    private Ship ship;
    private int money, piloting, trading, engineering, fighting;
    private Inventory inventory;

    public Player(){
    }

    public Player(String name, int piloting, int trading, int engineering, int fighting) {
		super();
		this.name = name;
		this.piloting = piloting;
		this.trading = trading;
		this.engineering = engineering;
		this.fighting = fighting;
		this.money=1000;
		this.ship= ShipFactory.getShip(ShipModel.GNAT);
	}


    //--Accessors and Modifiers
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

    public int getPiloting() {
		return piloting;
	}

	public void setPiloting(int piloting) {
		this.piloting = piloting;
	}

	public int getTrading() {
		return trading;
	}

	public void setTrading(int trading) {
		this.trading = trading;
	}

	public int getEngineering() {
		return engineering;
	}

	public void setEngineering(int engineering) {
		this.engineering = engineering;
	}

	public int getFighting() {
		return fighting;
	}

	public void setFighting(int fighting) {
		this.fighting = fighting;
	}
    
    
}
