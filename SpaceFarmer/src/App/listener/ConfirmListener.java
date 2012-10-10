package App.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import App.Util.Settings;
//import App.service.SettingService;
import App.view.Display;

/**
 * This class is used as an ActionListener for the confirm button on
 * the create new player screen. Its purpose is to validate the stats
 * input by the user; if they are valid, advance to the next screen.
 * @author ?????, Andrew Wilder
 */
public class ConfirmListener implements ActionListener {

    //private Settings settings;
    private Display gameFrame;

    public ConfirmListener(Display gameFrame/*, Settings settings*/){
        //this.settings = settings;
        this.gameFrame = gameFrame;
    }

    // NOTE: Does not validate inputs yet
	public void actionPerformed(ActionEvent e)
	{
/*	    if(SettingService.checkValid(settings))
        {*/
		    gameFrame.changeCard("TemporaryScreenCard");
	    //}
    }

}
