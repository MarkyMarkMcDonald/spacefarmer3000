/*This file holds the class TransactionService,which is responsible
 * for handling transactions between a Player and the MarketPlace.
 */
package app.service;

import app.model.Inventory;
import app.model.MarketPlace;
import app.model.Ship;
import app.model.player.Player;
import app.model.tradegoods.Tradable;
import app.view.Display;
import app.view.sidepanels.MessageType;

/**
 * User: marky Date: 10/18/12 Time: 11:14 PM
 * @author Mark
 * @version 1.0
 */
public class TransactionService {

	/**
	 * Buy something from a market.
	 * 
	 * @param player
	 *            The Player performing the transaction.
	 * @param marketPlace
	 *            The current marketplace where the purchase is taking place.
	 * @param price
	 *            The price of the good the Player is trying to buy.
	 * @param quantity
	 *            The quantity in which the Player is purchasing the goods.
	 * @param tradeGood
	 *            The goods that the Player is trying to buy.
	 * @return A String message telling the outcome of the attempted purchase.
	 */
	public static boolean hasBoughtFromMarket(Player player, MarketPlace marketPlace,
			int price, int quantity, Tradable tradeGood) {
		String message;

		final Inventory inventory = player.getInventory();
		// Set<Tradable> inventoryItems = inventory.getTradablesHeld();
		final Ship ship = player.getShip();
		final int cargoSize = ship.getCargoSize();
		int transactionCost = (price * quantity);

		// Make sure player has enough space to hold bought goods
		if (inventory.getSpaceUsed() + quantity > cargoSize) {
			message = "You need "
					+ (inventory.getSpaceUsed() + quantity - cargoSize)
					+ " more free space!";
			Display.setMessage(message, MessageType.ERROR);
			return false;
		}
		// Make sure player has enough money
		else if (transactionCost > player.getMoney()) {
			message = "You need $"
					+ (transactionCost - player.getMoney() + " more!");
			Display.setMessage(message, MessageType.ERROR);
			return false;
		} else {
			// Default success message
			message = "You Purchased " + quantity + " " + tradeGood.getName()
					+ "'s for $" + transactionCost;

			player.changeMoney(-transactionCost);

			marketPlace.changeQuantity(tradeGood, -quantity);

			inventory.addItem(tradeGood, quantity);

			Display.setMessage(message, MessageType.GOOD);
			return true;
		}
	}

	/**
	 * Sell a good to the market.
	 * 
	 * @param player
	 *            The Player performing the transaction.
	 * @param marketPlace
	 *            The marketplace with which this Player is interacting.
	 * @param price
	 *            The price at which the market is buying the good.
	 * @param quantity
	 *            The quantity in which the marketplace is buying goods from the
	 *            Player.
	 * @param tradeGood
	 *            The good which the Player is trying to sell.
	 * @return A string explaining the outcome of the transaction.
	 */
	public static boolean hasSoldToMarket(Player player, MarketPlace marketPlace,
			int price, int quantity, Tradable tradeGood) {
		String message;
		final Inventory inventory = player.getInventory();
		final int amountInInventory = inventory.getQuantity(tradeGood);
		final int transactionCost = price * quantity;

		// make sure player has enough
		if (amountInInventory >= quantity) {
			message = "You Sold " + quantity + " " + tradeGood.getName()
					+ "'s for " + transactionCost;
			inventory.addItem(tradeGood, -quantity);

			marketPlace.changeQuantity(tradeGood, quantity);

			player.changeMoney(transactionCost);

			Display.setMessage(message, MessageType.GOOD);
			return true;
		} else {
			message = "You need " + (quantity - amountInInventory)
					+ " more to sell that amount";
			Display.setMessage(message, MessageType.ERROR);
			return false;
		}
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "TransactionService";
	}
}
