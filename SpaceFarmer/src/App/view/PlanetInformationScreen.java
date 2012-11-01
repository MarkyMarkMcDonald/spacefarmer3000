package App.view;

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

    public PlanetInformationScreen(){
        name = CardName.PLANET_INFORMATION_CARD;

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        nameLabel = new JLabel();
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        resourceLabel = new JLabel();
        resourceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);



        add(nameLabel);
        add(resourceLabel);
    }

    public void update(Planet planet){
        nameLabel.setText("Planet " + planet.getName());
        resourceLabel.setText("Resources: " + planet.getResourceType().getName());
    }

}
