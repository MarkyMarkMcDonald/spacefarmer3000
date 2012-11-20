package app.model.player;

/**
 * User: marky Date: 10/7/12 Time: 8:46 PM
 */
public enum SkillType {
	PILOTING("Piloting"), TRADING("Trading"), FIGHTING("Fighting"), ENGINEERING(
			"Engineering");

	/**
	 * The name of the SkillType.
	 */
	private final String name;

	/**
	 * Constructs a SkillType using its name.
	 * 
	 * @param name
	 *            Name of the SkillType.
	 */
	private SkillType(String name) {
		this.name = name;
	}

	/**
	 * @return Name of the SkillType.
	 */
	public String toString() {
		return name;
	}
}
