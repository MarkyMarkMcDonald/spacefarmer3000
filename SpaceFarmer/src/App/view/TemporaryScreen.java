package App.view;

import javax.swing.*;
import java.awt.*;

/**
 * User: marky Date: 10/13/12 Time: 6:55 PM
 */

// TODO Remove this screen from the project!
// It's no longer needed now that M5 has passed.

public class TemporaryScreen extends Screen {
	public TemporaryScreen() {
		name = CardName.TEMPORARY_SCREEN_CARD;

		JLabel lblThisIsA = new JLabel("This is a temporary screen.");
		lblThisIsA.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThisIsA.setAlignmentY(0.0f);
		lblThisIsA.setAlignmentX(0.5f);
		add(lblThisIsA);
	}
}
