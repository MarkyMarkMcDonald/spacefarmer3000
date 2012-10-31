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
    private JLabel nameLabel;
    private JLabel resourceLabel;

    public PlanetInformationScreen(){
        name = CardName.PLANET_INFORMATION_CARD;

        nameLabel = new JLabel();
        resourceLabel = new JLabel();


    }

    public void update(Planet planet){
        nameLabel.setText("Planet: " + planet.getName());
        resourceLabel.setText("Resource Level: " + planet.getResourceType().getName());
    }

}
