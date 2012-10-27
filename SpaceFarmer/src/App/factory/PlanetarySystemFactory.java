package App.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import App.model.Planet;
import App.model.PlanetarySystem;
import App.service.Randomizer;


/*
 * Uses game variables to create the Planetary Systems.
 * Puts the Planetary Systems in quadrants, which are
 * just subdivisions of the universe.
 * @param names Names available for Planetary Systems.
 * @param planets Planets to be put into the Planetary Systems.
 * @param numSystems Number of Planetary Systems to be created.
 * @param quadrantXDimension The length of a quadrant.
 * @param quadrantYDimension The height of a quadrant.
 * @param systemRows The number of rows in a Planetary System where planets may be placed.
 * @param systemCols The number of columns in a PlanetarySystem
 * @param uniRows The number of rows in the universe where quadrants may lie.
 * @param uniCols The number of columns in the universe.
 */
public class PlanetarySystemFactory {
	
	private static Map<String,PlanetarySystem> systems;
	
	public static void createPlanetarySystems(List<String> names,List<Planet> planets, int numSystems,int quadrantXDimension, int quadrantYDimension, int systemRows, int systemCols, int uniRows,int uniCols)
    {
        systems = new HashMap<String, PlanetarySystem>();
        PlanetarySystem system;
        List<String> namesHolder=new ArrayList<String>(names);
        List<Planet> planetHolder= new ArrayList<Planet>(planets);
        Map<Integer[],Planet> slotMap;
        List<Integer[]> slots;
        int index=0;
        String systemName;
        int systemNameIndex;
        int planetIndex;
        int systemDistribution[]=Randomizer.distributeNumber(uniRows*uniCols,numSystems);
        int planetDistribution[]=Randomizer.distributeNumber(numSystems, planets.size());
        Map<Integer,List<Integer[]>> systemDimensions=new HashMap<Integer,List<Integer[]>>(uniRows*uniCols);
        for (int i=0;i<uniRows*uniCols;i++)
        {
        	systemDimensions.put(i,Randomizer.generateDimensions(systemDistribution[i],quadrantXDimension,quadrantYDimension));
        }
        for (int superIndex=0;superIndex<uniRows*uniCols;superIndex++)
        {
        	if (names.isEmpty())
    			break;
        	for (int subIndex=0;subIndex<systemDistribution[superIndex];subIndex++)
        	{
        		system=new PlanetarySystem();
        		slotMap=new HashMap<Integer[],Planet>(planetDistribution[index]);
        		systemNameIndex=Randomizer.nextInt(namesHolder.size());
        		systemName=namesHolder.get(systemNameIndex);
        		namesHolder.remove(systemNameIndex);
        		slots=Randomizer.generateDimensions(systemRows,systemCols,planetDistribution[index]);
        		for (int planetAssignIndex=0;planetAssignIndex<planetDistribution[index];planetAssignIndex++)
        		{
        			planetIndex=Randomizer.nextInt(planetHolder.size());
        			slotMap.put(slots.get(planetAssignIndex), planetHolder.get(planetIndex));
        			planetHolder.remove(planetIndex);
        		}
        		system.setX(systemDimensions.get(superIndex).get(subIndex)[0]+quadrantXDimension*(superIndex%uniRows));
        		system.setY(systemDimensions.get(superIndex).get(subIndex)[1]+quadrantYDimension*(superIndex/uniRows));
        		system.setName(systemName);
        		system.setSlots(slotMap);
        		systems.put(system.getName(),system);
        		index++;
        		
            }
        }
    }
}
