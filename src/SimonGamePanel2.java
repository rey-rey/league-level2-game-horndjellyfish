package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class SimonGamePanel2 extends JPanel implements  MouseListener {

    private  final int PANEL_SIZE = SimonFrame.HEIGHT;

    protected static final int BUTTON_WIDTH = SimonFrame.WIDTH / 2;
    protected static final int BUTTON_HEIGHT = SimonFrame.HEIGHT / 2;

    private SimonFrame _parent = null;
    private SimonGPButton _greenButton = new SimonGreenButton();
    private SimonGPButton _redButton = new SimonRedButton();
    private SimonGPButton _yellowButton = new SimonYellowButton();
    private SimonGPButton _blueButton = new SimonBlueButton();

    private SimonPatternManager _patternManager = new SimonPatternManager();

    private SimonFlashButtonTimer _flashButtonTimer = null;
    private SimonFlashPatternTimer2 _flashPatternTimer = null;

    // one array that contain the user selection
    private ArrayList<Integer> _userSelectionPattern = new ArrayList<Integer>();

    // User score
    private int _score = 0;

    public SimonGamePanel2(SimonFrame parent) {
        _parent = parent;

        // create timer to Flash a Button
        _flashButtonTimer = new SimonFlashButtonTimer( this );

        // Create timer to Flash a Pattern
        _flashPatternTimer = new SimonFlashPatternTimer2( this,
                _greenButton, _redButton, _blueButton, _yellowButton);

        // Listen to mouse clicks
        this.addMouseListener(this);
    }

    // start a new Game
    public void startGame() {
        _score = 0;

        //  create new Pattern
        _patternManager.startNewPattern();

        // create our Flash Pattern
        UpdateNFlashClonePattern();
    }

    // Stop the Game
    public void stopGame() {
        _parent.stopGame( _score );
    }

    // paint the Game Panel
    public void paintComponent(Graphics g) {
//System.out.println("***** GamePanel: PaintComponent");
        super.paintComponent(g);

        // paint the background
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, PANEL_SIZE, PANEL_SIZE);

        // paint the buttons
        paintButtons(g);
    }

    // paint all our buttons
    private void paintButtons (Graphics g ) {
        _greenButton.paintComponent(g);
        _redButton.paintComponent(g);
        _yellowButton.paintComponent(g);
        _blueButton.paintComponent(g);
    }

    //  Make sure game panel is repainted
    public void repaintTheGamePanel() {
        revalidate();;
        repaint();
    }

    // need to update flash pattern that shown to user
    private void UpdateNFlashClonePattern() {
        // get a clone of the pattern
        // We are going to update clone, as such, do not want to update original
        ArrayList<Integer> flashClonePattern = _patternManager.getClonePattern();

        // Now Start our timer to Flash the Pattern
        _flashPatternTimer.start( flashClonePattern );

        // reinitialize the user selection pattern
        // Since we have a new Pattern, user will have to repopulate
        _userSelectionPattern = new ArrayList<Integer>();
    }

    // Retrieve the  button that was just  clicked
    private SimonGPButton getButtonClicked( int mouseX, int mouseY) {
        SimonGPButton button = null;

        //  check the mouseX and mouseY against each button
        //  whichever contains XY must be the button that was clicked
        if ( _blueButton.Contains( mouseX, mouseY) ) {
            button = _blueButton;
        } else if ( _redButton.Contains( mouseX, mouseY) )  {
            button = _redButton;
        } else if ( _greenButton.Contains( mouseX, mouseY) )  {
            button = _greenButton;
        } else if ( _yellowButton.Contains( mouseX, mouseY) )  {
            button = _yellowButton;
        }
        return button;
    }

    //  Process the button that was just selected
    //  This is a callback from SimonFlashButtonTimer
    public void processButtonSelected(SimonGPButton button ) {
//System.out.println("processButtonSelected: " + button.getButtonName());
        // Add the users selection, to our list of user selections
        _userSelectionPattern.add(button.getButtonColorNumber());

        // now check all of user selection against computer generated Pattern
        int patternStatus = _patternManager.checkPattern( _userSelectionPattern);
//System.out.println( "     checkUserPattern: " + patternStatus);

        if (patternStatus == SimonPatternManager.PATTERN_DIFFERENT) {
            // WRONG selection !
            stopGame();
        }  else if (patternStatus ==  SimonPatternManager.PATTERN_SAME ) {
            // Button selection is Correct, but more button clicks to check
        }  else if (patternStatus ==  SimonPatternManager.PATTERN_SAME_AND_DONE ) {
           // success, so increment the score
           _score++;

           // Now let's add another color to comp pattern
           _patternManager.addToPattern();

           //  now reset our Flash Pattern, and start flashing again
           UpdateNFlashClonePattern();
        }
    }

    //  Flash the button that was just selected
    private void flashButtonSelected(SimonGPButton button ) {
        // NOTE. Make sure we are done processing any previous button selected, or pattern
        //       Trying to avoid starting/running two different timers at same time
        if ( _flashButtonTimer.isRunning()) {
            // ignore if we are flashing the button
//System.out.println("flashButtonSelected: Button Timer Running");
        } else if (_flashPatternTimer.isRunning() ) {
            // ignore if we are flashing the pattern
//System.out.println("flashButtonSelected: Button Pattern Running");
        } else {
//System.out.println("flashButtonSelected: Start Timer" + button.getButtonName());
            // Start timer to flash the button
            _flashButtonTimer.start( button );
        }
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        // figure out what button was pressed
        SimonGPButton button = getButtonClicked( e.getX(), e.getY());
//System.out.println("MousePressed: " + button.getButtonName());

        // Flash button to user (if all is okay to flash)
        flashButtonSelected( button );
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}

