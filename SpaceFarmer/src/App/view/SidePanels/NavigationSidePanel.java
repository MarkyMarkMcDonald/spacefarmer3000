package App.view.SidePanels;

import App.listener.ContinueListener;
import App.model.Game;
import App.view.CardName;
import App.view.Display;
import App.view.Market.MarketScreen;
import App.view.PlanetInformationScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created with IntelliJ IDEA.
 * User: mark.mcdonald
 * Date: 10/31/12
 * Time: 11:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class NavigationSidePanel extends SidePanel {

    public NavigationSidePanel(){
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));


        /**
         * Current Planet Info
         */
        JButton planetInfoBtn = new JButton("Current Planet");
        ContinueListener goToPlanetInfoListener = new ContinueListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardToMoveTo = CardName.PLANET_INFORMATION_CARD;

                PlanetInformationScreen planetScreen = (PlanetInformationScreen) Display.getCard(CardName.PLANET_INFORMATION_CARD.toString());
                planetScreen.update(Game.getCurrentPlanet());

                // Hide the Planet Travel Pane
                TravelSidePanel travelPanel = (TravelSidePanel) Display.getSidePanel("Right");
                travelPanel.setVisible(false);

                Display.hideMessage();

                progressDisplay();
            }
        };
        planetInfoBtn.addActionListener(goToPlanetInfoListener);
        add(planetInfoBtn);

        /**
         * Go to Current Planet's Market Place
         */
        JButton marketplaceBtn= new JButton("Marketplace");
        ContinueListener goToMarketPlaceListener= new ContinueListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardToMoveTo = CardName.MARKETPLACE_CARD;

                MarketScreen marketScreen = (MarketScreen) Display.getCard(CardName.MARKETPLACE_CARD.toString());
                marketScreen.updateMarketPlace(Game.getCurrentMarketPlace());


                // Hide the Planet Travel Pane
                TravelSidePanel travelPanel = (TravelSidePanel) Display.getSidePanel("Right");
                travelPanel.setVisible(false);

                Display.hideMessage();

                progressDisplay();
            }
        };

        marketplaceBtn.addActionListener(goToMarketPlaceListener);
        add(marketplaceBtn);

        /**
         * Go to current ship's information and peruse upgrade options
         */

        JButton btnShip = new JButton("Ship");
        add(btnShip);

        /**
         * Travel to a new planet and end the game
         */

        JButton btnTravel = new JButton("Travel");
        ContinueListener travelListener = new ContinueListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardToMoveTo = CardName.INTERSYSTEM_TRAVEL_CARD;
                TravelSidePanel travelPanel = (TravelSidePanel) Display.getSidePanel("Right");
                travelPanel.updateBasedOnAllPlanets();
                travelPanel.setVisible(true);

                // Hide the tutorial message after the first round
                if (Game.getRoundNumber() > 1){
                    Display.hideMessage();
                }
                else {
                    Display.setMessage("Click a Planet to Travel to!", MessageType.GOOD);
                }


                progressDisplay();
                System.out.println();
            }
        };
        btnTravel.addActionListener(travelListener);
        add(btnTravel);
    }

}
