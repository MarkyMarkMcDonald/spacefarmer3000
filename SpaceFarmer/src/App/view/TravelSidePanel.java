package App.view;

import App.factory.UniverseFactory;
import App.listener.ViewPlanetListener;
import App.model.PlanetarySystem;

import javax.swing.*;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: mark.mcdonald
 * Date: 11/6/12
 * Time: 1:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class TravelSidePanel extends SidePanel {

    public TravelSidePanel(){
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    }

    public void updateBasedOnAllPlanets(){
        removeAll();
        Collection<PlanetarySystem> systems = UniverseFactory.getPlanetarySystems().values();
        for (PlanetarySystem system : systems){
            JLabel systemName = new JLabel(system.getName());

            JComboBox planets = new JComboBox();
            planets.setModel(new DefaultComboBoxModel(system.getPlanets().keySet().toArray()));

            JButton goButton = new JButton("View Planet");
            goButton.addActionListener(new ViewPlanetListener(planets));

            add(systemName);

            JPanel planetSelectionPanel = new JPanel();
            planetSelectionPanel.setLayout(new BoxLayout(planetSelectionPanel,BoxLayout.X_AXIS));
            planetSelectionPanel.add(planets);
            planetSelectionPanel.add(goButton);
            add(planetSelectionPanel);
        }
    }
}
