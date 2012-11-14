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

    private FileChooserListener fileChooserListener;

    public LoaderListener(JTextField filePath, FileChooserListener fileChooserListener) {
        this.filePath = filePath;
        this.fileChooserListener = fileChooserListener;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Loader_db loader = new Loader_db();
        try {
            loader.LoadGame(fileChooserListener.getDbFile(), UniverseFactory.getPlanetarySystems(),UniverseFactory.getPlanets(),Game.getPlayers());
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
