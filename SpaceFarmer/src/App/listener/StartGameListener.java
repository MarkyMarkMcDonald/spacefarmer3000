package App.listener;

import App.factory.PlanetFactory;
import App.model.Game;
import App.model.Player;
import Conf.ConfigReader;
import App.view.CardName;
import Conf.GameVariables;
import Conf.PlanetNames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

/**
 * User: marky
 * Date: 10/13/12
 * Time: 6:48 PM
 */
public class StartGameListener extends ContinueListener implements ActionListener {

    public StartGameListener(){
        cardToMoveTo = CardName.TEMPORARY_SCREEN_CARD;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        List<String> planetNames = PlanetNames.getPlanetNamesAsList();

        // Create all the planets
        PlanetFactory.createPlanets(planetNames, GameVariables.xDimension, GameVariables.yDimension, GameVariables.yDimension);

        // Make player1 have the first turn
        Player player1 = Game.getPlayers().get(0);
        Game.setCurrentPlayer(player1);

        this.progressDisplay();
    }
}
