package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SimonEndPanel extends JPanel implements KeyListener {
    Font titleFont = new Font("Impact", Font.PLAIN, 120);
    Font subtitleFont = new Font("Impact", Font.PLAIN, 40);
    SimonFrame _parent = null;
    int _score = 0;

    public SimonEndPanel(SimonFrame parent) {
        _parent = parent;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 600, 600);
        g.setColor(Color.WHITE);
        g.setFont(titleFont);
        g.drawString("GAME OVER", 30, 300);
        g.setFont(subtitleFont);
        //g.drawString("Score: " + parent._gamePanel.score, 250, 400);
        g.drawString("Score: " + _score, 250, 400);
    }

    public void setScore ( int score ) {
        _score = score;
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            _parent.startGame();
        }
    }

    public void keyReleased(KeyEvent e) {

    }
}
