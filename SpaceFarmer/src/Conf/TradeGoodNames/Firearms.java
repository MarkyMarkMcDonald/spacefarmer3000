package Conf.TradeGoodNames;

/**
 * User: marky
 * Date: 10/22/12
 * Time: 2:24 PM
 */
public enum Firearms {

    PISTOLS("Pistols"),
    RIFLES("Rifles"),
    SHOTGUNS("Shotguns");

    private String name;

    public String getName(){
        return name;
    }

    private Firearms(String name){
        this.name = name;
    }

}
