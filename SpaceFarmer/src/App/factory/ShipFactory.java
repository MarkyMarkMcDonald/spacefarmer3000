package App.factory;

import App.model.Ship;
import App.model.ShipModel;

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

        // Check to see if we need to create a new ship
        if ( !ships.containsKey(shipModel) ){
            Ship ship = new Ship();

            // Assign the stats based on the kind of ship. This information should probably exist in the config files instead of hard coded
            switch (shipModel)
            {
                case GNAT:
                    ship.setName(ShipModel.GNAT);
                    ship.setCargoSize(15);
                    ship.setHealth(100);
                    ship.setPower(1);
                    ship.setDefense(0);
                    ship.setSpeed(14);
                    break;
                case FIREFLY:
                    ship.setName(ShipModel.FIREFLY);
                    ship.setCargoSize(20);
                    ship.setHealth(100);
                    ship.setPower(1);
                    ship.setDefense(1);
                    ship.setSpeed(17);
                    break;
                case MOSQUITO:
                    ship.setName(ShipModel.MOSQUITO);
                    ship.setCargoSize(15);
                    ship.setHealth(100);
                    ship.setPower(2);
                    ship.setDefense(1);
                    ship.setSpeed(13);
                    break;
                case BUMBLEBEE:
                    ship.setName(ShipModel.BUMBLEBEE);
                    ship.setCargoSize(25);
                    ship.setHealth(100);
                    ship.setPower(1);
                    ship.setDefense(2);
                    ship.setSpeed(15);
                    break;
            }
            ships.put(ship.getName(),ship);
            return ship;
        }
        else {
            return ships.get(shipModel);
        }
    }
}
