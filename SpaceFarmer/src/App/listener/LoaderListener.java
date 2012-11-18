package App.listener;

import App.factory.UniverseFactory;
import App.model.Game;
import App.service.Loader_db;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA. User: mark.mcdonald Date: 11/14/12 Time: 2:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class LoaderListener implements ActionListener {

	private JTextField filePath;

	private FileChooserListener fileChooserListener;

	/**
	 * Set up this LoaderListener object.
	 * 
	 * @param filePath
	 *            The file path to the database file to load.
	 * @param fileChooserListener
	 *            The file chooser that will handle displaying the open file
	 *            dialog.
	 */
	public LoaderListener(JTextField filePath,
			FileChooserListener fileChooserListener) {
		this.filePath = filePath;
		this.fileChooserListener = fileChooserListener;
	}

	/**
	 * Signal to the FileCoohserListener to allow the user to open a file for
	 * loading.
	 * 
	 * @param actionEvent
	 *            the instance of ActionEvent associated with this invocation.
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		Loader_db loader = new Loader_db();
		try {
			loader.LoadGame(fileChooserListener.getDbFile(),
					UniverseFactory.getPlanetarySystems(),
					UniverseFactory.getPlanets(), Game.getPlayers());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "LoadListener";
	}
}
