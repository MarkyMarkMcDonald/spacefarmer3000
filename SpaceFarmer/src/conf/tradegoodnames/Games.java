/*This files holds an enum containing names for Games*/
package conf.tradegoodnames;

/**
 * User: marky Date: 10/22/12 Time: 2:23 PM
 */
public enum Games {

	BOARD_GAMES("Board Games"), VIDEO_GAMES("Video Games"), SIDEWALK_CHALK(
			"Sidewalk Chalk");

	/**
	 * Name of the Game.
	 */
	private final String name;

	/**
	 * @return The name of the enumeration.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Create a Game using its name.
	 * @param name The Game's name.
	 */
	private Games(String name) {
		this.name = name;
	}

	/**
	 * @return Name of the Game.
	 */
	public String toString() {
		return name;
	}
}
