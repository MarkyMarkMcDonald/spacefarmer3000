package App.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
}
