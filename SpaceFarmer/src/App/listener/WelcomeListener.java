package App.listener;

import App.view.Display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The purpose of this ActionListener is to advance from the title screen to the screen
 * where the player enters their information.
 * @author ?????, Andrew Wilder
 */
public class WelcomeListener implements ActionListener {
	
	private Display gameFrame;
	
	/**
	 * This is the constructor for the WelcomeListener class.
	 * @param gameFrame A link to the instance of Display used for changing the center panel's card.
	 */
	public WelcomeListener(Display gameFrame) {
		this.gameFrame = gameFrame;
	}
	
	/**
	 * Change the center panel's card to the input player information card.
	 * @param e The instance of Event containing the invocation details.
	 */
	public void actionPerformed(ActionEvent e)
	{
	    gameFrame.changeCard("PlayerInformationCard");
	}
}

	
