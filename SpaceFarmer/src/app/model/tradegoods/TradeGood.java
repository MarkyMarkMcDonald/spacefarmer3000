package app.model.tradegoods;

/**
 * User: marky Date: 10/21/12 Time: 5:58 PM
 */
abstract public class TradeGood {
	protected String name;

	protected TradeGoodType tradeGoodType;

	protected Enum<?> tradeGoodSubName;

	public int hashCode() {
		return name.hashCode();
	}

	public boolean equals(Object object) {
		if (object instanceof Tradable) {
			return ((Tradable) object).getName().equals(name);
		} else {
			return false;
		}
	}

	public TradeGood(TradeGoodType tradeGoodType, Enum<?> tradeGoodSubName) {
		this.tradeGoodType = tradeGoodType;
		this.tradeGoodSubName = tradeGoodSubName;
	}

	public int getBasePrice() {
		return tradeGoodType.getBasePrice();
	}

	public String getName() {
		return name;
	}
}