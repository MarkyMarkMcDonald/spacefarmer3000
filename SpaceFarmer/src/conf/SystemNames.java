/*This file holds the possible names for PlanetarySystems.*/
package conf;

import java.util.Arrays;
import java.util.List;

/**
 * This class holds possible names for PlanetarySystems.
 * 
 * @author Bobbey
 * @version 1.0
 *
 */
public class SystemNames {
	
	/**
	 * Possible names for PlanetarySystems.
	 */
    public static final String[] SYSTEM_NAMES_ARRAY = new String[] {
    	"Milky Way Galaxy",
    	"Andromeda",
    	"Bode's Galaxy",
    	"Cartwheel Galaxy",
    	"Cigar Galaxy",
    	"Comet Galaxy",
    	"Hoag's Object",
    	"Large Magellanic Cloud",
    	"Small Magellanic Cloud",
    	"Mayall's Object",
    	"Pinwheel Galaxy",
    	"Sombrero Galaxy",
    	"Sunflower Galaxy",
    	"Tadpole Galaxy",
    	"Whirlpool Galaxy"
    	};
    
    /**
     * @return The PlanetarySystem names as a list.
     */
    public static List<String> getSystemNamesAsList() {
        return Arrays.asList(SystemNames.SYSTEM_NAMES_ARRAY);
    }
    
    /**
     * @return Information about this object as a String.
     */
    public String toString() {
    	return "SystemNames";
    }
}
