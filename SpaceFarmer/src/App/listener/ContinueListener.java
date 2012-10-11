package App.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import App.view.CardName;
import App.view.Display;

/**
 * The purpose of this class is to function as a generic screen advancement listener. This will be used for "continue" buttons
 * that lack complex logic
 * @author Andrew Wilder
 */
public class ContinueListener implements ActionListener {

	private CardName cardToMoveTo;
	
	/**
	 * This is the constructor for the AdvanceListener class.
     * @param cardToMoveTo The ID of the card to change the center panel to.
     */
	public ContinueListener(CardName cardToMoveTo) {
		this.cardToMoveTo = cardToMoveTo;
	}
	
	/**
	 * Advance the center panel to a different card.
	 * @param e The instance of Event containing the invocation details.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Display.changeCard(cardToMoveTo);
	}
}