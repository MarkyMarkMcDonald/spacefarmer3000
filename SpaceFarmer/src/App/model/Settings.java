package App.model;


import App.model.Player.Player;

import java.util.Collection;


/**
 * This class is used to save/load the game and hold the information for the
 * game
 * 
 * Mykal Thomas Settings 10/7/2012
 * 
 **/
public class Settings {

	private String saveLocation;

	/**
	 * this is the constructor for the settings.
	 **/
	public Settings() {
		// stub
	}

	public void addPlayer(Player player) {
		// stub
	}

	// --Accessors and Modifiers
	/**
	 * gets the current save location of the game
	 * 
	 * @return the saveLocation of the game
	 **/
	private String getSave() {
		return saveLocation;
	}

	/**
	 * changes the game save location
	 * 
	 * @param save
	 *            is the new location that the game will be saved to
	 **/
	//TODO create helper functions to individualy write / load
	private void setSave(String save) {
		saveLocation = save;
	}

	/**
	 * loads the game based on the file at the save location
	 * 
	 * @param save
	 *            the location of the loaded file
	 * @return boolean based if the save is successful
	 **/
	private boolean Load(String save) {
		// TODO implement
		return false;
	}

	/**
	 * loads the game based on the file at the default save location
	 * 
	 * @return boolean based if the save is successful
	 **/
	private boolean Load() {
		// TODO implement
		return false;
	}

	/**
	 * saves the game to the default location
	 * 
	 * @param players
	 *            a collection that will be iterated through
	 **/
	private void Save(Collection<Player> players) {
		// TODO implement
	}

	/**
	 * saves the game to the new location
	 * 
	 * @param save
	 *            is the new save location.
	 * @param players
	 *            a collection that will be iterated through
	 **/
	private void Save(Collection<Player> players, String save) {
		// TODO implement
	}
}
