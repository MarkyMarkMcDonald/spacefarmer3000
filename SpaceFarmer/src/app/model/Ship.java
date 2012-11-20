package app.model;

/**
 * Created with IntelliJ IDEA. User: Marky Date: 9/22/12 Time: 12:33 AM To
 * change this template use File | Settings | File Templates.
 * 
 * @author Mark
 * @version 1.0
 */
public class Ship {

	/**
	 * Enumerated ShipModel corresponding to this Ship.
	 */
	private ShipModel type;

	/**
	 * Amount of Tradables this Ship can hold.
	 */
	private int cargoSize;

	/**
	 * Measurement of how much damage the Ship may sustain.
	 */
	private int health;

	/**
	 * Offensive power of the Ship.
	 */
	private int power;

	/**
	 * Defensive measure of the Ship
	 */
	private int defense;

	/**
	 * How fast the Ship may travel.
	 */
	private int speed;

	/**
	 * Most fuel the Ship may hold.
	 */
	private int maxFuel;

	// --Accessors and Modifiers
	/**
	 * @return This Ship's maximum fuel.
	 */
	public int getMaxFuel() {
		return maxFuel;
	}

	/**
	 * @param maxFuel
	 *            Max fuel to set for the Ship.
	 */
	public void setMaxFuel(int maxFuel) {
		this.maxFuel = maxFuel;
	}

	/**
	 * @return Enumerated type of the Ship.
	 */
	public ShipModel getType() {
		return type;
	}

	/**
	 * @param type
	 *            Enumerated type of the Ship.
	 */
	public void setType(ShipModel type) {
		this.type = type;
	}

	/**
	 * @return The cargo size of the Ship.
	 */
	public int getCargoSize() {
		return cargoSize;
	}

	/**
	 * @param cargoSize
	 *            Cargo size to set for the Ship.
	 */
	public void setCargoSize(int cargoSize) {
		this.cargoSize = cargoSize;
	}

	/**
	 * @return Health of the Ship.
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @param health
	 *            Health to set for the Ship.
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * @return Power of the Ship.
	 */
	public int getPower() {
		return power;
	}

	/**
	 * @param power
	 *            Power to set for the Ship.
	 */
	public void setPower(int power) {
		this.power = power;
	}

	/**
	 * @return Defense of the Ship.
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 * @param defense
	 *            Defense to set for the Ship.
	 */
	public void setDefense(int defense) {
		this.defense = defense;
	}

	/**
	 * @return Speed of the Ship.
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed
	 *            Speed to set for the Ship.
	 */
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
