package App.model.Universe;

/**
 * Created with IntelliJ IDEA.
 * User: Marky
 * Date: 9/22/12
 * Time: 12:31 AM
 * To change this template use File | Settings | File Templates.
 */
public enum PoliticalSystem {
	ANARCHY ("Anarchy"),
	CAPITALIST_STATE ("Capitalist State"),
	COMMUNIST_STATE ("Communist State"),
	CONFEDERACY ("Confederacy"),
	CORPORATE_STATE ("Corporate State"),
	CYBERNETIC_STATE ("Cybernetic State"),
	DEMOCRACY ("Democracy"),
	DICTATORSHIP ("Dictatorship"),
	FASCIST ("Fascist"),
	FEUDAL_STATE ("Feudal State"),
	MILITARY_STATE ("Military State"),
	MONARCHY ("Monarchy"),
	PACIFIST_STATE ("Pacifist State"),
	SOCIALIST_STATE ("Socialist State"),
	TECHNOCRACY ("Technocracy"),
	THEOCRACY ("Theocracy");
	
	
	
	private PoliticalSystem(String name) {
		this.name = name;
	}

	private String name;
	
	public String getName() {
		return name;
	}
	
	
}
