/*This file holds the class RandomEvent,
 * which is responsible for holding a random
 * event to give to a Player.
 */
package app.model;

import java.util.Set;

import app.model.player.Player;
import app.model.tradegoods.BasicGood;
import app.model.tradegoods.Tradable;
import app.model.tradegoods.TradeGoodType;
import app.service.Randomizer;

public enum RandomEvent {
	LOSE_ITEM(new LoseEvent()), FIND_ITEM(new WinEvent());

	/**
	 * Minimum amount of an item that a player can find/lose.
	 */
	private static final int CHANGE_MIN = 1;

	/**
	 * Maximum amount of an item that a player can find/lose.
	 */
	private static final int CHANGE_MAX = 10;

	/**
	 * Array needed for some methods to properly return Integer arrays.
	 */
	private static final Tradable[] DUMMY_ARRAY = new Tradable[0];

	/**
	 * EventFunction object holding an event function.
	 */
	private final EventFunction event;

	/**
	 * Constructs a RandomEvent using an EventFunction.
	 * 
	 * @param event
	 *            EventFunction used to create the RandomEvent.
	 */
	private RandomEvent(EventFunction event) {
		this.event = event;
	}

	/**
	 * Calls the method in event on player
	 * 
	 * @param player
	 *            Player on which the method is called.
	 * @return String explaining what happened to the Player.
	 */
	public String giveEvent(Player player) {
		return event.function(player);
	}

	/**
	 * Class corresponding to an event where a players loses an item.
	 * 
	 * @author Bobbey
	 */
	private static class LoseEvent implements EventFunction {
		/**
		 * Actual method that causes a player to lose items.
		 * 
		 * @param player
		 *            Player that will find items.
		 * @return String explaining what happened to the Player.
		 */
		public String function(Player player) {
			if (player.getInventory().getSpaceUsed() == 0) {
				return null;
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
			if (loseAmount == 0) {
				return null;
			} else {
				player.getInventory().addItem(lostGood, -loseAmount);
				return " You lost some items to pirates on the journey!";
			}

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
	private static class WinEvent implements EventFunction {
		/**
		 * Actual method where a player finds items.
		 * 
		 * @param player
		 *            Player that will find items.
		 * @return String explaining what happened to the Player.
		 */
		public String function(Player player) {
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
			if (addAmount == 0) {
				return null;
			} else {
				player.getInventory().addItem(good, addAmount);
				return " You found some items floating in space!";
			}
		}

		/**
		 * @return Information about this object as a String.
		 */
		public String toString() {
			return "EventFunction.WinEvent";
		}
	}
}
