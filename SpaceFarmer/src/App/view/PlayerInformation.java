package App.view;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;

public class PlayerInformation extends JPanel {

	/**
	 * Create the panel.
	 */
	public PlayerInformation() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        Component verticalStrut = Box.createVerticalStrut(20);
        add(verticalStrut);

        JPanel PlayerName = new JPanel();
        FlowLayout flowLayout = (FlowLayout) PlayerName.getLayout();
        flowLayout.setVgap(1);
        add(PlayerName);

        JLabel lblPlayerName = new JLabel("Player Name");
        PlayerName.add(lblPlayerName);

        
        JTextField txtEnterPlayerName = new JTextField();
        PlayerName.add(txtEnterPlayerName);
        txtEnterPlayerName.setColumns(10);

        JPanel PilotSkill = new JPanel();
        add(PilotSkill);

        JLabel lblPilotSkill = new JLabel("Pilot Skill Points");
        PilotSkill.add(lblPilotSkill);

        JFormattedTextField frmtdtxtfldEnterPilotSkill = new JFormattedTextField();
        frmtdtxtfldEnterPilotSkill.setText("0");
        frmtdtxtfldEnterPilotSkill.setColumns(2);
        PilotSkill.add(frmtdtxtfldEnterPilotSkill);
        
        JButton PInc = new JButton("+");
        PilotSkill.add(PInc);

        JPanel FighterSkill = new JPanel();
        add(FighterSkill);

        JLabel lblFighterSkill = new JLabel("Fighter Skill Points");
        FighterSkill.add(lblFighterSkill);

        JFormattedTextField frmtdtxtfldEnterFighterSkill = new JFormattedTextField();
        frmtdtxtfldEnterFighterSkill.setText("0");
        frmtdtxtfldEnterFighterSkill.setColumns(2);
        FighterSkill.add(frmtdtxtfldEnterFighterSkill);
        
        JButton FInc = new JButton("+");
        FighterSkill.add(FInc);

        JPanel TraderSkill = new JPanel();
        add(TraderSkill);

        JLabel lblTraderSkill = new JLabel("Trader Skill Points");
        TraderSkill.add(lblTraderSkill);

        JFormattedTextField frmtdtxtfldEnterTraderSkill = new JFormattedTextField();
        frmtdtxtfldEnterTraderSkill.setText("0");
        frmtdtxtfldEnterTraderSkill.setColumns(2);
        TraderSkill.add(frmtdtxtfldEnterTraderSkill);
        
        JButton TInc = new JButton("+");
        TraderSkill.add(TInc);

        JPanel EngineerSkill = new JPanel();
        add(EngineerSkill);

        JLabel lblEngineerSkill = new JLabel("Engineer Skill Points");
        EngineerSkill.add(lblEngineerSkill);

        JFormattedTextField frmtdtxtfldEnterEngineerSkill = new JFormattedTextField();
        frmtdtxtfldEnterEngineerSkill.setText("0");
        frmtdtxtfldEnterEngineerSkill.setColumns(2);
        EngineerSkill.add(frmtdtxtfldEnterEngineerSkill);
        
        JButton EInc = new JButton("+");
        EngineerSkill.add(EInc);

        JPanel Difficulty = new JPanel();
        add(Difficulty);

        JLabel lblDifficulty = new JLabel("Difficulty");
        Difficulty.add(lblDifficulty);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Easy", "Medium", "Hard"}));
        Difficulty.add(comboBox);

        JPanel Confirm = new JPanel();
        add(Confirm);

        JButton btnConfirm = new JButton("Confirm");
        Confirm.add(btnConfirm);
	}

}
