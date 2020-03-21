package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimonFlashButtonTimer implements ActionListener {

    private int BUTTON_SELECTED         = 0;
    private int BUTTON_FLASHING         = 1;
    private int BUTTON_FLASHING_STOPPED = 2;

    private SimonGamePanel2 _parent = null;

    private SimonGPButton _flashButton = null;
    private int  _flashState = BUTTON_SELECTED;

    private Timer _timer = null;

    public SimonFlashButtonTimer(SimonGamePanel2 parent ) {
        _parent = parent;
        _timer = new Timer( 200, this);
    }

    //  Start the Timer for flashing passed in button
    public void start ( SimonGPButton button ) {
        _flashButton = button;
        _flashState = BUTTON_SELECTED;
        _timer.start();
    }

    //  Check if the Timer is running
    public boolean isRunning() {
        boolean running = _timer.isRunning();
        return running;
    }

    // Stop the timer
    private void stop() {
        // set flag just in case
        _flashState = BUTTON_FLASHING_STOPPED;
        _timer.stop();

        // now that we are done flashing button, let parent process the button selected
        _parent.processButtonSelected( _flashButton);
    }

    // Main action for the timer
    public void actionPerformed(ActionEvent e) {
        // check if there is anything left to flash
        if ( _flashState == BUTTON_FLASHING_STOPPED ) {
            //  Flashing has stopped, so stop this timer
           stop();
        } else if ( _flashState == BUTTON_SELECTED ) {
            // User just pressed button
            _flashButton.startFlash();

//System.out.println( "Flash Button Timer: FLASHING FLASHING: " +  _flashButton.getButtonName());
            // repaint the GamePanel to paint our Flash Button
            _parent.repaintTheGamePanel();

            // set state to flashing
            _flashState = BUTTON_FLASHING;
        } else if ( _flashState == BUTTON_FLASHING ) {
            // Button has been flashing so let stop it
            _flashButton.stopFlash();

//System.out.println( "Flash Button Timer: Stop Flashing " +  _flashButton.getButtonName());
            // repaint the GamePanel to paint our UN-Flashed button
            _parent.repaintTheGamePanel();

            // reset state to flashing has been stopped
            _flashState = BUTTON_FLASHING_STOPPED;
        }
    }
}
