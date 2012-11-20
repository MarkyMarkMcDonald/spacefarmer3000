/*
 * This class tests the functionality of the random events.
 * Author: Bobbey Reese
 */

package test;

import junit.framework.Assert;

import org.junit.Test;

import app.model.EventFunction;
import app.model.Inventory;
import app.model.Player.Player;
import app.model.TradeGoods.BasicGood;
import app.model.TradeGoods.TradeGoodType;
import conf.TradeGoodNames.Firearms;

public class EventFunctionTest {

	@Test
	public void test() {
		Player player = new Player("Dude", 4, 4, 4, 4);
		Inventory inventory = new Inventory();
		player.setInventory(inventory);
		BasicGood good = new BasicGood(TradeGoodType.FIREARMS, Firearms.PISTOLS);
		inventory.addItem(good, 15);
		EventFunction.WinFunction.function(player);

		// Make sure adding items to inventory at max does not result in more
		// goods than cargo space.
		Assert.assertEquals("Overloaded Inventory?", inventory.getSpaceUsed(),
				15);
		inventory = new Inventory();
		inventory.addItem(good, 14);
		player.setInventory(inventory);
		EventFunction.WinFunction.function(player);

		// Make sure that near the maximum, finding items pushing the amount to
		// the maximum cargo space but not over.
		Assert.assertEquals("Will add items near max?",
				inventory.getSpaceUsed(), 15);
		EventFunction.LoseFunction.function(player);

		// Make sure items can be lost in general.
		Assert.assertTrue("Items lost near max?", inventory.getSpaceUsed() < 15);
		inventory = new Inventory();
		player.setInventory(inventory);
		EventFunction.WinFunction.function(player);

		// Make sure items are added in general
		Assert.assertTrue("Items added near 0?", inventory.getSpaceUsed() > 0);
		player.setInventory(new Inventory());
		EventFunction.LoseFunction.function(player);

		// Make sure that nothing funny happens when items are lost from an
		// inventory with no items.
		Assert.assertEquals("No items lost at 0?", player.getInventory()
				.getSpaceUsed(), 0);
		inventory = new Inventory();
		inventory.addItem(good, 1);
		player.setInventory(inventory);
		EventFunction.LoseFunction.function(player);

		// Make sure that items lost near 0 push the inventory space to 0 and
		// not anywhere else.
		Assert.assertEquals("Items lost near 0?", inventory.getSpaceUsed(), 0);
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "EventFunctionTest";
	}
}