package App.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import App.view.Display;

public class WelcomeListener implements ActionListener {
	
	private Display gameFrame;
	
	public WelcomeListener(Display gameFrame) {
		this.gameFrame = gameFrame;
	}
	
	public void actionPerformed(ActionEvent e)
	{
	    gameFrame.changeCard("PlayerInformationCard");
	}
}

	
