import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Timer;

import javax.swing.JFrame;

public class Simon implements ActionListener, MouseListener {
	JFrame frame = new JFrame("Simon Game");
	final int width = 600;
	final int height = 600;
	public int flash;
	public int light;
	public int time;
	Timer timer = new Timer(20, this);
	GamePanel gp = new GamePanel();
	public static Simon simon;
	public static void main(String[] args) {
		simon = new Simon();
		simon.create();
	}

	public void create() {
		frame.setVisible(true);
		frame.setSize(600, 600);
		frame.setResizable(false);
		frame.addMouseListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(gp);
		timer.start();

	}

	public void mouseClicked(MouseEvent arg0) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if (x > 0 && x < 300 && y > 0 && y < 300) {
			flash = 0;
			time = 1;
		} else if (x > 300 && x < width && y > 0 && y < 300) {
			flash = 1;
			time = 1;
		} else if (x > 0 && x < 300 && y > 300 && y < width) {
			flash = 2;
			time = 1;
		} else if (x > 300 && x < width && y > 300 && y < width) {
			flash = 3;
			time = 1;
		}
		
	}

	public void mouseReleased(MouseEvent e) {

	}

	public void actionPerformed(ActionEvent e) {
		time = time + 1;
		if (time%20 == 0) {
			flash = -1;
		}
		gp.repaint();
	}

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		if (flash == 0) {
			g.setColor(Color.GREEN);
		} else {
			g.setColor(Color.GREEN.darker());
		}
		g.fillRect(0,  0, 300, 300);
		if (flash == 1) {
			g.setColor(Color.RED);
		} else {
			g.setColor(Color.RED.darker());
		}
		g.fillRect(300, 0, 300, 300);
		if (flash == 2) {
			g.setColor(Color.YELLOW);
		} else {
			g.setColor(Color.YELLOW.darker());
		}
		g.fillRect(0, 290, 300, 300);
		if (flash == 3) {
			g.setColor(Color.BLUE);
		} else {
			g.setColor(Color.BLUE.darker());
		}
		g.fillRect(300, 290, 300, 300);
		
		
		
		
		
	}
}
