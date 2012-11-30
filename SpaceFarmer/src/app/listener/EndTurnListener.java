/*This file holds the EndTurnListener class*/
package app.listener;

import app.model.Game;
import app.view.CardName;
import app.view.Display;
import app.view.StartOfTurnScreen;

import java.awt.event.ActionEvent;

/**
 * This class listens for the end of a turn.
 * 
 * @author Bobbey
 * @version 1.0
 * 
 */
public class EndTurnListener extends ContinueListener {

    public EndTurnListener(){
        cardToMoveTo = CardName.START_OF_TURN_CARD;
    }

	/**
	 * End the turn for this player.
	 * 
	 * @param event
	 *            The instance of actionEvent associated with this event.
	 */
	public void actionPerformed(ActionEvent event) {
		Game.endTurn();
        StartOfTurnScreen startOfTurnScreen = (StartOfTurnScreen) Display.getCard(CardName.START_OF_TURN_CARD.toString());
        startOfTurnScreen.updateTurn();
        progressDisplay();
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "EndTurnListener";
	}
}
