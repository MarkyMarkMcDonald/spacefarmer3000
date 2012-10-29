package App.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import App.factory.PlanetFactory;
import App.model.Planet;

public class Randomizer {
	private static Random rand=new Random();

	/*
	 * Generates a random element from the enum class given.
	 * @param enumClass Enumerated class to generate from
	 */
	public static Enum<?> randEnum(Class<? extends Enum<?>> enumClass)
	{
		Enum<?> enums[]=enumClass.getEnumConstants();
		int length=enums.length;
		return enums[rand.nextInt(length)];
	}
	
	/*
	 * Returns an array of unique integers.
	 * @param lowerBound lowest value possible.
	 * @param upperBound highest value possible +1
	 */
	public static Integer[] uniqueRandomInts(int lowerBound, int upperBound,int numberOfInts)
	{
		ArrayList<Integer> returnInts=new ArrayList<Integer>(numberOfInts);
		if (numberOfInts>=upperBound-lowerBound)
		{
			for (int i=lowerBound;i<upperBound;i++)
			{
				returnInts.add(i);
			}
			return returnInts.toArray(new Integer[0]);
		}
		returnInts.add(lowerBound+rand.nextInt(upperBound-lowerBound));
		int randInt=lowerBound+rand.nextInt(upperBound-lowerBound);
		int index=1;
		while (index<numberOfInts)
		{
			if (returnInts.contains(randInt))
				randInt=lowerBound+rand.nextInt(upperBound-lowerBound);
			else
			{
				index++;
				returnInts.add(randInt);
				randInt=lowerBound+rand.nextInt(upperBound-lowerBound);
			}
		}
		return returnInts.toArray(new Integer[0]);
	}
	
	/*
	 * Gives a random number of unique elements from an array.
	 * @param Total number to return.
	 */
	public static Object[] randElements(Object[] objects,int total)
	{
		Object[] returnObjects=new Object[total];
		Integer[] indexes=uniqueRandomInts(0,objects.length,total);
		for (int i=0;i<total;i++)
		{
			returnObjects[i]=objects[indexes[i]];
		}
		return returnObjects;
	}
	
	/*
	 * Generates a number of randomly assigned Integer[2] arrays
	 * Ensures every array is unique
	 * @param number Number of points to be generated
	 * @param xDim Upperbound value for the x-coordinate
	 * @param yDim Upperbound value for the y-coordinate
	 */
	public static List<Integer[]> generateDimensions(int number, int xDim, int yDim)
	{
		List<Integer[]> dimensionList=new ArrayList<Integer[]>();
        boolean isUniqueDimension;

        for (int i=0;i<number;i++)
		{
            Integer[] dimension=new Integer[2];
            dimension[0]=rand.nextInt(xDim);
            dimension[1]=rand.nextInt(yDim);

            // We don't know if the dimension is unique, so treat as might not be unique
            isUniqueDimension = false;

			while(!isUniqueDimension)
			{
                if (!isUniqueDimension(dimensionList, dimension)){
                    dimension[0]=rand.nextInt(xDim);
                    dimension[1]=rand.nextInt(yDim);
                }
                isUniqueDimension = isUniqueDimension(dimensionList,dimension);

			}
			dimensionList.add(dimension);
		}
		return dimensionList;
	}

    public static boolean isUniqueDimension(List<Integer[]> dimensionList, Integer[] dimension){
        for (int i = 0; i < dimensionList.size(); i++){
            if (dimensionList.get(i)[0].equals(dimension[0]) && dimensionList.get(i)[1].equals(dimension[1])){
                return false;
            }
        }
        return true;
    }
    
    public static boolean determineSuccess(double probability)
    {
    	if  (rand.nextDouble()>probability)
    		return false;
    	else
    		return true;
    }
	
	/*
	 * Serves only to mimic Random.nextInt() when necessary
	 * @param upperBound Generated value is 0 to this number-1
	 */
	public static int nextInt(int upperBound)
	{
		return rand.nextInt(upperBound);
	}

    public static Planet getRandomPlanet(){
        Collection<Planet> planetCollection = PlanetFactory.getPlanets().values();
        List<Planet> planets = new ArrayList<Planet>(planetCollection);
        int numberOfPlanets = PlanetFactory.getNumberOfPlanets();
        int chosenPlanetNumber = Randomizer.nextInt(numberOfPlanets);
        return planets.get(chosenPlanetNumber);
    }
    
    /*
     * Distributes a number into parts as an array as evenly as possible
     * while randomizing any leftover parts.
     * Ex: distributeNumber(5,32) may yield {6,6,7,6,7}
     * @param numSlots The number of parts to divide the number into.
     * @param number The number being divided.
     * @return An int array with numSlots indices, each containing a subdivision of the number.
     */
    public static int[] distributeNumber(int numSlots, int number)
    {
    	int[] returnDistribution=new int[numSlots];
    	int minimum=number/numSlots;
    	Integer[] augmentedIndices=uniqueRandomInts(0,numSlots,number%numSlots);
    	for (int i=0;i<numSlots;i++)
    	{
    		returnDistribution[i]=minimum;
    	}
    	for (int i=0;i<number%numSlots;i++)
    	{
    		returnDistribution[augmentedIndices[i]]++;
    	}
    	
    	return returnDistribution;
    }

}
