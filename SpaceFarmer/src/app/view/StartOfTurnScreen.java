package app.view;

import app.listener.ContinueListener;
import app.model.Game;
import app.model.Universe.Planet;
import app.model.Player.Player;
import app.view.SidePanels.PlayersInformationSidePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created with IntelliJ IDEA. User: mark.mcdonald Date: 10/31/12 Time: 11:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class StartOfTurnScreen extends Screen {

	private JLabel turnInfo;

	private JLabel title;

	private final String[] turnInfoStaticText = new String[] { "Turn ",
			" of Round " };

	private final String[] titleStaticText = new String[] { "It is now ",
			"'s turn." };

	public StartOfTurnScreen() {
		name = CardName.START_OF_TURN_CARD;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		Component glue1 = Box.createVerticalGlue();
		Component glue2 = Box.createVerticalGlue();
		title = new JLabel();
		turnInfo = new JLabel();

		title.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		title.setAlignmentY(JLabel.CENTER_ALIGNMENT);
		turnInfo.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		turnInfo.setAlignmentY(JLabel.CENTER_ALIGNMENT);

		add(glue1);
		add(title);
		add(turnInfo);

		JButton start = new JButton("Start");
		start.setAlignmentX(JButton.CENTER_ALIGNMENT);
		start.setAlignmentY(JButton.CENTER_ALIGNMENT);
		ContinueListener continueListener = new ContinueListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardToMoveTo = CardName.PLANET_INFORMATION_CARD;

				// update the planet info screen to be based on the current
				// player's planet
				Player currentPlayerPlayer = Game.getCurrentPlayer();
				Planet currentPlanet = currentPlayerPlayer.getCurrentPlanet();
				PlanetInformationScreen planetInformationScreen = 
					(PlanetInformationScreen) Display.getCard(cardToMoveTo.toString());
				planetInformationScreen.update(currentPlanet);

				progressDisplay();

				// enable the navigation panel
				JPanel navPanel = Display.getSidePanel("Left");
				navPanel.setVisible(true);

				PlayersInformationSidePanel playersInfoPanel = 
						(PlayersInformationSidePanel) Display.getSidePanel("Bot");
				playersInfoPanel.updateBasedOnAllPlayers();
				playersInfoPanel.setVisible(true);
			}

		};
		start.addActionListener(continueListener);
		add(start);

		add(glue2);
	}

	public void updateTurn() {
		turnInfo.setText(turnInfoStaticText[0] + Game.getTurnInRound()
				+ turnInfoStaticText[1] + Game.getRoundNumber());
		Player player = Game.getCurrentPlayer();
		String currentPlayerName = player.getName();
		title.setText(titleStaticText[0] + currentPlayerName
				+ titleStaticText[1]);
	}
}
