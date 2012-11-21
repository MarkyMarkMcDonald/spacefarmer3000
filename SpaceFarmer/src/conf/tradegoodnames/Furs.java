/*This files holds an enum containing names for Furs*/
package conf.tradegoodnames;

/**
 * User: marky Date: 10/22/12 Time: 2:15 PM
 */
public enum Furs {
	BEAR_PELT("Bear Pelt"), WOLF_PELT("Wolf Pelt"), DEER_PELT("Deer Pelt");

	/**
	 * Name of the Furs.
	 */
	private final String name;

	/**
	 * @return The name of the enumeration.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Creates a type of Furs using its name
	 * @param name The Furs' name.
	 */
	private Furs(String name) {
		this.name = name;
	}

	/**
	 * @return Name of the Furs.
	 */
	public String toString() {
		return name;
	}
}
