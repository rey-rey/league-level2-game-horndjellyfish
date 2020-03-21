package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SimonFlashPatternTimer2 implements ActionListener {

    private SimonGamePanel2 _parent = null;

    private SimonGPButton _greenButton = null;
    private SimonGPButton _redButton = null;
    private SimonGPButton _yellowButton = null;
    private SimonGPButton _blueButton = null;

    private ArrayList<Integer> _flashPattern = null;
    private Timer _timer = null;
    private int _delay = 1000;
    private boolean _stopTimer = false;

    private SimonFlashButtonTimer2 _buttonTimer = null;

    public SimonFlashPatternTimer2(SimonGamePanel2 parent,
                                   SimonGPButton green,
                                   SimonGPButton red,
                                   SimonGPButton blue,
                                   SimonGPButton yellow) {
        _parent = parent;
        _greenButton = green;
        _redButton = red;
        _blueButton = blue;
        _yellowButton = yellow;

        _timer = new Timer( _delay, this);
        // since button timer has to flash and unflash, make the delay less than half the Flash Timer
        int buttonDelay = (int)(_delay *.45);
        _buttonTimer = new SimonFlashButtonTimer2( _parent, buttonDelay );
    }

    //  Start the Timer
    public void start (ArrayList<Integer> flashPattern ) {
        // save off the pattern
        _flashPattern = flashPattern;

        // start time, and set our flag
        _timer.start();
        _stopTimer = false;
    }

    //  Check if the Timer is running
    public boolean isRunning() {
        // needed to include the flag, because Pattern timer was stopping too slow
       return ( _timer.isRunning() && (!_stopTimer) );
    }

    // Stop the timer
    private void stop() {
        // reset flag, and stop timer
        _stopTimer = true;
        _timer.stop();
    }

    // Main action for the timer
    public void actionPerformed(ActionEvent e) {
        if ( _buttonTimer.isRunning() ) {
            //  Skip this iteration if button timer still working
        } else {
            // clear any previous flashes
            setToStopFlashing();

            // check if there is anything left to flash
            if (_stopTimer) {
                //  time to stop, nothing more to flash
                _stopTimer = true;
                stop();
                // returning here so we do not have to repaint
                return;  // do not want to, but....
            } else if (_flashPattern.size() <= 0) {
                // Our flash pattern is complete
                // stop timer next time in
                _stopTimer = true;
            } else {
                // get the first item in our flash pattern array to flash
                int flashColor = _flashPattern.get(0);
                _buttonTimer.start(getButton(flashColor));

                // remove the item from our flash pattern array.
                // Eventually all will be remove, that is when we know we are done flashing
                _flashPattern.remove(0);
            }

            // repaint the GamePanel to paint our Buttons
            _parent.repaintTheGamePanel();
        }
    }

    // Set Button State to Start Flashing
    // Note.  This just set state, so on next Paint, it will Flash
    private void setToStartFlashing(int buttonColorNumber) {
        if (buttonColorNumber == _greenButton.getButtonColorNumber()) {
            _greenButton.startFlash();
        } else if (buttonColorNumber == _blueButton.getButtonColorNumber()) {
            _blueButton.startFlash();
        } else if (buttonColorNumber == _redButton.getButtonColorNumber()) {
            _redButton.startFlash();
        } else if (buttonColorNumber == _yellowButton.getButtonColorNumber()) {
            _yellowButton.startFlash();
        }
    }

    // Set ALL Button State to Stop Flashing
    // Note.  This just set state, so on next Paint, it will not Flash
    private void setToStopFlashing() {
        _greenButton.stopFlash();
        _blueButton.stopFlash();
        _redButton.stopFlash();
        _yellowButton.stopFlash();
    }

    //  Retrieve button associated with buttonColor
    private SimonGPButton getButton ( int buttonColor ) {
        SimonGPButton button = null;
        if (_greenButton.getButtonColorNumber() == buttonColor) {
            button = _greenButton;
        } else if (_blueButton.getButtonColorNumber() == buttonColor) {
            button = _blueButton;
        } else if (_redButton.getButtonColorNumber() == buttonColor) {
            button = _redButton;
        } else if (_yellowButton.getButtonColorNumber() == buttonColor) {
            button = _yellowButton;
        }
        return button;
    }
}
