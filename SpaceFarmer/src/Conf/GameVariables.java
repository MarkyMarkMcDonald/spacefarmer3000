package conf;

/**
 * User: marky
 * Date: 10/14/12
 * Time: 2:24 PM
 */
public class GameVariables {
	
    public static final int UniverseColumns = 3;
    
    public static final int UniverseRows = 3;
    
    public static final int SystemRows = 3;
    
    public static final int SystemColumns = 3;
    
    public static final int QuadrantXDimension = 50;
    
    public static final int QuadrantYDimension = 50;
    
    public static final int MaxDistance = (int) Math.sqrt(Math.pow(QuadrantXDimension *
    		UniverseColumns, 2) + Math.pow(QuadrantYDimension * UniverseRows, 2));

    public static final int LargestFuelTank = MaxDistance;
    
    public static final int NumPlanets = 30;
    
    public static final int NumPlanetarySystems = 12;
    
    public static final int PlantearySystemRows = 3;
    
    public static final int PlanetarySystemColomns = 3;
    
    public static final int PlayerStartingMoney = 100000;
    
    public static final int MinimumSystemDistance = 5;
    
	public static final double RandomEventChancce = 0.05;
    
    public static int getUniverseWidth() {
    	return UniverseColumns * QuadrantXDimension;
    }
    
    public static int getUniverseHeight() {
    	return UniverseRows * QuadrantYDimension;
    }
    
    /**
     * @return Information about this object as a String.
     */
    public String toString() {
    	return "GameVariables";
    }
}
