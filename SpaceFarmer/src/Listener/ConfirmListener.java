package Listener;

import java.awt.event.ActionEvent;

import App.view.Display;


public class ConfirmListener {
	
	public void actionPerformed(ActionEvent e)
	{
	    if(SettingService.checkCorrect())
        {
		    Display.moveToTemporaryScreen();
	    }
    }

}
