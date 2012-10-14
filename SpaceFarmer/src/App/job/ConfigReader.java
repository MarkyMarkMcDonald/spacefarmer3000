package App.job;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * The purpose of this class is to deal with file IO and parsing.
 * @author Andrew Wilder
 */

public class ConfigReader {
	/**
	 * Parse a file as a Collection of Strings, delimited by newlines.
	 * @param filePath The path to the file to parse.
	 * @return A Collection of Strings read from the file.
	 *         If the file does not exist, return null.
	 */
	public static List<String> parseFileToStrings(String filePath) {
		// Create the List to which the Strings will be added
		List<String> lines = new ArrayList<String>();
		Scanner sc;
		
		// Wrap file creation in a try-catch block to prevent uncaught IO exception
		try {
			sc = new Scanner(new File(filePath));
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

    public static Map<String, Integer> parseFileToMap(String filePath){
        Map<String, Integer> variables = new HashMap<String, Integer>();
        Scanner scanner;
        try {
            scanner = new Scanner(new File(filePath));
        } catch (FileNotFoundException e){
            System.out.println("File not found!");
            return null;
        }

        scanner.useDelimiter("\n");
        String line;
        while (scanner.hasNext()){
            line = scanner.nextLine();
            String[] variableAndValue = line.split(": ");
            variables.put(variableAndValue[0],Integer.parseInt(variableAndValue[1]));
        }

        return variables;
    }
}