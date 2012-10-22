package App.model;

import App.service.Randomizer;

/**
 * Created with IntelliJ IDEA.
 * User: Marky
 * Date: 9/22/12
 * Time: 12:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class Planet {
	
	private static final double eventProbability=.1;
    private String name;

	private TechnologyLevel technologyLevel;

	private PoliticalSystem politicalSystem;

	private Event event;
	
    private ResourceType resourceType;

    private int x,y;

	private MarketPlace market;

	public Planet(){

    }

	public Planet(String name,TechnologyLevel technologyLevel, PoliticalSystem politicalSystem,
			ResourceType resourceType, int x, int y) {
		super();
		this.name=name;
		this.technologyLevel = technologyLevel;
		this.politicalSystem = politicalSystem;
		this.resourceType = resourceType;
		this.x = x;
		this.y = y;
	}

    //--- Accessors and Modifiers

    public MarketPlace getMarket() {
        return market;
    }

    public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public void setMarket(MarketPlace market) {
        this.market = market;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

	public TechnologyLevel getTechnologyLevel() {
		return technologyLevel;
	}

	public void setTechnologyLevel(TechnologyLevel techLevel) {
		this.technologyLevel = techLevel;
	}

	public PoliticalSystem getPoliticalSystem() {
		return politicalSystem;
	}

	public void setPoliticalSystem(PoliticalSystem polSystem) {
		this.politicalSystem = polSystem;
	}

	public ResourceType getResourceType() {
		return resourceType;
	}

	public void setResourceType(ResourceType resType) {
		this.resourceType = resType;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void determineEvent()
	{
		if (Randomizer.determineSuccess(eventProbability))
			event=(Event) Randomizer.randEnum(Event.class);
		else
			event=Event.NO_EVENT;
	}
	
}
