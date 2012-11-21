/*This file holds the StartGameListener class*/
package app.listener;

import app.logging.Logger;
import app.model.Game;
import app.model.player.Player;
import app.service.Randomizer;
import app.view.CardName;
import app.view.Display;
import app.view.StartOfTurnScreen;

import java.awt.event.ActionEvent;
import java.util.List;

/**
 * User: marky Date: 10/13/12 Time: 6:48 PM
 * 
 * @author Mark
 * @version 1.0
 */
public class StartGameListener extends ContinueListener {

	/**
	 * Set up this StartGameListener object with a screen to advance to.
	 */
	public StartGameListener() {
		cardToMoveTo = CardName.START_OF_TURN_CARD;
	}

	/**
	 * Advance to starting the game after player creation.
	 * 
	 * @param e
	 *            The instance of ActionEvent associated wiith this invocation.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		// Make player1 have the first turn
		final List<Player> players = Game.getPlayers();
		final Player player1 = players.get(0);
		Game.setCurrentPlayer(player1);

		// Make each player start on a random Planet
		for (Player player : players) {
			player.setCurrentPlanet(Randomizer.getRandomPlanet());
		}

		// We'll start on turn 1 of round 1
		Game.setNumberOfTurns(1);

		// update the turn Screen
		final StartOfTurnScreen startOfTurnScreen = (StartOfTurnScreen) Display
				.getCard(CardName.START_OF_TURN_CARD.toString());
		startOfTurnScreen.updateTurn();

		this.progressDisplay();
		Logger.printGameToConsole();
	}

	/**
	 * @return Information about this object as a String.
	 */
	@Override
	public String toString() {
		return "StartGameListener";
	}
}
