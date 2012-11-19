package app.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.model.Game;

public class EndTurnListener implements ActionListener {

	private Game game;

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
