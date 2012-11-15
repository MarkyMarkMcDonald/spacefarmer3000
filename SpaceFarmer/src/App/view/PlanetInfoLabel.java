package App.view;

import App.model.Game;
import App.model.Universe.Planet;
import App.model.Universe.PlanetarySystem;

import javax.swing.*;
import java.awt.geom.Point2D;

/**
 * Created with IntelliJ IDEA.
 * User: mark.mcdonald
 * Date: 11/9/12
 * Time: 3:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlanetInfoLabel extends JLabel {

    public PlanetInfoLabel(){
        JButton testBut = new JButton("Testing");
        add(testBut);
    }
    
    public PlanetInfoLabel(Planet planet){
        this();
        updateBasedOnPlanet(planet);
    }

    public void updateBasedOnPlanet(Planet planet){
        boolean isCurrentPlanet = Game.getCurrentPlanet().equals(planet);
        String name = planet.getName();
        String currentEvent = planet.getEvent().getName();
        String resources = planet.getResourceType().getName();
        String technology = planet.getTechnologyLevel().getName();
        String political = planet.getPoliticalSystem().getName();
        // Add the amount of fuel required to travel
        PlanetarySystem currentPlanetarySystem = Game.getCurrentPlanet().getPlanetarySystem();
        PlanetarySystem destinationPlanetarySystem = planet.getPlanetarySystem();

        String requiredFuel;
        if (currentPlanetarySystem.equals(destinationPlanetarySystem)){
            requiredFuel= "0";
        }
        else {
            requiredFuel = Integer.toString((int) Point2D.distance(currentPlanetarySystem.getX(), currentPlanetarySystem.getY(), destinationPlanetarySystem.getX(), destinationPlanetarySystem.getY()));
        }

        // A string builder might be better here, but we aren't doing anything intensive
        String br = "<BR>";
        String html = "<html><p>";

        html += "Planet " + name + br;
        html += "Resources: " + resources + br;
        html += "Technology: " + technology + br;
        html += "Political System: " + political + br;
        html += "Current Event:  " + currentEvent;
        if (!isCurrentPlanet){
            html += br + "Fuel Needed: " + requiredFuel;
        }
        html += "</p></html>";

        setText(html);

    }

}
