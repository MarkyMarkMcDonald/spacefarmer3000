package App.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import App.Util.Settings;
//import App.service.SettingService;
import App.model.Player;
import App.service.PlayerValidationService;
import App.util.Settings;
import App.view.Display;
import App.view.PlayerInformation;

/**
 * This class is used as an ActionListener for the confirm button on
 * the create new player screen. Its purpose is to validate the stats
 * input by the user; if they are valid, advance to the next screen.
 * @author ?????, Andrew Wilder
 */
public class ConfirmListener implements ActionListener {

    //private Settings settings;
    private Display gameFrame;
    private PlayerInformation playerInformation;

    public ConfirmListener(Display gameFrame, PlayerInformation playerInformation){
        this.gameFrame = gameFrame;
        this.playerInformation = playerInformation;
    }

	public void actionPerformed(ActionEvent e)
	{
        Player player = new Player(playerInformation.getTxtEnterPlayerNameData(),playerInformation.getEnteredPilotSkill(),
                playerInformation.getEnteredTraderSkill(), playerInformation.getEnteredEngineerSkill(),playerInformation.getEnteredFighterSkill());
        Settings settings = gameFrame.getGame().getSettings();
        String message = PlayerValidationService.isValidPlayer(player, 16);
        if (message.equals("success")){
		    gameFrame.changeCard("TemporaryScreenCard");
        }
        else {
            playerInformation.setErrorMessage(message);
        }
    }

}
