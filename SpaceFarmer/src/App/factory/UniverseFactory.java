package App.factory;

import App.model.*;
import App.model.Universe.*;
import App.service.Randomizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniverseFactory {

    private static Map<String, Planet> planets;
    
    private static Map<String, PlanetarySystem> systems;

    public static PlanetarySystem getSystem(String name)
    {
    	return systems.get(name);
    }

	public static Planet getPlanet(String name)
	{
        return planets.get(name);
	}

    public static Map<String, Planet> getPlanets(){
        return planets;
    }

    public static Map<String, PlanetarySystem> getPlanetarySystems(){
        return systems;
    }
    
    

    /**
     * Fills the factory with planetary systems and planets
     * All parameters are based off values in GameVariables.
     */
    public static void createUniverse(List<String> planetNames,List<String> planetarySystemNames, int numPlanets,int numSystems,int systemRows, int systemCols, int uniRows, int uniCols,int quadrantXDimension,int quadrantYDimension,int minDistance){

        planets = new HashMap<String, Planet>();
        systems= new HashMap<String,PlanetarySystem>();
        Map<String,Planet> systemPlanets;
        
        Planet planet;
        PlanetarySystem system;

        int planetNameIndex,systemNameIndex;
        String planetName,systemName;
        List<String> planetNamesHolder = new ArrayList<String>(planetNames);
        List<String> systemNamesHolder = new ArrayList<String>(planetarySystemNames);

        // systemDistribution and planetDistribution put the planets and systems in
        // "boxes" which are evenly distributed as possible. The systems are
        // distributed into quadrants and planets are distributed into systems.
        //See Randomizer.distributeNumber for more details.
        //For example, if systemDistribution is {2,2,3}, then 3 total systems have planet counts
        // 2,2, and 3 respectively.
        int systemDistribution[]=Randomizer.distributeNumber(uniRows*uniCols,numSystems);
        int planetDistribution[]=Randomizer.distributeNumber(numSystems, numPlanets);
        List<Integer[]> planetPositions;
        Map<Integer,List<Integer[]>> systemDimensions=new HashMap<Integer,List<Integer[]>>(numSystems);
        for (int i=0;i<uniRows*uniCols;i++)
        {
        	//Give unique X and Y coordinates for each system in a quadrant that are at least minDistance apart.
        	//See Randomizer.generateDimensionsRange for more details.
        	systemDimensions.put(i,Randomizer.generateDimensionsRange(systemDistribution[i],quadrantXDimension,quadrantYDimension, minDistance));
        }
        int quadrantIndex=0;
        int systemIndex=0;
        int planetIndex=0;
        int systemCount=0;
        //A while loop for the quadrant, the system, and the planet to assign the appropriate attributes.
        
        //uniRows * uniCols gives the total number of quadrants in the universe.
        //When quadrantIndex exceeds this number, it's time to stop.
        while (quadrantIndex < uniRows*uniCols && !systemNamesHolder.isEmpty() && !planetNamesHolder.isEmpty()){
        	//Reset the system index for each quadrant after all the systems in a quadrant are distributed.
        	systemIndex=0;
        	//systemDistribution[quadrantIndex] gives the number of systems in the current quadrant.
        	//When systemIndex exceeds this number, it's time to move to the next quadrant.
        	while (systemIndex < systemDistribution[quadrantIndex] && !systemNamesHolder.isEmpty() && !planetNamesHolder.isEmpty()){
        		planetIndex=0;
        		system=new PlanetarySystem();
        		systemPlanets=new HashMap<String,Planet>();
        		
        		//Guarantee that each planet in a system has unique coordinates within the system.
        		//planetDistribution[systemCount] gives the number of planets in this system.
        		planetPositions=Randomizer.generateDimensions(planetDistribution[systemCount], systemRows, systemCols);
        		
        		systemNameIndex=Randomizer.nextInt(systemNamesHolder.size());
    			systemName=systemNamesHolder.get(systemNameIndex);
    			systemNamesHolder.remove(systemNameIndex);
    		
    			
        		while (planetIndex < planetDistribution[systemCount] && !planetNamesHolder.isEmpty()){
        			planet = new Planet();
        			planetNameIndex = Randomizer.nextInt(planetNamesHolder.size());
        			planetName=planetNamesHolder.get(planetNameIndex);
        			planetNamesHolder.remove(planetNameIndex);
        			planet.setPlanetarySystem(system);
        			planet.setName(planetName);
        			planet.setX(planetPositions.get(planetIndex)[0]);
        			planet.setY(planetPositions.get(planetIndex)[1]);
        			planet.setEvent(Event.NO_EVENT);
        			planet.setTechnologyLevel((TechnologyLevel) Randomizer.randEnum((TechnologyLevel.class)));
        			planet.setResourceType((ResourceType) Randomizer.randEnum((ResourceType.class)));
        			planet.setPoliticalSystem((PoliticalSystem) Randomizer.randEnum((PoliticalSystem.class)));
        			planet.setMarket(new MarketPlace(planet));
        			planets.put(planet.getName(), planet);
        			systemPlanets.put(planet.getName(),planet);
        			planetIndex++;
        		}
        		system.setX(systemDimensions.get(quadrantIndex).get(systemIndex)[0]+quadrantXDimension*(quadrantIndex%uniRows));
        		system.setY(systemDimensions.get(quadrantIndex).get(systemIndex)[1]+quadrantYDimension*(quadrantIndex/uniRows));
        		system.setName(systemName);
        		system.setPlanets(systemPlanets);
        		systems.put(system.getName(),system);
        		//systemCount exists to keep track of the current system.
        		//systemIndex cannot do this because it keeps track of planetary systems
        		//in a quadrant, not the total planetary systems.
        		systemCount++;
        		systemIndex++;
        	}
        	quadrantIndex++;
        	
        }

    }

    public static int getNumberOfPlanets(){
        return planets.size();
    }
    
    public static int getNumberOfSystem(){
    	return systems.size();
    }

}
