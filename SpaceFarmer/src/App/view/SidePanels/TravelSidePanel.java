package App.view.SidePanels;

import App.listener.TransportationListener;
import App.model.Game;
import App.model.Universe.Planet;
import App.view.PlanetInfoLabel;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: mark.mcdonald
 * Date: 11/6/12
 * Time: 1:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class TravelSidePanel extends SidePanel {
	
    private PlanetInfoLabel planetInfoLabel;
    
    private JButton travelButton;
    
    private TransportationListener transportationListener;

    public TravelSidePanel(){
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(250, 2000));
        planetInfoLabel = new PlanetInfoLabel();
        add(planetInfoLabel);
        transportationListener = new TransportationListener();
        travelButton = new JButton("Go!");
        travelButton.addActionListener(transportationListener);
        travelButton.setVisible(false);
        add(travelButton);
    }

    public void updateBasedOnPlanet(Planet planet){
        boolean isCurrentPlanet = Game.getCurrentPlanet().equals(planet);
        if (!isCurrentPlanet){
            travelButton.setVisible(true);
        } else {
            travelButton.setVisible(false);
        }
        transportationListener.setPlanet(planet);
        planetInfoLabel.updateBasedOnPlanet(planet);
    }
}
