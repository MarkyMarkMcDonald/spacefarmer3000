/*This file holds the LoaderListener class*/
package app.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import app.factory.UniverseFactory;
import app.model.Game;
import app.service.Loader_db;

/**
 * Created with IntelliJ IDEA. User: mark.mcdonald Date: 11/14/12 Time: 2:16 AM
 * To change this template use File | Settings | File Templates.
 * 
 * @author Mark
 * @version 1.0
 */
public class LoaderListener implements ActionListener {

	/**
	 * The file path to the database file to load.
	 */
	private final JTextField filePath;

	/**
	 * The file chooser that will handle displaying the open file dialog.
	 */
	private final FileChooserListener fileChooserListener;

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
		final Loader_db loader = new Loader_db();
		try {
			loader.loadGame(fileChooserListener.getDbFile(),
					UniverseFactory.getPlanetarySystems(),
					UniverseFactory.getAllPlanets(), Game.getPlayers());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return Information about this object as a String.
	 */
	@Override
	public String toString() {
		return "LoadListener";
	}
}
