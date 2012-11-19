package app.model.TradeGoods;

/**
 * User: marky Date: 10/22/12 Time: 3:15 PM
 */
public class BasicGood extends TradeGood implements Tradable {
	public BasicGood(TradeGoodType tradeGoodType, Enum<?> tradeGoodSubName) {
		super(tradeGoodType, tradeGoodSubName);
		this.name = tradeGoodSubName.toString();
	}

	public boolean equals(Object object) {
		if (object instanceof BasicGood) {
			return super.equals(object);
		} else {
			return false;
		}
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "BasicGood";
	}
}
