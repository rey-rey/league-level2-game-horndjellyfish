package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SimonGamePanel extends JPanel implements ActionListener, MouseListener {

    private  final int PANEL_SIZE = SimonFrame.HEIGHT;

    protected static final int BUTTON_WIDTH = SimonFrame.WIDTH / 2;
    protected static final int BUTTON_HEIGHT = SimonFrame.HEIGHT / 2;

    SimonFrame _parent = null;
    SimonGPButton _greenButton = new SimonGreenButton();
    SimonGPButton _redButton = new SimonRedButton();
    SimonGPButton _yellowButton = new SimonYellowButton();
    SimonGPButton _blueButton = new SimonBlueButton();
    SimonPatternManager _patternManager = new SimonPatternManager();


    // we need to keep two patterns arrays

    // one array that contain the user selection
    ArrayList<Integer> _userSelectionPattern = new ArrayList<Integer>();

    // one array so we can flash.
    // Note.  When flashing we will remove items from this array
    //        This way we can know when to stop flashing
    ArrayList<Integer> _flashClonePattern = new ArrayList<Integer>();
    private boolean _flashClonePatternFlashing = false;

    // need a field to hold the next color to flash.  Used in the Timer ActionPerformed Method
    //private int _flashColor = -1;
    Timer _timer = new Timer(1000, this);

    private int _score = 0;
    private boolean _startGame = false;
    private SimonGPButton _lastButtonSelected = null;
    private boolean _lastButtonSelectedFlashing = false;

    public SimonGamePanel(SimonFrame parent) {
        _parent = parent;
        this.addMouseListener(this);
    }

    // start a new Game
    public void startGame() {
        _startGame = true;
        _score = 0;

        //  create new Pattern
        _patternManager.startNewPattern();

        // since pattern has changed, need to update our Flash Pattern
        UpdateFlashClonePattern();

        // make sure we redraw
        repaintTheGamePanel();
    }

    // Stop the Game
    public void stopGame() {
        _startGame = false;
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

        if (!_startGame) {
            // Game not started.  Nothing more to paint.
        } else if (checkStartFlashPattern()) {
            // currently flashing.
            // see Timer.  ActionPerformed() for logic
        } else if (_lastButtonSelectedFlashing) {
            // reset
            _lastButtonSelectedFlashing = false;
            if (_lastButtonSelected != null ) {
                _lastButtonSelected.stopFlash();
                _lastButtonSelected = null;
            }

            // now check is Button Selected is correct
            if ( !checkUserSelections() ) {
                stopGame();
            } else {
               //  repaint, to redo logic
               repaintTheGamePanel();
            }
        } else if (checkPaintFlashButtonSelected(g)) {
           // Just Flash the Button Selected
           _lastButtonSelectedFlashing  = true;

           // reset, so next time we will stop the flash
           _lastButtonSelected.stopFlash();
           _lastButtonSelected = null;
        }
    }

    // paint all our buttons
    public void paintButtons (Graphics g ) {
        _greenButton.paintComponent(g);
        _redButton.paintComponent(g);
        _yellowButton.paintComponent(g);
        _blueButton.paintComponent(g);
    }

    //check if button Click matches Simon's current Pattern
    public boolean checkUserSelections () {
        boolean match = false;

        // check all of user selection against computer generated Pattern
        int patternStatus = _patternManager.checkPattern( _userSelectionPattern);
//System.out.println( "checkUserPattern: " + patternStatus);

        if (patternStatus == SimonPatternManager.PATTERN_DIFFERENT) {
            // WRONG selection !
            match = false;
        }  else if (patternStatus ==  SimonPatternManager.PATTERN_SAME ) {
            // Button selection is Correct, but more button clicks to check
            match = true;
        }  else if (patternStatus ==  SimonPatternManager.PATTERN_SAME_AND_DONE ) {
            match = true;
            // ALL Button Selections are Correct

            // increment the score
            _score++;

            // Now let's add Another color to patter
            _patternManager.addToPattern();

            //  Since new color added, our separate Flash Pattern needs updating
            UpdateFlashClonePattern();
        }
        return match;
    }

    // check and start time to Flash Pattern
    private boolean checkStartFlashPattern() {
        boolean flashing = false;
        // check if there is anything left to flash
        if ( _flashClonePattern.size() <= 0 ) {
            // nothing to flash
            flashing = false;
            _flashClonePatternFlashing = false;
        }
        else  {
            flashing = true;
            _flashClonePatternFlashing = true;
            // start time if not already stared
            if (!_timer.isRunning()) {
                _timer.start();
            }
        }
 //System.out.println ("CheckStartFlashPattern: " + flashing);
        return flashing;
    }
    // Check and Flash the last selected button
    private boolean checkPaintFlashButtonSelected(Graphics g ) {
        boolean flash = false;
//System.out.println ("**** CheckPaintFlashButtonSelected: " );
        if ( _lastButtonSelected != null ) {
            flash = true;

//System.out.println ("CheckPaintFlashButtonSelected: Call Button Paint" );
            // Flash Button
            _lastButtonSelected.paintComponent(g);

            //  Need to timer, so when can UnFlash'
            if (!_timer.isRunning()) {
//System.out.println ("CheckPaintFlashButtonSelected: Start Timer" );
                _timer.start();
            }
        }
//System.out.println ("----- CheckPaintFlashButtonSelected: " + flash);
        return flash;
    }

    // need to update flash pattern that shown to user
    private void UpdateFlashClonePattern() {
        _flashClonePattern = _patternManager.getClonePattern();

        // reinitialize  the user selection pattern
        _userSelectionPattern = new ArrayList<Integer>();
    }

    // Set Button State to Start Flashing
    // Note.  This just set state, so on next Paint, it will Flash
    private void setToStartFlashing(int color) {
        if (color == 0) {
            _greenButton.startFlash();
        } else if (color == 1) {
            _blueButton.startFlash();
        } else if (color == 2) {
            _redButton.startFlash();
        } else if (color == 3) {
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

    // Setup to Flash the Pattern
    private boolean checkNFlashPattern() {
        boolean flash = false;

        //  Does pattern have any more colors to Flash?
        if (_flashClonePattern.size()  > 0 ) {
            flash = true;

        // get the first item in the array to flash
        int flashColor = _flashClonePattern.get(0);
//System.out.println("checkNFlashPattern:  " +  flashColor );
        setToStartFlashing(flashColor);

        // remove the first item.  For Next time
        _flashClonePattern.remove( 0);
    }
        return flash;
    }

    // Setup to Flash the Button Selected
    private boolean checkNFlashButton() {
        boolean flash = false;
        //  Is there a Button Selected?
        if ( _lastButtonSelected != null ) {
            flash = true;

            // Get Button, and setup to Flash
            int flashColor = _lastButtonSelected.getButtonColorNumber();
//System.out.println("checkNFlashButton:  " +  flashColor );
            setToStartFlashing(flashColor);
        }
        return flash;
    }

    //  This is used for the Timer
    //  Set all Buttons to STOP Flashing to clear everything
    //  Then set specified button to START FLASHING
    public void actionPerformed(ActionEvent e) {
//System.out.println("1 timer's on: " + System.currentTimeMillis() );
        // clear any flashing
        setToStopFlashing();

        if (checkNFlashButton()) {
           // flashing button Selected
        } else if (checkNFlashPattern()) {
            // flashing Pattern
        } else {
            // nothing to flash so stop timer
            _timer.stop();
        }

        // Force a Repaint, so above action will be done
        repaintTheGamePanel();
    }

    //  This is used for the Timer
    //  Set all Buttons to STOP Flashing to clear everything
    //  Then set specified button to START FLASHING
    public void OLD_WAY_actionPerformed(ActionEvent e) {
System.out.println("2 timer's on: " + System.currentTimeMillis() );
        // clear any flashing
        setToStopFlashing();

        if ( (_flashClonePattern.size() <= 0 ) && ( _lastButtonSelected == null ) ) {
            // Timer needed in 2 scenarios
            // 1.  Need to continue to Flash our Color Pattern, or
            // 2.  Need to Flash the Button just selected

            //  Note.  Make sure Button Selected has finished it flash/unflash
            if (!_lastButtonSelectedFlashing) {
                _timer.stop();
            }
        } else if ( _lastButtonSelected != null ) {
            int flashColor = _lastButtonSelected.getButtonColorNumber();
//System.out.println("ActionPerformed: Button. SetToStartFlashing: " +  flashColor );
            setToStartFlashing(flashColor);
        } else {
            // get the first item in the array to flash
            int flashColor = _flashClonePattern.get(0);
//System.out.println("ActionPerformed: Pattern. SetToStartFlashing: " +  flashColor );
            setToStartFlashing(flashColor);

            // remove the first item.  For Next time
            _flashClonePattern.remove( 0);
        }

        // Force a Repaint, so above action will be done
        repaintTheGamePanel();
    }

    // figure out what button was clicked
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

    //  Make sure game panel is repainted
    public void repaintTheGamePanel() {
        revalidate();;
        repaint();
    }

    //  Process the mouse button that was just clicked
    public void processMouseButtonClicked( SimonGPButton button ) {
        // make sure we are done processing last button selected
        if ( _lastButtonSelectedFlashing) {
            // ignore if we are flashing the last Button Selected
        } else if (_flashClonePatternFlashing ) {
            // ignore if we are flashing the pattern
        } else {
//System.out.println("processMouseClicked: " + button.getButtonName());
            // save off last button click
            _lastButtonSelected = button;
            _lastButtonSelected.startFlash();

            // Add the Button Selected to the array of users selection
            _userSelectionPattern.add(_lastButtonSelected.getButtonColorNumber());
            repaintTheGamePanel();
        }
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        // figure out what button was pressed
        SimonGPButton button = getButtonClicked( e.getX(), e.getY());
        // now process mouse selected
        processMouseButtonClicked(button);
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

}

