package conf.tradegoodnames;

/**
 * User: marky Date: 10/22/12 Time: 2:18 PM
 */
public enum Food {

	BANANAS("Bananas"), PORKCHOPS("Porkchops"), FRIED_CHICKEN("Fried Chicken"), POPSICLES(
			"Popsicles");

	private String name;

	public String getName() {
		return name;
	}

	private Food(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
