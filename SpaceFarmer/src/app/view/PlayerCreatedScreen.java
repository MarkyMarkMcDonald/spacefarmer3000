package App.view;

import App.listener.StartGameListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This screen confirms the creation of a player.
 * 
 * @author Mark McDonald, Andrew Wilder
 */
public class PlayerCreatedScreen extends Screen {

	/**
	 * Prevents "serializable" warning
	 */
	private static final long serialVersionUID = -2641343039012994267L;

	/**
	 * Create the panel.
	 */
	public PlayerCreatedScreen() {
		name = CardName.PLAYER_CREATED_CARD;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JLabel lblYouCreatedA = new JLabel("You created a player!");
		lblYouCreatedA.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblYouCreatedA.setAlignmentY(Component.CENTER_ALIGNMENT);
		lblYouCreatedA.setAlignmentX(Component.CENTER_ALIGNMENT);

		JButton makeAnotherPlayer = new JButton("Add Another Player");
		ActionListener continueToPlayerCreationListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				PlayerInformationScreen playerInformationScreen = 
						(PlayerInformationScreen) Display
						.getCard(CardName.PLAYER_INFORMATION_CARD.toString());
				playerInformationScreen.resetInputs();
				Display.changeCard(CardName.PLAYER_INFORMATION_CARD);
			}
		};
		makeAnotherPlayer.addActionListener(continueToPlayerCreationListener);
		makeAnotherPlayer.setAlignmentY(Component.CENTER_ALIGNMENT);
		makeAnotherPlayer.setAlignmentX(Component.CENTER_ALIGNMENT);

		JButton startGame = new JButton("Start Game");
		StartGameListener startGameListener = new StartGameListener();
		startGame.addActionListener(startGameListener);
		startGame.setAlignmentY(Component.CENTER_ALIGNMENT);
		startGame.setAlignmentX(Component.CENTER_ALIGNMENT);

		Component topGlue = Box.createVerticalGlue();
		Component botGlue = Box.createVerticalGlue();

		add(topGlue);
		add(lblYouCreatedA);
		add(makeAnotherPlayer);
		add(startGame);
		add(botGlue);
	}

}
