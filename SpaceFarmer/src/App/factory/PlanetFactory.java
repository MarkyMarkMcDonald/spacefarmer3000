package App.factory;

import java.util.ArrayList;
import java.util.List;

import App.model.Planet;
import App.model.PoliticalSystem;
import App.model.ResourceType;
import App.model.TechnologyLevel;
import App.service.Randomizer;

public class PlanetFactory {
	
	private static Planet planet=new Planet();
	/*
	 * Takes in and returns ArrayLists to effectively randomize
	 * x and y of the planets. Also needs xDimension and yDimension
	 * from Settings to accomplish this.
	 * Planets will have unique coordinates.
	 * @param names List of the Planet's names
	 * @param xDim Length of the game's x-axis
	 * @param yDim Length of the game's y-axis
	 * @return List of Planets corresponding to the names.
	 */
	public static List<Planet> getPlanet(List<String> names,int xDim,int yDim)
	{
		// Don't want to make a new Planet in the for loop, reuse emptyPlanet
		int length=names.size();
		
		List<Planet> planets=new ArrayList<Planet>();
		List<Integer[]> coordinateList=Randomizer.generatePoints(length,xDim,yDim);
		
		String planetName;
		
		for (int i=0;i<length;i++)
		{
			planetName=names.get(Randomizer.nextInt(length));
			names.remove(planetName);
			planet.setName(planetName);
			planet.setX(coordinateList.get(i)[0]);
			planet.setY(coordinateList.get(i)[1]);
			planet.setTechnologyLevel((TechnologyLevel) Randomizer.randEnum((TechnologyLevel.AGRICULTURE.getClass())));
			planet.setResourceType((ResourceType) Randomizer.randEnum((ResourceType.MINERAL_RICH.getClass())));
			planet.setPoliticalSystem((PoliticalSystem) Randomizer.randEnum((PoliticalSystem.DEMOCRACY.getClass())));
            planets.add(planet);			
		}
		return planets;
		
	}

}
