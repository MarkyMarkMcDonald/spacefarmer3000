package app.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JTextField;

/**
 * Created with IntelliJ IDEA. User: mark.mcdonald Date: 11/14/12 Time: 1:52 AM
 * To change this template use File | Settings | File Templates.
 * 
 * @author Mark
 * @version 1.0
 */
public class FileChooserListener implements ActionListener {

	/**
	 * JFileChooser associated with this listener.
	 */
	private final JFileChooser fileChooser;

	/**
	 * The text field to which resulting diagnostics will be printed.
	 */
	private final JTextField textField;

	/**
	 * The game save database to be opened by this Listener.
	 */
	private File dbFile;

	/**
	 * Set up this FileChooserListener object.
	 * 
	 * @param fileChooser
	 *            The JFileChooser to activate upon actionPerformed invocation.
	 * @param textField
	 *            The text field to which resulting diagnostics will be printed.
	 */
	public FileChooserListener(JFileChooser fileChooser, JTextField textField) {
		this.fileChooser = fileChooser;
		this.textField = textField;
	}

	/**
	 * Show the open file dialog, and display diagnostic information pertaining
	 * to the attempt to open a file.
	 * 
	 * @param actionEvent
	 *            the instance of ActionEvent associated with this invocation.
	 */

	public void actionPerformed(ActionEvent actionEvent) {
		final int option = fileChooser.showSaveDialog(null);
		if (option == JFileChooser.APPROVE_OPTION) {
			textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
			dbFile = fileChooser.getSelectedFile();
		}
	}

	/**
	 * @return The game save database that was opened by this Listener.
	 */
	public File getDbFile() {
		return dbFile;
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "FileChooserListener";
	}
}
