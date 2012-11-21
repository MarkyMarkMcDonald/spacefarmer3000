/*This files holds an enum containing names for Ore*/
package conf.tradegoodnames;

/**
 * User: marky Date: 10/22/12 Time: 2:21 PM
 */
public enum Ore {
	TITANIUM("Titanum Ore"), GOLD("Gold Ore"), SILVER("Silver"), PLATINUM(
			"Platinum");

	/**
	 * Name of the Ore.
	 */
	private final String name;

	/**
	 * @return The name of the enumeration.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Creates an Ore using its name.
	 * @param name The Ore's name.
	 */
	private Ore(String name) {
		this.name = name;
	}

	/**
	 * @return Name of the Ore.
	 */
	public String toString() {
		return name;
	}
}
