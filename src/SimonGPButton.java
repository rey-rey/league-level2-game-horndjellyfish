package src;

import java.awt.*;

public class SimonGPButton {
    //base class
    private final int WIDTH = SimonFrame.WIDTH / 2;
    private final int HEIGHT = SimonFrame.HEIGHT / 2;

    protected String _name = "";
    protected int _buttonColorNumber = -1;

    // save state of flash


    private boolean _flash = false;

    // paint the button

    public void paintComponent(Graphics g) {
        g.setColor( Color.BLACK);
        g.drawRect(getX(), getY(), WIDTH, HEIGHT);

        g.setColor(getDisplayColor());
        g.fillRect(getX(), getY(), WIDTH-1, HEIGHT-1);

        g.setColor( Color.BLACK);
        g.drawString( _name, getX() + (WIDTH/2), getY() + HEIGHT/2);
    }

    // Set the state to turn flash Color ON
    public void startFlash() {
        _flash = true;
    }

    // Set the state to turn flash Color OFF
    public void stopFlash() {
        _flash = false;
    }

    // get Color to display on Button; Regular vs Flash
    private Color getDisplayColor() {
        Color clr = null;
        if (_flash) {
            clr = getFlashColor();
//System.out.println( "   " + _name + " FLASH-FLASH-FLASH-FLASH: " + clr);
        } else {
            //clr = getColor();
           clr = Color.GRAY;
//System.out.println( "   " + _name + " NO Flash: " + clr);
        }
        return clr;
    }

    // Retrieve name of the Button
    public String getButtonName() {
        return _name;
    }

    // Retrieve  Button Color Number
    public int getButtonColorNumber() {
        return _buttonColorNumber;
    }

    // Return Button Color
    protected Color getColor() {
        return Color.GRAY; //default, should overwrite in subclass
    }

    // Return the Button Flash Color
    public Color getFlashColor() {
        return getColor().brighter();
    }
    // Return Button Start X
    protected int getX() {
        return 0;
    }

    // Return Button Start Y
    protected int getY() {
        return 0;
    }

    // Check if this buttons contains the passed mouse X,Y is in this Button
    public boolean Contains(int mouseX, int mouseY ) {
        boolean clicked = false;

        // get start and end of X
        int startX = getX();
        int endX = startX + WIDTH;

        // get start and end of Y
        int startY = getY();
        int endY = startY + HEIGHT;

        // Now check against passed in values
        // Note.  If value is outside any of the checks, then no need to check anymore
        if (mouseX < startX) {
           // outside x
        } else if (mouseX > endX) {
            // outside x
        } else  if (mouseY < startY) {
            // outside y
        } else if (mouseY > endY) {
            // outside y
        } else {
            // all good
            clicked = true;
        }
       return clicked;
    }
}
