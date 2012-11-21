
/*This file holds the MessageSidePanel class, which represents
 * SidePanels holding messages.
 */
package app.view.sidepanels;

import java.awt.Color;

import javax.swing.JLabel;

/**
 * Created with IntelliJ IDEA. User: mark.mcdonald Date: 11/9/12 Time: 1:19 PM
 * To change this template use File | Settings | File Templates.
 * @author Mark
 * @version 1.0
 */
public class MessageSidePanel extends SidePanel {

	/**
	 * JLabel holding the message for the panel.
	 */
	private final JLabel message;

	/**
	 * String holding the message for the label.
	 */
	private String baseMessage;

	/**
	 * field used for functionality of setMessage.
	 */
	private int count;

	/**
	 * Constructs a MessageSidePanel using default values.
	 */
	public MessageSidePanel() {
		baseMessage = "";
		message = new JLabel();
		add(message);
		this.setVisible(false);
	}

	/**
	 * Adds to the displayed message. 
	 * @param addenum String to add to the message.
	 */
	public void addToMessage(String addenum) {
		baseMessage += addenum;
		message.setText(baseMessage);
	}

	/**
	 * Changes the message. If this is the same message as last time, it will
	 * display a count of how many times it's been displayed in a row
	 * 
	 * @param message String to set the message to.
	 * @param type Enumeration indicating the type of message.
	 */
	public void setMessage(String message, MessageType type) {
		if (baseMessage.equals(message)) {
			count++;
		} else {
			count = 1;
		}

		this.baseMessage = message;
		if (count > 1) {
			message += " (" + Integer.toString(count) + ")"; // $codepro.audit.disable questionableAssignment
		}
		this.message.setText(message);

		switch (type) {
		case GOOD:
			this.message.setBackground(Color.green);
			this.setBackground(Color.green);
			break;
		case BAD:
			this.message.setBackground(Color.orange);
			this.setBackground(Color.orange);
			break;
		case CRITICAL:
		case ERROR:
			this.message.setBackground(Color.red);
			this.setBackground(Color.red);
			break;
		default:
			this.message.setBackground(Color.green);
			this.setBackground(Color.green);
			break;

		}
		this.message.setForeground(Color.white);

		this.setVisible(true);
	}

}
