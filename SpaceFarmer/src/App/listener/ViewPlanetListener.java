package App.listener;

import App.factory.UniverseFactory;
import App.model.Universe.Planet;
import App.view.CardName;
import App.view.Display;
import App.view.PlanetInformationScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created with IntelliJ IDEA.
 * User: mark.mcdonald
 * Date: 11/7/12
 * Time: 1:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class ViewPlanetListener extends ContinueListener {

    private JComboBox planetChoices;

    public ViewPlanetListener(JComboBox planetChoices){
        cardToMoveTo = CardName.PLANET_INFORMATION_CARD;
        this.planetChoices = planetChoices;
    }
    public void actionPerformed(ActionEvent e){
        PlanetInformationScreen planetInfoScreen = (PlanetInformationScreen) Display.getCard(cardToMoveTo.toString());
        String selectedPlanetName = (String) planetChoices.getSelectedItem();
        Planet selectedPlanet = UniverseFactory.getPlanet(selectedPlanetName);
        planetInfoScreen.update(selectedPlanet);

        progressDisplay();
    }


}
