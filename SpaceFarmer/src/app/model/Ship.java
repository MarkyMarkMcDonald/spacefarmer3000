package app.model;

/**
 * Created with IntelliJ IDEA. User: Marky Date: 9/22/12 Time: 12:33 AM To
 * change this template use File | Settings | File Templates.
 */
public class Ship {

	private ShipModel type;

	private int cargoSize;

	private int health;

	private int power;

	private int defense;

	private int speed;

	private int maxFuel;

	// --Accessors and Modifiers
	public int getMaxFuel() {
		return maxFuel;
	}

	public void setMaxFuel(int maxFuel) {
		this.maxFuel = maxFuel;
	}

	public ShipModel getType() {
		return type;
	}

	public void setType(ShipModel type) {
		this.type = type;
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

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "Ship";
	}
}
