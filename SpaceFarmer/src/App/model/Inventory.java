package App.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Marky
 * Date: 9/22/12
 * Time: 12:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class Inventory {

    private Map<Tradable, Integer> inventory;

    public Inventory(){
        inventory = new HashMap<Tradable, Integer>();
    }

    public int getSpaceUsed(){
        int sum = 0;
        Collection<Integer> quantities = inventory.values();
        for (Integer quantity : quantities){
            sum+= quantity;
        }
        return sum;
    }

    public void addItem(Tradable item, int quantity){
        if (!inventory.containsKey(item)){
            inventory.put(item,quantity);
        }
        else {
            Integer currentQuantity = inventory.get(item);
            inventory.put(item,currentQuantity + quantity);
        }
        if (inventory.get(item) == 0)
        {
        	inventory.remove(item);
        }
    }

    public int getQuantity(Tradable item){
        return inventory.get(item);
    }

    public Set<Map.Entry<Tradable,Integer>> getInventoryEntries(){
        return inventory.entrySet();
    }

    public Set<Tradable> getTradablesHeld(){
        return inventory.keySet();
    }


}
