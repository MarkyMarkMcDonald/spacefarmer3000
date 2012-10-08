package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import App.Util.Settings;
import App.service.SettingService;
import App.view.Display;


public class ConfirmListener implements ActionListener {

    private Settings settings;

    public ConfirmListener(Settings settings){
        this.settings = settings;
    }

	public void actionPerformed(ActionEvent e)
	{
	    if(SettingService.checkValid(settings))
        {
		    Display.moveToTemporaryScreen();
	    }
    }

}
