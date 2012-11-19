package app.view;

import app.model.Player.Player;
import app.model.Ship;
import app.model.ShipModel;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA. User: mark.mcdonald Date: 10/29/12 Time: 2:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlayerInformationSidePanel extends JPanel {
	public PlayerInformationSidePanel(Player player) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		Ship ship = player.getShip();
		ShipModel shipType = ship.getType();
		int money = player.getMoney();

		JLabel nameLabel = new JLabel(player.getName());
		JLabel shipLabel = new JLabel(shipType.toString());
		JLabel moneyLabel = new JLabel("$" + Integer.toString(money));
		JLabel cargoLabel = new JLabel("Cargo: "
				+ player.getInventory().getSpaceUsed() + "/"
				+ player.getShip().getCargoSize());
		JLabel fuelLabel = new JLabel("Fuel: "
				+ Integer.toString(player.getFuel()) + "/"
				+ player.getShip().getMaxFuel());
		JLabel planetLabel = new JLabel("On "
				+ player.getCurrentPlanet().getName());

		add(nameLabel);
		add(shipLabel);
		add(moneyLabel);
		add(cargoLabel);
		add(fuelLabel);
		add(planetLabel);
	}

}
