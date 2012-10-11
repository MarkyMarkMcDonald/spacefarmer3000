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

	private Display gameFrame;
	private String cardID;
	
	/**
	 * This is the constructor for the AdvanceListener class.
	 * @param gameFrame A link to the instance of Display, used for changing its center panel.
	 * @param cardID The ID of the card to change the center panel to.
	 */
	public ContinueListener(Display gameFrame, String cardID) {
		this.gameFrame = gameFrame;
		this.cardID = cardID;
	}
	
	/**
	 * Advance the center panel to a different card.
	 * @param e The instance of Event containing the invocation details.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		gameFrame.changeCard(cardID);
	}
}