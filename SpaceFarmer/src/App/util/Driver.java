package App.util;

import App.factory.PlanetFactory;
import App.model.Game;
import App.model.Settings;
import App.view.Display;
import Conf.GameVariables;
import Conf.PlanetNames;

import java.awt.EventQueue;

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
                    PlanetFactory.createPlanets(PlanetNames.getPlanetNamesAsList(), GameVariables.quadrantXDimension, GameVariables.quadrantYDimension, GameVariables.numPlanets);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
