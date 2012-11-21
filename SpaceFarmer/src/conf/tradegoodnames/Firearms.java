/*This files holds an enum containing names for Firearms.*/
package conf.tradegoodnames;

/**
 * User: marky Date: 10/22/12 Time: 2:24 PM
 */
public enum Firearms {

	PISTOLS("Pistols"), RIFLES("Rifles"), SHOTGUNS("Shotguns");

	/**
	 * Name of the Firearm.
	 */
	private final String name;

	/**
	 * @return The name of the enumeration.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Creates a Firearm using its name.
	 * @param name The Firearm's name.
	 */
	private Firearms(String name) {
		this.name = name;
	}

	/**
	 * @return The name of the enumeration.
	 */
	public String toString() {
		return name;
	}

}
