package Conf.TradeGoodNames;

/**
 * User: marky
 * Date: 10/22/12
 * Time: 2:11 PM
 */
public enum Water {

    SPRING_WATER("Spring Water"),
    UNFILTERED_WATER("Flavored Water"),
    SPORTS_DRINKS("Sports Drinks");

    private String name;

    public String getName(){
        return name;
    }

    private Water(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }

}
