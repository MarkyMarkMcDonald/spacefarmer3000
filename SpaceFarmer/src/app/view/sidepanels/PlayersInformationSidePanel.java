package app.view.sidepanels;

import app.listener.ContinueListener;
import app.model.Game;
import app.model.player.Player;
import app.view.CardName;
import app.view.PlayerInformationSidePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * Created with IntelliJ IDEA. User: mark.mcdonald Date: 10/29/12 Time: 2:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlayersInformationSidePanel extends JPanel {

	private JPanel items;

	public PlayersInformationSidePanel(List<Player> players) {
		JButton dbButton = new JButton("Save and Load");
		ContinueListener saveAndLoadListener = new ContinueListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardToMoveTo = CardName.SAVING_AND_LOADING_CARD;
				progressDisplay();
			}
		};
		dbButton.addActionListener(saveAndLoadListener);
		add(dbButton);

		items = new JPanel();
		items.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
		if (players != null) {
			for (Player player : players) {
				PlayerInformationSidePanel playerInformationSidePanel = 
						new PlayerInformationSidePanel(
						player);
				items.add(playerInformationSidePanel);
			}
		}
		add(items);
	}

	public void updateBasedOnAllPlayers() {
		items.removeAll();
		List<Player> players = Game.getPlayers();
		for (Player player : players) {
			PlayerInformationSidePanel playerInformationSidePanel = 
					new PlayerInformationSidePanel(player);
			items.add(playerInformationSidePanel);
		}
	}
}
