package App.model;

/**
 * Created with IntelliJ IDEA.
 * User: Marky
 * Date: 9/22/12
 * Time: 12:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class Planet {
    private String name;

	private TechnologyLevel techLevel;

	private PoliticalSystem polSystem;

    private ResourceType resType;

    private int x,y;

	public void setName(String name) {
		this.name = name;
	}

	public Planet(){

    }

	public Planet(String name,TechnologyLevel techLevel, PoliticalSystem polSystem,
			ResourceType resType, int x, int y) {
		super();
		this.name=name;
		this.techLevel = techLevel;
		this.polSystem = polSystem;
		this.resType = resType;
		this.x = x;
		this.y = y;
	}

    public String getName() {
        return name;
    }

	public TechnologyLevel getTechnologyLevel() {
		return techLevel;
	}

	public void setTechnologyLevel(TechnologyLevel techLevel) {
		this.techLevel = techLevel;
	}

	public PoliticalSystem getPoliticalSystem() {
		return polSystem;
	}

	public void setPoliticalSystem(PoliticalSystem polSystem) {
		this.polSystem = polSystem;
	}

	public ResourceType getResourceType() {
		return resType;
	}

	public void setResourceType(ResourceType resType) {
		this.resType = resType;
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
	
	
	
}
