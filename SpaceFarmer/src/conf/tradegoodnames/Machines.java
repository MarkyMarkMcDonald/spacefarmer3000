/*This files holds an enum containing names for Machines*/
package conf.tradegoodnames;

/**
 * User: marky Date: 10/22/12 Time: 2:27 PM
 */
public enum Machines {

	RUMBA("Rumba"), ZAMBONI("Zamboni");

	/**
	 * Name of the Machines.
	 */
	private final String name;

	/**
	 * @return The name of the enumeration.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Creates a Machine using its name.
	 * @param name The Machine's name.
	 */
	private Machines(String name) {
		this.name = name;
	}

	/**
	 * @return Name of the Machines.
	 */
	public String toString() {
		return name;
	}
}
