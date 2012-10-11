package App.view;

import App.model.Game;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * This class controls the viewing pane. The different screens are controlled
 * by components that use the instance of this Display as a parameter to link
 * to the changeCard() method.
 * @author Mark McDonald, Andrew Wilder
 */
public class Display extends JFrame {

    /**
	 * Prevents "serializable" warning
	 */
	private static final long serialVersionUID = 5472341215748317058L;

	public Display() {
		this.setup();
	}

    private static JPanel CenterPanel;
    private static Game game;

    /**
     * set up the initial screen
     */
    public void setup() {
        setTitle("SpaceFarmer 3000");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        JPanel mainContentPanel = new JPanel();
        mainContentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
        mainContentPanel.setLayout(new BorderLayout(0, 0));
        
        setContentPane(mainContentPanel);

        JPanel TopPanel = new JPanel();
        TopPanel.setBackground(Color.GREEN);
        mainContentPanel.add(TopPanel, BorderLayout.NORTH);
        TopPanel.setLayout(new BoxLayout(TopPanel, BoxLayout.X_AXIS));

        JLabel lblWip = new JLabel("WIP");
        TopPanel.add(lblWip);

        Component verticalStrut = Box.createVerticalStrut(80);
        TopPanel.add(verticalStrut);

        JPanel BottomPanel = new JPanel();
        BottomPanel.setBackground(Color.MAGENTA);
        mainContentPanel.add(BottomPanel, BorderLayout.SOUTH);
        BottomPanel.setLayout(new BoxLayout(BottomPanel, BoxLayout.X_AXIS));

        JLabel label_1 = new JLabel("WIP");
        BottomPanel.add(label_1);

        Component verticalStrut_1 = Box.createVerticalStrut(80);
        BottomPanel.add(verticalStrut_1);

        JPanel LeftPanel = new JPanel();
        LeftPanel.setBackground(Color.CYAN);
        mainContentPanel.add(LeftPanel, BorderLayout.WEST);
        LeftPanel.setLayout(new BoxLayout(LeftPanel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("WIP");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setAlignmentY(0.0f);
        LeftPanel.add(label);

        Component horizontalStrut = Box.createHorizontalStrut(100);
        LeftPanel.add(horizontalStrut);

        JPanel RightPanel = new JPanel();
        RightPanel.setBackground(Color.PINK);
        mainContentPanel.add(RightPanel, BorderLayout.EAST);
        RightPanel.setLayout(new BoxLayout(RightPanel, BoxLayout.Y_AXIS));

        JLabel label_2 = new JLabel("WIP");
        label_2.setAlignmentX(Component.CENTER_ALIGNMENT);
        label_2.setAlignmentY(0.0f);
        RightPanel.add(label_2);

        Component horizontalStrut_1 = Box.createHorizontalStrut(100);
        RightPanel.add(horizontalStrut_1);

        CenterPanel = new JPanel();
        CenterPanel.setBackground(Color.ORANGE);
        mainContentPanel.add(CenterPanel, BorderLayout.CENTER);
        CenterPanel.setLayout(new CardLayout(0, 0));


        // Generate every possible card
        for (CardName name : CardName.values()){
            CenterPanel.add(name.getScreen(), name.toString());
        }

    }
    
    /**
     * Flips to the specified card in the center panel.
     * @param cardID The card ID of the panel to flip to.
     */
    public static void changeCard(String cardID) {
    	((CardLayout)CenterPanel.getLayout()).show(CenterPanel, cardID);
    }

    //--Accessors and Modifiers

    public static Game getGame() {
        return game;
    }

    public static void setGame(Game game) {
        Display.game = game;
    }

    public static JPanel getCenterPanel() {
        return CenterPanel;
    }

}
