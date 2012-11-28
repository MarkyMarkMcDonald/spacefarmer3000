// $codepro.audit.disable packagePrefixNamingConvention
/*This file holds the class BasicGood, which represent Tradable
 * objects that have a type and a sub name.
 */
package app.model.tradegoods;

/**
 * User: marky Date: 10/22/12 Time: 3:15 PM
 * 
 * @author Mark
 * @version 1.0
 */
public class BasicGood extends TradeGood implements Tradable {
	/**
	 * Constructs a BasicGood from a TradeGoodType and enumerated object.
	 * 
	 * @param tradeGoodType
	 *            TradeGoodType of this BasicGood.
	 * @param tradeGoodSubName
	 *            Subname of this BasicGood.
	 */
	public BasicGood(TradeGoodType tradeGoodType, Enum<?> tradeGoodSubName) {
		super(tradeGoodType, tradeGoodSubName);
		this.name = tradeGoodSubName.toString();
	}

	/**
	 * Checks to see if an Object is the same as this BasicGood.
	 * 
	 * @param object
	 *            Object for which to check equivalency.
	 * @return true if they are the same, false otherwise.
	 */
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (!(object instanceof BasicGood)) {
			return false;
		} else {

			return super.equals((BasicGood) object);
		}
	}

	/**
	 * Computes the hashCode from the name.
	 * 
	 * @return The hashCode of the name.
	 */
	public int hashCode() {
		return super.hashCode();
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "BasicGood";
	}
}
