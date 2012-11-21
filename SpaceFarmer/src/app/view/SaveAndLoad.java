/* This file holds the SaveAndLoad class, which represents
 * the saving and loading screen.
 */
package app.view;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import app.listener.FileChooserListener;
import app.listener.LoaderListener;
import app.listener.SaverListener;

/**
 * Created with IntelliJ IDEA. User: mark.mcdonald Date: 11/14/12 Time: 1:05 AM
 * To change this template use File | Settings | File Templates.
 * @author Mark
 * @version 1.0
 */
public class SaveAndLoad extends Screen {

	/**
	 * Columns in the file path.
	 */
	private static final int FILE_PATH_COLUMNS = 24;
	
	/**
	 * Constructs a new SaveAndLoad by adding the
	 * appropriate buttons, filechoosers, listeners, etc.
	 */
	public SaveAndLoad() {

		name = CardName.SAVING_AND_LOADING_CARD;

		final JTextField filePath = new JTextField();
		filePath.setColumns(FILE_PATH_COLUMNS);
		add(filePath);

		final JFileChooser fileChooser = new JFileChooser();
		final FileNameExtensionFilter fileNameExtensionFilter = 
				new FileNameExtensionFilter(
				"sql lite", "sql");
		fileChooser.setFileFilter(fileNameExtensionFilter);

		final FileChooserListener fileChooserListener = new FileChooserListener(
				fileChooser, filePath);
		final LoaderListener loaderListener = new LoaderListener(filePath,
				fileChooserListener);
		final SaverListener saverListener = new SaverListener(filePath,
				fileChooserListener);

		final JButton choose = new JButton("Choose File");
		choose.addActionListener(fileChooserListener);
		final JButton load = new JButton("Load");
		load.addActionListener(loaderListener);
		final JButton save = new JButton("Save");
		save.addActionListener(saverListener);

		add(choose);
		add(load);
		add(save);

	}
}
