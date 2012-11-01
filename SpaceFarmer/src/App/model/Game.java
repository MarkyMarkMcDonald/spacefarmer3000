package App.model;



import java.util.ArrayList;
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
        players = new ArrayList<Player>();
    }

    //--Accessors and Modifiers

    public static Player getCurrentPlayer() {
        return currentPlayer;
    }

    public static void setCurrentPlayer(Player currentPlayer) {
        Game.currentPlayer = currentPlayer;
    }

    public static int getNumberOfTurns() {
        return numberOfTurns;
    }

    public static void setNumberOfTurns(int numberOfTurns) {
        Game.numberOfTurns = numberOfTurns;
    }

    public static List<Player> getPlayers() {
        return players;
    }

    public static void setPlayers(List<Player> players) {
        Game.players = players;
    }

    public static Settings getSettings() {
        return settings;
    }

    public static void setSettings(Settings settings) {
        Game.settings = settings;
    }

    public static Map<String, Planet> getPlanets() {
        return planets;
    }

    public static void setPlanets(Map<String, Planet> planets) {
        Game.planets = planets;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
    
    public void endTurn()
    {
        int	playerIndex=players.indexOf(currentPlayer)+1;
    	if (playerIndex >= players.size())
    	{
    		currentPlayer=players.get(0);
    		for (int planetIndex=0;planetIndex<planets.size();planetIndex++);
    		{
    			planets.get(0).determineEvent();
    		}
    	}
    	else
    	{
    		currentPlayer=players.get(playerIndex);
    	}
    }
    
    public static Planet getCurrentPlanet() {
        return currentPlayer.getCurrentPlanet();
    }

    public static MarketPlace getCurrentMarketPlace() {
        return getCurrentPlanet().getMarket();
    }
}
