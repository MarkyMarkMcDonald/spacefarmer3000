package App.view;

import App.model.Game;
import App.model.Player;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 *
 * User: marky
 * Date: 10/7/12
 * Time: 4:48 PM
 */
public class Display extends JFrame {

    /**
	 * Prevents "serializable" warning
	 */
	private static final long serialVersionUID = 5472341215748317058L;

	public Display() {
		this.setup();
	}

    private JPanel mainContentPanel;
    private static JPanel CenterPanel;
    private Game game;

    /**
     * set up the initial screen
     */
    public void setup() {
        setTitle("SpaceFarmer 3000");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        mainContentPanel = new JPanel();
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

        JPanel wScr = new WelcomeScreen(this);
        CenterPanel.add(wScr, "WelcomeCard");
        
        JPanel pInf = new PlayerInformation(this);
        CenterPanel.add(pInf, "PlayerInformationCard");
        
        JPanel tScr = new TemporaryScreen(this);
        CenterPanel.add(tScr, "TemporaryScreenCard");
    }
    
    /**
     * Flips to the specified card in the center panel.
     * @param cardID The card ID of the panel to flip to.
     */
    public void changeCard(String cardID) {
    	((CardLayout)CenterPanel.getLayout()).show(CenterPanel, cardID);
    }

    //--Accessors and Modifiers

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    /* Why do we need getters and setters for this?
    public JPanel setMainContentPanel() {
        return mainContentPanel;
    }

    public void setMainContentPanel(JPanel newContentPanel) {
        this.mainContentPanel = newContentPanel;
    }*/

    public JPanel getCenterPanel() {
        return CenterPanel;
    }

    public void setCenterPanel(JPanel centerPanel) {
        CenterPanel = centerPanel;
    }
}
