/*This file holds the SaverListener class*/
package app.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import app.factory.UniverseFactory;
import app.model.Game;
import app.model.Settings;
import app.service.Saver_db;

/**
 * Created with IntelliJ IDEA. User: mark.mcdonald Date: 11/14/12 Time: 2:16 AM
 * To change this template use File | Settings | File Templates.
 * @author Mark
 * @version 1.0
 */
public class SaverListener implements ActionListener {

	/**
	 * The file path to the database file to save the game data in.
	 */
	private final JTextField jTextField;

	/**
	 * The listener which will handle showing a save file dialog to the player.
	 */
	private final FileChooserListener fileChooserListener;

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
		//Player[] tempP=new Player[Game.getPlayers().size()];
		//System.out.println(Game.getPlayers().toArray());
		//tempP=(Player[]) Game.getPlayers().toArray();
		//Planet[] tempPlan=new Planet[UniverseFactory.getPlanets().size()];
		//tempPlan=(Planet[]) UniverseFactory.getPlanets().values().toArray();
		final Saver_db saver = new Saver_db(fileChooserListener.getDbFile(),
				Game.getPlayers(), UniverseFactory.getAllPlanets(),
				new Settings(), new Game());
		try {
			saver.saveGame();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return Information about this object as a String.
	 */
	@Override
	public String toString() {
		return "SaverListener";
	}
}
