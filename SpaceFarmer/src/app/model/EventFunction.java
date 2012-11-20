package app.model;

import app.model.Player.Player;
import app.model.TradeGoods.BasicGood;
import app.model.TradeGoods.Tradable;
import app.model.TradeGoods.TradeGoodType;
import app.service.Randomizer;

import java.util.Set;

/**
 * This interface requires a method that takes in a Player. The methods acts as
 * a random event and alters the player.
 * 
 * @author Bobbey
 * @version 1.0
 */
public interface EventFunction {

	/**
	 * Gives a Player a randomEvent.
	 * 
	 * @param player
	 *            Player to give the event to.
	 */
	void function(Player player);

	/**
	 * Minimum amount of an item that a player can find/lose.
	 */
	int CHANGE_MIN = 1;

	/**
	 * Maximum amount of an item that a player can find/lose.
	 */
	int CHANGE_MAX = 10;
	
	/**
	 * Array needed for some methods to properly return Integer arrays.
	 */
    Tradable[] DUMMY_ARRAY= new Tradable[0];

	/**
	 * EventFunction holding method corresponding to a Player losing an item.
	 */
	EventFunction LOSE_FUNCTION = new LoseEvent();

	/**
	 * EventFunction holding method corresponding to a Player finding an item.
	 */
	EventFunction WIN_FUNCTION = new WinEvent();

	/**
	 * Class corresponding to an event where a players loses an item.
	 * 
	 * @author Bobbey
	 */
	public static class LoseEvent implements EventFunction {
		/**
		 * Actual method that causes a player to lose items.
		 * 
		 * @param player
		 *            Player that will find items.
		 */
		public void function(Player player) {
			if (player.getInventory().getSpaceUsed() == 0) {
				return;
			}
			int loseAmount = CHANGE_MIN
					+ Randomizer.nextInt(CHANGE_MAX - CHANGE_MIN + 1);
			final Set<Tradable> goodsSet = player.getInventory()
					.getTradablesHeld();
			final Tradable[] goods = goodsSet.toArray(DUMMY_ARRAY);
			final Tradable lostGood = (Tradable) Randomizer.randElement(goods);
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
	 * 
	 * @author Bobbey
	 */

	public static class WinEvent implements EventFunction {
		/**
		 * Actual method where a player finds items.
		 * 
		 * @param player
		 *            Player that will find items.
		 */
		public void function(Player player) {
			int addAmount = CHANGE_MIN
					+ Randomizer.nextInt(CHANGE_MAX - CHANGE_MIN + 1);
			final TradeGoodType type = (TradeGoodType) Randomizer
					.randEnum(TradeGoodType.class);
			final Enum<?>[] subNames = type.getSubNames();
			final BasicGood good = new BasicGood(type,
					(Enum<?>) Randomizer.randElement(subNames));
			final Ship ship = player.getShip();
			final int cargoSize = ship.getCargoSize();
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
