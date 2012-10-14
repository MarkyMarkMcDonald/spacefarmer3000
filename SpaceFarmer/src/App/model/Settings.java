package App.model;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * This class is used to save/load the game and hold the information for the
 * game
 * 
 * Mykal Thomas Settings 10/7/2012
 * 
 **/
public class Settings {
	private int difficulty;

	private List<Player> players;
	private String saveLocation;
	private int xDimension;
	private int yDimension;

	/**
	 * this is the constructor for the settings.
	 **/
	public Settings() {
		players = new ArrayList<Player>();
	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	// --Accessors and Modifiers

	/**
	 * getter for the game difficulty
	 * 
	 * @return the games difficulty
	 **/
	private int getDiff() {
		return difficulty;
	}

	/**
	 * setter for the game difficulty it throws a Index out of bounds error if
	 * num is outside 1-3
	 * 
	 * @param num
	 *            is the games new difficulty
	 **/
	private void setDiff(int num) {
		if (num > 3 | num < 1) {
			throw new IndexOutOfBoundsException();
		} else {
			difficulty = num;
		}
	}



	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}



	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public int getxDimension() {
		return xDimension;
	}

	public void setxDimension(int xDimension) {
		this.xDimension = xDimension;
	}

	public int getyDimension() {
		return yDimension;
	}

	public void setyDimension(int yDimension) {
		this.yDimension = yDimension;
	}

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
