package app.service;

import app.factory.UniverseFactory;
import app.model.Player.Player;
import app.model.RandomEvent;
import app.model.Universe.Planet;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * This class is used to handle randomizations in universe generation.
 * 
 * @author Bobby Reese, Mark McDonald
 * @version 1.0
 */
public class Randomizer {

	/**
	 * Random object to be used by Randomizer.
	 */
	private static final Random RAND = new Random();

	/**
	 * Array necessary to return Integer array correctly in some methods.
	 */
	private static final Integer[] DUMMY_ARRAY = new Integer[0];

	/**
	 * Number of coordinates to acquire in generateDimenisions.
	 */
	private static final int COORDINATES = 2;

	/**
	 * Generates a random element from the enum class given.
	 * 
	 * @param enumClass
	 *            Enumerated class to generate from.
	 * @return A random element from that class.
	 */
	public static Enum<?> randEnum(Class<? extends Enum<?>> enumClass) {
		final Enum<?> enums[] = enumClass.getEnumConstants();
		final int length = enums.length;
		return enums[RAND.nextInt(length)];
	}

	/**
	 * Returns an array of unique integers.
	 * 
	 * @param lowerBound
	 *            lowest value possible.
	 * @param upperBound
	 *            highest value possible +1
	 * @param numberOfInts
	 *            Number of integers to be in array.
	 * @return array of unique integers.
	 */
	public static Integer[] uniqueRandomInts(int lowerBound, int upperBound,
			int numberOfInts) {
		final ArrayList<Integer> returnInts = new ArrayList<Integer>(
				numberOfInts);
		if (numberOfInts >= upperBound - lowerBound) {
			for (int i = lowerBound; i < upperBound; i++) {
				returnInts.add(i);
			}
			return returnInts.toArray(DUMMY_ARRAY);
		}
		returnInts.add(lowerBound + RAND.nextInt(upperBound - lowerBound));
		int randInt = lowerBound + RAND.nextInt(upperBound - lowerBound);
		int index = 1;
		while (index < numberOfInts) {
			if (returnInts.contains(randInt)) {
				randInt = lowerBound + RAND.nextInt(upperBound - lowerBound);
			} else {
				index++;
				returnInts.add(randInt);
				randInt = lowerBound + RAND.nextInt(upperBound - lowerBound);
			}
		}
		return returnInts.toArray(DUMMY_ARRAY);
	}

	/**
	 * Gives a random number of unique elements from an array.
	 * 
	 * @param objects
	 *            Elements to choose from.
	 * @param total
	 *            Number of elements to retrieve.
	 * @return Random elements from objects.
	 */
	public static Object[] multiRandElements(Object[] objects, int total) {
		final Object[] returnObjects = new Object[total];
		final Integer[] indexes = uniqueRandomInts(0, objects.length, total);
		for (int i = 0; i < total; i++) {
			returnObjects[i] = objects[(int) indexes[i]];
		}
		return returnObjects;
	}

	/**
	 * Returns a random element from an array.
	 * 
	 * @param objects
	 *            Array containing the elements.
	 * @return Random element from objects.
	 */
	public static Object randElement(Object[] objects) {
		return objects[RAND.nextInt(objects.length)];
	}

	/**
	 * Generates a number of randomly assigned Integer[2] arrays. Ensures every
	 * array is unique
	 * 
	 * @param number
	 *            Number of points to be generated
	 * @param xDim
	 *            Upperbound value for the x-coordinate
	 * @param yDim
	 *            Upperbound value for the y-coordinate
	 * @return Random, unique Integer[2] arrays.
	 */
	public static List<Integer[]> generateDimensions(int number, int xDim,
			int yDim) {
		final List<Integer[]> dimensionList = new ArrayList<Integer[]>();
		boolean isUniqueDimension;

		for (int i = 0; i < number; i++) {
			Integer[] dimension = new Integer[COORDINATES];
			dimension[0] = RAND.nextInt(xDim);
			dimension[1] = RAND.nextInt(yDim);

			// We don't know if the dimension is unique, so treat as might not
			// be unique
			isUniqueDimension = false;

			while (!isUniqueDimension) {
				if (!isUniqueDimension(dimensionList, dimension)) {
					dimension[0] = RAND.nextInt(xDim);
					dimension[1] = RAND.nextInt(yDim);
				}
				isUniqueDimension = isUniqueDimension(dimensionList, dimension);

			}
			dimensionList.add(dimension);
		}
		return dimensionList;
	}

	/**
	 * Generates unique Integer[2] arrays within a Euclidean distance of each
	 * other.
	 * 
	 * @param number
	 *            Number of arrays to generate.
	 * @param xDim
	 *            Maximum x coordinate of arrays.
	 * @param yDim
	 *            Maximum y coordinate of arrays.
	 * @param range
	 *            Minimum distance between two arrays.
	 * @return List of unique Integer[2] arrays.
	 */
	public static List<Integer[]> generateDimensionsRange(int number, int xDim,
			int yDim, int range) {
		final List<Integer[]> dimensionList = new ArrayList<Integer[]>();
		Integer[] point = new Integer[COORDINATES];
		point[0] = RAND.nextInt(xDim);
		point[1] = RAND.nextInt(yDim);
		boolean outOfRange = true;
		for (int i = 0; i < number; i++) {
			while (!outOfRange) {
				outOfRange = true;
				for (Integer[] p : dimensionList) {
					if (Point2D.distance(p[0], p[1], point[0], point[1]) < range) {
						outOfRange = false;
						point[0] = RAND.nextInt(xDim);
						point[1] = RAND.nextInt(yDim);
						break;
					}
				}
			}
			outOfRange = false;
			dimensionList.add(point);
			point = new Integer[COORDINATES];
			point[0] = RAND.nextInt(xDim);
			point[1] = RAND.nextInt(yDim);
		}
		return dimensionList;
	}

	/**
	 * Determines if an array of integers are unique from a List of integer
	 * array entries.
	 * 
	 * @param dimensionList
	 *            A List of integer arrays to determine uniqueness from.
	 * @param dimension
	 *            An integer array to determine if it's unique.
	 * @return True if this array of integers being checked is unique.
	 */
	public static boolean isUniqueDimension(List<Integer[]> dimensionList,
			Integer[] dimension) {
		for (int i = 0; i < dimensionList.size(); i++) {
			if (dimensionList.get(i)[0].equals(dimension[0])
					&& dimensionList.get(i)[1].equals(dimension[1])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Serves as the upper bound in determining a valid probabilistic outcome.
	 * 
	 * @param probability
	 *            The upper bound for the allowed probability.
	 * @return true if a randomly-generated number falls within the probability
	 *         bounds.
	 */
	public static boolean isSuccessful(double probability) {
		return RAND.nextDouble() <= probability;
	}

	/**
	 * Serves only to mimic Random.nextInt() when necessary
	 * 
	 * @param upperBound
	 *            Generated value is 0 to this number-1
	 * @return A random Integer.
	 */
	public static int nextInt(int upperBound) {
		return RAND.nextInt(upperBound);
	}

	/**
	 * Gets a random planet from UniverseFactory.
	 * 
	 * @return A random planet.
	 */
	public static Planet getRandomPlanet() {
		final Collection<Planet> planetCollection = UniverseFactory
				.getAllPlanets().values();
		final List<Planet> planets = new ArrayList<Planet>(planetCollection);
		final int numberOfPlanets = UniverseFactory.getNumberOfPlanets();
		final int chosenPlanetNumber = Randomizer.nextInt(numberOfPlanets);
		return planets.get(chosenPlanetNumber);
	}

	/**
	 * Distributes a number into parts as an array as evenly as possible while
	 * randomizing any leftover parts. Ex: distributeNumber(5,32) may yield
	 * {6,6,7,6,7}
	 * 
	 * @param numSlots
	 *            The number of parts to divide the number into.
	 * @param number
	 *            The number being divided.
	 * @return An int array with numSlots indices, each containing a subdivision
	 *         of the number.
	 */
	public static int[] distributeNumber(int numSlots, int number) {
		final int[] returnDistribution = new int[numSlots];
		final int minimum = number / numSlots;
		final Integer[] augmentedIndices = uniqueRandomInts(0, numSlots, number
				% numSlots);
		for (int i = 0; i < numSlots; i++) {
			returnDistribution[i] = minimum;
		}
		for (int i = 0; i < number % numSlots; i++) {
			returnDistribution[(int) augmentedIndices[i]]++;
		}
		return returnDistribution;
	}

	/**
	 * Gives a player a random event if a probability check succeeds.
	 * 
	 * @param player
	 *            Player potentially receiving the event.
	 * @param chance
	 *            Chance the player will receive the event.
	 */
	public static void giveEvent(Player player, double chance) {
		if (isSuccessful(chance)) {
			final RandomEvent event = (RandomEvent) randEnum(RandomEvent.class);
			event.giveEvent(player);
		}
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "Randomizer";
	}
}
