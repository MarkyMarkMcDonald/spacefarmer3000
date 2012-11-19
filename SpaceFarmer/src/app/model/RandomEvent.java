package App.model;

import App.model.Player.Player;

public enum RandomEvent {
	LOSE_ITEM(EventFunction.LoseFunction), FIND_ITEM(EventFunction.WinFunction);

	private EventFunction event;

	private RandomEvent(EventFunction event) {
		this.event = event;
	}

	public void giveEvent(Player player) {
		event.function(player);
	}
}
