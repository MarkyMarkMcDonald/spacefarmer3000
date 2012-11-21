/*This file holds the enum TechnologyLevel, which represents the
 * current state of technology on the Planet.
 */
package app.model.universe;

/**
 * Created with IntelliJ IDEA. User: Marky Date: 9/22/12 Time: 12:33 AM To
 * change this template use File | Settings | File Templates.
 */
public enum TechnologyLevel {
	PRE_AGRICULTURE("Pre-Agriculture"), AGRICULTURE("Agriculture"), MEDIEVAL(
			"Medieval"), RENAISSANCE("Renaissance"), EARLY_INDUSTRIAL(
			"Early Industrial"), INDUSTRIAL("Industrial"), POST_INDUSTRIAL(
			"Post Industrial"), HI_TECH("Hi-Tech");

	/**
	 * Name of the TechnologyLevel.
	 */
	private final String name;

	/**
	 * Constructs a TechnologyLevel from its name.
	 * 
	 * @param name
	 *            Name of the TechnologyLevel.
	 */
	private TechnologyLevel(String name) {
		this.name = name;
	}

	/**
	 * @return The name of the TechnologyLevel.
	 */
	public String getName() {
		return name;
	}

}
