package App.factory;

import App.model.Ship;
import App.model.ShipModel;
import Conf.GameVariables;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: marky
 * Date: 10/7/12
 * Time: 4:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShipFactory {

    static private Map<ShipModel, Ship> ships;


    /**
     * Returns a ship based on the Enum ShipModel.
     * This will only instantiate a new ship if it does not exist yet
     * @param shipModel determines the stats of the ship to create or retrieve
     * @return the created or retrieved ship
     */
    static public Ship getShip(ShipModel shipModel){
        if (ships == null){
            ships = new HashMap<ShipModel, Ship>(4);
        }
        // Check to see if we need to create a new ship
        if ( !ships.containsKey(shipModel) ){
            Ship ship = new Ship();

            // Assign the stats based on the kind of ship. This information should probably exist in the config files instead of hard coded
            switch (shipModel)
            {
                case GNAT:
                    ship.setType(ShipModel.GNAT);
                    ship.setCargoSize(15);
                    ship.setHealth(100);
                    ship.setPower(1);
                    ship.setDefense(0);
                    ship.setSpeed(14);
                    ship.setMaxFuel((int) (GameVariables.largestFuelTank * .4));
                    break;
                case FIREFLY:
                    ship.setType(ShipModel.FIREFLY);
                    ship.setCargoSize(20);
                    ship.setHealth(100);
                    ship.setPower(1);
                    ship.setDefense(1);
                    ship.setSpeed(17);
                    ship.setMaxFuel((int) (GameVariables.largestFuelTank * .55));
                    break;
                case MOSQUITO:
                    ship.setType(ShipModel.MOSQUITO);
                    ship.setCargoSize(15);
                    ship.setHealth(100);
                    ship.setPower(2);
                    ship.setDefense(1);
                    ship.setSpeed(13);
                    ship.setMaxFuel((int) (GameVariables.largestFuelTank * .7));
                    break;
                case BUMBLEBEE:
                    ship.setType(ShipModel.BUMBLEBEE);
                    ship.setCargoSize(25);
                    ship.setHealth(100);
                    ship.setPower(1);
                    ship.setDefense(2);
                    ship.setSpeed(15);
                    ship.setMaxFuel(GameVariables.largestFuelTank);
                    break;
            }
            ships.put(ship.getType(),ship);
            return ship;
        }
        else {
            return ships.get(shipModel);
        }
    }
}
