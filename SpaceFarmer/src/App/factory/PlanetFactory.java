package App.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import App.model.Event;
import App.model.MarketPlace;
import App.model.Planet;
import App.model.PlanetarySystem;
import App.model.PoliticalSystem;
import App.model.ResourceType;
import App.model.TechnologyLevel;
import App.service.Randomizer;

public class PlanetFactory {

    private static Map<String, Planet> planets;
    
    private static Map<String, PlanetarySystem> systems;

	public static Planet getPlanet(String name)
	{
        return planets.get(name);
	}
    public static Map<String, Planet> getPlanets(){
        return planets;
    }

    /**
     * Fills the factory with planets.
     *
     * @param names List of the Planet's possible names
     * @param maxXDim Length of the game's x-axis
     * @param maxYDim Length of the game's y-axis
     * @param numPlanets how many planets for this game
     */
    
    
    public static void createPlanets(List<String> planetNames,List<String> planetarySystemNames, int numPlanets,int numSystems,int systemRows, int systemCols, int uniRows, int uniCols,int quadrantXDimension,int quadrantYDimension){

        planets = new HashMap<String, Planet>();
        systems= new HashMap<String,PlanetarySystem>();
        Map<String,Planet> systemPlanets=new HashMap<String,Planet>();
        
        Planet planet;
        PlanetarySystem system;
        int planetNameIndex,systemNameIndex;
        String planetName,systemName;
        List<String> planetNamesHolder = new ArrayList<String>(planetNames);
        List<String> systemNamesHolder = new ArrayList<String>(planetarySystemNames);
        int systemDistribution[]=Randomizer.distributeNumber(uniRows*uniCols,numSystems);
        int planetDistribution[]=Randomizer.distributeNumber(numSystems, numPlanets);
        List<Integer[]> planetPositions;
        Map<Integer,List<Integer[]>> systemDimensions=new HashMap<Integer,List<Integer[]>>(numSystems);
        for (int i=0;i<uniRows*uniCols;i++)
        {
        	systemDimensions.put(i,Randomizer.generateDimensions(systemDistribution[i],quadrantXDimension,quadrantYDimension));
        }
        int quadrantIndex=0;
        int superIndex=0;
        int subIndex=0;
        while (quadrantIndex < uniRows*uniCols && !systemNamesHolder.isEmpty() && !planetNamesHolder.isEmpty()){
        	superIndex=0;
        	while (superIndex < systemDistribution[quadrantIndex] && !systemNamesHolder.isEmpty() && !planetNamesHolder.isEmpty()){
        		subIndex=0;
        		system=new PlanetarySystem();
        		planetPositions=Randomizer.generateDimensions(planetDistribution[superIndex], systemRows, systemCols);
        		systemNameIndex=Randomizer.nextInt(systemNamesHolder.size());
    			systemName=systemNamesHolder.get(systemNameIndex);
    			systemNamesHolder.remove(systemNameIndex);
        		while (subIndex < planetDistribution[superIndex] && !planetNamesHolder.isEmpty()){
        			planet = new Planet();
        			planetNameIndex = Randomizer.nextInt(planetNamesHolder.size());
        			planetName=planetNamesHolder.get(planetNameIndex);
        			planetNamesHolder.remove(planetNameIndex);
        			planet.setPlanetarySystem(system);
        			planet.setName(planetName);
        			planet.setX(planetPositions.get(subIndex)[0]);
        			planet.setY(planetPositions.get(subIndex)[1]);
        			planet.setEvent(Event.NO_EVENT);
        			planet.setTechnologyLevel((TechnologyLevel) Randomizer.randEnum((TechnologyLevel.class)));
        			planet.setResourceType((ResourceType) Randomizer.randEnum((ResourceType.class)));
        			planet.setPoliticalSystem((PoliticalSystem) Randomizer.randEnum((PoliticalSystem.class)));
        			planet.setMarket(new MarketPlace(planet));
        			planets.put(planet.getName(), planet);
        			systemPlanets.put(planet.getName(),planet);
        			subIndex++;
        		}
        		system.setX(systemDimensions.get(quadrantIndex).get(superIndex)[0]+quadrantXDimension*(quadrantIndex%uniRows));
        		system.setY(systemDimensions.get(quadrantIndex).get(superIndex)[1]+quadrantYDimension*(quadrantIndex/uniRows));
        		system.setName(systemName);
        		system.setPlanets(systemPlanets);
        		systems.put(system.getName(),system);
        		superIndex++;
        	}
        	quadrantIndex++;
        	
        }

    }

    public static int getNumberOfPlanets(){
        return planets.size();
    }

}
