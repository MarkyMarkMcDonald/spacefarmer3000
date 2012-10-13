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
	public static List<Integer[]> generatePoints(int number,int xDim,int yDim)
	{
		List<Integer[]> pointList=new ArrayList<Integer[]>();
		Integer points[]=new Integer[2];
		points[0]=rand.nextInt(xDim);
		points[1]=rand.nextInt(yDim);
		for (int i=0;i<number;i++)
		{
			while(pointList.contains(points))
			{
				points[0]=rand.nextInt(xDim);
				points[1]=rand.nextInt(yDim);
			}
			pointList.add(points);
		}
		return pointList;
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
