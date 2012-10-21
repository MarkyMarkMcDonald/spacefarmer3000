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

    public void addItem(Tradeable item, int quantity){
        if (!inventory.containsKey(item)){
            inventory.put(item,quantity);
        }
        else {
            inventory.get(TradeGood)
        }
    }


}
