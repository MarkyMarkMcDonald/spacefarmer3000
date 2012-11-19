package app.model.Universe;

/**
 * Created with IntelliJ IDEA. User: Marky Date: 9/22/12 Time: 12:33 AM To
 * change this template use File | Settings | File Templates.
 */
public enum TechnologyLevel {
	PRE_AGRICULTURE("Pre-Agriculture"), AGRICULTURE("Agriculture"), MEDIEVAL(
			"Medieval"), RENAISSANCE("Renaissance"), EARLY_INDUSTRIAL(
			"Early Industrial"), INDUSTRIAL("Industrial"), POST_INDUSTRIAL(
			"Post Industrial"), HI_TECH("Hi-Tech");

	private String name;

	private TechnologyLevel(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
