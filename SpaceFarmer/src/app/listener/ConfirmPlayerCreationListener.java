package app.listener;

import app.model.Game;
import app.model.Inventory;
import app.model.player.Player;
import app.service.PlayerValidationService;
import app.view.CardName;
import app.view.Display;
import app.view.PlayerInformationScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import app.Util.Settings;
//import app.service.SettingService;

/**
 * This class is used as an ActionListener for the confirm button on the create
 * new player screen. Its purpose is to update the game settings with a new
 * player.
 * 
 * @author ?????, Andrew Wilder
 */
public class ConfirmPlayerCreationListener implements ActionListener {

	// private Settings settings;
	private PlayerInformationScreen playerInformationScreen;

	/**
	 * Set up this ConfirmPlayerCreationListener.
	 * 
	 * @param playerInformationScreen
	 *            A reference to the screen this interacts with.
	 */
	public ConfirmPlayerCreationListener(
			PlayerInformationScreen playerInformationScreen) {
		this.playerInformationScreen = playerInformationScreen;
	}

	/**
	 * Finalize the creation of a player, or give an error message explaining
	 * why it failed.
	 * 
	 * @param e
	 *            The instance of actionEvent associated with this CPCL.
	 */
	public void actionPerformed(ActionEvent e) {
		Player player = new Player(
				playerInformationScreen.getTxtEnterPlayerNameData(),
				playerInformationScreen.getEnteredPilotSkill(),
				playerInformationScreen.getEnteredTraderSkill(),
				playerInformationScreen.getEnteredEngineerSkill(),
				playerInformationScreen.getEnteredFighterSkill());
		player.setInventory(new Inventory());
		Game game = Display.getGame();
		String message = PlayerValidationService.isValidPlayer(player, 16);
		if (message.equals("success")) {
			game.addPlayer(player);
			Display.changeCard(CardName.PLAYER_CREATED_CARD);
		} else {
			playerInformationScreen.setErrorMessage(message);
		}
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "ConfirmPlayerCreationListener";
	}
}
