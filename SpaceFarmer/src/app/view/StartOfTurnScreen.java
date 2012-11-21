/* This file holds the StartOfTurnScreen class, which
 * represents the displayed Screen when a Player begins
 * his turn.
 */
package app.view;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.listener.ContinueListener;
import app.model.Game;
import app.model.player.Player;
import app.model.universe.Planet;
import app.view.sidepanels.PlayersInformationSidePanel;

/**
 * Created with IntelliJ IDEA. User: mark.mcdonald Date: 10/31/12 Time: 11:18 AM
 * To change this template use File | Settings | File Templates.
 * @author Mark
 * @version 1.0
 */
public class StartOfTurnScreen extends Screen {

	/**
	 * Label holding information about the turn.
	 */
	private final JLabel turnInfo;

	/**
	 * Label containing information about whose turn it is.
	 */
	private final JLabel title;

	/**
	 * Array containing parts of the turn info label's text that do not change.
	 */
	private final String[] turnInfoStaticText = new String[] { "Turn ",
			" of Round " };

	/**
	 * Array containing parts of the title label's text that do not change.
	 */
	private final String[] titleStaticText = new String[] { "It is now ",
			"'s turn." };

	/**
	 * Constructs a new StartOfTurnScreen.
	 */
	public StartOfTurnScreen() {
		name = CardName.START_OF_TURN_CARD;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		final Component glue1 = Box.createVerticalGlue();
		final Component glue2 = Box.createVerticalGlue();
		title = new JLabel();
		turnInfo = new JLabel();

		title.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		title.setAlignmentY(JLabel.CENTER_ALIGNMENT);
		turnInfo.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		turnInfo.setAlignmentY(JLabel.CENTER_ALIGNMENT);

		add(glue1);
		add(title);
		add(turnInfo);

		final JButton start = new JButton("Start");
		start.setAlignmentX(JButton.CENTER_ALIGNMENT);
		start.setAlignmentY(JButton.CENTER_ALIGNMENT);
		final ContinueListener continueListener = new ContinueListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardToMoveTo = CardName.PLANET_INFORMATION_CARD;

				// update the planet info screen to be based on the current
				// player's planet
				final Player currentPlayerPlayer = Game.getCurrentPlayer();
				final Planet currentPlanet = currentPlayerPlayer.getCurrentPlanet();
				final PlanetInformationScreen planetInformationScreen = 
					(PlanetInformationScreen) Display.getCard(cardToMoveTo.toString());
				planetInformationScreen.update(currentPlanet);

				progressDisplay();

				// enable the navigation panel
				final JPanel navPanel = Display.getSidePanel("Left");
				navPanel.setVisible(true);

				final PlayersInformationSidePanel playersInfoPanel = 
						(PlayersInformationSidePanel) Display.getSidePanel("Bot");
				playersInfoPanel.updateBasedOnAllPlayers();
				playersInfoPanel.setVisible(true);
			}

		};
		start.addActionListener(continueListener);
		add(start);

		add(glue2);
	}

	/**
	 * Updates the text on the labels.
	 */
	public void updateTurn() {
		turnInfo.setText(turnInfoStaticText[0] + Game.getTurnInRound()
				+ turnInfoStaticText[1] + Game.getRoundNumber());
		final Player player = Game.getCurrentPlayer();
		final String currentPlayerName = player.getName();
		title.setText(titleStaticText[0] + currentPlayerName
				+ titleStaticText[1]);
	}
}
