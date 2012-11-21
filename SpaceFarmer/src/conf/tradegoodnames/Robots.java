/*This files holds an enum containing names for Robots*/
package conf.tradegoodnames;

/**
 * User: marky Date: 10/22/12 Time: 2:33 PM
 */
public enum Robots {
	ROBOTIC_LABORER("Robotic Laborer"), ROBOTIC_SERVANT("Robotic Servant");

	/**
	 * Name of the Robot.
	 */
	private final String name;

	/**
	 * @return The name of the enumeration.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Creates a Robot using its name.
	 * @param name The Robot's name.
	 */
	private Robots(String name) {
		this.name = name;
	}

	/**
	 * @return Name of the Robot.
	 */
	public String toString() {
		return name;
	}
}
