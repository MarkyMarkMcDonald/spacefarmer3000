package App.job;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

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
	public static Collection<String> parseFileToStrings(String filePath) {
		// Create the Collection to which the Strings will be added
		Collection<String> lines = new ArrayList<String>();
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
}