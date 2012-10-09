package App.view;

import java.awt.Component;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomeScreen extends JPanel {
	/**
	 * Prevents "serializable" warning
	 */
	private static final long serialVersionUID = -4701770682971357648L;

	public WelcomeScreen() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		Component TitleStrut1 = Box.createVerticalStrut(40);
        add(TitleStrut1);

        JLabel WelcomeLabel1 = new JLabel("Space");
        WelcomeLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
        WelcomeLabel1.setAlignmentY(0.0f);
        WelcomeLabel1.setFont(new Font("Tahoma", Font.BOLD, 40));
        add(WelcomeLabel1);

        Component TitleStrut2 = Box.createVerticalStrut(40);
        add(TitleStrut2);

        JLabel WelcomeLabel2 = new JLabel("Farmer");
        WelcomeLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        WelcomeLabel2.setAlignmentY(0.0f);
        WelcomeLabel2.setFont(new Font("Tahoma", Font.BOLD, 40));
        add(WelcomeLabel2);

        Component TitleStrut3 = Box.createVerticalStrut(40);
        add(TitleStrut3);

        JLabel WelcomeLabel3 = new JLabel("3000");
        WelcomeLabel3.setAlignmentX(Component.CENTER_ALIGNMENT);
        WelcomeLabel3.setAlignmentY(0.0f);
        WelcomeLabel3.setFont(new Font("Tahoma", Font.BOLD, 40));
        add(WelcomeLabel3);

        Component TitleStrut4 = Box.createVerticalStrut(40);
        add(TitleStrut4);

        JPanel WelcomeButtonPanel = new JPanel();
        add(WelcomeButtonPanel);

        JButton AboutButton = new JButton("    About    ");
        WelcomeButtonPanel.add(AboutButton);

        Component ButtonStrut1 = Box.createHorizontalStrut(50);
        WelcomeButtonPanel.add(ButtonStrut1);

        JButton NewGameButton = new JButton(" New Game");
        WelcomeButtonPanel.add(NewGameButton);

        Component ButtonStrut2 = Box.createHorizontalStrut(50);
        WelcomeButtonPanel.add(ButtonStrut2);

        JButton LoadGameButton = new JButton("Load Game");
        WelcomeButtonPanel.add(LoadGameButton);
	}
}
