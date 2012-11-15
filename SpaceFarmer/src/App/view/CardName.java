package App.view;

import App.view.Market.MarketScreen;

/**
 * This class acts as an enumeration for the JPanels acting as cards for the
 * center screen. User: Mark McDonald Date: 10/11/12 Time: 3:22 PM
 */
public enum CardName {
	WELCOME_CARD("WelcomeCard") {
		public Screen getScreen() {
			return new WelcomeScreen();
		}
	},
	PLAYER_INFORMATION_CARD("PlayerInformationCard") {
		public Screen getScreen() {
			return new PlayerInformationScreen();

		}
	},
	PLAYER_CREATED_CARD("PlayerCreatedCard") {
		public Screen getScreen() {
			return new PlayerCreatedScreen();
		}
	},
	TEMPORARY_SCREEN_CARD("TemporaryCard") {
		public Screen getScreen() {
			return new TemporaryScreen();
		}
	},
	PLANET_INFORMATION_CARD("PlanetInformationCard") {
		public Screen getScreen() {
			return new PlanetInformationScreen();
		}
	},
	MARKETPLACE_CARD("MarketplaceCard") {
		public Screen getScreen() {
			return new MarketScreen();
		}
	},
	START_OF_TURN_CARD("StartOfTurnCard") {
		public Screen getScreen() {
			return new StartOfTurnScreen();
		}
	},
	INTERSYSTEM_TRAVEL_CARD("IntersystemTravelCard") {
		public Screen getScreen() {
			return new IntersystemTravelScreen();
		}
	},
	SAVING_AND_LOADING_CARD("SavingAndLoadingCard") {
		public Screen getScreen() {
			return new SaveAndLoad();
		}
	};

	private final String name;

	/**
	 * Construct the CardName enumeration with a String.
	 * 
	 * @param name
	 *            The CardName's associated name String.
	 */
	private CardName(String name) {
		this.name = name;
	}

	/**
	 * Overloaded per CardName type to return a hardcoded JPanel type.
	 * 
	 * @return A new class that extends JPanel.
	 */
	public abstract Screen getScreen();

	/**
	 * @return The name of this CardName enumeration as a String.
	 */
	public String toString() {
		return name;
	}
}
