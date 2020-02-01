import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ColorModel;

public class SimonGamePanel extends JPanel {

    public final int GREEN = 1;
    public final int BLUE = 2;
    public final int RED = 3;
    public final int YELLOW = 4;

    public final int PANEL_SIZE = SimonFrame.HEIGHT;
    protected static final int BUTTON_WIDTH = SimonFrame.WIDTH/2;
    protected static final int BUTTON_HEIGHT = SimonFrame.HEIGHT/2;

    SimonGPButton _greenButton = new SimonGreenButton();
    SimonGPButton _redButton = new SimonRedButton();

    // paint the Game Panel
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // paint the background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, PANEL_SIZE, PANEL_SIZE);

        // paint the buttons
        _greenButton.paintComponent(g);
        _redButton.paintComponent(g);
    }

}
