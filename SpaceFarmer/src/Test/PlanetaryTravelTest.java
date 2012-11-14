package Test;

import App.model.Game;
import App.model.Player.Player;
import App.model.Universe.Planet;
import App.model.Universe.PlanetarySystem;
import App.service.TransportationService;
import org.junit.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: mark.mcdonald
 * Date: 11/11/12
 * Time: 9:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlanetaryTravelTest {

    Player player1;
    Player player2;
    PlanetarySystem system1;
    PlanetarySystem system2;
    Planet planet1;
    Planet planet2;
    Planet planet3;

    @Before
    public void setup(){
        player1 = new Player();
        player2 = new Player();

        Game.setCurrentPlayer(player1);

        system1 = new PlanetarySystem();
        system2 = new PlanetarySystem();

        planet1 = new Planet();
        planet2 = new Planet();
        planet3 = new Planet();

        Map<String,Planet> system1Planets = new HashMap<String, Planet>();

        system1.setPlanets(system1Planets);

    }

    public void TravelInSystem(){
        TransportationService.goToPlanet(planet1);
        assertTrue(player1.getCurrentPlanet().equals(planet1));
    }

    public void TravelOutOfSystem(){
        TransportationService.goToPlanet(planet2);
        assertTrue(player1.getCurrentPlanet().equals(planet2));
    }

}