/*This files holds an enum containing names for Medince*/
package conf.tradegoodnames;

/**
 * User: marky Date: 10/22/12 Time: 2:25 PM
 */
public enum Medicine {

	ASPIRIN("Aspirin"), MORPHENE("Morphene"), COUGH_SYRUP("Cough Syrup");

	/**
	 * Name of the Medicine.
	 */
	private final String name;

	/**
	 * @return The name of the enumeration.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Creates Medicine using its name.
	 * @param name The Medicine's name.
	 */
	private Medicine(String name) {
		this.name = name;
	}

	/**
	 * @return Name of the Medicine.
	 */
	public String toString() {
		return name;
	}
}
