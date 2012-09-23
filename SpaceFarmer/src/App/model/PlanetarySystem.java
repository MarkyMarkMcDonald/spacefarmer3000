package App.model;

/**
 * Created with IntelliJ IDEA.
 * User: Marky
 * Date: 9/22/12
 * Time: 12:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class PlanetarySystem {

    private String name;

    private Map<Planet> planets;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(Map<Planet> planets) {
        this.planets = planets;
    }
}
