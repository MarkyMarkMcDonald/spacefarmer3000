package App.util;

import App.model.Game;
import App.view.Display;
import java.awt.EventQueue;

public class Driver {


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Display frame = new Display();
                    frame.setVisible(true);
                    frame.setGame(new Game());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
