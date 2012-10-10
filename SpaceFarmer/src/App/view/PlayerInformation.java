package App.view;

import App.model.Player;
import App.listener.ConfirmListener;
import App.listener.IncrementListener;

import java.awt.FlowLayout;
import java.awt.Dimension;

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
import javax.swing.SpringLayout;

public class PlayerInformation extends JPanel {

	/**
	 * Prevents "serializable" warning
	 */
	private static final long serialVersionUID = -3313579360751444648L;
	private Display gameFrame;

	/**
	 * Create the panel.
	 */
	public PlayerInformation(Display gameFrame) {
		this.gameFrame = gameFrame;
		
		Player player = new Player();
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        Component verticalStrut = Box.createVerticalStrut(20);
        add(verticalStrut);

        JPanel PlayerName = new JPanel();
        add(PlayerName);
                PlayerName.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
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
        PInc.addActionListener(new IncrementListener(frmtdtxtfldEnterPilotSkill, IncrementListener.INC));
        PilotSkill.add(PInc);
        
        JButton PDec = new JButton("-");
        PDec.addActionListener(new IncrementListener(frmtdtxtfldEnterPilotSkill, IncrementListener.DEC));
        PilotSkill.add(PDec);

        JPanel FighterSkill = new JPanel();
        add(FighterSkill);

        JLabel lblFighterSkill = new JLabel("Fighter Skill Points");
        FighterSkill.add(lblFighterSkill);

        JFormattedTextField frmtdtxtfldEnterFighterSkill = new JFormattedTextField();
        frmtdtxtfldEnterFighterSkill.setText("0");
        frmtdtxtfldEnterFighterSkill.setColumns(2);
        FighterSkill.add(frmtdtxtfldEnterFighterSkill);
        
        JButton FInc = new JButton("+");
        FInc.addActionListener(new IncrementListener(frmtdtxtfldEnterFighterSkill, IncrementListener.INC));
        FighterSkill.add(FInc);
        
        JButton FDec = new JButton("-");
        FDec.addActionListener(new IncrementListener(frmtdtxtfldEnterFighterSkill, IncrementListener.DEC));
        FighterSkill.add(FDec);

        JPanel TraderSkill = new JPanel();
        add(TraderSkill);

        JLabel lblTraderSkill = new JLabel("Trader Skill Points");
        TraderSkill.add(lblTraderSkill);

        JFormattedTextField frmtdtxtfldEnterTraderSkill = new JFormattedTextField();
        frmtdtxtfldEnterTraderSkill.setText("0");
        frmtdtxtfldEnterTraderSkill.setColumns(2);
        TraderSkill.add(frmtdtxtfldEnterTraderSkill);
        
        JButton TInc = new JButton("+");
        TInc.addActionListener(new IncrementListener(frmtdtxtfldEnterTraderSkill, IncrementListener.INC));
        TraderSkill.add(TInc);
        
        JButton TDec = new JButton("-");
        TDec.addActionListener(new IncrementListener(frmtdtxtfldEnterTraderSkill, IncrementListener.DEC));
        TraderSkill.add(TDec);

        JPanel EngineerSkill = new JPanel();
        add(EngineerSkill);

        JLabel lblEngineerSkill = new JLabel("Engineer Skill Points");
        EngineerSkill.add(lblEngineerSkill);

        JFormattedTextField frmtdtxtfldEnterEngineerSkill = new JFormattedTextField();
        frmtdtxtfldEnterEngineerSkill.setText("0");
        frmtdtxtfldEnterEngineerSkill.setColumns(2);
        EngineerSkill.add(frmtdtxtfldEnterEngineerSkill);
        
        JButton EInc = new JButton("+");
        EInc.addActionListener(new IncrementListener(frmtdtxtfldEnterEngineerSkill, IncrementListener.INC));
        EngineerSkill.add(EInc);
        
        JButton EDec = new JButton("-");
        EDec.addActionListener(new IncrementListener(frmtdtxtfldEnterEngineerSkill, IncrementListener.DEC));
        EngineerSkill.add(EDec);

        JPanel Difficulty = new JPanel();
        add(Difficulty);

        JLabel lblDifficulty = new JLabel("Difficulty");
        Difficulty.add(lblDifficulty);

        JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Easy", "Medium", "Hard", "Impossible"}));
        Difficulty.add(comboBox);

        JPanel Confirm = new JPanel();
        add(Confirm);

        JButton btnConfirm = new JButton("Confirm");
        btnConfirm.setPreferredSize(new Dimension(120, 30));
        btnConfirm.addActionListener(new ConfirmListener(gameFrame));
        Confirm.add(btnConfirm);
	}
}