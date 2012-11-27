/* This file holds the class PlayerInformationScreen, which 
 * represents the Screen where PlayerInformation is displayed.
 */
package app.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.listener.ConfirmPlayerCreationListener;
import app.listener.IncrementListener;

/**
 * This screen shows the Player his information. (WIP)
 * 
 * @author Mark McDonald
 * @version 1.0
 */
public class PlayerInformationScreen extends Screen {

	/**
	 * Amount for vertical strut
	 */
	private static final int VERTICAL_STRUT_AMOUNT = 20;
	
	/**
	 * Flow layout horizontal gap.
	 */
	private static final int FLOW_HORIZONTAL_GAP  = 5;
	
	/**
	 * Flow layout vertical gap.
	 */
	private static final int FLOW_VERTICAL_GAP  = 5;
	
	/**
	 * Number of columns.
	 */
	private static final int COLUMN_NUMBER = 10;
	
	/**
	 * Number of columns for skills.
	 */
	private static final int SKILL_COLUMN_NUMBER = 2;
	
	/**
	 * Preferred width of the confirm button.
	 */
	private static final int CONFIRM_X = 120;
	
	/**
	 * Preferred height of the confirm button.
	 */
	private static final int CONFIRM_Y = 30;
	
	/**
	 * Prevents "serializable" warning
	 */
	private static final long serialVersionUID = -3313579360751444648L;

	/**
	 * Text field for the Player's name.
	 */
	private final JTextField enteredPlayerName;

	/**
	 * Text field for the Pilot SkillType.
	 */
	private final JFormattedTextField enteredPilotSkill;

	/**
	 * Text field for the Fighter SkillType.
	 */
	private final JFormattedTextField enteredFighterSkill;

	/**
	 * Text field for the Trader SkillType.
	 */
	private final JFormattedTextField enteredTraderSkill;

	/**
	 * Text field for the Engineer SkillType.
	 */
	private final JFormattedTextField enteredEngineerSkill;

	/**
	 * JLabel for when a Player enters information incorrectly.
	 */
	private final JLabel errorLabel;

	/**
	 * Create the panel.
	 */
	public PlayerInformationScreen() {
		name = CardName.PLAYER_INFORMATION_CARD;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		final Component verticalStrut = Box.createVerticalStrut(VERTICAL_STRUT_AMOUNT);
		add(verticalStrut);

		final JPanel playerName = new JPanel();
		add(playerName);
		playerName.setLayout(new FlowLayout
				(FlowLayout.CENTER, FLOW_HORIZONTAL_GAP, FLOW_VERTICAL_GAP));

		final JLabel lblPlayerName = new JLabel("Player Name");
		playerName.add(lblPlayerName);

		enteredPlayerName = new JTextField();
		playerName.add(enteredPlayerName);
		enteredPlayerName.setColumns(COLUMN_NUMBER);

		final JPanel allocatePointsInfo = new JPanel();
		final JLabel numPointsToAllocate = new JLabel("Please Allocate 16 Points");
		allocatePointsInfo.add(numPointsToAllocate);
		add(allocatePointsInfo);

		final JPanel pilotSkill = new JPanel();
		add(pilotSkill);

		final JLabel lblPilotSkill = new JLabel("Pilot Skill Points");
		pilotSkill.add(lblPilotSkill);

		enteredPilotSkill = new JFormattedTextField();
		enteredPilotSkill.setText("0");
		enteredPilotSkill.setColumns(SKILL_COLUMN_NUMBER);
		pilotSkill.add(enteredPilotSkill);

		final JButton pInc = new JButton("+");
		pInc.addActionListener(new IncrementListener(enteredPilotSkill,
				IncrementListener.INC));
		pilotSkill.add(pInc);

		final JButton pDec = new JButton("-");
		pDec.addActionListener(new IncrementListener(enteredPilotSkill,
				IncrementListener.DEC));
		pilotSkill.add(pDec);

		final JPanel fighterSkill = new JPanel();
		add(fighterSkill);

		final JLabel lblFighterSkill = new JLabel("Fighter Skill Points");
		fighterSkill.add(lblFighterSkill);

		enteredFighterSkill = new JFormattedTextField();
		enteredFighterSkill.setText("0");
		enteredFighterSkill.setColumns(SKILL_COLUMN_NUMBER);
		fighterSkill.add(enteredFighterSkill);

		final JButton fInc = new JButton("+");
		fInc.addActionListener(new IncrementListener(enteredFighterSkill,
				IncrementListener.INC));
		fighterSkill.add(fInc);

		final JButton fDec = new JButton("-");
		fDec.addActionListener(new IncrementListener(enteredFighterSkill,
				IncrementListener.DEC));
		fighterSkill.add(fDec);

		final JPanel traderSkill = new JPanel();
		add(traderSkill);

		final JLabel lblTraderSkill = new JLabel("Trader Skill Points");
		traderSkill.add(lblTraderSkill);

		enteredTraderSkill = new JFormattedTextField();
		enteredTraderSkill.setText("0");
		enteredTraderSkill.setColumns(SKILL_COLUMN_NUMBER);
		traderSkill.add(enteredTraderSkill);

		final JButton tInc = new JButton("+");
		tInc.addActionListener(new IncrementListener(enteredTraderSkill,
				IncrementListener.INC));
		traderSkill.add(tInc);

		final JButton tDec = new JButton("-");
		tDec.addActionListener(new IncrementListener(enteredTraderSkill,
				IncrementListener.DEC));
		traderSkill.add(tDec);

		final JPanel engineerSkill = new JPanel();
		add(engineerSkill);

		final JLabel lblEngineerSkill = new JLabel("Engineer Skill Points");
		engineerSkill.add(lblEngineerSkill);

		enteredEngineerSkill = new JFormattedTextField();
		enteredEngineerSkill.setText("0");
		enteredEngineerSkill.setColumns(SKILL_COLUMN_NUMBER);
		engineerSkill.add(enteredEngineerSkill);

		final JButton eInc = new JButton("+");
		eInc.addActionListener(new IncrementListener(enteredEngineerSkill,
				IncrementListener.INC));
		engineerSkill.add(eInc);

		final JButton eDec = new JButton("-");
		eDec.addActionListener(new IncrementListener(enteredEngineerSkill,
				IncrementListener.DEC));
		engineerSkill.add(eDec);

		final JPanel difficulty = new JPanel();
		add(difficulty);

		final JLabel lblDifficulty = new JLabel("Difficulty");
		difficulty.add(lblDifficulty);

		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Easy",
				"Medium", "Hard", "Impossible" }));
		difficulty.add(comboBox);

		final JPanel confirm = new JPanel();
		add(confirm);

		final JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setPreferredSize(new Dimension(CONFIRM_X, CONFIRM_Y));
		btnConfirm.addActionListener(new ConfirmPlayerCreationListener(this));
		confirm.add(btnConfirm);

		final JPanel errorPanel = new JPanel();
		add(errorPanel);

		errorLabel = new JLabel("");
		errorPanel.add(errorLabel);

	}

	/**
	 * Resets the inputs of the text fields.
	 */
	public void resetInputs() {
		enteredEngineerSkill.setText("0");
		enteredFighterSkill.setText("0");
		enteredPilotSkill.setText("0");
		enteredTraderSkill.setText("0");
		enteredPlayerName.setText("");
	}

	/**
	 * Sets the error label to the given message.
	 * @param message String to set the label to.
	 */
	public void setErrorMessage(String message) {
		errorLabel.setText(message);
	}

	/**
	 * @return Text in the enteredPlayerName text field.
	 */
	public String getTxtEnterPlayerNameData() {
		return enteredPlayerName.getText();
	}

	/**
	 * @return Integer in the getEnteredPilotSkill field.
	 */
	public int getEnteredPilotSkill() {
		try{
			return Integer.parseInt(enteredPilotSkill.getText());
		}
		catch (Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}

	/**
	 * @return Integer in the getEnteredFighterSkill field.
	 */
	public int getEnteredFighterSkill() {
		try{
			return Integer.parseInt(enteredFighterSkill.getText());
		}
		catch (Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}

	/**
	 * @return Integer in the getEnteredTraderSkill field.
	 */
	public int getEnteredTraderSkill() {
		try{
			return Integer.parseInt(enteredTraderSkill.getText());
		}
		catch (Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}

	/**
	 * @return Integer in the getEnteredEngineerSkill field.
	 */
	public int getEnteredEngineerSkill() {
		try{
			return Integer.parseInt(enteredEngineerSkill.getText());
		}
		catch (Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}

	/**
	 * @param name String to set for the text on enteredPlayerName.
	 */
    public void setEnteredPlayerName(String name) {
        enteredPlayerName.setText(name);
    }

    /**
     * @param enteredPilotSkill String to set for the text on enteredPilotSkill.
     */
    public void setEnteredPilotSkill(String enteredPilotSkill) {
        this.enteredPilotSkill.setText(enteredPilotSkill);
    }

    /**
     * @param enteredFighterSkill String to set for the text on enteredFighterSkill.
     */
    public void setEnteredFighterSkill(String enteredFighterSkill) {
        this.enteredFighterSkill.setText(enteredFighterSkill);
    }

    /**
     * @param enteredTraderSkill String to set for the text on enteredTraderSkill.
     */
    public void setEnteredTraderSkill(String enteredTraderSkill) {
        this.enteredTraderSkill.setText(enteredTraderSkill);
    }

    /**
     * @param enteredEngineerSkill String to set for the text on enteredEngineerSkill.
     */
    public void setEnteredEngineerSkill(String enteredEngineerSkill) {
        this.enteredEngineerSkill.setText(enteredEngineerSkill);
    }
}