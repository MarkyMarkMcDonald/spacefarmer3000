/*This file holds the enum ShipModel, which represent the different
 * type of ships.
 */
package app.model;

public enum ShipModel {
	GNAT("Gnat"), FIREFLY("Firefly"), MOSQUITO("Mosquito"), BUMBLEBEE(
			"Bumblebee");

	/**
	 * Name associated with the ShipModel.
	 */
	private final String name;

	/**
	 * Constructs a ShipModel using its name.
	 * 
	 * @param name
	 *            To give to the ShipModel.
	 */
	private ShipModel(String name) {
		this.name = name;
	}

	/**
	 * @return This ShipModel's name.
	 */
	public String toString() {
		return name;
	}
}
