package app.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.view.CardName;

/**
 * The purpose of this class is to function as a generic screen advancement
 * listener. This will be used for "continue" buttons that lack complex logic
 * 
 * @author Andrew Wilder
 */
public class BasicContinueListener extends ContinueListener implements
		ActionListener {
	/**
	 * This is the constructor for the AdvanceListener class.
	 * 
	 * @param cardToMoveTo
	 *            The ID of the card to change the center panel to.
	 */
	public BasicContinueListener(CardName cardToMoveTo) {
		this.cardToMoveTo = cardToMoveTo;
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "BasicContinueListener";
	}
}