package App.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: mark.mcdonald
 * Date: 11/6/12
 * Time: 12:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class HeadingPanel extends JPanel {
    public HeadingPanel(String first, String second, String third, String fourth){
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        setAlignmentY(Component.TOP_ALIGNMENT);
        setPreferredSize(new Dimension(480, 30));

        Component horizontalStrut1 = Box.createHorizontalStrut(100);
        add(horizontalStrut1);

        JLabel lblItem = new JLabel(first);
        lblItem.setHorizontalAlignment(JLabel.CENTER);
        add(lblItem);

        Component horizontalStrut2 = Box.createHorizontalStrut(85);
        add(horizontalStrut2);

        JLabel lblBuyingPrice = new JLabel(second);
        lblBuyingPrice.setHorizontalAlignment(JLabel.CENTER);
        add(lblBuyingPrice);

        Component horizontalStrut3 = Box.createHorizontalStrut(50);
        add(horizontalStrut3);

        JLabel lblAvailable = new JLabel(third);
        lblAvailable.setHorizontalAlignment(JLabel.CENTER);
        add(lblAvailable);

        Component horizontalStrut4 = Box.createHorizontalStrut(40);
        add(horizontalStrut4);

        JLabel lblToBuy = new JLabel(fourth);
        add(lblToBuy);

        Component horizontalStrut5 = Box.createHorizontalStrut(230);
        add(horizontalStrut5);
    }
}