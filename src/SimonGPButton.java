import java.awt.*;

public class SimonGPButton {

    protected int xStart = 0;
    protected int yStart = 0;
    private  int WIDTH = SimonGamePanel.BUTTON_WIDTH;
    private  int HEIGHT = SimonGamePanel.BUTTON_HEIGHT;



    protected boolean flash = false;

    public void paintComponent(Graphics g) {
        g.setColor(getColor());
        g.fillRect(xStart, yStart, WIDTH, HEIGHT);
    }

    protected Color getColor() {
        return Color.BLACK;
    }

    public boolean isPressed (int x, int y ) {
        boolean pressed = false;
        if ( ( x < xStart )  || ( x > ( xStart + WIDTH) )   ) {
            // not in button x range
        }
        else if ( ( y < yStart )  || ( y > ( yStart + HEIGHT) )   ) {
            // not in button y range
        }
        else {
            pressed = true;
        }
        return pressed;
    }

    public void startFlash () {
       flash = true;
    }

    public void stopFlash () {
        flash = false;
    }

}
