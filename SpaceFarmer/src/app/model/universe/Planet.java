// $codepro.audit.disable packagePrefixNamingConvention
/*This file holds the class Planet, which represents a Planet
 * in the Universe.
 */
package app.model.universe;

import app.model.Event;
import app.model.MarketPlace;
import app.service.Randomizer;

/**
 * Created with IntelliJ IDEA. User: Marky Date: 9/22/12 Time: 12:32 AM To
 * change this template use File | Settings | File Templates.
 * 
 * @author Mark
 * @version 1.0
 */
public class Planet {

	/**
	 * The probability of a random event being generated on a Planet.
	 */
	private static final double EVENT_PROBABILITY = .1;

	/**
	 * The name of the Planet.
	 */
	private String name;

	/**
	 * TechnologyLevel of the Planet.
	 */
	private TechnologyLevel technologyLevel;

	/**
	 * PoliticalSystem of the Planet.
	 */
	private PoliticalSystem politicalSystem;

	/**
	 * Event happening on the Planet.
	 */
	private Event event;

	/**
	 * ResourceType of the Planet.
	 */
	private ResourceType resourceType;

	/**
	 * Position within the Solar System.
	 */
	private int x, y;

	/**
	 * MarketPlace on the Planet.
	 */
	private MarketPlace market;

	/**
	 * PlanetarySystem which the Planet belongs to.
	 */
	private PlanetarySystem planetarySystem;

	// --- Accessors and Modifiers
	/**
	 * @return The MarketPlace on the Planet.
	 */
	public MarketPlace getMarket() {
		return market;
	}

	/**
	 * @return The event happening on the Planet.
	 */
	public Event getEvent() {
		return event;
	}

	/**
	 * @param event
	 *            Event to set on the Planet.
	 */
	public void setEvent(Event event) {
		this.event = event;
	}

	/**
	 * @param market
	 *            MarketPlace to set on the Planet.
	 */
	public void setMarket(MarketPlace market) {
		this.market = market;
	}

	/**
	 * @param name
	 *            Name to set for the Planet.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return The Planet's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return TechnologyLevel of the Planet.
	 */
	public TechnologyLevel getTechnologyLevel() {
		return technologyLevel;
	}

	/**
	 * @param techLevel
	 *            TechnologyLevel to set for the Planet.
	 */
	public void setTechnologyLevel(TechnologyLevel techLevel) {
		this.technologyLevel = techLevel;
	}

	/**
	 * @return PoliticalSystem of the Planet.
	 */
	public PoliticalSystem getPoliticalSystem() {
		return politicalSystem;
	}

	/**
	 * @param polSystem
	 *            PoliticalSystem to set for the Planet.
	 */
	public void setPoliticalSystem(PoliticalSystem polSystem) {
		this.politicalSystem = polSystem;
	}

	/**
	 * @return The ResourceType of the Planet.
	 */
	public ResourceType getResourceType() {
		return resourceType;
	}

	/**
	 * @param resType
	 *            ResourceType to set for the Planet.
	 */
	public void setResourceType(ResourceType resType) {
		this.resourceType = resType;
	}

	/**
	 * @return X coordinate of the Planet.
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            X coordinate to set for the Planet.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * 
	 * @return Y coordinate of the Planet.
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            Y coordinate to set for the Planet.
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return The PlanetarySystem the Planet belongs to.
	 */
	public PlanetarySystem getPlanetarySystem() {
		return planetarySystem;
	}

	/**
	 * @param planetarySystem
	 *            PlanetarySystem to set for the Planet.
	 */
	public void setPlanetarySystem(PlanetarySystem planetarySystem) {
		this.planetarySystem = planetarySystem;
	}

	/**
	 * Determine if an event is to occur by using static fields.
	 */
	public void determineEvent() {
		if (Randomizer.isSuccessful(EVENT_PROBABILITY)) {
			event = (Event) Randomizer.randEnum(Event.class);
		} else {
			event = Event.NO_EVENT;
		}
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "Planet";
	}

	/**
	 * Hash the Planet based on its name.
	 * 
	 * @return A hash for this Planet so it can be used in a HashMap.
	 */
	public int hashCode() {
		return name.hashCode();
	}

	/**
	 * Checks to see if an object equals this Planet.
	 * @param object Object for which to check equality.
	 * @return true if they are equal, false otherwise.
	 */
	public boolean equals(Object object) {
		if (this == object){
			return true;
		}
		if (!(object instanceof Planet)) {
			return false;
		} else {
			final Planet truth = (Planet) object;
			return (name.equals(truth.getName()));
		}
	}
}