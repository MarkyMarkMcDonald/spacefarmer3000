package app.model;

import app.model.tradegoods.Tradable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA. User: Marky Date: 9/22/12 Time: 12:35 AM To
 * change this template use File | Settings | File Templates.
 * 
 * @author Mark
 * @version 1.0
 */
public class Inventory {

	/**
	 * Map from the Tradables in the inventory to their quantities.
	 */
	private final Map<Tradable, Integer> theInventory;

	/**
	 * Creates an Inventory by initializing theInventory.
	 */
	public Inventory() {
		theInventory = new HashMap<Tradable, Integer>();
	}

	/**
	 * Calculates the amount of space used in this inventory.
	 * 
	 * @return The amount of space used.
	 */
	public int getSpaceUsed() {
		int sum = 0;
		final Collection<Integer> quantities = theInventory.values();
		for (Integer quantity : quantities) {
			sum += quantity;
		}
		return sum;
	}

	/**
	 * Adds an item to this Inventory.
	 * 
	 * @param item
	 *            Item to be added.
	 * @param quantity
	 *            Amount of the item to be added.
	 */
	public void addItem(Tradable item, int quantity) {
		if (!theInventory.containsKey(item)) {
			theInventory.put(item, quantity);
		} else {
			final Integer currentQuantity = theInventory.get(item);
			theInventory.put(item, currentQuantity + quantity);
		}
		if (theInventory.get(item) == 0) {
			theInventory.remove(item);
		}
	}

	/**
	 * Returns the quantity of an item in this Inventory.
	 * 
	 * @param item
	 *            Item quantity to check.
	 * @return Amount of the item in this Inventory.
	 */
	public int getQuantity(Tradable item) {
		if (theInventory.containsKey(item)) {
			return theInventory.get(item);
		} else {
			return 0;
		}
	}

	/**
	 * @return The entrySet of the theInventory.
	 */
	public Set<Map.Entry<Tradable, Integer>> getInventoryEntries() {
		return theInventory.entrySet();
	}

	/**
	 * @return Key set of the Tradables in this Inventory.
	 */
	public Set<Tradable> getTradablesHeld() {
		return theInventory.keySet();
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "Inventory";
	}
}
