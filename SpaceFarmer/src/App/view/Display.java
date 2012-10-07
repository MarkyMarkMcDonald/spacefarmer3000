package App.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 *
 * User: marky
 * Date: 10/7/12
 * Time: 4:48 PM
 */
public class Display extends JFrame {

    private JPanel contentPane;
    private JTextField txtEnterPlayerName;

    /**
     * set up the initial screen
     */
    public void setup() {
        setTitle("Space Farmer 3000");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel TopPanel = new JPanel();
        TopPanel.setBackground(Color.GREEN);
        contentPane.add(TopPanel, BorderLayout.NORTH);
        TopPanel.setLayout(new BoxLayout(TopPanel, BoxLayout.X_AXIS));

        JLabel lblWip = new JLabel("WIP");
        TopPanel.add(lblWip);

        Component verticalStrut = Box.createVerticalStrut(80);
        TopPanel.add(verticalStrut);

        JPanel BottomPanel = new JPanel();
        BottomPanel.setBackground(Color.MAGENTA);
        contentPane.add(BottomPanel, BorderLayout.SOUTH);
        BottomPanel.setLayout(new BoxLayout(BottomPanel, BoxLayout.X_AXIS));

        JLabel label_1 = new JLabel("WIP");
        BottomPanel.add(label_1);

        Component verticalStrut_1 = Box.createVerticalStrut(80);
        BottomPanel.add(verticalStrut_1);

        JPanel LeftPanel = new JPanel();
        LeftPanel.setBackground(Color.CYAN);
        contentPane.add(LeftPanel, BorderLayout.WEST);
        LeftPanel.setLayout(new BoxLayout(LeftPanel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("WIP");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setAlignmentY(0.0f);
        LeftPanel.add(label);

        Component horizontalStrut = Box.createHorizontalStrut(100);
        LeftPanel.add(horizontalStrut);

        JPanel RightPanel = new JPanel();
        RightPanel.setBackground(Color.PINK);
        contentPane.add(RightPanel, BorderLayout.EAST);
        RightPanel.setLayout(new BoxLayout(RightPanel, BoxLayout.Y_AXIS));

        JLabel label_2 = new JLabel("WIP");
        label_2.setAlignmentX(Component.CENTER_ALIGNMENT);
        label_2.setAlignmentY(0.0f);
        RightPanel.add(label_2);

        Component horizontalStrut_1 = Box.createHorizontalStrut(100);
        RightPanel.add(horizontalStrut_1);

        JPanel CenterPanel = new JPanel();
        CenterPanel.setBackground(Color.ORANGE);
        contentPane.add(CenterPanel, BorderLayout.CENTER);
        CenterPanel.setLayout(new CardLayout(0, 0));

        JPanel WelcomeScreen = new JPanel();
        CenterPanel.add(WelcomeScreen, "name_446464616656544");
        WelcomeScreen.setLayout(new BoxLayout(WelcomeScreen, BoxLayout.Y_AXIS));

        Component TitleStrut1 = Box.createVerticalStrut(40);
        WelcomeScreen.add(TitleStrut1);

        JLabel WelcomeLabel1 = new JLabel("Space");
        WelcomeLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
        WelcomeLabel1.setAlignmentY(0.0f);
        WelcomeLabel1.setFont(new Font("Tahoma", Font.BOLD, 40));
        WelcomeScreen.add(WelcomeLabel1);

        Component TitleStrut2 = Box.createVerticalStrut(40);
        WelcomeScreen.add(TitleStrut2);

        JLabel WelcomeLabel2 = new JLabel("Farmer");
        WelcomeLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        WelcomeLabel2.setAlignmentY(0.0f);
        WelcomeLabel2.setFont(new Font("Tahoma", Font.BOLD, 40));
        WelcomeScreen.add(WelcomeLabel2);

        Component TitleStrut3 = Box.createVerticalStrut(40);
        WelcomeScreen.add(TitleStrut3);

        JLabel WelcomeLabel3 = new JLabel("3000");
        WelcomeLabel3.setAlignmentX(Component.CENTER_ALIGNMENT);
        WelcomeLabel3.setAlignmentY(0.0f);
        WelcomeLabel3.setFont(new Font("Tahoma", Font.BOLD, 40));
        WelcomeScreen.add(WelcomeLabel3);

        Component TitleStrut4 = Box.createVerticalStrut(40);
        WelcomeScreen.add(TitleStrut4);

        JPanel WelcomeButtonPanel = new JPanel();
        WelcomeScreen.add(WelcomeButtonPanel);

        JButton AboutButton = new JButton("    About    ");
        WelcomeButtonPanel.add(AboutButton);

        Component ButtonStrut1 = Box.createHorizontalStrut(50);
        WelcomeButtonPanel.add(ButtonStrut1);

        JButton NewGameButton = new JButton(" New Game");
        WelcomeButtonPanel.add(NewGameButton);

        Component ButtonStrut2 = Box.createHorizontalStrut(50);
        WelcomeButtonPanel.add(ButtonStrut2);

        JButton LoadGameButton = new JButton("Load Game");
        WelcomeButtonPanel.add(LoadGameButton);

        JPanel PlayerInformation = new JPanel();
        CenterPanel.add(PlayerInformation, "name_1349575637728092000");
        PlayerInformation.setLayout(new BoxLayout(PlayerInformation, BoxLayout.Y_AXIS));

        JPanel PlayerName = new JPanel();
        FlowLayout flowLayout = (FlowLayout) PlayerName.getLayout();
        flowLayout.setVgap(1);
        PlayerInformation.add(PlayerName);

        JLabel lblPlayerName = new JLabel("Player Name");
        PlayerName.add(lblPlayerName);

        txtEnterPlayerName = new JTextField();
        PlayerName.add(txtEnterPlayerName);
        txtEnterPlayerName.setColumns(10);

        JPanel PilotSkill = new JPanel();
        PlayerInformation.add(PilotSkill);

        JLabel lblPilotSkill = new JLabel("Pilot Skill Points");
        PilotSkill.add(lblPilotSkill);

        JFormattedTextField frmtdtxtfldEnterPilotSkill = new JFormattedTextField();
        frmtdtxtfldEnterPilotSkill.setColumns(2);
        PilotSkill.add(frmtdtxtfldEnterPilotSkill);

        JPanel FighterSkill = new JPanel();
        PlayerInformation.add(FighterSkill);

        JLabel lblFighterSkill = new JLabel("Fighter Skill Points");
        FighterSkill.add(lblFighterSkill);

        JFormattedTextField frmtdtxtfldEnterFighterSkill = new JFormattedTextField();
        frmtdtxtfldEnterFighterSkill.setColumns(2);
        FighterSkill.add(frmtdtxtfldEnterFighterSkill);

        JPanel TraderSkill = new JPanel();
        PlayerInformation.add(TraderSkill);

        JLabel lblTraderSkill = new JLabel("Trader Skill Points");
        TraderSkill.add(lblTraderSkill);

        JFormattedTextField frmtdtxtfldEnterTraderSkill = new JFormattedTextField();
        frmtdtxtfldEnterTraderSkill.setColumns(2);
        TraderSkill.add(frmtdtxtfldEnterTraderSkill);

        JPanel EngineerSkill = new JPanel();
        PlayerInformation.add(EngineerSkill);

        JLabel lblEngineerSkill = new JLabel("Engineer Skill Points");
        EngineerSkill.add(lblEngineerSkill);

        JFormattedTextField frmtdtxtfldEnterEngineerSkill = new JFormattedTextField();
        frmtdtxtfldEnterEngineerSkill.setColumns(2);
        EngineerSkill.add(frmtdtxtfldEnterEngineerSkill);

        JPanel Difficulty = new JPanel();
        PlayerInformation.add(Difficulty);

        JLabel lblDifficulty = new JLabel("Difficulty");
        Difficulty.add(lblDifficulty);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Easy", "Medium", "Hard"}));
        Difficulty.add(comboBox);

        JPanel Confirm = new JPanel();
        PlayerInformation.add(Confirm);

        JButton btnConfirm = new JButton("Confirm");
        Confirm.add(btnConfirm);
    }

    public JTextField getTxtEnterPlayerName() {
        return txtEnterPlayerName;
    }

    public void setTxtEnterPlayerName(JTextField txtEnterPlayerName) {
        this.txtEnterPlayerName = txtEnterPlayerName;
    }

    public JPanel getContentPane() {
        return contentPane;
    }

    public void setContentPane(JPanel contentPane) {
        this.contentPane = contentPane;
    }
}
