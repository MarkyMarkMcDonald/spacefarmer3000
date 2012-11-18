package App.service;

import App.model.Game;

/**
 * Created with IntelliJ IDEA. User: mark.mcdonald Date: 11/14/12 Time: 3:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class TurnService {

	public static void advanceTurn() {
		Game.setNumberOfTurns(Game.getTurnNumber() + 1);
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "TurnService";
	}
}
