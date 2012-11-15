package Conf;

/**
 * User: marky
 * Date: 10/14/12
 * Time: 2:24 PM
 */
public class GameVariables {
	
    public static final int universeColumns = 3;
    
    public static final int universeRows = 3;
    
    public static final int systemRows = 3;
    
    public static final int systemColumns = 3;
    
    public static final int quadrantXDimension = 50;
    
    public static final int quadrantYDimension = 50;
    
    public static final int maxDistance = (int) Math.sqrt(Math.pow(quadrantXDimension *
    		universeColumns, 2) + Math.pow(quadrantYDimension * universeRows, 2));

    public static final int largestFuelTank = maxDistance;
    
    public static final int numPlanets = 30;
    
    public static final int numPlanetarySystems = 12;
    
    public static final int plantearySystemRows = 3;
    
    public static final int planetarySystemColomns = 3;
    
    public static final int playerStartingMoney = 100000;
    
    public static final int minimumSystemDistance = 5;
    
	public static final double randomEventChancce = 0.05;
    
    public static int getUniverseWidth() {
    	return universeColumns * quadrantXDimension;
    }
    
    public static int getUniverseHeight() {
    	return universeRows * quadrantYDimension;
    }
}
