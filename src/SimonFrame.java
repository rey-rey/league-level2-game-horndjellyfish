import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SimonFrame extends JFrame implements KeyListener {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;

    SimonMenuPanel _menuPanel = new SimonMenuPanel( this );
    SimonGamePanel _gamePanel = new SimonGamePanel();
    public CardLayout _layout = new CardLayout();

    public SimonFrame() {
        super( "Simon Frame");
        setup();
        displayMenuPanel();
        displayGamePanel();
    }

    private void setup() {
        this.setLayout( _layout );
        this.addKeyListener( _menuPanel);
        //this.addKeyListener( this);
        setVisible(true);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void switchCard() {
        _layout.next( this.getContentPane());
    }

    private void displayGamePanel() {
        this.add( _gamePanel) ;
    }

    private void displayMenuPanel() {
       this.add( _menuPanel) ;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            _layout.next(this);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}