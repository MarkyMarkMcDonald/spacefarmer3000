/*This file holds the EndTurnListener class*/
package app.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.model.Game;

/**
 * This class listens for the end of a turn.
 * 
 * @author Bobbey
 * @version 1.0
 * 
 */
public class EndTurnListener implements ActionListener {

	/**
	 * Game for which the ActionListener listens.
	 */
	private final Game game;

	/**
	 * Set up this EndTurnListener object.
	 * 
	 * @param game
	 *            A link to the global game data to use in this EndTurnListener.
	 */
	public EndTurnListener(Game game) {
		this.game = game;
	}

	/**
	 * End the turn for this player.
	 * 
	 * @param event
	 *            The instance of actionEvent associated with this event.
	 */
	public void actionPerformed(ActionEvent event) {
		game.endTurn();
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "EndTurnListener";
	}
}
