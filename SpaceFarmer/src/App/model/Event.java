package App.model;

public enum Event {

	NO_EVENT ("No Event"),
	DROUGHT ("Drought"),
	COLD ("Cold"),
	CROPFAIL ("Cropfail"),
	WAR ("War"),
	BOREDOM ("Boredom"),
	PLAGUE ("Plague"),
	LACKOFWORKERS ("Lack of Workers");
	
	private String name;

	private Event(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	
}
