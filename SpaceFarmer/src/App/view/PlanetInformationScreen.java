package App.view;

import App.model.Planet;
import App.model.PoliticalSystem;
import App.model.ResourceType;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: mark.mcdonald
 * Date: 10/24/12
 * Time: 5:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class PlanetInformationScreen extends Screen{
    public PlanetInformationScreen(){
        name = CardName.PLANET_INFORMATION_CARD;
    }

    public PlanetInformationScreen(Planet planet){
        name = CardName.PLANET_INFORMATION_CARD;

        String name = planet.getName();
        ResourceType resourceLevel = planet.getResourceType();
        PoliticalSystem politicalLevel = planet.getPoliticalSystem();

        JLabel nameLabel = new JLabel(name);

        JLabel resourceLabel = new JLabel("Resource Level: " + resourceLevel.getName());
    }
}
