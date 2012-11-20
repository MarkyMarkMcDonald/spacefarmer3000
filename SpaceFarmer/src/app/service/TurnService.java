package app.service;

import app.model.Game;

/**
 * Created with IntelliJ IDEA. User: mark.mcdonald Date: 11/14/12 Time: 3:06 AM
 * To change this template use File | Settings | File Templates.
 * 
 * @author Mark
 * @version 1.0
 */
public class TurnService {

	/**
	 * Increments the Game's turn.
	 */
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
