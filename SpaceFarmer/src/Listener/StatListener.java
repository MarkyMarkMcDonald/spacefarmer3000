package App.model;

import App.service.PointsService;
import App.view.Display;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatListener implements ActionListener {

	private SkillType skillType;
    private Player player;
    private  JLabel pointsText;

    public StatListener(SkillType skillType, Player player, JLabel pointsText){
        this.skillType = skillType;
        this.player = player;
        this.pointsText = pointsText;
    }

    public void actionPerformed(ActionEvent e)
	{
        int newPointsValue = PointsService.increment(skillType, player);
        pointsText.setText(Integer.toString(newPointsValue));
    }

}
