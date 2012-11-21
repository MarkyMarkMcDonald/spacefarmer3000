/*This file holds the ContinueListener class*/
package app.listener;

import app.view.CardName;
import app.view.Display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The purpose of this class is to function as a generic screen advancement
 * listener. This will be used for "continue" buttons that lack complex logic
 * 
 * @author Andrew Wilder
 * @version 1.0
 */
public abstract class ContinueListener implements ActionListener {

	/**
	 * Card that the game will progress to.
	 */
	protected CardName cardToMoveTo;

	/**
	 * Advance the center panel to a different card.
	 * 
	 * @param e
	 *            The instance of Event containing the invocation details.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Display.changeCard(cardToMoveTo);
	}

	/**
	 * Progress to the next card in a state machine sequence.
	 */
	public void progressDisplay() {
		Display.changeCard(cardToMoveTo);
	}
}