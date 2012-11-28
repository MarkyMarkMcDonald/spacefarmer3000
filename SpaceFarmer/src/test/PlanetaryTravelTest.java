// $codepro.audit.disable

/* This is a JUnit test case file and is thus not subject to an audit.
 */

package test;

import app.model.Game;
import app.model.player.Player;
import app.model.universe.Planet;
import app.model.universe.PlanetarySystem;
import app.service.TransportationService;
import app.view.Display;
import org.junit.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Tests the current user traveling within a system and outside of a system.
 *
 * Created with IntelliJ IDEA. User: mark.mcdonald Date: 11/11/12 Time: 9:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlanetaryTravelTest {

	private Player player1;

    private Planet planet1;

	private Planet planet2;

	private Planet planet3;

	@Before
	public void setup() {
		// set up placeholder display so it doesn't throw nulls when trying to set messages
        Display display = new Display();

        player1 = new Player();
		player1.setFuel(1000);
        Game.setCurrentPlayer(player1);

        PlanetarySystem system1 = new PlanetarySystem();
        system1.setX(2);
        system1.setY(2);
        planet1 = new Planet();
        planet2 = new Planet();
        planet1.setPlanetarySystem(system1);
        planet2.setPlanetarySystem(system1);

        PlanetarySystem system2 = new PlanetarySystem();
        system2.setX(3);
        system2.setY(3);
        planet3 = new Planet();
        planet3.setPlanetarySystem(system2);

        Map<String, Planet> system1Planets = new HashMap<String, Planet>();
        Map<String, Planet> system2Planets = new HashMap<String, Planet>();

        system1Planets.put(planet1.getName(), planet1);
        system1Planets.put(planet2.getName(), planet2);
        system2Planets.put(planet3.getName(), planet3);

        system1.setPlanets(system1Planets);
        system2.setPlanets(system2Planets);

        player1.setCurrentPlanet(planet1);
    }

    @Test
	public void TravelInSystem() {
        int initialFuel = player1.getFuel();
        TransportationService.hasGoneToPlanet(planet2);
		assertTrue(player1.getCurrentPlanet().equals(planet2));
        assertEquals(player1.getCurrentPlanet().getPlanetarySystem(),planet1.getPlanetarySystem());
        assertTrue(player1.getFuel() == initialFuel );
    }

    @Test
	public void TravelOutOfSystem() {
		int initialFuel = player1.getFuel();
        TransportationService.hasGoneToPlanet(planet3);
		assertTrue(player1.getCurrentPlanet().equals(planet3));
        assertNotSame(player1.getCurrentPlanet().getPlanetarySystem(), planet1.getPlanetarySystem());
        assertTrue(player1.getFuel() < initialFuel );
    }

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "PlanetaryTravelTest";
	}
}