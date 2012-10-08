package App.service;

import App.model.Player;
import App.model.SkillType;

import java.util.Map;

/**
 * User: marky
 * Date: 10/7/12
 * Time: 8:32 PM
 */
public class PointsService {

    public static int increment(SkillType skillType, Player player){
        Map<SkillType, Integer> skills = player.getSkillLevels();

        int currentSum = sumOfSkillPoints(skills);

        int currentSkillLevel = skills.get(skillType);

        if (currentSum > 15){
            return currentSkillLevel;
        }
        else {
            // Grab the map of skills, increment the corresponding skill level, and set the map back

            currentSkillLevel++;
            skills.put(skillType,currentSkillLevel);
            player.setSkillLevels(skills);

            return currentSkillLevel;
        }

    }

    public static int sumOfSkillPoints(Map<SkillType, Integer> skills){
        int sum = 0;
        for (SkillType skillType : SkillType.values()){
            sum += skills.get(skillType);
        }
        return sum;
    }
}
