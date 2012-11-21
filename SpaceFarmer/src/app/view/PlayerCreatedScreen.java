/* This file holds the PlayerCreatedScreen class, which
 * represents a screen where a Player is created.
 */
package app.view;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

import app.listener.StartGameListener;

/**
 * This screen confirms the creation of a player.
 * 
 * @author Mark McDonald, Andrew Wilder
 * @version 1.0;
 */
public class PlayerCreatedScreen extends Screen {

	/**
	 * Font size.
	 */
	private static final int FONT_SIZE = 20;
	
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

		final JLabel lblYouCreatedA = new JLabel("You created a player!");
		lblYouCreatedA.setFont(new Font("Tahoma", Font.BOLD, FONT_SIZE));
		lblYouCreatedA.setAlignmentY(Component.CENTER_ALIGNMENT);
		lblYouCreatedA.setAlignmentX(Component.CENTER_ALIGNMENT);

		final JButton makeAnotherPlayer = new JButton("Add Another Player");
		final ActionListener continueToPlayerCreationListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				final PlayerInformationScreen playerInformationScreen = 
						(PlayerInformationScreen) Display
						.getCard(CardName.PLAYER_INFORMATION_CARD.toString());
				playerInformationScreen.resetInputs();
				Display.changeCard(CardName.PLAYER_INFORMATION_CARD);
			}
		};
		makeAnotherPlayer.addActionListener(continueToPlayerCreationListener);
		makeAnotherPlayer.setAlignmentY(Component.CENTER_ALIGNMENT);
		makeAnotherPlayer.setAlignmentX(Component.CENTER_ALIGNMENT);

		final JButton startGame = new JButton("Start Game");
		final StartGameListener startGameListener = new StartGameListener();
		startGame.addActionListener(startGameListener);
		startGame.setAlignmentY(Component.CENTER_ALIGNMENT);
		startGame.setAlignmentX(Component.CENTER_ALIGNMENT);

		final Component topGlue = Box.createVerticalGlue();
		final Component botGlue = Box.createVerticalGlue();

		add(topGlue);
		add(lblYouCreatedA);
		add(makeAnotherPlayer);
		add(startGame);
		add(botGlue);
	}

}
