package App.listener;

import App.factory.PlanetFactory;
import App.job.ConfigReader;
import App.view.CardName;

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
        List<String> planetNames = ConfigReader.parseFileToStrings("src/Conf/planetNames.txt");
        Map<String,Integer> gameVariables = ConfigReader.parseFileToMap("src/Conf/gameVariables.txt");
        // Create all the planets
        PlanetFactory.createPlanets(planetNames, gameVariables.get("xDimension"), gameVariables.get("xDimension"), gameVariables.get("numberPlanets") );

        // Make player1 have the first turn



        this.progressDisplay();
    }
}
