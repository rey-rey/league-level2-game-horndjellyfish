package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimonFrame extends JFrame  {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;

    SimonMenuPanel _menuPanel = new SimonMenuPanel(this);
    SimonEndPanel _endPanel = new SimonEndPanel(this);

    //SimonGamePanel _gamePanel = new SimonGamePanel(this);
    SimonGamePanel2 _gamePanel = new SimonGamePanel2(this);

    public CardLayout _layout = new CardLayout();

    public SimonFrame() {
        super("Simon Frame");
        setup();
        displayMenuPanel();
        displayGamePanel();
        displayEndPanel();
    }

    // configure and setup UI Frame
    private void setup() {
        this.setLayout(_layout);
        this.addKeyListener(_menuPanel);

        setVisible(true);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // start the Game
    public void startGame() {
        // switch to Game Panel Card
        _layout.next(this.getContentPane());

        // Start Game Panel
        _gamePanel.startGame();
    }

    // Stop the Game
    public void stopGame( int score) {
        // update the score
        _endPanel.setScore( score );

        // Switch to END Card UI
        _layout.next(this.getContentPane());
    }

    //  Add Game Panel UI to Cards
    private void displayGamePanel() {
        this.add(_gamePanel);
    }

    //  Add Menu Panel UI to Cards
    private void displayMenuPanel() {
        this.add(_menuPanel);
    }

    //  Add End Panel UI to Cards
    private void displayEndPanel() {
        this.add(_endPanel);
    }

}