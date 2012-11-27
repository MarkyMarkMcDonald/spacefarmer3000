// $codepro.audit.disable packagePrefixNamingConvention
package test;

import app.factory.UniverseFactory;
import app.listener.ConfirmPlayerCreationListener;
import app.model.Game;
import app.model.player.Player;
import app.model.player.SkillType;
import app.view.Display;
import app.view.PlayerInformationScreen;
import conf.GameVariables;
import conf.PlanetNames;
import conf.SystemNames;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * @author Ivory Assan
 * This class is to test that the player information screen has been properly creating.
 * Thus allowing the player to be properly created.
 */
public class CreatePlayerTest {

    /**
     * Create/Set the information required to create a player on the player information screen.
     * This information shows up on the player information screen and is then used to create the actual player
     * by assigning the name and values to the player.
     */
    @Test
    public void test(){
        //Copied from Driver
        final Display frame = new Display();
        frame.setVisible(true);
        final Game game = new Game();
        Display.setGame(game);
        UniverseFactory.createUniverse(
                PlanetNames.getPlanetNamesAsList(),
                SystemNames.getSystemNamesAsList(),
                GameVariables.NUM_PLANETS,
                GameVariables.NUM_PLANETARY_SYSTEMS,
                GameVariables.SYSTEM_ROWS,
                GameVariables.SYSTEM_COLUMNS,
                GameVariables.UNIVERSE_ROWS,
                GameVariables.UNIVERSE_COLUMNS,
                GameVariables.QUADRANT_X_DIMENSION,
                GameVariables.QUADRANT_Y_DIMENSION,
                GameVariables.MINIMUM_SYSTEM_DISTANCE);

        PlayerInformationScreen infoScreen = new PlayerInformationScreen(); //create player information screen
        infoScreen.setEnteredPlayerName("Ivory"); //set player name
        infoScreen.setEnteredPilotSkill("3"); //set player pilot skills
        infoScreen.setEnteredFighterSkill("4"); //set player fighter skills
        infoScreen.setEnteredTraderSkill("7"); //set player trader skills
        infoScreen.setEnteredEngineerSkill("2"); //set player engineer skills
        ConfirmPlayerCreationListener creationListener = new ConfirmPlayerCreationListener(infoScreen);
        //create the listener and take in the player information screen
        creationListener.actionPerformed(null); //when an action is performed, use the information inputed on the player
        //information screen to create an actual player
        System.out.println("hello world"); //make sure the code properly runs

        List<Player> players = Game.getPlayers(); //get the list of players created
        Player player = players.get(0); //specifically get the player that has just been created
        Map<SkillType, Integer> skills = player.getSkillLevels(); //get all of the player's skill levels
        skills.get(SkillType.PILOTING); //get the piloting skill level
        skills.get(SkillType.FIGHTING); //get the fighting skill level
        skills.get(SkillType.TRADING); //get the trading skill level
        skills.get(SkillType.ENGINEERING); //get the engineering skill level

        //check to see if the information I entered to create the player is the same information I pull back
        //from that player
        assertTrue(player.getName().equals("Ivory"));
        assertTrue(skills.get(SkillType.PILOTING).equals(3));
        assertTrue(skills.get(SkillType.FIGHTING).equals(4));
        assertTrue(skills.get(SkillType.TRADING).equals(7));
        assertTrue(skills.get(SkillType.ENGINEERING).equals(2));

        //the total amount of skill points distributed to the player has to be equal to 16
        assertTrue(skills.get(SkillType.PILOTING) + skills.get(SkillType.FIGHTING) + skills.get(SkillType.TRADING) + skills.get(SkillType.ENGINEERING) == 16 );

        //edge case to make sure that the total skill points distributed is not greater than 16
        assertFalse(skills.get(SkillType.PILOTING) + skills.get(SkillType.FIGHTING) + skills.get(SkillType.TRADING) + skills.get(SkillType.ENGINEERING) > 16);

        //edge case to make sure that the total skill points distributed is not less than 16
        assertFalse(skills.get(SkillType.PILOTING) + skills.get(SkillType.FIGHTING) + skills.get(SkillType.TRADING) + skills.get(SkillType.ENGINEERING) < 16 );
    }









}
