package app.model.universe;

import app.model.universe.Planet;

import java.util.Map;

/**
 * Created with IntelliJ IDEA. User: Marky Date: 9/22/12 Time: 12:32 AM To
 * change this template use File | Settings | File Templates.
 */
public class PlanetarySystem {

	private String name;

	private Map<String, Planet> planets;

	// Thinking this should replace String->Planet Map.
	private Map<Integer[], Planet> slots;

	private int x;

	private int y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Planet> getPlanets() {
		return planets;
	}

	public void setPlanets(Map<String, Planet> planets) {
		this.planets = planets;
	}

	public Map<Integer[], Planet> getSlots() {
		return slots;
	}

	public void setSlots(Map<Integer[], Planet> slots) {
		this.slots = slots;
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "PlanetarySystem";
	}
}
