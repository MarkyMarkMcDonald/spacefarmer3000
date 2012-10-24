package Conf.TradeGoodNames;

/**
 * User: marky
 * Date: 10/22/12
 * Time: 2:15 PM
 */
public enum Furs {
    BEAR_PELT("Bear Pelt"),
    WOLF_PELT("Wolf Pelt"),
    DEER_PELT("Deer Pelt");



    private String name;

    public String getName(){
        return name;
    }

    private Furs(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
