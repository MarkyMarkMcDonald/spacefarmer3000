package App.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Font;

public class TemporaryScreen extends JPanel {

	/**
	 * Create the panel.
	 */
	public TemporaryScreen() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel lblYouCreatedA = new JLabel("You created a player!");
		lblYouCreatedA.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblYouCreatedA.setAlignmentY(Component.TOP_ALIGNMENT);
		lblYouCreatedA.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblYouCreatedA);
		
		JLabel lblThisIsA = new JLabel("This is a temporary screen.");
		lblThisIsA.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThisIsA.setAlignmentY(0.0f);
		lblThisIsA.setAlignmentX(0.5f);
		add(lblThisIsA);
		
		JLabel lblItWillBe = new JLabel("It will be removed after M5.");
		lblItWillBe.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblItWillBe.setAlignmentY(0.0f);
		lblItWillBe.setAlignmentX(0.5f);
		add(lblItWillBe);

	}

}
