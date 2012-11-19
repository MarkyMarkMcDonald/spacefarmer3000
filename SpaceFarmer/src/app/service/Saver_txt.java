package App.service;

import App.model.Player.Player;
import App.model.Settings;
import App.model.Universe.Planet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

/**
 * This class handles saving the current game.
 * 
 * @author Mykal Thomas, Mark McDonald
 */
public class Saver_txt {
	private String saveLocations[];

	private FileWriter fWriter;

	private BufferedWriter writer;

	private Collection<Player> players;

	private Collection<Planet> planets;

	private Settings gameSettings;

	/**
	 * Constructer for the saver
	 * 
	 * @param loctaions
	 *            the array of save locations
	 * @param people
	 *            a collection of players in the game
	 * @param universe
	 *            a collection of planets in the game
	 * @param settings
	 *            the settings for the game.
	 */
	public Saver_txt(String loctaions[], Collection<Player> people,
			Collection<Planet> universe, Settings settings) {
		saveLocations = loctaions;
		players = people;
		fWriter = null;
		writer = null;
		planets = universe;
		gameSettings = settings;
	}

	/**
	 * saves the players (npc's included) and all their stuff to a file
	 * 
	 * @param players
	 *            a collection of players in the game
	 */
	private void savePlayer(String location, Collection<Player> players) {
		try {
			fWriter = new FileWriter(location + "/players");
			writer = new BufferedWriter(fWriter);
			writer.write(players.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Player player : players) {
			try {
				writer.write("\n" + player.getName());
				writer.write("\n" + player.getMoney());
				writer.write("\n" + player.getSkillLevels().toString());
				writer.write("\n" + player.getInventory().toString());
				writer.write("\n" + player.getShip().getType().toString());

				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Save the Player information to a Save file object.
	 */
	private void savePlayer() {
		savePlayer(saveLocations[0], players);
	}

	/**
	 * saves the planets in the
	 * 
	 * @param location
	 *            the array of save locations
	 * @param planets
	 */
	private void savePlanet(String location, Collection<Planet> planets) {
		try {
			fWriter = new FileWriter(location + "/planets");
			writer = new BufferedWriter(fWriter);
			writer.write(planets.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Planet planet : planets) {
			try {
				writer.write("\n" + planet.getName());
				writer.write("\n" + planet.getX() + "," + planet.getY());
				writer.write("\n" + planet.getPoliticalSystem());
				writer.write("\n" + planet.getResourceType());
				writer.write("\n" + planet.getTechnologyLevel());

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Save Planet information to a Save file object.
	 */
	private void savePlanet() {
		savePlanet(saveLocations[0], planets);
	}

	/**
	 * Save Settings information to a Save file object.
	 * 
	 * @param location
	 *            the array of save locations
	 * @param gameSettigns
	 */
	private void saveSettings(String location, Settings gameSettigns) {
		try {
			fWriter = new FileWriter(location + "/settings");
			writer = new BufferedWriter(fWriter);
			writer.write(planets.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			java.util.Date date = new java.util.Date();
			writer.write(date.toString());
			writer.write((int) date.getTime());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Why are there two saveSettings methods?
	 */
	private void saveSettings() {
		saveSettings(saveLocations[0], gameSettings);
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "Saver_txt";
	}
}
