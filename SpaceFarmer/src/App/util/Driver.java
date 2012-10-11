package App.util;

import App.model.Game;
import App.view.Display;
import java.awt.EventQueue;
import App.util.Settings;

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

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
