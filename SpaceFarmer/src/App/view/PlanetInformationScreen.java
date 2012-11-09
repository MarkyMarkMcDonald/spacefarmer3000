package App.view;

import App.listener.TransportationListener;
import App.model.Game;
import App.model.Universe.Planet;
import App.model.Universe.PlanetarySystem;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

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
    private JPanel travelPanel;
    private JButton travelButton;
    private JLabel requiredFuelLabel;

    private JLabel message;

    private TransportationListener transportationListener;

    public PlanetInformationScreen(){
        name = CardName.PLANET_INFORMATION_CARD;

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        // We'll place the planet information in it's own box so we can left align everything
        JPanel informationHolder = new JPanel();
        informationHolder.setLayout(new BoxLayout(informationHolder,BoxLayout.Y_AXIS));

        nameLabel = new JLabel();
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        message = new JLabel();
        message.setVisible(false);
        message.setForeground(Color.red);

        travelPanel = new JPanel();
        travelPanel.setVisible(false);

        travelButton = new JButton("Travel Here");
        transportationListener = new TransportationListener(message);
        travelButton.addActionListener(transportationListener);

        requiredFuelLabel = new JLabel();

        travelPanel.add(travelButton);
        travelPanel.add(requiredFuelLabel);

        resourceLabel = new JLabel();
        resourceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        technologylabel = new JLabel();
        technologylabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        politicalLabel = new JLabel();
        politicalLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        currentEventLabel = new JLabel();
        currentEventLabel.setAlignmentX(Component.LEFT_ALIGNMENT);



        informationHolder.add(resourceLabel);
        informationHolder.add(technologylabel);
        informationHolder.add(politicalLabel);
        informationHolder.add(currentEventLabel);

        add(nameLabel);
        add(travelPanel);

        add(informationHolder);
        Component glue1 = Box.createVerticalGlue();
        Component glue2 = Box.createVerticalGlue();
        add(glue1);
        add(message);
        add(glue2);
    }

    public void update(Planet planet){
        nameLabel.setText("Planet " + planet.getName());
        resourceLabel.setText("Resources: " + planet.getResourceType().getName());
        technologylabel.setText("Technology: " + planet.getTechnologyLevel().getName());
        politicalLabel.setText("Political System: " + planet.getPoliticalSystem().getName());
        currentEventLabel.setText("Current Event: " + planet.getEvent().getName());
        transportationListener.setPlanet(planet);
        // If the player isn't on this planet, create and reveal the components for traveling there
        if (!Game.getCurrentPlanet().equals(planet)){
            // Add the amount of fuel required to travel
            PlanetarySystem currentPlanetarySystem = Game.getCurrentPlanet().getPlanetarySystem();
            PlanetarySystem destinationPlanetarySystem = planet.getPlanetarySystem();
            if (currentPlanetarySystem.equals(destinationPlanetarySystem)){
                requiredFuelLabel.setText("No Fuel Required For Inter-System Travel");
            }
            else {
                requiredFuelLabel.setText((int) Point2D.distance(currentPlanetarySystem.getX(), currentPlanetarySystem.getY(), destinationPlanetarySystem.getX(), destinationPlanetarySystem.getY()) + " Fuel Required");
            }
            travelPanel.setVisible(true);
        }
        else {
            travelPanel.setVisible(false);
        }
        message.setVisible(false);

    }

}
