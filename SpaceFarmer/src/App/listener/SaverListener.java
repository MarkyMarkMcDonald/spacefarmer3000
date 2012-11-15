package app.listener;

import app.factory.UniverseFactory;
import app.model.Game;
import app.model.Settings;
import app.service.Saver_db;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA. User: mark.mcdonald Date: 11/14/12 Time: 2:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class SaverListener implements ActionListener {

	private JTextField jTextField;

	private FileChooserListener fileChooserListener;

	/**
	 * Set up this SaverListener object.
	 * 
	 * @param jTextField
	 *            The file path to the database file to save the game data in.
	 * @param fileChooserListener
	 *            The listener which will handle showing a save file dialog to
	 *            the player.
	 */
	public SaverListener(JTextField jTextField,
			FileChooserListener fileChooserListener) {
		this.jTextField = jTextField;
		this.fileChooserListener = fileChooserListener;
	}

	/**
	 * Show the save file dialog to the user.
	 * 
	 * @param actionEvent
	 *            The instance of ActionEvent associated with this invocation.
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		Saver_db saver = new Saver_db(fileChooserListener.getDbFile(),
				Game.getPlayers(), UniverseFactory.getPlanets().values(),
				new Settings(), new Game());
		try {
			saver.SaveGame();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "SaverListener";
	}
}
