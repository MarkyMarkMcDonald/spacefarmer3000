package App.listener;

import App.factory.UniverseFactory;
import App.model.Game;
import App.service.Loader_db;

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
public class LoaderListener implements ActionListener {

    private JTextField filePath;

    public LoaderListener(JTextField filePath) {
        this.filePath = filePath;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Loader_db loader = new Loader_db();
        try {
            loader.LoadGame(filePath.getText(), UniverseFactory.getPlanetarySystems(),UniverseFactory.getPlanets(),Game.getPlayers());
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
