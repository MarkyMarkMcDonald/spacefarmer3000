package App.model;

import java.util.Collection;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Marky
 * Date: 9/22/12
 * Time: 12:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class Inventory {

    private Map<Tradeable, Integer> inventory;



    public int getSpaceUsed(){
        int sum = 0;
        Collection<Integer> quantities = inventory.values();
        for (Integer quantity : quantities){
            sum+= quantity;
        }
        return sum;
    }

    /**
     * Increase or Decrease the quantity of an item the player has. Use a negative quantityToAdd param to reduce the amount
     * @param item
     * @param quantityToAdd
     */
    public void increaseItemQuantity(Tradeable item, int quantityToAdd){
        if (!inventory.containsKey(item)){
            inventory.put(item,quantityToAdd);
        }
        else {
            int currentQuantity = inventory.get(item);
            inventory.put(item,currentQuantity + quantityToAdd);
        }
    }




}
