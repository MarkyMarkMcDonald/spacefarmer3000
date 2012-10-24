package Conf.TradeGoodNames;

/**
 * User: marky
 * Date: 10/22/12
 * Time: 2:23 PM
 */
public enum Games {

    BOARD_GAMES("Board Games"),
    VIDEO_GAMES("Video Games"),
    SIDEWALK_CHALK("Sidewalk Chalk");

    private String name;

    public String getName(){
        return name;
    }

    private Games(String name){
        this.name = name;
    }
}
