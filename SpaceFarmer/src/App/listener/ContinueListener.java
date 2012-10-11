package App.listener;

import App.view.Display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The purpose of this class is to function as a generic screen advancement listener. This will be used for "continue" buttons
 * that lack complex logic
 * @author Andrew Wilder
 */
public class ContinueListener implements ActionListener {

	private String cardToMoveTo;
	
	/**
	 * This is the constructor for the AdvanceListener class.
     * @param cardToMoveTo The ID of the card to change the center panel to.
     */
	public ContinueListener(String cardToMoveTo) {
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