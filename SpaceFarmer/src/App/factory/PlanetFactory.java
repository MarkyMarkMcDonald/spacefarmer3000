package App.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import App.model.Planet;
import App.model.PoliticalSystem;
import App.model.ResourceType;
import App.model.TechnologyLevel;
import App.service.Randomizer;

public class PlanetFactory {

    private static Map<String, Planet> planets;

	public static Planet getPlanet(String name)
	{
        return planets.get(name);
	}

    /**
     * Fills the factory with planets.
     *
     * @param names List of the Planet's possible names
     * @param maxXDim Length of the game's x-axis
     * @param maxYDim Length of the game's y-axis
     * @param numPlanets how many planets for this game
     */
    public static void createPlanets(List<String> names, int maxXDim, int maxYDim, int numPlanets){
        Planet planet = new Planet();
        planets = new HashMap<String, Planet>();

        List<Integer[]> coordinateList=Randomizer.generateDimensions(numPlanets, maxXDim, maxYDim);

        int index = 0;
        for (String name : names){
            planet.setName(name);

            String planetName=names.get(Randomizer.nextInt(names.size()));
            names.remove(planetName);
            planet.setName(planetName);
            planet.setX(coordinateList.get(index)[0]);
            planet.setY(coordinateList.get(index)[1]);
            planet.setTechnologyLevel((TechnologyLevel) Randomizer.randEnum((TechnologyLevel.class)));
            planet.setResourceType((ResourceType) Randomizer.randEnum((ResourceType.class)));
            planet.setPoliticalSystem((PoliticalSystem) Randomizer.randEnum((PoliticalSystem.class)));
            planets.put(planet.getName(), planet);
            index++;
        }

    }

}
