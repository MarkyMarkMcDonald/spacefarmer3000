// $codepro.audit.disable lossOfPrecisionInCast
package conf;

/**
 * User: marky
 * Date: 10/14/12
 * Time: 2:24 PM
 * @author Mark
 * @version 1.0
 */
public class GameVariables {
	
	/**
	 * Number of columns in the Universe.
	 */
    public static final int UNIVERSE_COLUMNS = 3;
    
    public static final int UNIVERSE_ROWS = 3;
    
    public static final int SYSTEM_ROWS = 3;
    
    public static final int SYSTEM_COLUMNS = 3;
    
    public static final int QUADRANT_X_DIMENSION = 50;
    
    public static final int QUADRANT_Y_DIMENSION = 50;
    
    public static final int MAX_DISTANCE = (int) Math.sqrt(Math.pow(QUADRANT_X_DIMENSION *
    		UNIVERSE_COLUMNS, 2) + Math.pow(QUADRANT_Y_DIMENSION * UNIVERSE_ROWS, 2));

    public static final int LARGEST_FUEL_TANK = MAX_DISTANCE;
    
    public static final int NUM_PLANETS = 30;
    
    public static final int NUM_PLANETARY_SYSTEMS = 12;
    
    public static final int PLANETARY_SYSTEM_ROWS = 3;
    
    public static final int PLANETARY_SYSTEM_COLUMNS = 3;
    
    public static final int PLAYER_STARTING_MONEY = 100000;
    
    public static final int MINIMUM_SYSTEM_DISTANCE = 5;
    
	public static final double RANDOM_EVENT_CHANCE = 0.5;
	
	public static final int MAX_SKILL_POINTS = 16;
	
    
    public static int getUniverseWidth() {
    	return UNIVERSE_COLUMNS * QUADRANT_X_DIMENSION;
    }
    
    public static int getUniverseHeight() {
    	return UNIVERSE_ROWS * QUADRANT_Y_DIMENSION;
    }
    
    /**
     * @return Information about this object as a String.
     */
    public String toString() {
    	return "GameVariables";
    }
}
