package App.view;

import App.listener.FileChooserListener;
import App.listener.LoaderListener;
import App.listener.SaverListener;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Created with IntelliJ IDEA.
 * User: mark.mcdonald
 * Date: 11/14/12
 * Time: 1:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class SaveAndLoad extends Screen {

    public SaveAndLoad(){

        name = CardName.SAVING_AND_LOADING_CARD;

        JTextField filePath = new JTextField();
        filePath.setColumns(24);
        add(filePath);

        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("sql lite","sql");
        fileChooser.setFileFilter(fileNameExtensionFilter);

        FileChooserListener fileChooserListener = new FileChooserListener(fileChooser, filePath);
        LoaderListener loaderListener = new LoaderListener(filePath);
        SaverListener saverListener = new SaverListener(filePath);

        JButton choose = new JButton("Choose File");
        choose.addActionListener(fileChooserListener);
        JButton load = new JButton("Load");
        load.addActionListener(loaderListener);
        JButton save = new JButton("Save");
        save.addActionListener(saverListener);

        add(choose);
        add(load);
        add(save);


    }
}
