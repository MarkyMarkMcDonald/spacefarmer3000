package app.model.Universe;

import app.model.*;
import app.service.Randomizer;

/**
 * Created with IntelliJ IDEA. User: Marky Date: 9/22/12 Time: 12:32 AM To
 * change this template use File | Settings | File Templates.
 */
public class Planet {

	private static final double EventProbability = .1;

	private String name;

	private TechnologyLevel technologyLevel;

	private PoliticalSystem politicalSystem;

	private Event event;

	private ResourceType resourceType;

	// Position within the solar system
	private int x, y;

	private MarketPlace market;

	private PlanetarySystem planetarySystem;

	public Planet() {

	}

	public Planet(String name, TechnologyLevel technologyLevel,
			PoliticalSystem politicalSystem, ResourceType resourceType, int x,
			int y) {
		this.name = name;
		this.technologyLevel = technologyLevel;
		this.politicalSystem = politicalSystem;
		this.resourceType = resourceType;
		this.x = x;
		this.y = y;
	}

	// --- Accessors and Modifiers
	public MarketPlace getMarket() {
		return market;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public void setMarket(MarketPlace market) {
		this.market = market;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public TechnologyLevel getTechnologyLevel() {
		return technologyLevel;
	}

	public void setTechnologyLevel(TechnologyLevel techLevel) {
		this.technologyLevel = techLevel;
	}

	public PoliticalSystem getPoliticalSystem() {
		return politicalSystem;
	}

	public void setPoliticalSystem(PoliticalSystem polSystem) {
		this.politicalSystem = polSystem;
	}

	public ResourceType getResourceType() {
		return resourceType;
	}

	public void setResourceType(ResourceType resType) {
		this.resourceType = resType;
	}

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

	public PlanetarySystem getPlanetarySystem() {
		return planetarySystem;
	}

	public void setPlanetarySystem(PlanetarySystem planetarySystem) {
		this.planetarySystem = planetarySystem;
	}

	/**
	 * Determine if an event is to occur by using static fields.
	 */
	public void determineEvent() {
		if (Randomizer.determineSuccess(EventProbability)) {
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
	 * @return The hash code for this Planet object, based on its name.
	 */
	public int hashCode() {
		return name.hashCode();
	}
}