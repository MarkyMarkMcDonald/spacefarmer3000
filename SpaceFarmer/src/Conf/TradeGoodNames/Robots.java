package conf.TradeGoodNames;

/**
 * User: marky Date: 10/22/12 Time: 2:33 PM
 */
public enum Robots {
	ROBOTIC_LABORER("Robotic Laborer"), ROBOTIC_SERVANT("Robotic Servant");

	private String name;

	public String getName() {
		return name;
	}

	private Robots(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
