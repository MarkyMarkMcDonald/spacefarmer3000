package App.view;

import App.listener.BasicContinueListener;

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
 */
public class WelcomeScreen extends Screen {

	/**
	 * Prevents "serializable" warning
	 */
	private static final long serialVersionUID = -4701770682971357648L;

	public WelcomeScreen() {
		name = CardName.WELCOME_CARD;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		Component titleStrut1 = Box.createVerticalStrut(40);
		add(titleStrut1);

		JLabel welcomeLabel1 = new JLabel("Space");
		welcomeLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
		welcomeLabel1.setAlignmentY(0.0f);
		welcomeLabel1.setFont(new Font("Tahoma", Font.BOLD, 40));
		add(welcomeLabel1);

		Component titleStrut2 = Box.createVerticalStrut(40);
		add(titleStrut2);

		JLabel welcomeLabel2 = new JLabel("Farmer");
		welcomeLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
		welcomeLabel2.setAlignmentY(0.0f);
		welcomeLabel2.setFont(new Font("Tahoma", Font.BOLD, 40));
		add(welcomeLabel2);

		Component titleStrut3 = Box.createVerticalStrut(40);
		add(titleStrut3);

		JLabel welcomeLabel3 = new JLabel("3000");
		welcomeLabel3.setAlignmentX(Component.CENTER_ALIGNMENT);
		welcomeLabel3.setAlignmentY(0.0f);
		welcomeLabel3.setFont(new Font("Tahoma", Font.BOLD, 40));
		add(welcomeLabel3);

		Component titleStrut4 = Box.createVerticalStrut(40);
		add(titleStrut4);

		JPanel welcomeButtonPanel = new JPanel();
		add(welcomeButtonPanel);

		JButton AboutButton = new JButton("About");
		AboutButton.setPreferredSize(new Dimension(120, 30));
		welcomeButtonPanel.add(AboutButton);

		Component buttonStrut1 = Box.createHorizontalStrut(50);
		welcomeButtonPanel.add(buttonStrut1);

		JButton newGameButton = new JButton("New Game");
		newGameButton.setPreferredSize(new Dimension(120, 30));
		newGameButton.addActionListener(new BasicContinueListener(
				CardName.PLAYER_INFORMATION_CARD));
		welcomeButtonPanel.add(newGameButton);

		Component buttonStrut2 = Box.createHorizontalStrut(50);
		welcomeButtonPanel.add(buttonStrut2);

		JButton loadGameButton = new JButton("Load Game");
		loadGameButton.setPreferredSize(new Dimension(120, 30));
		loadGameButton.addActionListener(new TEMP_LISTENER());
		welcomeButtonPanel.add(loadGameButton);
	}

	private class TEMP_LISTENER implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Display.playMiniGame();
		}

		/**
		 * @return Information about this object as a String.
		 */
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
