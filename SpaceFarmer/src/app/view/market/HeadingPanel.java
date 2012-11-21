// $codepro.audit.disable staticMemberAccess

/* staticMemberAccess is disabled for this file because each instance of this violation
 * is a natural use of static constant access used in constructing swing containers.
 */

/*This files holds the class HeadingPanel, which heads
 * the market views.
 */
package app.view.market;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Created with IntelliJ IDEA. User: mark.mcdonald Date: 11/6/12 Time: 12:14 AM
 * To change this template use File | Settings | File Templates.
 * 
 * @author Mark
 * @version 1.0
 */
public class HeadingPanel extends JPanel {

	/**
	 * Maximum width of HeadingPanel
	 */
	private static final int MAX_WIDTH = 500;
	
	/**
	 * Maximum height of HeadingPanel
	 */
	private static final int MAX_HEIGHT = 30;
	
	/**
	 * Amount for first horizontal strut.
	 */
	private static final int FIRST_STRUT = 35;
	
	/**
	 * Amount for second horizontal strut.
	 */
	private static final int SECOND_STRUT = 50;
	
	/**
	 * Amount for third horizontal strut.
	 */
	private static final int THIRD_STRUT = 30;
	
	/**
	 * Amount for fourth horizontal strut.
	 */
	private static final int FOURTH_STRUT = 35;
	
	/**
	 * Amount for fifth horizontal strut.
	 */
	private static final int FIFTH_STRUT = 220;
	
	/**
	 * Creates a HeadingPanel from four Strings.
	 * 
	 * @param first
	 *            First String.
	 * @param second
	 *            Second String.
	 * @param third
	 *            Third String.
	 * @param fourth
	 *            Fourth String.
	 */
	public HeadingPanel(String first, String second, String third, String fourth) {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setAlignmentY(Component.TOP_ALIGNMENT);
		setMaximumSize(new Dimension(MAX_WIDTH, MAX_HEIGHT));
		final Component horizontalStrut1 = Box.createHorizontalStrut(FIRST_STRUT);
		add(horizontalStrut1);

		final JLabel lblItem = new JLabel(first);
		lblItem.setHorizontalAlignment(JLabel.CENTER);
		add(lblItem);

		final Component horizontalStrut2 = Box.createHorizontalStrut(SECOND_STRUT);
		add(horizontalStrut2);

		final JLabel lblBuyingPrice = new JLabel(second);
		lblBuyingPrice.setHorizontalAlignment(JLabel.CENTER);
		add(lblBuyingPrice);

		final Component horizontalStrut3 = Box.createHorizontalStrut(THIRD_STRUT);
		add(horizontalStrut3);

		final JLabel lblAvailable = new JLabel(third);
		lblAvailable.setHorizontalAlignment(JLabel.CENTER);
		add(lblAvailable);

		final Component horizontalStrut4 = Box.createHorizontalStrut(FOURTH_STRUT);
		add(horizontalStrut4);

		final JLabel lblToBuy = new JLabel(fourth);
		add(lblToBuy);

		final Component horizontalStrut5 = Box.createHorizontalStrut(FIFTH_STRUT);
		add(horizontalStrut5);
	}
}
