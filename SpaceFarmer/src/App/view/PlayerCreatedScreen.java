package App.view;

import App.listener.BasicContinueListener;
import App.listener.StartGameListener;

import javax.swing.*;
import java.awt.Component;
import java.awt.Font;

/**
 * This screen confirms the creation of a player.
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
		lblYouCreatedA.setAlignmentY(Component.TOP_ALIGNMENT);
		lblYouCreatedA.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblYouCreatedA);

        JButton makeAnotherPlayer = new JButton("Add Another Player");
        BasicContinueListener continueToPlayerCreationListener = new BasicContinueListener(CardName.PLAYER_INFORMATION_CARD);
        makeAnotherPlayer.addActionListener(continueToPlayerCreationListener);
        add(makeAnotherPlayer);

        JButton startGame = new JButton("Start Game");
        StartGameListener startGameListener = new StartGameListener();
        startGame.addActionListener(startGameListener);
        add(startGame);
	}

}
