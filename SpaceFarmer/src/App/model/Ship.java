package App.model;

import App.model.Equipment;
import App.model.Model;
import java.util.Map;
import java.util.Map;



/**
 * Created with IntelliJ IDEA.
 * User: Marky
 * Date: 9/22/12
 * Time: 12:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class Ship {

    private int cargoSize;

    private int health;

    private int power;

    private int defense;

    private int speed;

    private Map<String, Equipment> equipment;

    
    
    public Ship(Model model)
    {
    	switch (model)
    	{
    	    case GNAT:
    	    	cargoSize=15;
    	    	health=100;
    	    	power=1;
    	    	defense=0;
    	    	speed=14;
    	        break;
    	    case FIREFLY:
    	    	cargoSize=20;
    	    	health=100;
    	    	power=1;
    	    	defense=1;
    	    	speed=17;
    	        break;
    	    case MOSQUITO:
    	    	cargoSize=15;
    	    	health=100;
    	    	power=2;
    	    	defense=1;
    	    	speed=13;
    	        break;
    	    case BUMBLEBEE:
    	    	cargoSize=25;
    	    	health=100;
    	    	power=1;
    	    	defense=2;
    	    	speed=15;
    	        break;
    	}
    }

	public int getCargoSize() {
        return cargoSize;
    }

    public void setCargoSize(int cargoSize) {
        this.cargoSize = cargoSize;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
