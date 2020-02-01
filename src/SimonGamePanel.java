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

    SimonGPButton greenButton = new SimonGreenButton();

    public SimonGamePanel() {
       super();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 600, 600);

        greenButton.paintComponent(g);
    }

}
