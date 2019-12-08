import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener {
//	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		Simon.simon.paint(g);
//	}

	int MENU_STATE = 0;
	int GAME_STATE = 1;
	int END_STATE = 2;
	int INSTRUCTIONS_STATE = 3;
	int currentState = MENU_STATE;
	Font titleFont = new Font("Impact", Font.PLAIN, 120);
	Font subtitleFont = new Font("Impact", Font.PLAIN, 40);

	public void drawMenuState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 600, 600);
		g.setColor(Color.WHITE);
		g.setFont(titleFont);
		g.drawString("SIMON", 140, 300);
		g.setFont(subtitleFont);
		g.drawString("Press Enter to start", 150, 400);
		g.drawString("Press Space for instructions", 70, 440);
	}
	
	public void drawInstructionsState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0,  0,  600,  600);
		g.setColor(Color.WHITE);
		g.setFont(subtitleFont);
		g.drawString("When the game starts, different colors will light up.\nWhen the color lights up, click that color.\nAs time goes on, the pattern will get increasingly more complex.\nDon't press the wrong color!", 50, 50);
	}

	public void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 600, 600);
		g.setColor(Color.GREEN.darker());
		g.fillRect(0, 0, 300, 300);
		g.setColor(Color.RED.darker());
		g.fillRect(300, 0, 300, 300);
		g.setColor(Color.YELLOW.darker());
		g.fillRect(0, 290, 300, 300);
		g.setColor(Color.BLUE.darker());
		g.fillRect(300, 290, 300, 300);

	}
	public void drawEndState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0,  0,  600,  600);
		g.setColor(Color.WHITE);
		g.setFont(titleFont);
		g.drawString("GAME OVER", 250, 300);
	}
	public void actionPerformed(ActionEvent e) {
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}
		repaint();
	}

	public void updateEndState() {
		
	}

	public void updateGameState() {
	
	}

	public void updateMenuState() {
	
	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == INSTRUCTIONS_STATE) {
			drawInstructionsState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
	}
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == MENU_STATE) {
				currentState = GAME_STATE;
			} else if (currentState == GAME_STATE) {
				currentState = END_STATE;
			} else if (currentState == END_STATE) {
				currentState = MENU_STATE;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			currentState = INSTRUCTIONS_STATE;
		}
	}
		

	public void keyTyped(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {

	}

}
