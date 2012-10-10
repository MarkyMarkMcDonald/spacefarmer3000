package App.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JFormattedTextField;

public class IncrementListener implements ActionListener {
	
	private JFormattedTextField theField;
	private boolean IncType;
	
	public static boolean INC = true, DEC = false;
	
	public IncrementListener(JFormattedTextField theField, boolean IncType) {
		this.theField = theField;
		this.IncType = IncType;
	}

	public void actionPerformed(ActionEvent e) {
		if(Pattern.matches("[0-9]+", theField.getText())) {
			int n = Integer.parseInt(theField.getText());
			theField.setText(n + (IncType?1:(n>0?-1:0)) + "");
		} else {
			theField.setText("0");
		}
	}
}
