package App.listener;

import App.view.CardName;
import App.view.Display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The purpose of this class is to function as a generic screen advancement
 * listener. This will be used for "continue" buttons that lack complex logic
 * 
 * @author Andrew Wilder
 */
abstract public class ContinueListener implements ActionListener {

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