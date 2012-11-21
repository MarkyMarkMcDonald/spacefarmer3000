/*This file holds the enum ResourceType, which represents
 * the natural resource situation on a Planet.
 */
package app.model.universe;

public enum ResourceType {

	// NONE is for TradeGoods with no increased/decreased
	// quantity conditions
	NONE("None"), NO_SPECIAL_RESOURCES("Normal"), MINERAL_RICH(
			"Abundant Minerals"), MINERAL_POOR("Scarce Minerals"), DESERT(
			"Desert"), LOTS_OF_WATER("Lots of Water"), RICH_SOIL("Rich Soil"), POOR_SOIL(
			"Poor Soil"), RICH_FAUNA("Rich Fauna"), LIFELESS("Lifeless"), WEIRD_MUSHROOMS(
			"Weird Mushrooms"), LOTS_OF_HERBS("Lots of Herbs"), ARTISTIC(
			"Artistic"), WARLIKE("Warlike");

	/**
	 * Name of the ResourceType.
	 */
	private final String name;

	/**
	 * Constructs a ResourceType from its name.
	 * 
	 * @param name
	 *            Name of the ResourceType.
	 */
	private ResourceType(String name) {
		this.name = name;
	}

	/**
	 * @return Name of the ResourceType.
	 */
	public String getName() {
		return name;
	}
}
