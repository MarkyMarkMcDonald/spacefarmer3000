package app.factory;

import app.view.CardName;
import app.view.Screen;

import java.util.EnumMap;
import java.util.Map;

/**
 * User: marky Date: 10/11/12 Time: 5:08 PM
 */
public class CardFactory {
	private static Map<CardName, Screen> Cards;

	/**
	 * Get a Screen associated with a card name.
	 * 
	 * @param cardName
	 *            The CardName enum with which the Screen is associated.
	 * @return The Screen associated with the parameter cardName.
	 */
	public static Screen getCard(CardName cardName) {
		if (Cards == null) {
			Cards = new EnumMap<CardName, Screen>(CardName.class);
		}

		boolean cardIsAlreadyCreated = !Cards.containsKey(cardName);

		if (cardIsAlreadyCreated) {
			return Cards.get(cardName);
		} else {
			// need to create a screen here
			Screen screen = cardName.getScreen();
			Cards.put(cardName, screen);
			return screen;
		}
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "CardFactory";
	}
}
