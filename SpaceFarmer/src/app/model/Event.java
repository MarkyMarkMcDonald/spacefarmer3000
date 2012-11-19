package app.model;

public enum Event {

	NO_EVENT("None"), DROUGHT("Drought"), COLD("Cold"), CROPFAIL("Crop Failure"), WAR(
			"War"), BOREDOM("Boredom"), PLAGUE("Plague"), LACKOFWORKERS(
			"Lack of Workers");

	private String name;

	private Event(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
