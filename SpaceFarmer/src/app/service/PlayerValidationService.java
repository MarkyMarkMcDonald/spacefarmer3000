package app.service;

import app.model.player.Player;
import app.model.player.SkillType;

import java.util.Map;

/**
 * Used to confirm the user's inputs follow the character creation rules User:
 * marky Date: 10/7/12 Time: 8:32 PM
 * 
 * @author Mark
 * @version 1.0
 */
public class PlayerValidationService {

	/**
	 * Check that the player's name is set
	 * 
	 * @param player
	 *            player in question
	 * @return true if name is correct
	 */
	public static boolean isPlayerNameSet(Player player) {
		return (player != null && player.getName() != null && !player.getName()
				.isEmpty());
	}

	/**
	 * Check that all points (no more, no less) have been distributed
	 * 
	 * @param player
	 *            player in question
	 * @param numPointsToDistribute
	 *            number to check against, will likely be 16
	 * @return true if points distributed correctly
	 */
	public static boolean hasDistributedPoints(Player player,
			int numPointsToDistribute) {
		final Map<SkillType, Integer> skills = player.getSkillLevels();
		return sumOfSkillPoints(skills) == numPointsToDistribute;
	}

	/**
	 * helper method for calculating the number of distributed points
	 * 
	 * @param skills
	 *            map of skills to calculate the sum of
	 * @return number of distributed points
	 */
	public static int sumOfSkillPoints(Map<SkillType, Integer> skills) {
		int sum = 0;
		for (SkillType skillType : SkillType.values()) {
			sum += skills.get(skillType);
		}
		return sum;
	}

	/**
	 * 
	 * @param player
	 *            which person we're checking
	 * @param numOfPointsToDistribute
	 *            allocated to the user
	 * @return an error message or "success"
	 */
	public static String checkValidPlayer(Player player,
			int numOfPointsToDistribute) {
		String message = "success";
		if (!hasDistributedPoints(player, numOfPointsToDistribute)) {
			message = "Please allocate exactly 16 points!";
		} else if (!isPlayerNameSet(player)) {
			message = "Please enter a name for this player!";
		}
		return message;
	}

	/**
	 * @return Information about this object as a String.
	 */
	public String toString() {
		return "PlayerValidationService";
	}
}
