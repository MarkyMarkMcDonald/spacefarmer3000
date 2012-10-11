package App.service;

import App.model.Player;
import App.model.SkillType;

import java.util.Map;

/**
 * User: marky
 * Date: 10/7/12
 * Time: 8:32 PM
 */
public class PlayerValidationService {

    public static boolean playerNameIsSet(Player player){
        return (player != null && player.getName()!= null && !player.getName().isEmpty());
    }

    public static boolean allPointsAreDistributed(Player player, int numPointsToDistribute){
        Map<SkillType, Integer> skills = player.getSkillLevels();
        return sumOfSkillPoints(skills) == numPointsToDistribute;
    }

    public static int sumOfSkillPoints(Map<SkillType, Integer> skills){
        int sum = 0;
        for (SkillType skillType : SkillType.values()){
            sum += skills.get(skillType);
        }
        return sum;
    }

    /**
     *
     * @param player which person we're checking
     * @param numOfPointsToDistribute allocated to the user
     * @return an error message or "success"
     */
    public static String isValidPlayer(Player player, int numOfPointsToDistribute){
        String message = "success";
        if (!allPointsAreDistributed(player,numOfPointsToDistribute)){
            message = "Please allocate exactly 16 points!";
        }
        else if (!playerNameIsSet(player)){
            message = "Please enter a name for this player!";
        }
        return message;
    }
}
