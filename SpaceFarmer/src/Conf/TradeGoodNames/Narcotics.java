package Conf.TradeGoodNames;

/**
 * User: marky
 * Date: 10/22/12
 * Time: 2:30 PM
 */
public enum Narcotics {

    MOLLY("Molly"),
    MARIJUANA("Marijuana"),
    WOW_SUB_CARDS("World of Warcraft Subscription Cards");

    private String name;

    public String getName(){
        return name;
    }

    private Narcotics(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
