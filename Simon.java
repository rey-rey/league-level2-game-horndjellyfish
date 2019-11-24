import javax.swing.JFrame;

public class Simon {
	JFrame frame = new JFrame();
	JButton button = new JButton();
	GamePanel gp = new GamePanel();
	Buttons bu = new Buttons();
	public static void main (String [] args) {
		Simon simon = new Simon();
		simon.create();
	}
	public void create() {
		frame.setVisible(true);
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(gp);
		frame.add(bu);
		
	}
}
