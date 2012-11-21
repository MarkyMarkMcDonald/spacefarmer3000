/*This file holds the Event enum, which holds
 * enumerations for Random Events on Planets.*/
package app.model;

public enum Event {

	NO_EVENT("None"), DROUGHT("Drought"), COLD("Cold"), CROPFAIL("Crop Failure"), WAR(
			"War"), BOREDOM("Boredom"), PLAGUE("Plague"), LACKOFWORKERS(
			"Lack of Workers");

	/**
	 * Name of an event.
	 */
	private final String name;

	/**
	 * Creates an Event using a String to represent its name.
	 * 
	 * @param name
	 *            Name of the Event.
	 */
	private Event(String name) {
		this.name = name;
	}

	/**
	 * Returns the contents of name.
	 * 
	 * @return The name of the Event.
	 */
	public String getName() {
		return name;
	}

}
