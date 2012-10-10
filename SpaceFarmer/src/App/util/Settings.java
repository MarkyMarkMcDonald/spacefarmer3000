package App.util;

import java.util.Collection;
import App.model.Player;

/**
 * This class is used to save/load the game and hold
 * the information for the game
 *
 * Mykal Thomas
 * Settings
 * 10/7/2012
 *
 **/
public class Settings {
	int difficulty;
	int currentTurn;
	int numPlayers;
	String saveLocation;

    /**
	 * this is the constructor for the game.
	 * @param save is the string value of the location of the game file
	 * @param diff is the difficulty of the game
	 **/
	Settings(String save, int diff) {
		difficulty = diff;
		currentTurn = 0;
		numPlayers = 0;
		saveLocation = null;
	}
	/**
	 * getter for the game difficulty
	 * @return the games difficulty
	 **/
	private int getDiff() {
		return difficulty;
	}
	/**
	 * setter for the game difficulty
	 * it throws a Index out of bounds error if num is outside 1-3
	 * @param num is the games new difficulty
	 **/
	private void setDiff(int num) {
		if (num>3 | num<1) {
			throw new IndexOutOfBoundsException();
		}
		else {
			difficulty = num;
		}
	}
	/**
	 * gets the current Turn of the game
	 * @return the game's current turn
	 **/
	private int getCurTurn() {
		return currentTurn;
	}
	/**
	 * sets the current turn to num
	 * @param num is the new turn number
	 **/
	private void setCurTurn(int num) {
		currentTurn = num;
	}
	/**
	 * returns the number of players in the game
	 * @return the number of players (human/computer)
	 **/
	private int getPlayers() {
		return numPlayers;
	}
	/**
	 * sets the number of players
	 * @param num is the number of current players
	 **/
	private void setPlayers(int num) {
		numPlayers = num;
	}
	/**
	 * gets the current save location of the game
	 * @return the saveLocation of the game
	 **/
	private String getSave() {
		return saveLocation;
	}
	/**
	 * changes the game save location
	 * @param save is the new location that the game will be saved to
	 **/
	private void setSave(String save) {
		saveLocation = save;
	}
	/**
	 *loads the game based on the file at the save location
	 * @param save the location of the loaded file
	 * @return boolean based if the save is successful
	 **/
	private boolean Load(String save) {
		// TODO implement
		return false;
	}
	/**
	 * loads the game based on the file at the default save location
	 * @return boolean based if the save is successful
	 **/
	private boolean Load() {
		// TODO implement
		return false;
	}
	/**
	 * saves the game to the default location
	 * @param players a collection that will be iterated through
	 **/
	private void Save(Collection<Player> players) {
		// TODO implement
	}
	/**
	 * saves the game to the new location
	 * @param save is the new save location.
	 * @param players a collection that will be iterated through
	 **/
	private void Save(Collection<Player> players, String save){
		// TODO implement
	}
}
