package App.util;

import App.factory.UniverseFactory;
import App.model.Game;
import App.model.Settings;
import App.view.Display;
import Conf.GameVariables;
import Conf.PlanetNames;
import Conf.SystemNames;

import java.awt.*;

public class Driver {


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // There is a singleton Game (holds all information) and Display (Holds all the views and the layout configuration)s.
                    Display frame = new Display();
                    frame.setVisible(true);
                    Game game = new Game();
                    game.setSettings(new Settings());
                    Display.setGame(game);
                    UniverseFactory.createUniverse(PlanetNames.getPlanetNamesAsList(), SystemNames.getSystemNamesAsList(), GameVariables.numPlanets, GameVariables.numPlanetarySystems, GameVariables.systemRows, GameVariables.systemColumns, GameVariables.universeRows, GameVariables.universeColumns, GameVariables.quadrantXDimension, GameVariables.quadrantYDimension);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
