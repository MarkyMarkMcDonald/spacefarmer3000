import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ButtonListener implements ActionListener {

	private MiniGameFrame frame;
	
	public ButtonListener(MiniGameFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		frame.playMiniGame();
	}
}
