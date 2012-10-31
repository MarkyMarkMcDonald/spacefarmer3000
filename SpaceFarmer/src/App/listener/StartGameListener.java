package App.listener;

import App.logging.Logger;
import App.model.Game;
import App.model.Player;
import App.service.Randomizer;
import App.view.CardName;
import App.view.Display;
import App.view.StartOfTurnScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * User: marky
 * Date: 10/13/12
 * Time: 6:48 PM
 */
public class StartGameListener extends ContinueListener implements ActionListener {

    public StartGameListener(){
        cardToMoveTo = CardName.START_OF_TURN_CARD;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Make player1 have the first turn
        List<Player> players = Game.getPlayers();
        Player player1 = players.get(0);
        Game.setCurrentPlayer(player1);

        // Make each player start on a random Planet
        for (Player player : players){
            player.setCurrentPlanet(Randomizer.getRandomPlanet());
        }

        // We'll start on turn 1 of round 1
        Game.setNumberOfTurns(1);

        // update the turn Screen
        StartOfTurnScreen startOfTurnScreen = (StartOfTurnScreen) Display.getCard(CardName.START_OF_TURN_CARD.toString());
        startOfTurnScreen.updateTurn();

        this.progressDisplay();
        Logger.printGameToConsole();
    }
}
