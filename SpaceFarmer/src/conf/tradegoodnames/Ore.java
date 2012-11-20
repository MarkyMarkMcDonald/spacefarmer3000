package conf.tradegoodnames;

/**
 * User: marky Date: 10/22/12 Time: 2:21 PM
 */
public enum Ore {
	TITANIUM("Titanum Ore"), GOLD("Gold Ore"), SILVER("Silver"), Platinum(
			"Platinum");

	private String name;

	public String getName() {
		return name;
	}

	private Ore(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
