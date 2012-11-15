package Conf;

import java.util.Arrays;
import java.util.List;

public class SystemNames {
	
    public static final String[] SystemNamesArray =new String[] {
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
    	"Whirlpool Galaxy"};
    
    public static List<String> getSystemNamesAsList() {
        return Arrays.asList(SystemNames.SystemNamesArray);
    }
    
    /**
     * @return Information about this object as a String.
     */
    public String toString() {
    	return "SystemNames";
    }
}
