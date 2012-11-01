package App.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import App.model.Game;

public class EndTurnListener implements ActionListener{

	private Game game;
	public EndTurnListener(Game game)
	{
		this.game=game;
	}
	public void actionPerformed(ActionEvent event)
	{
		game.endTurn();
	}
}
