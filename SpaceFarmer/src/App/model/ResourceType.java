

package App.model;

public enum ResourceType {
	
	NOSPECIALRESOURCES ("No Special Resources"),
	MINERALRICH ("Mineral Rich"),
	DESERT ("Desert"),
	LOTSOFWATER ("Lots of Water"),
	RICHSOIL ("Rich Soil"),
	POORSOIL ("Poor Soil"),
	RICHFAUNA ("Rich Fauna"),
	LIFELESS ("Lifeless"),
	WEIRDMUSHROOMS ("Weird Mushrooms"),
	LOTSOFHERBS ("Lots of Herbs"),
	ARTISTIC ("Artistic"),
	WARLIKE ("Warlike");
	
	private String name;

	
	private ResourceType(String name) {
		this.name = name;
	}


	public String getName() {
		return name;
	}
	

}
