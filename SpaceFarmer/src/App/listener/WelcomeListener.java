package App.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import App.view.Display;

public class WelcomeListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e)
	  {
	    Display.moveToPlayerInfo();
	  }
	
}

	
