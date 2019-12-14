import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Simon.simon.paint(g);
	}
}
