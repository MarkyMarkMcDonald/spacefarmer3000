package App.view;

import App.listener.ContinueListener;
import App.model.Game;
import App.model.Planet;
import App.model.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created with IntelliJ IDEA.
 * User: mark.mcdonald
 * Date: 10/31/12
 * Time: 11:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class StartOfTurnScreen extends Screen{
    private JLabel turnInfo;
    private JLabel title;

    private final String[] turnInfoStaticText = new String[] {"Turn "," of Round "};
    private final String[] titleStaticText = new String[] {"It is now ","'s turn."};

    public StartOfTurnScreen(){
        name = CardName.START_OF_TURN_CARD;

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        title = new JLabel();
        turnInfo = new JLabel();

        add(title);
        add(turnInfo);

        JButton start = new JButton("Start");
        ContinueListener continueListener = new ContinueListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardToMoveTo = CardName.PLANET_INFORMATION_CARD;

                // update the planet info screen to be based on the current player's planet
                Player currentPlayerPlayer = Game.getCurrentPlayer();
                Planet currentPlanet = currentPlayerPlayer.getCurrentPlanet();
                PlanetInformationScreen planetInformationScreen = (PlanetInformationScreen) Display.getCard(cardToMoveTo.toString());
                planetInformationScreen.update(currentPlanet);

                progressDisplay();

                // enable the navigation panel
                JPanel navPanel = Display.getSidePanel("Left");
                navPanel.setVisible(true);

                PlayersInformationSidePanel playersInfoPanel = (PlayersInformationSidePanel) Display.getSidePanel("Bot");
                playersInfoPanel.updateBasedOnAllPlayers();
                playersInfoPanel.setVisible(true);
            }


        };
        start.addActionListener(continueListener);
        add(start);
    }

    public void updateTurn(){
        int roundLength = Game.getPlayers().size() + 1;
        int turnInRound = Game.getNumberOfTurns() % roundLength;
        int roundNum = (int) Math.floor(Game.getNumberOfTurns() / roundLength + 1);
        turnInfo.setText(turnInfoStaticText[0] + turnInRound+ turnInfoStaticText[1] + roundNum);

        Player player = Game.getCurrentPlayer();
        String currentPlayerName = player.getName();
        title.setText(titleStaticText[0] + currentPlayerName + titleStaticText[1]);
    }
}
