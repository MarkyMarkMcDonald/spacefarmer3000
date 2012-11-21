/*This files holds an enum containing names for Food*/
package conf.tradegoodnames;

/**
 * User: marky Date: 10/22/12 Time: 2:18 PM
 */
public enum Food {

	BANANAS("Bananas"), PORKCHOPS("Porkchops"), FRIED_CHICKEN("Fried Chicken"), POPSICLES(
			"Popsicles");

	/**
	 * Name of the Food.
	 */
	private final String name;

	/**
	 * @return The name of the enumeration.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Creates a Food using its name.
	 * @param name The Food's name.
	 */
	private Food(String name) {
		this.name = name;
	}

	/**
	 * @return Name of the Food.
	 */
	public String toString() {
		return name;
	}
}
