package App.model;

import App.Util.Settings;

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

    private List<Player> players;

    private Settings settings;

    private Map<String, Planet> planets;

    //--Accessors and Modifiers
    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public Map<String, Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(Map<String, Planet> planets) {
        this.planets = planets;
    }
}
