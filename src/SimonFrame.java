import javax.swing.*;

public class SimonFrame extends JFrame {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;

    SimonMenuPanel _menuPanel = new SimonMenuPanel();
    SimonGamePanel _gamePanel = new SimonGamePanel();

    public SimonFrame() {
        super( "Simon");
        setup();
        //displayMenuPanel();
        displayGamePanel();
    }

    private void setup() {
        setVisible(true);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void displayGamePanel() {
        this.add( _gamePanel) ;
    }

    private void displayMenuPanel() {
       this.add( _menuPanel) ;
    }

}