package App.model;


public enum RandomEvent {
	
	LOSE_ITEM(EventFunction.loseFunction),
	FIND_ITEM(EventFunction.winFunction);

	private EventFunction event;

	private RandomEvent(EventFunction event) {
		this.event = event;
	}

	public void giveEvent(Player player)
	{
		event.function(player);
	}
	

}
