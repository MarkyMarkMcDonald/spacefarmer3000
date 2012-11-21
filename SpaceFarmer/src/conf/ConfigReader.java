/*This file holds the ConfigReader class, which is
 * for reading game configuration.
 */
package conf;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * The purpose of this class is to deal with file IO and parsing.
 * 
 * @author Andrew Wilder
 * @version 1.0
 */

public class ConfigReader {

	/**
	 * Parse a file as a Collection of Strings, delimited by newlines.
	 * 
	 * @param confFile
	 *            The path to the file to parse.
	 * @return A Collection of Strings read from the file. If the file does not
	 *         exist, return null.
	 */
	public static List<String> parseFileToStrings(String confFile) {
		// Create the List to which the Strings will be added
		final List<String> lines = new ArrayList<String>();
		final Scanner sc;

		// Wrap file creation in a try-catch block to prevent uncaught IO
		// exception
		try {
			final URL location = ConfigReader.class.getProtectionDomain()
					.getCodeSource().getLocation();

			sc = new Scanner(new File(location.getPath() + "Conf/" + confFile));
		} catch (FileNotFoundException e) { // $codepro.audit.disable logExceptions
			System.out.println("File not found!");
			return null;
		}

		// Scan the contents of the file into the Collection
		sc.useDelimiter("\n"); // $codepro.audit.disable com.instantiations.assist.eclipse.analysis.unusedReturnValue
		while (sc.hasNext()) {
			lines.add(sc.nextLine());
		}

		// Return the completed Collection
		return lines;
	}

	/**
	 * parse a file that determines game configuration variables into a map
	 * based on the name of the value and the integer value. Variables should be
	 * in the form of 'foo: 1'
	 * 
	 * @param confFile
	 *            the name of the file in the Conf folder to parse
	 * @return a map to use for settings game variables
	 */
	public static Map<String, Integer> parseFileToMap(String confFile) {
		final Map<String, Integer> variables = new HashMap<String, Integer>();
		final Scanner scanner;
		try {
			final URL location = ConfigReader.class.getProtectionDomain()
					.getCodeSource().getLocation();
			scanner = new Scanner(new File(location.getPath() + "Conf/"
					+ confFile));
		} catch (FileNotFoundException e) { // $codepro.audit.disable logExceptions
			System.out.println("File not found!");
			return null;
		}

		scanner.useDelimiter("\n"); // $codepro.audit.disable com.instantiations.assist.eclipse.analysis.unusedReturnValue
		String line;
		while (scanner.hasNext()) {
			line = scanner.nextLine();
			String[] variableAndValue = line.split("");
			try{
			variables.put(variableAndValue[0],
					Integer.parseInt(variableAndValue[1]));
			}
			catch (Exception e){
				e.printStackTrace();
			}
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