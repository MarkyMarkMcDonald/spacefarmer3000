package App.service;

import App.model.*;

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
            message = "You need $" + (transactionCost - player.getMoney() + " more!");
        }
        else {
            // Default success message
            message = "You Purchased " + quantity + " " + tradeGood.getName() + "'s for " + transactionCost;

            player.changeMoney(-transactionCost);

            marketPlace.changeQuantity(tradeGood,-quantity);

            inventory.addItem(tradeGood,quantity);
        }
        return message;
    }

    public static String sellToMarket(Player player, MarketPlace marketPlace, int price, int quantity, Tradable tradeGood){
        String message;
        Inventory inventory = player.getInventory();
        int amountInInventory = inventory.getQuantity(tradeGood);
        Ship ship = player.getShip();
        int cargoSize = ship.getCargoSize();
        int transactionCost = price * quantity;

        // make sure player has enough
        if (amountInInventory >= quantity){
            message = "You Sold " + quantity + " " + tradeGood.getName() + "'s for " + transactionCost;

            inventory.addItem(tradeGood,-quantity);

            marketPlace.changeQuantity(tradeGood,quantity);
        }
        else {
            message = "You need " + (quantity - amountInInventory) + " more to sell that amount";
        }
        return message;
    }

    public static String buyFromMarket(){
        String message = "success";

        return message;
    }
}
