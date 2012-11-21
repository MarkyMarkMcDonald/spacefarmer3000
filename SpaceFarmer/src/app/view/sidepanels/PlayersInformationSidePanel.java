/*This files holds the PlayersInformationSidePanel class, which
 * represents a SidePanel holding player information.
 */
package app.view.sidepanels;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import app.listener.ContinueListener;
import app.model.Game;
import app.model.player.Player;
import app.view.CardName;
import app.view.PlayerInformationSidePanel;

/**
 * Created with IntelliJ IDEA. User: mark.mcdonald Date: 10/29/12 Time: 2:28 PM
 * To change this template use File | Settings | File Templates.
 * @author Mark
 * @version 1.0
 */
public class PlayersInformationSidePanel extends JPanel {

	/**
	 * The gap values for the flow layout for this panel.
	 */
	private static final int FLOW_HORIZONTAL_GAP = 20, FLOW_VERTICAL_GAP = 5;
	
	/**
	 * JPanel showing the items the players have.
	 */
	private final JPanel items;

	/**
	 * Creates a PlayersInformationSidePanel using the players in the game.
	 * @param players Players in the game.
	 */
	public PlayersInformationSidePanel(List<Player> players) {
		final JButton dbButton = new JButton("Save and Load");
		final ContinueListener saveAndLoadListener = new ContinueListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardToMoveTo = CardName.SAVING_AND_LOADING_CARD;
				progressDisplay();
			}
		};
		dbButton.addActionListener(saveAndLoadListener);
		add(dbButton);

		items = new JPanel();
		items.setLayout(new FlowLayout(
				FlowLayout.LEFT, FLOW_HORIZONTAL_GAP, FLOW_VERTICAL_GAP));
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

	/**
	 * Updates the panel based on the players in the game.
	 */
	public void updateBasedOnAllPlayers() {
		items.removeAll();
		final List<Player> players = Game.getPlayers();
		for (Player player : players) {
			PlayerInformationSidePanel playerInformationSidePanel = 
					new PlayerInformationSidePanel(player);
			items.add(playerInformationSidePanel);
		}
	}
}
