import javax.swing.*;
import java.awt.*;

public class SimonMenuPanel extends JPanel {

    Font titleFont = new Font("Impact", Font.PLAIN, 120);
    Font subtitleFont = new Font("Impact", Font.PLAIN, 40);
    Font smaller = new Font("Impact", Font.PLAIN, 20);

    public void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, SimonFrame.WIDTH, SimonFrame.HEIGHT);
        /*
        g.setColor(Color.white);
        g.setFont(titleFont);
        g.drawString("SIMON", 140, 300);
        g.setFont(subtitleFont);
        g.drawString("Press Enter to start", 150, 400);
        g.setFont(smaller);
        g.drawString("When the game starts, different colors will light up. When the color", 40, 470);
        g.drawString("lights up, click that color. As time goes on, the pattern will get", 60, 495);
        g.drawString("increasingly more complex. Don't press the wrong color!", 80, 520);
         */
    }
}
