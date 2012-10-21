package App.service;

import App.model.*;

/**
 * User: marky
 * Date: 10/18/12
 * Time: 11:14 PM
 */
public class TransactionService {

    public static String sellToMarket(Player player, MarketPlace marketPlace, int price, int quantity, String tradeGoodName){
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
            inventory
        }


        return message;
    }

    public static String buyFromMarket(){
        String message = "success";


        return message;
    }
}
