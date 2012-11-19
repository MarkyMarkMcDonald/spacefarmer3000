package conf.TradeGoodNames;

/**
 * User: marky Date: 10/22/12 Time: 2:11 PM
 */
public enum Water {

	SPRING_WATER("Spring Water"), UNFILTERED_WATER("Flavored Water"), SPORTS_DRINKS(
			"Sports Drinks");

	/**
	 * name of the water
	 */
	private final String name;

	/**
	 * returns the name
	 * @return 
	 * 	the name of the water good
	 */
	public String getName() {
		return name;
	}

	/**
	 * setter for the water object
	 * @param name
	 * 	name of the object
	 */
	private Water(String name) {
		this.name = name;
	}

	/**
	 * override for the to string method
	 * @return the name of the object
	 */
	public String toString() {
		return name;
	}

}
