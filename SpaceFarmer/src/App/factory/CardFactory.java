package App.factory;

import App.view.CardName;
import App.view.Screen;

import java.util.EnumMap;
import java.util.Map;

/**
 * User: marky
 * Date: 10/11/12
 * Time: 5:08 PM
 */
public class CardFactory {
    private static Map<CardName, Screen> cards;

    public static Screen getCard(CardName cardName){
        if (cards == null) {
            cards = new EnumMap<CardName, Screen>(CardName.class);
        }

        boolean cardIsAlreadyCreated = !cards.containsKey(cardName);

        if (cardIsAlreadyCreated){
            return cards.get(cardName);
        }
        else {
            //need to create a screen here
            Screen screen = cardName.getScreen();
            cards.put(cardName, screen);
            return screen;
        }


    }

}
