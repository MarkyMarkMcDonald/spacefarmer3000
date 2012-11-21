/*This files holds an enum containing names for Narcotics*/
package conf.tradegoodnames;

/**
 * User: marky Date: 10/22/12 Time: 2:30 PM
 */
public enum Narcotics {

	MOLLY("Molly"), MARIJUANA("Marijuana"), WOW_SUB_CARDS("WoW Time");

	/**
	 * Name of the Narcotics.
	 */
	private final String name;

	/**
	 * @return The name of the enumeration.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Creates a Narcotic using its name.
	 * @param name The Narcotic's name.
	 */
	private Narcotics(String name) {
		this.name = name;
	}

	/**
	 * @return Name of the Narcotics.
	 */
	public String toString() {
		return name;
	}
}
