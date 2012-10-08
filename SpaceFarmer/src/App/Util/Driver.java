package App.Util;

import App.model.Game;
import App.view.Display;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class Driver {


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Display frame = new Display();
                    frame.setVisible(true);
                    frame.setGame(new Game());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
