package app.logging;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import app.factory.UniverseFactory;
import app.model.Game;
import app.model.Ship;
import app.model.player.Player;
import app.model.player.SkillType;
import app.model.universe.Planet;
import app.model.universe.PlanetarySystem;

/**
 * User: marky Date: 10/18/12 Time: 3:44 PM
 * 
 * @author Mark
 * @version 1.0
 */
public class Logger {

	/**
	 * Systematically dumps all game information to the console
	 */
	public static void printGameToConsole() {
		final List<Player> players = Game.getPlayers();
		final Collection<Planet> planets = UniverseFactory.getAllPlanets()
				.values();
		final Collection<PlanetarySystem> systems = UniverseFactory
				.getPlanetarySystems().values();

		System.out.println("########################################");
		System.out.println("########################################");
		System.out.println("### THROWING GAME INFO INTO CONSOLE  ###");
		System.out.println("########################################");
		System.out.println("########################################");
		System.out.println("########################################");

		System.out.println("Number of Players: " + players.size());
		int playerCounter = 0;
		for (Player player : players) {
			playerCounter++;
			System.out.println('\n');
			System.out.println("Player " + playerCounter + ":");
			printPlayerInfo(player);
			System.out.print('\n');
		}

		System.out.println("Current Player: "
				+ Game.getCurrentPlayer().getName());
		System.out.print('\n');
		System.out.println("## Planets ##");
		System.out.print("Number of Planets: " + planets.size());
		System.out.print('\n');
		for (Object planet : planets) {
			printPlanetInfo((Planet) planet);
		}

		System.out.println("## PlanetarySystems ##");
		System.out.println("Number of Planetary Systems: " + systems.size());
		for (Object system : systems) {
			printSystemInfo((PlanetarySystem) system);
		}

	}
	/*
	 * Helper Methods for the console dump
	 */

	/**
	 * Prints information about a Player.
	 * 
	 * @param player
	 *            Player whose information is to be printed.
	 */
	public static void printPlayerInfo(Player player) {
		System.out.println("Name: " + player.getName());
		System.out.println("Money: " + player.getMoney());
		System.out.println("Skills: ");
		printPlayerSkills(player.getSkillLevels());
		printShipInfo(player.getShip());
	}

	/**
	 * Print the values of the Player's skills.
	 * 
	 * @param skills
	 *            Map of the Player's skills to their Integer values.
	 */
	public static void printPlayerSkills(Map<SkillType, Integer> skills) {
		for (SkillType skillType : SkillType.values()) {
			System.out.println("\t" + skillType.toString() + " = "
					+ skills.get(skillType));
		}
	}

	/**
	 * Prints information about a Ship.
	 * 
	 * @param ship
	 *            Ship the information is associated with.
	 */
	public static void printShipInfo(Ship ship) {
		System.out.println("Ship: " + ship.getType().toString());
	}

	/**
	 * Print information about a Planet.
	 * 
	 * @param planet
	 *            Planet the information is associated with.
	 */
	public static void printPlanetInfo(Planet planet) {
		System.out.println("Name: " + planet.getName() + "; xDimension: "
				+ planet.getX() + "; yDimension: " + planet.getY());
		System.out.println("Tech level: " + planet.getTechnologyLevel());
		System.out.println("Resource level: " + planet.getResourceType());
		System.out.println("Political level: " + planet.getPoliticalSystem());
		System.out.println("Planetary System: "
				+ planet.getPlanetarySystem().getName());
		System.out.println();
	}

	/**
	 * Prints information about a Planetary System.
	 * 
	 * @param system
	 *            PlanetarySystem the information is associated with.
	 */
	public static void printSystemInfo(PlanetarySystem system) {
		System.out.println("Name: " + system.getName() + "; xDimension: "
				+ system.getX() + "; yDimension: " + system.getY());
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "Logger";
	}
}
