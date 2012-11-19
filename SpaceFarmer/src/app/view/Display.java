package app.view;

import app.model.Game;
import app.model.Universe.Planet;
import app.view.SidePanels.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * This class controls the viewing pane. The different screens are controlled by
 * components that use the instance of this Display as a parameter to link to
 * the changeCard() method.
 * 
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

	private static JPanel CenterPanel, MainContentPanel;

	private static Game Game;

	private static MiniGameScreen MiniGameView;

	// We need this to be able to update cards instead of creating new ones
	// every time
	private static Map<String, Screen> CardMap;

	private static Map<String, JPanel> SidePanelMap;

	/**
	 * set up the initial screen
	 */
	public final void setup() {
		SidePanelMap = new HashMap<String, JPanel>();

		/**
		 * Set up the frame
		 */

		setTitle("SpaceFarmer 3000");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 900);
		MainContentPanel = new JPanel();
		MainContentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(MainContentPanel);
		MainContentPanel.setLayout(new CardLayout(0, 0));

		JPanel standardView = new JPanel();
		MainContentPanel.add(standardView, "Standard");
		standardView.setLayout(new BorderLayout(0, 0));

		/**
		 * Create all the Frame's Panels
		 */

		/**
		 * Top Panel
		 */

		MessageSidePanel topPanel = new MessageSidePanel();

		/**
		 * Bot Panel
		 */

		JPanel bottomPanel = new PlayersInformationSidePanel(null);
		bottomPanel.setBackground(Color.GRAY);

		/**
		 * Left Panel
		 */

		JPanel leftPanel = new NavigationSidePanel();
		leftPanel.setBackground(new Color(205, 201, 205));

		Component horizontalStrut = Box.createHorizontalStrut(100);
		leftPanel.add(horizontalStrut);

		/**
		 * Right Panel
		 */

		TravelSidePanel rightPanel = new TravelSidePanel();
		rightPanel.setBackground(new Color(205, 201, 205));

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

		standardView.add(SidePanelMap.get("Top"), BorderLayout.NORTH);
		standardView.add(SidePanelMap.get("Bot"), BorderLayout.SOUTH);
		standardView.add(SidePanelMap.get("Left"), BorderLayout.WEST);
		standardView.add(SidePanelMap.get("Right"), BorderLayout.EAST);

	}

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

	public static void setMessage(String message, MessageType messageType) {
		MessageSidePanel sidePanel = (MessageSidePanel) getSidePanel("Top");
		sidePanel.setMessage(message, messageType);
	}

	public static void addToMessage(String addendum) {
		MessageSidePanel sidePanel = (MessageSidePanel) getSidePanel("Top");
		sidePanel.addToMessage(addendum);
	}

	public static void hideMessage() {
		MessageSidePanel sidePanel = (MessageSidePanel) getSidePanel("Top");
		sidePanel.setVisible(false);
	}

	public static void updatePlanetTravelInfo(Planet planet) {
		TravelSidePanel sidePanel = (TravelSidePanel) getSidePanel("Right");
		sidePanel.updateBasedOnPlanet(planet);
	}

	public static void updatePlayersInfo() {
		PlayersInformationSidePanel playersInformationSidePanel = 
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
	public static Screen getCard(String cardName) {
		return CardMap.get(cardName);
	}

	public static JPanel getSidePanel(String direction) {
		return SidePanelMap.get(direction);
	}

	public static Game getGame() {
		return Game;
	}

	public static void setGame(Game game) {
		Display.Game = game;
	}

	public static JPanel getCenterPanel() {
		return CenterPanel;
	}

	public static JPanel getMainContentPanel() {
		return MainContentPanel;
	}

}
