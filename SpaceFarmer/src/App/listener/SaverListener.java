package App.listener;

import App.factory.UniverseFactory;
import App.model.Game;
import App.model.Settings;
import App.service.Saver_db;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: mark.mcdonald
 * Date: 11/14/12
 * Time: 2:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class SaverListener implements ActionListener{

    private JTextField jTextField;

    public SaverListener(JTextField jTextField) {
        this.jTextField = jTextField;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Saver_db saver = new Saver_db(jTextField.getText(), jTextField.getText(), Game.getPlayers(), UniverseFactory.getPlanets().values(),new Settings(), new Game());
        try {
            saver.SaveGame();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
