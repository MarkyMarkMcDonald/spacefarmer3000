package App.view;

import App.listener.ContinueListener;

import javax.swing.*;
import java.awt.Component;
import java.awt.Font;

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
		
		JLabel lblThisIsA = new JLabel("This is a temporary screen.");
		lblThisIsA.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThisIsA.setAlignmentY(0.0f);
		lblThisIsA.setAlignmentX(0.5f);
		add(lblThisIsA);
		
		JLabel lblItWillBe = new JLabel("It will be removed after M5.");
		lblItWillBe.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblItWillBe.setAlignmentY(0.0f);
		lblItWillBe.setAlignmentX(0.5f);
		add(lblItWillBe);

        JButton makeAnotherPlayer = new JButton("Add Player");
        ContinueListener continueToPlayerCreationListener = new ContinueListener(CardName.PLAYER_INFORMATION_CARD.toString());
        //todo: move back to createPlayer

	}

}
