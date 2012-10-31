package App.service;

import App.model.*;

import java.util.Iterator;
import java.util.Set;

/**
 * User: marky
 * Date: 10/18/12
 * Time: 11:14 PM
 */
public class TransactionService {

    public static String buyFromMarket(Player player, MarketPlace marketPlace, int price, int quantity, Tradable tradeGood){
        String message;

        Inventory inventory = player.getInventory();
        Set<Tradable> inventoryItems = inventory.getTradablesHeld();
        Ship ship = player.getShip();
        int cargoSize = ship.getCargoSize();
        int transactionCost = (price * quantity);

        // Make sure player has enough space to hold bought goods
        if (inventory.getSpaceUsed() + quantity > cargoSize){
            message = "You need " + (inventory.getSpaceUsed() + quantity - cargoSize) + " more free space!";
        }
        // Make sure player has enough money
        else if (transactionCost > player.getMoney()){
            message = "You need $" + (transactionCost - player.getMoney() + "more!");
        }
        else {
            // Default success message
            message = "You Purchased " + quantity + " " + tradeGood.getName() + "'s for " + transactionCost;

            player.changeMoney(-transactionCost);

            Iterator<Tradable> iterator = inventoryItems.iterator();
            while (iterator.hasNext()){
                Tradable inventoryItem = iterator.next();
                if (inventoryItem.equals(tradeGood)){

                }
            }
        }
        return message;
    }

    public static String sellToMarket(Player player, MarketPlace marketPlace, int price, int quantity, Tradable tradeGood){
        String message;
        Inventory inventory = player.getInventory();
        Ship ship = player.getShip();
        int cargoSize = ship.getCargoSize();
        int transactionCost = price * quantity;

        // make sure player has enough

        message = "You Sold" + quantity + " " + tradeGood.getName() + "'s for " + transactionCost;

        // decrease the amount in the inventory

        // increase the amount in the marketplace

        // update the price of that good in the marketplace

        return message;
    }

    public static String buyFromMarket(){
        String message = "success";


        return message;
    }
}
