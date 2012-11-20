package app.model;

import static app.model.EventFunction.LOSE_FUNCTION;
import static app.model.EventFunction.WIN_FUNCTION;
import app.model.Player.Player;

public enum RandomEvent {
	LOSE_ITEM(LOSE_FUNCTION), FIND_ITEM(WIN_FUNCTION);

	private EventFunction event;

	private RandomEvent(EventFunction event) {
		this.event = event;
	}

	public void giveEvent(Player player) {
		event.function(player);
	}
}
