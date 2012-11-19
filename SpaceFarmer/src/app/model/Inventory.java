package app.model;

import app.model.TradeGoods.Tradable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA. User: Marky Date: 9/22/12 Time: 12:35 AM To
 * change this template use File | Settings | File Templates.
 */
public class Inventory {

	private Map<Tradable, Integer> theInventory;

	public Inventory() {
		theInventory = new HashMap<Tradable, Integer>();
	}

	public int getSpaceUsed() {
		int sum = 0;
		Collection<Integer> quantities = theInventory.values();
		for (Integer quantity : quantities) {
			sum += quantity;
		}
		return sum;
	}

	public void addItem(Tradable item, int quantity) {
		if (!theInventory.containsKey(item)) {
			theInventory.put(item, quantity);
		} else {
			Integer currentQuantity = theInventory.get(item);
			theInventory.put(item, currentQuantity + quantity);
		}
		if (theInventory.get(item) == 0) {
			theInventory.remove(item);
		}
	}

	public int getQuantity(Tradable item) {
		if (theInventory.containsKey(item)) {
			return theInventory.get(item);
		} else
			return 0;
	}

	public Set<Map.Entry<Tradable, Integer>> getInventoryEntries() {
		return theInventory.entrySet();
	}

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
