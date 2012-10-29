package App.view;

import App.model.Player;
import App.model.Ship;
import App.model.ShipModel;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: mark.mcdonald
 * Date: 10/29/12
 * Time: 2:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlayerInformationPanel extends JPanel{
    public PlayerInformationPanel(Player player){
        Ship ship = player.getShip();
        ShipModel shipType = ship.getType();
        int money = player.getMoney();

        JLabel nameLabel = new JLabel(player.getName());
        JLabel shipLabel = new JLabel(shipType.toString());
        JLabel moneyLabel = new JLabel(Integer.toString(money));

        add(nameLabel);
        add(shipLabel);
        add(moneyLabel);
    }

}
