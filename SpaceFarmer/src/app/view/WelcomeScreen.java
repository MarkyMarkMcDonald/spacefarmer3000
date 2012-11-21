/*This file holds the class WelcomeScreen, which represents
 * the displayed screen upon first opening the game.
 */
package app.view;

import app.listener.BasicContinueListener;

import java.awt.Component;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class represents the panel shown to users when loading SpaceFarmer 3000.
 * 
 * @author Mark McDaniel, Andrew Wilder
 * @version 1.0
 */
public class WelcomeScreen extends Screen {

	/**
	 * Vertical Strut Amount
	 */
	private static final int VERTICAL_STRUT_AMOUNT = 40;

	/**
	 * Horizontal Strut Amount
	 */
	private static final int HORIZONTAL_STRUT_AMOUNT = 50;

	/**
	 * Width of buttons.
	 */
	private static final int BUTTON_WIDTH = 120;

	/**
	 * Height of buttons.
	 */
	private static final int BUTTON_HEIGHT = 120;

	/**
	 * Font size.
	 */
	private static final int FONT_SIZE = 40;

	/**
	 * Prevents "serializable" warning
	 */
	private static final long serialVersionUID = -4701770682971357648L;

	/**
	 * This serves as the welcome screen for the program
	 */
	public WelcomeScreen() {
		name = CardName.WELCOME_CARD;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		final Component titleStrut1 = Box
				.createVerticalStrut(VERTICAL_STRUT_AMOUNT);
		add(titleStrut1);

		final JLabel welcomeLabel1 = new JLabel("Space");
		welcomeLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
		welcomeLabel1.setAlignmentY(0.0f);
		welcomeLabel1.setFont(new Font("Tahoma", Font.BOLD, FONT_SIZE));
		add(welcomeLabel1);

		final Component titleStrut2 = Box
				.createVerticalStrut(VERTICAL_STRUT_AMOUNT);
		add(titleStrut2);

		final JLabel welcomeLabel2 = new JLabel("Farmer");
		welcomeLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
		welcomeLabel2.setAlignmentY(0.0f);
		welcomeLabel2.setFont(new Font("Tahoma", Font.BOLD, FONT_SIZE));
		add(welcomeLabel2);

		final Component titleStrut3 = Box
				.createVerticalStrut(VERTICAL_STRUT_AMOUNT);
		add(titleStrut3);

		final JLabel welcomeLabel3 = new JLabel("3000");
		welcomeLabel3.setAlignmentX(Component.CENTER_ALIGNMENT);
		welcomeLabel3.setAlignmentY(0.0f);
		welcomeLabel3.setFont(new Font("Tahoma", Font.BOLD, FONT_SIZE));
		add(welcomeLabel3);

		final Component titleStrut4 = Box
				.createVerticalStrut(VERTICAL_STRUT_AMOUNT);
		add(titleStrut4);

		final JPanel welcomeButtonPanel = new JPanel();
		add(welcomeButtonPanel);

		final JButton aboutButton = new JButton("About");
		aboutButton
				.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		welcomeButtonPanel.add(aboutButton);

		final Component buttonStrut1 = Box
				.createHorizontalStrut(HORIZONTAL_STRUT_AMOUNT);
		welcomeButtonPanel.add(buttonStrut1);

		final JButton newGameButton = new JButton("New Game");
		newGameButton.setPreferredSize(new Dimension(BUTTON_WIDTH,
				BUTTON_HEIGHT));
		newGameButton.addActionListener(new BasicContinueListener(
				CardName.PLAYER_INFORMATION_CARD));
		welcomeButtonPanel.add(newGameButton);

		final Component buttonStrut2 = Box
				.createHorizontalStrut(HORIZONTAL_STRUT_AMOUNT);
		welcomeButtonPanel.add(buttonStrut2);

		final JButton loadGameButton = new JButton("Load Game");
		loadGameButton.setPreferredSize(new Dimension(BUTTON_WIDTH,
				BUTTON_HEIGHT));
		loadGameButton.addActionListener(new TEMP_LISTENER());
		welcomeButtonPanel.add(loadGameButton);
	}

	/**
	 * this listens for the buttons on the main screen
	 * 
	 * @author Mark
	 */
	private static class TEMP_LISTENER implements ActionListener {

		/**
		 * when a button is pressed
		 * 
		 * @param e
		 *            Unused
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			Display.playMiniGame();
		}

		/**
		 * @return Information about this object as a String.
		 */
		@Override
		public String toString() {
			return "TempListener";
		}
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "WelcomeScreen";
	}
}
