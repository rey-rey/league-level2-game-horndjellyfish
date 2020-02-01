import java.awt.*;

public class SimonGPButton {

    private final int WIDTH = SimonFrame.WIDTH/2;
    private final int HEIGHT = SimonFrame.HEIGHT/2;

    // save state of flash
    private boolean _flash = false;

    // paint the button
    public void paintComponent(Graphics g) {
        g.setColor(getDisplayColor());
        g.fillRect(getX(), getY(), WIDTH, HEIGHT);
    }

    // Has the button been pressed
    public boolean isPressed (int x, int y ) {
        boolean pressed = false;
        if ( ( x < getX() )  || ( x > ( getX() + WIDTH) )   ) {
            // not in button x range
        }
        else if ( ( y < getY() )  || ( y > ( getY() + HEIGHT) )   ) {
            // not in button y range
        }
        else {
            pressed = true;
        }
        return pressed;
    }

    // Turn on flash Color
    public void startFlash () {
        _flash = true;
    }

    // Turn off flash Color
    public void stopFlash () {
        _flash = false;
    }

    // get Color to display on Button;  Regular vs Flash
    private Color getDisplayColor() {
        Color clr = null;
        if ( _flash ) {
            clr = getFlashColor();
        } else {
           clr = getColor();
        }
        return clr;
    }

    // Get Button Color
    protected Color getColor() {
        return Color.WHITE;
    }

    // Get Button Start X
    protected int getX() {
        return 0;
    }

    // Get Button Start Y
    protected int getY() {
        return 0;
    }

    // Get the Flash Color
    private Color getFlashColor() {
        return getColor().brighter().brighter();
    }
}
