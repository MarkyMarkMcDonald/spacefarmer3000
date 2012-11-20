package app.model;

import static app.model.EventFunction.LOSE_FUNCTION;
import static app.model.EventFunction.WIN_FUNCTION;
import app.model.player.Player;

public enum RandomEvent {
	LOSE_ITEM(LOSE_FUNCTION), FIND_ITEM(WIN_FUNCTION);

	/**
	 * EventFunction object holding an event function.
	 */
	private final EventFunction event;

	/**
	 * Constructs a RandomEvent using an EventFunction.
	 * 
	 * @param event
	 *            EventFunction used to create the RandomEvent.
	 */
	private RandomEvent(EventFunction event) {
		this.event = event;
	}

	/**
	 * Calls the method in event on player
	 * 
	 * @param player
	 *            Player on which the method is called.
	 */
	public String giveEvent(Player player) {
		return event.function(player);
	}
}
