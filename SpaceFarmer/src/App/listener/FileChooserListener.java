package App.listener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: mark.mcdonald
 * Date: 11/14/12
 * Time: 1:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class FileChooserListener implements ActionListener{


    private JFileChooser fileChooser;
    private JTextField textField;

    public FileChooserListener(JFileChooser fileChooser, JTextField textField) {
        this.fileChooser = fileChooser;
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int option = fileChooser.showSaveDialog(null);
        if (option == JFileChooser.APPROVE_OPTION){
            textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
        }

    }
}
