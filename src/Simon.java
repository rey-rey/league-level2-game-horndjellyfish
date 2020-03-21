//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.util.ArrayList;
//import java.util.Random;
//
//import javax.swing.Timer;
//
//import javax.swing.JFrame;
//
//public class Simon implements ActionListener, MouseListener {
//	JFrame frame = new JFrame("Simon Game");
//	final int width = 600;
//	final int height = 600;
//	public int flash;
//	public int light;
//	public int time;
//	Timer timer = new Timer(20, this);
//	GamePanel gp;
//	public static Simon simon;
//	public ArrayList<Integer> pattern;
//	public boolean makingPattern = true;
//	public Random rand;
//
//	public static void main(String[] args) {
//		simon = new Simon();
//		simon.create();
//
//	}
//
//	public void create() {
//		gp = new GamePanel(this);
//		frame.setVisible(true);
//		frame.setSize(600, 600);
//		frame.setResizable(false);
//		frame.addMouseListener(this);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.addKeyListener(gp);
//		frame.add(gp);
//		start();
//		timer.start();
//	}
//
//	public void start() {
//		rand = new Random();
//		pattern = new ArrayList<Integer>();
//	}
//
//	public void mousePressed(MouseEvent e) {
//		int x = e.getX();
//		int y = e.getY();
//		if (!makingPattern) {
//			if (x > 0 && x < 300 && y > 0 && y < 300) {
//				flash = 0;
//				time = 1;
//			} else if (x > 300 && x < width && y > 0 && y < 300) {
//				flash = 1;
//				time = 1;
//			} else if (x > 0 && x < 300 && y > 300 && y < width) {
//				flash = 2;
//				time = 1;
//			} else if (x > 300 && x < width && y > 300 && y < width) {
//				flash = 3;
//				time = 1;
//			}
//		}
//	}
//
//	public void actionPerformed(ActionEvent e) {
//		time = time + 1;
//		if (time % 20 == 0) {
//			flash = -1;
//			if (makingPattern) {
//				flash = rand.nextInt(4);
//				pattern.add(flash);
//
//			}
//		}
//		gp.repaint();
//	}
//
//	public void mouseClicked(MouseEvent arg0) {
//
//	}
//
//	public void mouseEntered(MouseEvent e) {
//
//	}
//
//	public void mouseExited(MouseEvent e) {
//
//	}
//
//	public void mouseReleased(MouseEvent e) {
//
//	}
//
//}
