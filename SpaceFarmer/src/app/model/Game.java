package app.model;

import app.model.player.Player;
import app.model.universe.Planet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA. User: Marky Date: 9/22/12 Time: 12:33 AM To
 * change this template use File | Settings | File Templates.
 * 
 * @author Mark
 * @version 1.0
 */
public class Game {

	/**
	 * List of Players in the game.
	 */
	private static List<Player> Players = null;

	/**
	 * Settings associated with the game.
	 */
	private static Settings Settings = null;

	/**
	 * Map of the planet names in the game to the planets.
	 */
	private static Map<String, Planet> Planets = null;

	/**
	 * The number of turns in this game.
	 */
	private static int NumberOfTurns = 0;

	/**
	 * Player that the current turn is associated with.
	 */
	private static Player CurrentPlayer = null;

	/**
	 * Creates a Game by initializing the number of turns and the players.
	 */
	public Game() {
		setNumberOfTurns(1);
		setPlayers(new ArrayList<Player>());
	}

	/**
	 * @return The number of turns in this game.
	 */
	public static int getTurnNumber() {
		return NumberOfTurns;
	}

	/**
	 * Gives the length of a round by using the number of players.
	 * 
	 * @return The length of one round.
	 */
	public static int getRoundLength() {
		return Game.getPlayers().size() + 1;
	}

	/**
	 * Calculates the round number by using the turn number and the number of
	 * players.
	 * 
	 * @return The current round.
	 */
	public static int getRoundNumber() {
		return getTurnNumber() % Players.size() + 1;
	}

	/**
	 * Calculates which turn it is in the current round.
	 * 
	 * @return Turn in round.
	 */
	public static int getTurnInRound() {
		return (int) Math.floor(Game.getTurnNumber() % Game.getRoundLength());
	}

	/**
	 * Gives the turn to the next player. If the player was the last player,
	 * then assign a new event to each planet.
	 */
	public void endTurn() {
		final int playerIndex = Players.indexOf(CurrentPlayer) + 1;
		
		if (playerIndex >= Players.size()) {
			setCurrentPlayer(Players.get(0));
			for (Planet planet : Planets.values()) {
				planet.determineEvent();
			}
		} else {
			setCurrentPlayer(Players.get(playerIndex));
		}
	}

	/**
	 * @return The Planet the current Player is on.
	 */
	public static Planet getCurrentPlanet() {
		return CurrentPlayer.getCurrentPlanet();
	}

	/**
	 * @return The MarketPlace on the current Planet.
	 */
	public static MarketPlace getCurrentMarketPlace() {
		return getCurrentPlanet().getMarket();
	}

	/**
	 * @return The current Player.
	 */
	public static Player getCurrentPlayer() {
		return CurrentPlayer;
	}

	/**
	 * @param currentPlayer
	 *            The Player the current Player will be set to.
	 */
	public static void setCurrentPlayer(Player currentPlayer) {
		Game.CurrentPlayer = currentPlayer;
	}

	/**
	 * @param numberOfTurns
	 *            The number of turns to be set to.
	 */
	public static void setNumberOfTurns(int numberOfTurns) {
		Game.NumberOfTurns = numberOfTurns;
	}

	/**
	 * @return A list of all the Players.
	 */
	public static List<Player> getPlayers() {
		return Players;
	}

	/**
	 * @param players
	 *            The players Players will be set to.
	 */
	public static void setPlayers(List<Player> players) {
		Game.Players = players;
	}

	/**
	 * @return The Settings associated with this Game.
	 */
	public static Settings getSettings() {
		return Settings;
	}

	/**
	 * @param settings
	 *            The settings Settings will be set to.
	 */
	public static void setSettings(Settings settings) {
		Game.Settings = settings;
	}

	/**
	 * @return The Planets in this game.
	 */
	public static Map<String, Planet> getPlanets() {
		return Planets;
	}

	/**
	 * @param planets
	 *            The Planets that the game's Planets will be set to.
	 */
	public static void setPlanets(Map<String, Planet> planets) {
		Game.Planets = planets;
	}

	/**
	 * Adds a Player to the game
	 * 
	 * @param player
	 *            Player to be added.
	 */
	public void addPlayer(Player player) {
		Players.add(player);
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "Game";
	}
}
