package src;

import java.awt.*;

public class SimonBlueButton extends SimonGPButton {
    //subclass

    public SimonBlueButton() {
        _buttonColorNumber = SimonPatternManager.BLUE;
        _name = "blue";
    }

    protected Color getColor() {
        return (Color.BLUE.darker());
    }

    protected int getX() {
        return (300);
    }

    protected int getY() {
        return (300);
    }
}
