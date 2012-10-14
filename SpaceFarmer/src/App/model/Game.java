package App.model;



import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Marky
 * Date: 9/22/12
 * Time: 12:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class Game {

    private static List<Player> players;

    private static Settings settings;

    private static Map<String, Planet> planets;

    private static int numberOfTurns;

    private static Player currentPlayer;

    public Game(){
        numberOfTurns = 0;
    }

    //--Accessors and Modifiers

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public static void setCurrentPlayer(Player currentPlayer) {
        Game.currentPlayer = currentPlayer;
    }

    public int getNumberOfTurns() {
        return numberOfTurns;
    }

    public static void setNumberOfTurns(int numberOfTurns) {
        Game.numberOfTurns = numberOfTurns;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public static void setPlayers(List<Player> players) {
        Game.players = players;
    }

    public Settings getSettings() {
        return settings;
    }

    public static void setSettings(Settings settings) {
        Game.settings = settings;
    }

    public Map<String, Planet> getPlanets() {
        return planets;
    }

    public static void setPlanets(Map<String, Planet> planets) {
        Game.planets = planets;
    }
}
