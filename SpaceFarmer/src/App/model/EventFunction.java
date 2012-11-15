package App.model;

import App.model.Player.Player;
import App.model.TradeGoods.BasicGood;
import App.model.TradeGoods.Tradable;
import App.model.TradeGoods.TradeGoodType;
import App.service.Randomizer;

import java.util.Set;

/**
 * This interface requires a method that takes in a Player. The methods acts as
 * a random event and alters the player.
 */
public interface EventFunction {

	public void function(Player player);

	public static final int CHANGE_MIN = 1;

	public static final int CHANGE_MAX = 10;

	public static final EventFunction LoseFunction = new LoseEvent();

	public static final EventFunction WinFunction = new WinEvent();

	/**
	 * Class corresponding to an event where a players loses an item.
	 */
	public static class LoseEvent implements EventFunction {
		public void function(Player player) {
			if (player.getInventory().getSpaceUsed() == 0)
				return;
			int loseAmount = CHANGE_MIN
					+ Randomizer.nextInt(CHANGE_MAX - CHANGE_MIN + 1);
			Set<Tradable> goodsSet = player.getInventory().getTradablesHeld();
			Tradable[] goods = goodsSet.toArray(new Tradable[0]);
			Tradable lostGood = (Tradable) Randomizer.randElement(goods);
			if (player.getInventory().getQuantity(lostGood) < loseAmount) {
				loseAmount = player.getInventory().getQuantity(lostGood);
			}
			player.getInventory().addItem(lostGood, -loseAmount);
		}

		/**
		 * @return Information about this object as a String.
		 */
		public String toString() {
			return "EventFunction.LoseEvent";
		}
	}

	/**
	 * Class corresponding to an event where a player finds an item.
	 */

	public static class WinEvent implements EventFunction {
		public void function(Player player) {
			int addAmount = CHANGE_MIN
					+ Randomizer.nextInt(CHANGE_MAX - CHANGE_MIN + 1);
			TradeGoodType type = (TradeGoodType) Randomizer
					.randEnum(TradeGoodType.class);
			Enum<?>[] subNames = type.getSubNames();
			BasicGood good = new BasicGood(type,
					(Enum<?>) Randomizer.randElement(subNames));
			Ship ship = player.getShip();
			int cargoSize = ship.getCargoSize();
			if (player.getInventory().getSpaceUsed() + addAmount > cargoSize) {
				addAmount = cargoSize - player.getInventory().getSpaceUsed();
			}
			player.getInventory().addItem(good, addAmount);
		}

		/**
		 * @return Information about this object as a String.
		 */
		public String toString() {
			return "EventFunction.WinEvent";
		}
	}
}
