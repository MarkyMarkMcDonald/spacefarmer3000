package Conf.TradeGoodNames;

/**
 * User: marky Date: 10/22/12 Time: 2:27 PM
 */
public enum Machines {

	RUMBA("Rumba"), ZAMBONI("Zamboni");

	private String name;

	public String getName() {
		return name;
	}

	private Machines(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
