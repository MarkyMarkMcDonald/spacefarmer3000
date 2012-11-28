// $codepro.audit.disable assignmentToNonFinalStatic

/* assignmentToNonFinalStatic is disabled for this file because Display acts as a
 * singleton, so assigning to static members within a non-static context is okay since
 * instance variables and static members are synonymous.
 */

/** 
 * This file holds the class Display, which is the display
 * for SpaceFarmer3000
 */
package app.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.model.Game;
import app.model.universe.Planet;
import app.view.sidepanels.MessageSidePanel;
import app.view.sidepanels.MessageType;
import app.view.sidepanels.NavigationSidePanel;
import app.view.sidepanels.PlayersInformationSidePanel;
import app.view.sidepanels.TravelSidePanel;

/**
 * This class controls the viewing pane. The different screens are controlled by
 * components that use the instance of this Display as a parameter to link to
 * the changeCard() method.
 * 
 * @author Mark McDonald, Andrew Wilder
 * @version 1.0
 * 
 */
public class Display extends JFrame {

	/**
	 * X positions for the bounds of the Display.
	 */
	private static final int BOUNDS_X = 100;
	
	/**
	 * Y positions for the bounds of the Display.
	 */
	private static final int BOUNDS_Y = 100;
	
	/**
	 * Width of the Display.
	 */
	private static final int BOUNDS_WIDTH = 1600;
	
	/**
	 * Height of the Display.
	 */
	private static final int BOUNDS_HEIGHT = 900;
	
	/**
	 * Length for the Horizontal Strut
	 */
	private static final int HORIZONTAL_STRUT_LENGTH = 100;

	/**
	 * Color for the Background of the side panels.
	 */
	private static final Color BACKGROUND_COLOR = new Color(205, 201, 205);
	
	/**
	 * Prevents "serializable" warning
	 */
	private static final long serialVersionUID = 5472341215748317058L;

	/**
	 * Constructs a Display by Calling a method to setup the Display.
	 */
	public Display() {
		this.setup();
	}

	/**
	 * Panels on the Display.
	 */
	private static JPanel CenterPanel = null, MainContentPanel = null;

	/**
	 * Game associated with the Display.
	 */
	private static Game Game = null;

	/**
	 * MiniGameScreen associated with the Display.
	 */
	private static MiniGameScreen MiniGameView = null;

	// We need this to be able to update cards instead of creating new ones
	// every time
	/**
	 * Map from the card names to their Screens.
	 */
	private static Map<String, Screen> CardMap = null;

	/**
	 * Map from the SidePanel names to their JPanels.
	 */
	private static Map<String, JPanel> SidePanelMap = null;

	/**
	 * set up the initial screen
	 */
	public final void setup() { // $codepro.audit.disable com.instantiations.assist.eclipse.analysis.jUnitChecks
		SidePanelMap = new HashMap<String, JPanel>();

		/**
		 * Set up the frame
		 */

		setTitle("SpaceFarmer 3000");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(BOUNDS_X, BOUNDS_Y, BOUNDS_WIDTH, BOUNDS_HEIGHT);
		MainContentPanel = new JPanel();
		MainContentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(MainContentPanel);
		MainContentPanel.setLayout(new CardLayout(0, 0));

		final JPanel standardView = new JPanel();
		MainContentPanel.add(standardView, "Standard");
		standardView.setLayout(new BorderLayout(0, 0));

		/**
		 * Create all the Frame's Panels
		 */

		/**
		 * Top Panel
		 */

		final MessageSidePanel topPanel = new MessageSidePanel();

		/**
		 * Bot Panel
		 */

		final JPanel bottomPanel = new PlayersInformationSidePanel(null);
		bottomPanel.setBackground(Color.GRAY);

		/**
		 * Left Panel
		 */

		final JPanel leftPanel = new NavigationSidePanel();
		leftPanel.setBackground(BACKGROUND_COLOR);

		final Component horizontalStrut = Box
				.createHorizontalStrut(HORIZONTAL_STRUT_LENGTH);
		leftPanel.add(horizontalStrut);

		/**
		 * Right Panel
		 */

		final TravelSidePanel rightPanel = new TravelSidePanel();
		rightPanel.setBackground(BACKGROUND_COLOR);

		/**
		 * Center Panel
		 */

		CenterPanel = new JPanel();
		standardView.add(CenterPanel, BorderLayout.CENTER);
		CenterPanel.setBackground(Color.ORANGE);
		CenterPanel.setLayout(new CardLayout(0, 0));

		MiniGameView = new MiniGameScreen();
		MainContentPanel.add(MiniGameView, "MiniGame");

		CardMap = new HashMap<String, Screen>();
		// Generate every possible card
		for (CardName name : CardName.values()) {
			CardMap.put(name.toString(), name.getScreen());
			CenterPanel.add(name.toString(), CardMap.get(name.toString()));
		}

		/**
		 * Add all the side Panels
		 */

		SidePanelMap.put("Top", topPanel);
		SidePanelMap.put("Bot", bottomPanel);
		SidePanelMap.put("Left", leftPanel);
		SidePanelMap.put("Right", rightPanel);

		// listeners involved with changing the display will need to make the
		// side panels visible or not visible
		turnOffSidePanels();

		standardView.add(SidePanelMap.get("Top"), BorderLayout.NORTH); // $codepro.audit.disable com.instantiations.eclipse.analysis.audit.security.incompatibleTypesStoredInACollection
		standardView.add(SidePanelMap.get("Bot"), BorderLayout.SOUTH);  // $codepro.audit.disable com.instantiations.eclipse.analysis.audit.security.incompatibleTypesStoredInACollection
		standardView.add(SidePanelMap.get("Left"), BorderLayout.WEST);  // $codepro.audit.disable com.instantiations.eclipse.analysis.audit.security.incompatibleTypesStoredInACollection
		standardView.add(SidePanelMap.get("Right"), BorderLayout.EAST); // $codepro.audit.disable com.instantiations.eclipse.analysis.audit.security.incompatibleTypesStoredInACollection

	}

	/**
	 * Shuts off the SidePanels.
	 */
	public static void turnOffSidePanels() {
		for (JPanel sidePanel : SidePanelMap.values()) {
			sidePanel.setVisible(false);
		}
	}

	/**
	 * Flips to the specified card in the center panel.
	 * 
	 * @param name
	 *            The card ID of the panel to flip to.
	 */
	public static void changeCard(CardName name) {
		((CardLayout) CenterPanel.getLayout()).show(CenterPanel,
				name.toString());
	}

	/**
	 * Initiate the minigame
	 */
	public static void playMiniGame() {
		MiniGameView.startGame();
		((CardLayout) MainContentPanel.getLayout()).show(MainContentPanel,
				"MiniGame");
		MiniGameView.requestFocus();
	}

	/**
	 * Sets the message in the Display.
	 * 
	 * @param message
	 *            Message to set.
	 * @param messageType
	 *            Type of the message.
	 */
	public static void setMessage(String message, MessageType messageType) {
		final MessageSidePanel sidePanel = (MessageSidePanel) getSidePanel("Top");
		sidePanel.setMessage(message, messageType);
	}

	/**
	 * Adds to the message in the Display.
	 * 
	 * @param addendum
	 *            String that is added.
	 */
	public static void addToMessage(String addendum) {
		final MessageSidePanel sidePanel = (MessageSidePanel) getSidePanel("Top");
		sidePanel.addToMessage(addendum);
	}

	/**
	 * Hides a message in the Display.
	 */
	public static void hideMessage() {
		final MessageSidePanel sidePanel = (MessageSidePanel) getSidePanel("Top");
		sidePanel.setVisible(false);
	}

	/**
	 * Updates the Planet travel information.
	 * 
	 * @param planet
	 *            Planet with which to update.
	 */
	public static void updatePlanetTravelInfo(Planet planet) {
		final TravelSidePanel sidePanel = (TravelSidePanel) getSidePanel("Right");
		sidePanel.updateBasedOnPlanet(planet);
	}

	/**
	 * Updates the Display based off the Players.
	 */
	public static void updatePlayersInfo() {
		final PlayersInformationSidePanel playersInformationSidePanel = 
				(PlayersInformationSidePanel) getSidePanel("Bot");
		playersInformationSidePanel.updateBasedOnAllPlayers();
	}

	/**
	 * Return from minigame
	 */
	public static void exitGame() {
		((CardLayout) MainContentPanel.getLayout()).show(MainContentPanel,
				"Standard");
	}

	// --Accessors and Modifiers
	/**
	 * Returns a Screen based off its name.
	 * 
	 * @param cardName
	 *            The Screen's name.
	 * @return A Screen based off the name.
	 */
	public static Screen getCard(String cardName) {
		return CardMap.get(cardName);
	}

	/**
	 * Returns a JPanel corresponding to a position on the Display.
	 * 
	 * @param direction
	 *            String representation of the position.
	 * @return Panel corresponding to the String.
	 */
	public static JPanel getSidePanel(String direction) {
		return SidePanelMap.get(direction);
	}

	/**
	 * @return Game associated with this Display.
	 */
	public static Game getGame() {
		return Game;
	}

	/**
	 * @param game
	 *            Game to set for this Display.
	 */
	public static void setGame(Game game) {
		Display.Game = game;
	}

	/**
	 * @return The center panel of this Display.
	 */
	public static JPanel getCenterPanel() {
		return CenterPanel;
	}

	/**
	 * @return The main content panel of this Display.
	 */
	public static JPanel getMainContentPanel() {
		return MainContentPanel;
	}

}
