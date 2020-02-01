import java.awt.*;

public class SimonGreenButton extends SimonGPButton{

    public SimonGreenButton() {
       super();
       xStart = 0;
       yStart = 0;
    }

    @Override
    protected Color getColor() {
        Color clr;
        if ( flash ) {
            clr = Color.GREEN.brighter().brighter();
        }
        else {
            clr = Color.GREEN;
        }
        return clr;
    }
}
