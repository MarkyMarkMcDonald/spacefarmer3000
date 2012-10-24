package Conf.TradeGoodNames;

/**
 * User: marky
 * Date: 10/22/12
 * Time: 2:25 PM
 */
public enum Medicine {

    ASPIRIN("Aspirin"),
    MORPHENE("Morphene"),
    COUGH_SYRUP("Cough Syrup");

    private String name;

    public String getName(){
        return name;
    }

    private Medicine(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
