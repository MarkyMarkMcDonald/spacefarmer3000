/*This file holds the class TradeGood, which represents goods in
 * the MarketPlace that may be bought or sold.
 */
package app.model.tradegoods;

/**
 * User: marky Date: 10/21/12 Time: 5:58 PM
 * 
 * @author Mark
 * @version 1.0
 */
public class TradeGood implements Tradable {

	/**
	 * Name of the TradeGood.
	 */
	protected String name;

	/**
	 * Enumerated Type of the TradeGood
	 */
	protected TradeGoodType tradeGoodType;

	/**
	 * Enumerated sub name of the TradeGood.
	 */
	protected Enum<?> tradeGoodSubName;

	/**
	 * Returns the hashcode of a TradeGood based of its name.
	 * @return The hashcode of the TradeGood's name.
	 */
	public int hashCode() {
		return name.hashCode();
	}

	/**
	 * Checks to see if an Object equals this TradeGood.
	 * 
	 * @param object
	 *            Object to check.
	 * @return true if they are equivalent, false otherwise.
	 */
	public boolean equals(Object object) {
		if (object == this){
			return true;
		}
		if (!(object instanceof Tradable)) {
			return false;
			
		} else {
			final Tradable actual = (Tradable) object;
			return actual.getName().equals(name);
		}
	}

	/**
	 * Constructs a TradeGood out of a TradeGoodType and an enumeration.
	 * 
	 * @param tradeGoodType
	 *            Type of the TradeGood
	 * @param tradeGoodSubName
	 *            Sub name to associate with the TradeGood.
	 */
	public TradeGood(TradeGoodType tradeGoodType, Enum<?> tradeGoodSubName) {
		this.tradeGoodType = tradeGoodType;
		this.tradeGoodSubName = tradeGoodSubName;
	}

	/**
	 * @return The base price of this TradeGood.
	 */
	public int getBasePrice() {
		return tradeGoodType.getBasePrice();
	}

	/**
	 * @return The name of this TradeGood.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return The name of this TradeGood.
	 */
	public String toString(){
		return name;
	}
}