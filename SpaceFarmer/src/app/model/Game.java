package app.model;

import app.model.Player.Player;
import app.model.Universe.Planet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA. User: Marky Date: 9/22/12 Time: 12:33 AM To
 * change this template use File | Settings | File Templates.
 */
public class Game {

	private static List<Player> Players;

	private static Settings Settings;

	private static Map<String, Planet> Planets;

	private static int NumberOfTurns;

	private static Player CurrentPlayer;

	public Game() {
		setNumberOfTurns(1);
		setPlayers(new ArrayList<Player>());
	}

	// --Accessors and Modifiers
	public static int getTurnNumber() {
		return NumberOfTurns;
	}

	public static int getRoundLength() {
		return Game.getPlayers().size() + 1;
	}

	public static int getRoundNumber() {
		return getTurnNumber() % Players.size() + 1;
	}

	public static int getTurnInRound() {
		return (int) Math.floor(Game.getTurnNumber() % Game.getRoundLength());
	}

	/*
	 * Gives the turn to the next player. If the player was the last player,
	 * then assign a new event to each planet.
	 */
	public void endTurn() {
		int playerIndex = Players.indexOf(CurrentPlayer) + 1;
		if (playerIndex >= Players.size()) {
			setCurrentPlayer(Players.get(0));
			for (int planetIndex = 0; planetIndex < Planets.size(); planetIndex++) {
				Planets.get(planetIndex).determineEvent();
			}
		} else {
			setCurrentPlayer(Players.get(playerIndex));
		}
	}

	public static Planet getCurrentPlanet() {
		return CurrentPlayer.getCurrentPlanet();
	}

	public static MarketPlace getCurrentMarketPlace() {
		return getCurrentPlanet().getMarket();
	}

	// Auto generated
	public static Player getCurrentPlayer() {
		return CurrentPlayer;
	}

	public static void setCurrentPlayer(Player currentPlayer) {
		Game.CurrentPlayer = currentPlayer;
	}

	public static void setNumberOfTurns(int numberOfTurns) {
		Game.NumberOfTurns = numberOfTurns;
	}

	public static List<Player> getPlayers() {
		return Players;
	}

	public static void setPlayers(List<Player> players) {
		Game.Players = players;
	}

	public static Settings getSettings() {
		return Settings;
	}

	public static void setSettings(Settings settings) {
		Game.Settings = settings;
	}

	public static Map<String, Planet> getPlanets() {
		return Planets;
	}

	public static void setPlanets(Map<String, Planet> planets) {
		Game.Planets = planets;
	}

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
