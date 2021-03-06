import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.CardLayout;


public class MiniGameFrame extends JFrame {

	private static final long serialVersionUID = 4980454723791390090L;
	private JPanel MainContentPanel;
	private JLabel ResultLabel;
	private MiniGamePanel Game;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiniGameFrame frame = new MiniGameFrame();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MiniGameFrame() {
		setTitle("Minigame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		MainContentPanel = new JPanel();
		MainContentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(MainContentPanel);
		MainContentPanel.setLayout(new CardLayout(0, 0));
		
		JPanel TitlePanel = new JPanel();
		MainContentPanel.add(TitlePanel, "Title");
		Game = new MiniGamePanel(this);
		MainContentPanel.add(Game, "Game");
		TitlePanel.setLayout(new BoxLayout(TitlePanel, BoxLayout.Y_AXIS));
		
		JPanel MiddlePanel = new JPanel();
		TitlePanel.add(MiddlePanel);
		MiddlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton StartButton = new JButton("Start Game");
		StartButton.addActionListener(new ButtonListener(this));
		MiddlePanel.add(StartButton);
		
		JPanel BottomPanel = new JPanel();
		TitlePanel.add(BottomPanel);
		BottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		ResultLabel = new JLabel("Use left and right to guide the ship off the right side of the screen!");
		ResultLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BottomPanel.add(ResultLabel);
	}

	public void playMiniGame() {
		CardLayout layout = (CardLayout)MainContentPanel.getLayout();
		Game.setup();
		layout.show(MainContentPanel, "Game");
		Game.playGame();
	}
	
	public void returnToTitle(boolean won) {
		if(won) {
			setResultLabel("You won!");
		} else {
			setResultLabel("You lost!");
		}
		((CardLayout)MainContentPanel.getLayout()).show(MainContentPanel, "Title");
	}
	
	private void setResultLabel(String msg) {
		ResultLabel.setText(msg);
	}
}
