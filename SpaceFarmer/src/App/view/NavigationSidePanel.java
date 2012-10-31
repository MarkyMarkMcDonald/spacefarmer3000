package App.view;

import App.listener.ContinueListener;
import App.model.Game;

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

        JButton planetInfoBtn = new JButton("Current Planet");
        ContinueListener goToPlanetInfoListener = new ContinueListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardToMoveTo = CardName.PLANET_INFORMATION_CARD;

                PlanetInformationScreen planetScreen = (PlanetInformationScreen) Display.getCard(CardName.PLANET_INFORMATION_CARD.toString());
                planetScreen.update(Game.getCurrentPlanet());

                progressDisplay();
            }
        };
        planetInfoBtn.addActionListener(goToPlanetInfoListener);
        add(planetInfoBtn);

        JButton marketplaceBtn= new JButton("Marketplace");
        ContinueListener goToMarketPlaceListener= new ContinueListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardToMoveTo = CardName.MARKETPLACE_CARD;

                MarketScreen marketScreen = (MarketScreen) Display.getCard(CardName.MARKETPLACE_CARD.toString());
                marketScreen.updateMarketPlace(Game.getCurrentMarketPlace());

                progressDisplay();
            }
        };

        marketplaceBtn.addActionListener(goToMarketPlaceListener);
        add(marketplaceBtn);

        JButton btnShip = new JButton("Ship");
        add(btnShip);

        JButton btnTravel = new JButton("Travel");
        add(btnTravel);
    }

}
