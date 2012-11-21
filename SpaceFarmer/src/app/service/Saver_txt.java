// $codepro.audit.disable lossOfPrecisionInCast
package app.service;

import app.model.Settings;
import app.model.player.Player;
import app.model.universe.Planet;

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
	 * Constructor for the saver
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
	public Saver_txt(String locations[], Collection<Player> people,
			Collection<Planet> universe, Settings settings) {
		saveLocations = new String[locations.length];
		for(int i = 0; i < locations.length; ++i) {
			saveLocations[i] = locations[i];
		}
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
	 * @throws IOException 
	 */
	private void savePlayer(String location, Collection<Player> players) throws IOException {
		try {
			fWriter = new FileWriter(location + "/players");
			writer = new BufferedWriter(fWriter);
			writer.write(players.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fWriter.close();
		}
		for (Player player : players) {
			try {
				writer.write("\n" + player.getName());
				writer.write("\n" + player.getMoney());
				writer.write("\n" + player.getSkillLevels().toString());
				writer.write("\n" + player.getInventory().toString());
				writer.write("\n" + player.getShip().getType().toString());

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				writer.close();
			}
		}
	}

	/**
	 * Save the Player information to a Save file object.
	 */
	private void savePlayer() {
		try {
			savePlayer(saveLocations[0], players);
		} catch(IOException e) {
			System.out.println("An IO Exception was thrown!");
		}
	}

	/**
	 * saves the planets in the
	 * 
	 * @param location
	 *            the array of save locations
	 * @param planets
	 * @throws IOException 
	 */
	private void savePlanet(String location, Collection<Planet> planets) throws IOException {
		try {
			fWriter = new FileWriter(location + "/planets");
			writer = new BufferedWriter(fWriter);
			writer.write(planets.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fWriter.close();
			writer.close();
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
		try {
			savePlanet(saveLocations[0], planets);
		} catch(IOException e) {
			System.out.println("An IOExceptino was thrown!");
		}
	}

	/**
	 * Save Settings information to a Save file object.
	 * 
	 * @param location
	 *            the array of save locations
	 * @param gameSettigns
	 * @throws IOException 
	 */
	private void saveSettings(String location, Settings gameSettigns) throws IOException {
		try {
			fWriter = new FileWriter(location + "/settings");
			writer = new BufferedWriter(fWriter);
			writer.write(planets.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fWriter.close();
			writer.close();
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
		try {
			saveSettings(saveLocations[0], gameSettings);
		} catch(IOException e) {
			System.out.println("An IOException was thrown!");
		}
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "Saver_txt";
	}
}
