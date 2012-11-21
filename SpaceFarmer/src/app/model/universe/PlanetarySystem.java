/*This file holds the class PlanetarySystem, which
 * represents a system holding Planets in the Universe.
 */
package app.model.universe;

import java.util.Map;

/**
 * Created with IntelliJ IDEA. User: Marky Date: 9/22/12 Time: 12:32 AM To
 * change this template use File | Settings | File Templates.
 * 
 * @author Mark
 * @version 1.0
 */
public class PlanetarySystem {

	/**
	 * Name of the PlanetarySystem
	 */
	private String name;

	/**
	 * Map of the names of the Planets in this system to the Planets.
	 */
	private Map<String, Planet> planets;

	/**
	 * X coordinate of this PlanetarySystem.
	 */
	private int x;

	/**
	 * Y coordinate of this PlanetarySystem
	 */
	private int y;

	/**
	 * @return X coordinate of this PlanetarySystem
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            X coordinate to set for this PlanetarySystem.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return Y coordinate for this PlanetarySystem.
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            Y coordinate to set for this PlanetarySystem.
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return Name of this PlanetarySystem.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            Name to set for this PlanetarySystem.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Map of this PlanetarySystem's Planet names to its Planets.
	 */
	public Map<String, Planet> getPlanets() {
		return planets;
	}

	/**
	 * @param planets
	 *            String to Planet map to set for this PlanetarySystem.
	 */
	public void setPlanets(Map<String, Planet> planets) {
		this.planets = planets;
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "PlanetarySystem";
	}
}
