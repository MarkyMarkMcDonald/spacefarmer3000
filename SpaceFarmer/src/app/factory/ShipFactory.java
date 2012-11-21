// $codepro.audit.disable lossOfPrecisionInCast, numericLiterals
/* This file holds the ShipFactory class, 
 * used to create ships from enumerated ShipModels. */
package app.factory;

import app.model.Ship;
import app.model.ShipModel;
import conf.GameVariables;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA. User: marky Date: 10/7/12 Time: 4:17 PM To change
 * this template use File | Settings | File Templates.
 * 
 * @author Mark
 * @version 1.0
 */
public class ShipFactory {

	/**
	 * Map of the enumerated ShipModels to their corresponding Ships.
	 */
	private static Map<ShipModel, Ship> Ships = null;

	/**
	 * Returns a ship based on the Enum ShipModel. This will only instantiate a
	 * new ship if it does not exist yet
	 * 
	 * @param shipModel
	 *            determines the stats of the ship to create or retrieve
	 * @return the created or retrieved ship
	 */
	public static Ship getShip(ShipModel shipModel) {
		if (Ships == null) {
			Ships = new HashMap<ShipModel, Ship>(ShipModel.values().length);
		}
		// Check to see if we need to create a new ship
		if (!Ships.containsKey(shipModel)) {
			final Ship ship = new Ship();

			// Assign the stats based on the kind of ship. This information
			// should probably exist in the config files instead of hard coded
			switch (shipModel) {
			case GNAT:
				ship.setType(ShipModel.GNAT);
				ship.setCargoSize(15);
				ship.setHealth(100);
				ship.setPower(1);
				ship.setDefense(0);
				ship.setSpeed(14);
				ship.setMaxFuel((int) (GameVariables.LARGEST_FUEL_TANK * .6));
				break;
			case FIREFLY:
				ship.setType(ShipModel.FIREFLY);
				ship.setCargoSize(20);
				ship.setHealth(100);
				ship.setPower(1);
				ship.setDefense(1);
				ship.setSpeed(17);
				ship.setMaxFuel((int) (GameVariables.LARGEST_FUEL_TANK * .75));
				break;
			case MOSQUITO:
				ship.setType(ShipModel.MOSQUITO);
				ship.setCargoSize(15);
				ship.setHealth(100);
				ship.setPower(2);
				ship.setDefense(1);
				ship.setSpeed(13);
				ship.setMaxFuel(GameVariables.LARGEST_FUEL_TANK);
				break;
			case BUMBLEBEE:
				ship.setType(ShipModel.BUMBLEBEE);
				ship.setCargoSize(25);
				ship.setHealth(100);
				ship.setPower(1);
				ship.setDefense(2);
				ship.setSpeed(15);
				ship.setMaxFuel((int) (GameVariables.LARGEST_FUEL_TANK * 1.5));
				break;
			default:
				ship.setType(ShipModel.GNAT);
				ship.setCargoSize(15);
				ship.setHealth(100);
				ship.setPower(1);
				ship.setDefense(0);
				ship.setSpeed(14);
				ship.setMaxFuel((int) (GameVariables.LARGEST_FUEL_TANK * .6));
				break;
			}
			Ships.put(ship.getType(), ship);
			return ship;
		} else {
			return Ships.get(shipModel);
		}
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "ShipFactory";
	}
}
