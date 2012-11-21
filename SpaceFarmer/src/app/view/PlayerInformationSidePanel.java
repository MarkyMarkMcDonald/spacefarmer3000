/* This file holds the PlayerInformationSidePanel class,
 * which represents the SidePanel holding Player
 * information.
 */
package app.view;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.model.Ship;
import app.model.ShipModel;
import app.model.player.Player;

/**
 * Created with IntelliJ IDEA. User: mark.mcdonald Date: 10/29/12 Time: 2:21 PM
 * To change this template use File | Settings | File Templates.
 * @author Mark
 * @version 1.0
 */
public class PlayerInformationSidePanel extends JPanel {
	
	/**
	 * Creates a PlayerInformationSidePanel from a Player.
	 * @param player Player with which to create the panel.
	 */
	public PlayerInformationSidePanel(Player player) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		final Ship ship = player.getShip();
		final ShipModel shipType = ship.getType();
		final int money = player.getMoney();

		final JLabel nameLabel = new JLabel(player.getName());
		final JLabel shipLabel = new JLabel(shipType.toString());
		final JLabel moneyLabel = new JLabel("$" + Integer.toString(money));
		final JLabel cargoLabel = new JLabel("Cargo: "
				+ player.getInventory().getSpaceUsed() + "/"
				+ player.getShip().getCargoSize());
		final JLabel fuelLabel = new JLabel("Fuel: "
				+ Integer.toString(player.getFuel()) + "/"
				+ player.getShip().getMaxFuel());
		final JLabel planetLabel = new JLabel("On "
				+ player.getCurrentPlanet().getName());

		add(nameLabel);
		add(shipLabel);
		add(moneyLabel);
		add(cargoLabel);
		add(fuelLabel);
		add(planetLabel);
	}

}
