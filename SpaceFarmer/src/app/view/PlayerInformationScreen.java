/* This file holds the class PlayerInformationScreen, which 
 * represents the Screen where PlayerInformation is displayed.
 */
package app.view;

import app.listener.ConfirmPlayerCreationListener;
import app.listener.IncrementListener;

import javax.swing.*;
import java.awt.*;

/**
 * This screen shows the Player his information. (WIP)
 * 
 * @author Mark McDonald
 * @version 1.0
 */
public class PlayerInformationScreen extends Screen {

	/**
	 * Prevents "serializable" warning
	 */
	private static final long serialVersionUID = -3313579360751444648L;

	private JTextField enteredPlayerName;

	private JFormattedTextField enteredPilotSkill;

	private JFormattedTextField enteredFighterSkill;

	private JFormattedTextField enteredTraderSkill;

	private JFormattedTextField enteredEngineerSkill;

	private JLabel ErrorLabel;

	/**
	 * Create the panel.
	 */
	public PlayerInformationScreen() {
		name = CardName.PLAYER_INFORMATION_CARD;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		Component verticalStrut = Box.createVerticalStrut(20);
		add(verticalStrut);

		JPanel playerName = new JPanel();
		add(playerName);
		playerName.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblPlayerName = new JLabel("Player Name");
		playerName.add(lblPlayerName);

		enteredPlayerName = new JTextField();
		playerName.add(enteredPlayerName);
		enteredPlayerName.setColumns(10);

		JPanel allocatePointsInfo = new JPanel();
		JLabel numPointsToAllocate = new JLabel("Please Allocate 16 Points");
		allocatePointsInfo.add(numPointsToAllocate);
		add(allocatePointsInfo);

		JPanel pilotSkill = new JPanel();
		add(pilotSkill);

		JLabel lblPilotSkill = new JLabel("Pilot Skill Points");
		pilotSkill.add(lblPilotSkill);

		enteredPilotSkill = new JFormattedTextField();
		enteredPilotSkill.setText("0");
		enteredPilotSkill.setColumns(2);
		pilotSkill.add(enteredPilotSkill);

		JButton pInc = new JButton("+");
		pInc.addActionListener(new IncrementListener(enteredPilotSkill,
				IncrementListener.INC));
		pilotSkill.add(pInc);

		JButton pDec = new JButton("-");
		pDec.addActionListener(new IncrementListener(enteredPilotSkill,
				IncrementListener.DEC));
		pilotSkill.add(pDec);

		JPanel fighterSkill = new JPanel();
		add(fighterSkill);

		JLabel lblFighterSkill = new JLabel("Fighter Skill Points");
		fighterSkill.add(lblFighterSkill);

		enteredFighterSkill = new JFormattedTextField();
		enteredFighterSkill.setText("0");
		enteredFighterSkill.setColumns(2);
		fighterSkill.add(enteredFighterSkill);

		JButton fInc = new JButton("+");
		fInc.addActionListener(new IncrementListener(enteredFighterSkill,
				IncrementListener.INC));
		fighterSkill.add(fInc);

		JButton fDec = new JButton("-");
		fDec.addActionListener(new IncrementListener(enteredFighterSkill,
				IncrementListener.DEC));
		fighterSkill.add(fDec);

		JPanel traderSkill = new JPanel();
		add(traderSkill);

		JLabel lblTraderSkill = new JLabel("Trader Skill Points");
		traderSkill.add(lblTraderSkill);

		enteredTraderSkill = new JFormattedTextField();
		enteredTraderSkill.setText("0");
		enteredTraderSkill.setColumns(2);
		traderSkill.add(enteredTraderSkill);

		JButton tInc = new JButton("+");
		tInc.addActionListener(new IncrementListener(enteredTraderSkill,
				IncrementListener.INC));
		traderSkill.add(tInc);

		JButton tDec = new JButton("-");
		tDec.addActionListener(new IncrementListener(enteredTraderSkill,
				IncrementListener.DEC));
		traderSkill.add(tDec);

		JPanel engineerSkill = new JPanel();
		add(engineerSkill);

		JLabel lblEngineerSkill = new JLabel("Engineer Skill Points");
		engineerSkill.add(lblEngineerSkill);

		enteredEngineerSkill = new JFormattedTextField();
		enteredEngineerSkill.setText("0");
		enteredEngineerSkill.setColumns(2);
		engineerSkill.add(enteredEngineerSkill);

		JButton eInc = new JButton("+");
		eInc.addActionListener(new IncrementListener(enteredEngineerSkill,
				IncrementListener.INC));
		engineerSkill.add(eInc);

		JButton eDec = new JButton("-");
		eDec.addActionListener(new IncrementListener(enteredEngineerSkill,
				IncrementListener.DEC));
		engineerSkill.add(eDec);

		JPanel difficulty = new JPanel();
		add(difficulty);

		JLabel lblDifficulty = new JLabel("Difficulty");
		difficulty.add(lblDifficulty);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Easy",
				"Medium", "Hard", "Impossible" }));
		difficulty.add(comboBox);

		JPanel confirm = new JPanel();
		add(confirm);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setPreferredSize(new Dimension(120, 30));
		btnConfirm.addActionListener(new ConfirmPlayerCreationListener(this));
		confirm.add(btnConfirm);

		JPanel errorPanel = new JPanel();
		add(errorPanel);

		ErrorLabel = new JLabel("");
		errorPanel.add(ErrorLabel);

	}

	public void resetInputs() {
		enteredEngineerSkill.setText("0");
		enteredFighterSkill.setText("0");
		enteredPilotSkill.setText("0");
		enteredTraderSkill.setText("0");
		enteredPlayerName.setText("");
	}

	public void setErrorMessage(String message) {
		ErrorLabel.setText(message);
	}

	public String getTxtEnterPlayerNameData() {
		return enteredPlayerName.getText();
	}

	public int getEnteredPilotSkill() {
		return Integer.parseInt(enteredPilotSkill.getText());
	}

	public int getEnteredFighterSkill() {
		return Integer.parseInt(enteredFighterSkill.getText());
	}

	public int getEnteredTraderSkill() {
		return Integer.parseInt(enteredTraderSkill.getText());
	}

	public int getEnteredEngineerSkill() {
		return Integer.parseInt(enteredEngineerSkill.getText());
	}
}