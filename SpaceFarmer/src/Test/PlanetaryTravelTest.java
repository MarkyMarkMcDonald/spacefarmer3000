package test;

import app.model.Game;
import app.model.Player.Player;
import app.model.Universe.Planet;
import app.model.Universe.PlanetarySystem;
import app.service.TransportationService;
import org.junit.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA. User: mark.mcdonald Date: 11/11/12 Time: 9:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlanetaryTravelTest {

	private Player player1;

	private Player player2;

	private PlanetarySystem system1;

	private PlanetarySystem system2;

	private Planet planet1;

	private Planet planet2;

	private Planet planet3;

	@Before
	public void setup() {
		player1 = new Player();
		player2 = new Player();

		Game.setCurrentPlayer(player1);

		system1 = new PlanetarySystem();
		system2 = new PlanetarySystem();

		planet1 = new Planet();
		planet2 = new Planet();
		planet3 = new Planet();

		Map<String, Planet> system1Planets = new HashMap<String, Planet>();

		system1.setPlanets(system1Planets);

	}

	public void TravelInSystem() {
		TransportationService.goToPlanet(planet1);
		assertTrue(player1.getCurrentPlanet().equals(planet1));
	}

	public void TravelOutOfSystem() {
		TransportationService.goToPlanet(planet2);
		assertTrue(player1.getCurrentPlanet().equals(planet2));
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "PlanetaryTravelTest";
	}
}