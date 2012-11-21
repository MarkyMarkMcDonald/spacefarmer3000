// $codepro.audit.disable largeNumberOfParameters
/*This file holds the UniverseFactory, which creates a 
 * the Universe to play the game in.
 */

package app.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.model.Event;
import app.model.MarketPlace;
import app.model.universe.Planet;
import app.model.universe.PlanetarySystem;
import app.model.universe.PoliticalSystem;
import app.model.universe.ResourceType;
import app.model.universe.TechnologyLevel;
import app.service.Randomizer;

/**
 * This class creates the universe
 * @author Bobbey
 * @version 1
 *
 */
public class UniverseFactory {

	/**
	 * map of the planets to be
	 */
	private static Map<String, Planet> Planets=null;

	/**
	 * map of the systems to be
	 */
	private static Map<String, PlanetarySystem> Systems=null;

	/**
	 * Perform a reverse lookup of a PlanetarySystem from its unique name.
	 * 
	 * @param name
	 *            The name of the PlanetarySystem to retrieve.
	 * @return The PlanetarySystem whose name is equal to the String parameter.
	 */
	public static PlanetarySystem getSystem(String name) {
		return Systems.get(name);
	}

	/**
	 * Perform a reverse lookup of a Planet from its unique name.
	 * 
	 * @param name
	 *            The name of the Planet to retrieve.
	 * @return The Planet whose name is equal to the String parameter.
	 */
	public static Planet getPlanet(String name) {
		return Planets.get(name);
	}

	/**
	 * Getter for this singleton's String-Planet mapping.
	 * 
	 * @return The mapping of Planet names (as Strings) onto their respective
	 *         Planets.
	 */
	public static Map<String, Planet> getAllPlanets() {
		return Planets;
	}
	
	/**
	 * sets the universes planets
	 * @param pl
	 */
	public static  void setAllPlanets(Map<String, Planet>pl) {
		 Planets=pl;
	}

	/**
	 * Getter for this singleton's String-PlanetarySystem mapping.
	 * 
	 * @return The mapping of PlanetarySystem names as Strings onto their
	 *         PlanetarySystems
	 */
	public static Map<String, PlanetarySystem> getPlanetarySystems() {
		return Systems;
	}
	
	/**
	 * sets the planets systems
	 * @param ps
	 */
	public static  void setPlanetarySystems(Map<String, PlanetarySystem> ps) {
		 Systems=ps;
	}

	/**
	 * Fills the factory with planetary systems and planets All parameters are
	 * based off values in GameVariables.
	 * 
	 * @param planetNames
	 *            List of all the possible planet names.
	 * @param planetarySystemNames
	 *            List of all the possible planetary system names.
	 * @param numPlanets
	 *            Number of planets to be generated.
	 * @param numSystems
	 *            Number of PlanetarySystems to be generated.
	 * @param systemRows
	 *            Number of rows in a planetary system grid.
	 * @param systemCols
	 *            Number of columns in a planetary system grid.
	 * @param uniRows
	 *            Number of quadrants in a row of the universe.
	 * @param uniCols
	 *            Number of quadrants in a column of the universe.
	 * @param quadrantXDimension
	 *            Width of a quadrant.
	 * @param quadrantYDimension
	 *            Height of a quadrant
	 * @param minDistance
	 *            The minimum distance two systems must be from each other..
	 */
	public static void createUniverse(List<String> planetNames,
			List<String> planetarySystemNames, int numPlanets, int numSystems,
			int systemRows, int systemCols, int uniRows, int uniCols,
			int quadrantXDimension, int quadrantYDimension, int minDistance) {

		Planets = new HashMap<String, Planet>();
		Systems = new HashMap<String, PlanetarySystem>();
		Map<String, Planet> systemPlanets;

		Planet planet;
		PlanetarySystem system;

		int planetNameIndex, systemNameIndex;
		String planetName, systemName;
		final List<String> planetNamesHolder = new ArrayList<String>(planetNames);
		final List<String> systemNamesHolder = new ArrayList<String>(
				planetarySystemNames);

		// systemDistribution and planetDistribution put the planets and systems
		// in
		// "boxes" which are evenly distributed as possible. The systems are
		// distributed into quadrants and planets are distributed into systems.
		// See Randomizer.distributeNumber for more details.
		// For example, if systemDistribution is {2,2,3}, then 3 total systems
		// have planet
		// counts
		// 2,2, and 3 respectively.
		final int systemDistribution[] = Randomizer.distributeNumber(uniRows
				* uniCols, numSystems);
		final int planetDistribution[] = Randomizer.distributeNumber(numSystems,
				numPlanets);
		List<Integer[]> planetPositions;
		final Map<Integer, List<Integer[]>> systemDimensions = 
				new HashMap<Integer, List<Integer[]>>(numSystems);
		for (int i = 0; i < uniRows * uniCols; i++) {
			// Give unique X and Y coordinates for each system in a quadrant
			// that are at least minDistance apart.
			// See Randomizer.generateDimensionsRange for more details.
			systemDimensions.put(i, Randomizer.generateDimensionsRange(
					systemDistribution[i], quadrantXDimension,
					quadrantYDimension, minDistance));
		}
		int quadrantIndex = 0;
		int systemIndex = 0;
		int planetIndex = 0;
		int systemCount = 0;
		// A while loop for the quadrant, the system, and the planet to assign
		// the appropriate attributes.

		// uniRows * uniCols gives the total number of quadrants in the
		// universe.
		// When quadrantIndex exceeds this number, it's time to stop.
		while (quadrantIndex < uniRows * uniCols
				&& !systemNamesHolder.isEmpty() && !planetNamesHolder.isEmpty()) {
			// Reset the system index for each quadrant after all the systems in
			// a quadrant are distributed.
			systemIndex = 0;
			// systemDistribution[quadrantIndex] gives the number of systems in
			// the current quadrant.
			// When systemIndex exceeds this number, it's time to move to the
			// next quadrant.
			while (systemIndex < systemDistribution[quadrantIndex]
					&& !systemNamesHolder.isEmpty()
					&& !planetNamesHolder.isEmpty()) {
				planetIndex = 0;
				system = new PlanetarySystem();
				systemPlanets = new HashMap<String, Planet>();

				// Guarantee that each planet in a system has unique coordinates
				// within the system.
				// planetDistribution[systemCount] gives the number of planets
				// in this system.
				planetPositions = Randomizer
						.generateDimensions(planetDistribution[systemCount],
								systemRows, systemCols);

				systemNameIndex = Randomizer.nextInt(systemNamesHolder.size());
				systemName = systemNamesHolder.get(systemNameIndex);
				systemNamesHolder.remove(systemNameIndex);

				while (planetIndex < planetDistribution[systemCount]
						&& !planetNamesHolder.isEmpty()) {
					planet = new Planet();
					planetNameIndex = Randomizer.nextInt(planetNamesHolder
							.size());
					planetName = planetNamesHolder.get(planetNameIndex);
					planetNamesHolder.remove(planetNameIndex);
					planet.setPlanetarySystem(system);
					planet.setName(planetName);
					planet.setX(planetPositions.get(planetIndex)[0]);
					planet.setY(planetPositions.get(planetIndex)[1]);
					planet.setEvent(Event.NO_EVENT);
					planet.setTechnologyLevel((TechnologyLevel) Randomizer
							.randEnum((TechnologyLevel.class)));
					planet.setResourceType((ResourceType) Randomizer
							.randEnum((ResourceType.class)));
					planet.setPoliticalSystem((PoliticalSystem) Randomizer
							.randEnum((PoliticalSystem.class)));
					planet.setMarket(new MarketPlace(planet));
					Planets.put(planet.getName(), planet);
					systemPlanets.put(planet.getName(), planet);
					planetIndex++;
				}
				system.setX(systemDimensions.get(quadrantIndex)
						.get(systemIndex)[0]
						+ quadrantXDimension
						* (quadrantIndex % uniRows));
				system.setY(systemDimensions.get(quadrantIndex)
						.get(systemIndex)[1]
						+ quadrantYDimension
						* (quadrantIndex / uniRows));
				system.setName(systemName);
				system.setPlanets(systemPlanets);
				Systems.put(system.getName(), system);
				// systemCount exists to keep track of the current system.
				// systemIndex cannot do this because it keeps track of
				// planetary systems
				// in a quadrant, not the total planetary systems.
				systemCount++;
				systemIndex++;
			}
			quadrantIndex++;

		}

	}

	/**
	 * @return The number of Planets in the generated universe.
	 */
	public static int getNumberOfPlanets() {
		return Planets.size();
	}

	/**
	 * @return The number of PlanetarySystems in the generated universe.
	 */
	public static int getNumberOfSystem() {
		return Systems.size();
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "UniverseFactory";
	}
}
