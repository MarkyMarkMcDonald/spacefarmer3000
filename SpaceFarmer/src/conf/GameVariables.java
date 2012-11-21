// $codepro.audit.disable lossOfPrecisionInCast
/*This file contains all of the game variables.*/
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
    
    /**
     * Number of rows in the Universe.
     */
    public static final int UNIVERSE_ROWS = 3;
    
    /**
     * Number of rows in a PlanetarySystem.
     */
    public static final int SYSTEM_ROWS = 3;
    
    /**
     * Number of columns in a PlanetarySystem.
     */
    public static final int SYSTEM_COLUMNS = 3;
    
    /**
     * Width of a quadrant.
     */
    public static final int QUADRANT_X_DIMENSION = 50;
    
    /**
     * Height of a quadrant.
     */
    public static final int QUADRANT_Y_DIMENSION = 50;
    
    /**
     * Max distance between two points in the Universe.
     */
    public static final int MAX_DISTANCE = (int) Math.sqrt(Math.pow(QUADRANT_X_DIMENSION *
    		UNIVERSE_COLUMNS, 2) + Math.pow(QUADRANT_Y_DIMENSION * UNIVERSE_ROWS, 2));

    /**
     * Largest fuel tank possible.
     */
    public static final int LARGEST_FUEL_TANK = MAX_DISTANCE;
    
    /**
     * Number of Planets to generate.
     */
    public static final int NUM_PLANETS = 30;
    
    /**
     * Number of PlanetarySystems to generate.
     */
    public static final int NUM_PLANETARY_SYSTEMS = 12;
   
    /**
     * Number of rows in a PlanetarySystem.
     */
    public static final int PLANETARY_SYSTEM_ROWS = 3;
   
    /**
     * Number of columns in a PlanetarySystem.
     */
    public static final int PLANETARY_SYSTEM_COLUMNS = 3;
    
    /**
     * Starting money for the Player.
     */
    public static final int PLAYER_STARTING_MONEY = 100000;
    
    /**
     * Minimum distance between two PlanetarySystems.
     */
    public static final int MINIMUM_SYSTEM_DISTANCE = 5;
    
    /**
     * Chance that a random event will happen to a player.
     */
	public static final double RANDOM_EVENT_CHANCE = 0.5;
	
	/**
	 * Max skill points that can be allocated for a Player.
	 */
	public static final int MAX_SKILL_POINTS = 16;
    
	/**
	 * Width of the Universe.
	 */
	public static final int UNIVERSE_WIDTH = UNIVERSE_COLUMNS * QUADRANT_X_DIMENSION;
	
	/**
	 * Height of the Universe.
	 */
	public static final int UNIVERSE_HEIGHT = UNIVERSE_ROWS * QUADRANT_Y_DIMENSION;
	
	/**
	 * @return The width of the Universe.
	 */
    public static int getUniverseWidth() {
    	return UNIVERSE_WIDTH;
    }
    
    /**
     * @return The height of the Universe.
     */
    public static int getUniverseHeight() {
    	return UNIVERSE_HEIGHT;
    }
    
    /**
     * @return Information about this object as a String.
     */
    public String toString() {
    	return "GameVariables";
    }
}
