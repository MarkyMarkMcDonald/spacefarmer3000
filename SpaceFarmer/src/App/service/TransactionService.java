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
        String message = "success";
        Inventory inventory = player.getInventory();
        Set<Tradable> inventoryItems = inventory.getTradablesHeld();
        Ship ship = player.getShip();
        int cargoSize = ship.getCargoSize();
        int transactionCost = price * quantity;
        Iterator<Tradable> iterator = inventoryItems.iterator();
        while (iterator.hasNext()){
            Tradable inventoryItem = iterator.next();
            if (inventoryItem.equals(tradeGood)){

            }



        }
        // Make sure player has enough quantity to sell
//        if (){
//            message = "Not enough Inventory Space";
//        }
//        else {
//            // decrease the amount in the inventory
//        }


        return message;
    }

    public static String sellToMarket(Player player, MarketPlace marketPlace, int price, int quantity, Tradable tradeGood){
        String message = "success";
        Inventory inventory = player.getInventory();
        Ship ship = player.getShip();
        int cargoSize = ship.getCargoSize();
        int transactionCost = price * quantity;
        // Make sure player has enough space for quantity
        if (inventory.getSpaceUsed() + quantity > cargoSize){
            message = "Not enough Inventory Space";
        }
        // Make sure player has enough money
        else if (player.getMoney() < transactionCost){
            message = "You need $" + Math.abs(player.getMoney() - transactionCost) + " more!";
        }
        else {
            // decrease the amount in the inventory
        }


        return message;
    }

    public static String buyFromMarket(){
        String message = "success";


        return message;
    }
}
