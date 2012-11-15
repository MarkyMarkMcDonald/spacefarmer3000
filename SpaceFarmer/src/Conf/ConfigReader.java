package conf;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

/**
 * The purpose of this class is to deal with file IO and parsing.
 * @author Andrew Wilder
 */

public class ConfigReader {

	/**
	 * Parse a file as a Collection of Strings, delimited by newlines.
	 * @param confFile The path to the file to parse.
	 * @return A Collection of Strings read from the file.
	 *         If the file does not exist, return null.
	 */
	public static List<String> parseFileToStrings(String confFile) {
		// Create the List to which the Strings will be added
		List<String> lines = new ArrayList<String>();
		Scanner sc;

		// Wrap file creation in a try-catch block to prevent uncaught IO exception
		try {
	        URL location = 
	        	ConfigReader.class.getProtectionDomain().getCodeSource().getLocation();

            sc = new Scanner(new File(location.getPath() + "conf/" + confFile));
		} catch(FileNotFoundException e) {
		    System.out.println("File not found!");
		    return null;
		}
		
		// Scan the contents of the file into the Collection
		sc.useDelimiter("\n");
		while(sc.hasNext()) {
			lines.add(sc.nextLine());
		}
		
		// Return the completed Collection
		return lines;
	}

    /**
     * parse a file that determines game configuration variables into a map based on the
     * name of the value and the integer value.
     * Variables should be in the form of 'foo: 1'
     * @param confFile the name of the file in the Conf folder to parse
     * @return a map to use for settings game variables
     */
    public static Map<String, Integer> parseFileToMap(String confFile){
        Map<String, Integer> variables = new HashMap<String, Integer>();
        Scanner scanner;
        try {
            URL location = 
            	ConfigReader.class.getProtectionDomain().getCodeSource().getLocation();
            scanner = new Scanner(new File(location.getPath() + "conf/" + confFile));
        } catch (FileNotFoundException e){
            System.out.println("File not found!");
            return null;
        }

        scanner.useDelimiter("\n");
        String line;
        while (scanner.hasNext()){
            line = scanner.nextLine();
            String[] variableAndValue = line.split("");
            variables.put(variableAndValue[0], Integer.parseInt(variableAndValue[1]));
        }

        return variables;
    }
    
    /**
     * @return Information about this object as a String.
     */
    public String toString() {
    	return "ConfigReader";
    }
}