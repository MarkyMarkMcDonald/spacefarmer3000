package App.view.SidePanels;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: mark.mcdonald
 * Date: 11/9/12
 * Time: 1:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class MessageSidePanel extends SidePanel{
	
    private JLabel message;
    
    private String baseMessage;
    
    private int count;

    public MessageSidePanel(){
        baseMessage = "";
        message = new JLabel();
        add(message);
        this.setVisible(false);
    }

    public void addToMessage(String addenum){
        baseMessage += addenum;
        message.setText(baseMessage);
    }

    /**
     * Changes the message. If this is the same message as last time, it will display a count of how many times
     * it's been displayed in a row
     * @param message
     * @param type
     */
    public void setMessage(String message, MessageType type){
        if (baseMessage.equals(message)){
            count++;
        } else {
            count = 1;
        }

        this.baseMessage = message;
        if (count > 1) {
            message += " (" + Integer.toString(count) + ")";
        }
        this.message.setText(message);

        switch (type){
            case GOOD:
                this.message.setBackground(Color.green);
                this.setBackground(Color.green);
                break;
            case BAD:
                this.message.setBackground(Color.orange);
                this.setBackground(Color.orange);
                break;
            case ERROR:
                this.message.setBackground(Color.red);
                this.setBackground(Color.red);
                break;

        }
        this.message.setForeground(Color.white);

        this.setVisible(true);
    }

}
