import java.awt.*;

public class SimonRedButton extends SimonGPButton{
    @Override
    protected Color getColor() {
        return( Color.RED);
    }

    @Override
    protected int getX() {
        return 300;
    }

    @Override
    protected int getY() {
        return 0;
    }

}
