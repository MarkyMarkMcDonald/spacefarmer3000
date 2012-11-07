package App.view;

import App.listener.TransportationListener;
import App.model.Game;
import App.model.Planet;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: mark.mcdonald
 * Date: 10/24/12
 * Time: 5:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlanetInformationScreen extends Screen{
    private JLabel nameLabel;
    private JLabel resourceLabel;
    private JLabel technologylabel;
    private JLabel politicalLabel;
    private JLabel currentEventLabel;
    private JButton travelButton;

    private JLabel message;

    public PlanetInformationScreen(){
        name = CardName.PLANET_INFORMATION_CARD;

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        // We'll place the planet information in it's own box so we can left align everything
        JPanel informationHolder = new JPanel();
        informationHolder.setLayout(new BoxLayout(informationHolder,BoxLayout.Y_AXIS));

        nameLabel = new JLabel();
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        travelButton = new JButton("Travel Here");
        travelButton.setVisible(false);

        resourceLabel = new JLabel();
        resourceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        technologylabel = new JLabel();
        technologylabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        politicalLabel = new JLabel();
        politicalLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        currentEventLabel = new JLabel();
        currentEventLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        message = new JLabel();
        message.setVisible(false);
        message.setForeground(Color.red);

        informationHolder.add(resourceLabel);
        informationHolder.add(technologylabel);
        informationHolder.add(politicalLabel);
        informationHolder.add(currentEventLabel);

        add(nameLabel);
        add(travelButton);
        add(informationHolder);
    }

    public void update(Planet planet){
        nameLabel.setText("Planet " + planet.getName());
        resourceLabel.setText("Resources: " + planet.getResourceType().getName());
        technologylabel.setText("Technology: " + planet.getTechnologyLevel().getName());
        politicalLabel.setText("Political System: " + planet.getPoliticalSystem().getName());
        currentEventLabel.setText("Current Event: " + planet.getEvent().getName());

        // If the player isn't on this planet, create the components for traveling there
        if (!Game.getCurrentPlanet().equals(planet)){
            travelButton.addActionListener(new TransportationListener(planet, message));
            travelButton.setVisible(true);
        }
        else {
            travelButton.setVisible(false);
        }
        message.setVisible(false);

    }

}
