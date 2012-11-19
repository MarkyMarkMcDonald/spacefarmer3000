package App.listener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created with IntelliJ IDEA. User: mark.mcdonald Date: 11/14/12 Time: 1:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class FileChooserListener implements ActionListener {

	private JFileChooser fileChooser;

	private JTextField textField;

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
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		int option = fileChooser.showSaveDialog(null);
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
