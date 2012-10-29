package App.view;

import App.model.Player;

import javax.swing.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mark.mcdonald
 * Date: 10/29/12
 * Time: 2:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlayersInformationPanel extends JPanel{

    private JPanel items;

    public PlayersInformationPanel(List<Player> players){
        items = new JPanel();

        for (Player player : players){
            PlayerInformationPanel playerInformationPanel = new PlayerInformationPanel(player);
            items.add(playerInformationPanel);
        }

        add(items);
    }
}
