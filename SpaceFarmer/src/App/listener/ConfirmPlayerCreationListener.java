package App.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import App.Util.Settings;
//import App.service.SettingService;
import App.model.Player;
import App.service.PlayerValidationService;
import App.util.Settings;
import App.view.CardName;
import App.view.Display;
import App.view.PlayerInformationScreen;

/**
 * This class is used as an ActionListener for the confirm button on
 * the create new player screen. Its purpose is to update the game settings with a new player.
 * @author ?????, Andrew Wilder
 */
public class ConfirmPlayerCreationListener implements ActionListener {

    //private Settings settings;
    private PlayerInformationScreen playerInformationScreen;

    public ConfirmPlayerCreationListener(PlayerInformationScreen playerInformationScreen){
        this.playerInformationScreen = playerInformationScreen;
    }

	public void actionPerformed(ActionEvent e)
	{
        Player player = new Player(playerInformationScreen.getTxtEnterPlayerNameData(), playerInformationScreen.getEnteredPilotSkill(),
                playerInformationScreen.getEnteredTraderSkill(), playerInformationScreen.getEnteredEngineerSkill(), playerInformationScreen.getEnteredFighterSkill());
        Settings settings = Display.getGame().getSettings();
        String message = PlayerValidationService.isValidPlayer(player, 16);
        if (message.equals("success")){
            settings.addPlayer(player);
            Display.changeCard(CardName.PLAYER_CREATED_CARD);
        }
        else {
            playerInformationScreen.setErrorMessage(message);
        }
    }

}
