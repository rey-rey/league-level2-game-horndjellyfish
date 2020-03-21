//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Graphics;
//import java.awt.event.ActionEvent;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.util.ArrayList;
//
//import javax.swing.JPanel;
//
//public class GamePanel extends JPanel implements KeyListener {
////	protected void paintComponent(Graphics g) {
////		super.paintComponent(g);
////		Simon.simon.paint(g);
////	}
//	int MENU_STATE = 0;
//	int GAME_STATE = 1;
//	int END_STATE = 2;
//	int currentState = MENU_STATE;
//	Font titleFont = new Font("Impact", Font.PLAIN, 120);
//	Font subtitleFont = new Font("Impact", Font.PLAIN, 40);
//	Font smaller = new Font("Impact", Font.PLAIN, 20);
//	Simon simon;
//	PatternManager pm;
//
//	GamePanel(Simon simon) {
//		this.simon = simon;
//		pm = new PatternManager(simon);
//	}
//
//	public void drawMenuState(Graphics g) {
//		g.setColor(Color.black);
//		g.fillRect(0, 0, 600, 600);
//		g.setColor(Color.white);
//		g.setFont(titleFont);
//		g.drawString("SIMON", 140, 300);
//		g.setFont(subtitleFont);
//		g.drawString("Press Enter to start", 150, 400);
//		g.setFont(smaller);
//		g.drawString("When the game starts, different colors will light up. When the color", 40, 470);
//		g.drawString("lights up, click that color. As time goes on, the pattern will get", 60, 495);
//		g.drawString("increasingly more complex. Don't press the wrong color!", 80, 520);
//	}
//
//	public void drawGameState(Graphics g) {
//
//		g.setColor(Color.BLACK);
//		g.fillRect(0, 0, simon.width, simon.height);
//		if (simon.flash == 0) {
//			g.setColor(Color.GREEN);
//		} else {
//			g.setColor(Color.GREEN.darker());
//		}
//		g.fillRect(0, 0, 300, 300);
//		if (simon.flash == 1) {
//			g.setColor(Color.RED);
//		} else {
//			g.setColor(Color.RED.darker());
//		}
//		g.fillRect(300, 0, 300, 300);
//		if (simon.flash == 2) {
//			g.setColor(Color.YELLOW);
//		} else {
//			g.setColor(Color.YELLOW.darker());
//		}
//		g.fillRect(0, 290, 300, 300);
//		if (simon.flash == 3) {
//			g.setColor(Color.BLUE);
//		} else {
//			g.setColor(Color.BLUE.darker());
//		}
//		g.fillRect(300, 290, 300, 300);
//		// pm.makePattern();
//	}
//
//	public void drawEndState(Graphics g) {
//		g.setColor(Color.black);
//		g.fillRect(0, 0, 600, 600);
//		g.setColor(Color.WHITE);
//		g.setFont(titleFont);
//		g.drawString("GAME OVER", 30, 300);
//	}
//
//	public void actionPerformed(ActionEvent e) {
//		if (currentState == MENU_STATE) {
//			updateMenuState();
//		} else if (currentState == GAME_STATE) {
//			updateGameState();
//		} else if (currentState == END_STATE) {
//			updateEndState();
//		}
//		repaint();
//	}
//
//	private void updateEndState() {
//
//	}
//
//	private void updateGameState() {
//
//	}
//
//	private void updateMenuState() {
//
//	}
//
//	public void paintComponent(Graphics g) {
//		if (currentState == MENU_STATE) {
//			drawMenuState(g);
//		} else if (currentState == GAME_STATE) {
//			drawGameState(g);
//		} else if (currentState == END_STATE) {
//			drawEndState(g);
//		}
//	}
//
//	public void keyTyped(KeyEvent e) {
//
//	}
//
//	public void keyPressed(KeyEvent e) {
//		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//			if (currentState == MENU_STATE) {
//				currentState = GAME_STATE;
//			} else if (currentState == GAME_STATE) {
//				currentState = END_STATE;
//			} else if (currentState == END_STATE) {
//				currentState = MENU_STATE;
//			}
//		}
//	}
//
//	public void keyReleased(KeyEvent e) {
//
//	}
//
//}
