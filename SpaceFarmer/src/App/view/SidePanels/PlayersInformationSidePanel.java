package App.view.SidePanels;

import App.model.Game;
import App.model.Player.Player;
import App.view.PlayerInformationSidePanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mark.mcdonald
 * Date: 10/29/12
 * Time: 2:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlayersInformationSidePanel extends JPanel{

    private JPanel items;

    public PlayersInformationSidePanel(List<Player> players){
        items = new JPanel();
        items.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
        if (players != null) {
            for (Player player : players){
                PlayerInformationSidePanel playerInformationSidePanel = new PlayerInformationSidePanel(player);
                items.add(playerInformationSidePanel);
            }
        }
        add(items);
    }

    public void updateBasedOnAllPlayers(){
        items.removeAll();
        List<Player> players = Game.getPlayers();
        for (Player player : players){
            PlayerInformationSidePanel playerInformationSidePanel = new PlayerInformationSidePanel(player);
            items.add(playerInformationSidePanel);
        }
    }
}
