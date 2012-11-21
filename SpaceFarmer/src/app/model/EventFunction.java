/*This file holds the interface EventFunction, responsible for
 * holding a function that takes in a Player and spits out a String message.
 */
package app.model;

import app.model.player.Player;

/**
 * This interface requires a method that takes in a Player. The methods acts as
 * a random event and alters the player.
 * 
 * @author Bobbey
 * @version 1.0
 */
public interface EventFunction {

	/**
	 * Gives a Player a randomEvent.
	 * 
	 * @param player
	 *            Player to give the event to.
	 * @return String explaining what happened to the Player.
	 */
	String function(Player player);

	
	
}
