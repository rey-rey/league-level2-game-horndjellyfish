import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class LeagueInvaders {
    JFrame frame = new JFrame();
    final int height = 800;
    final int width = 500;
    GamePanel gp = new GamePanel();

    public static void main(String[] args) {
        LeagueInvaders LI = new LeagueInvaders();
        LI.setup();
    }

    public void setup() {
        frame.add(gp);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(gp);
        frame.getContentPane().setPreferredSize(new Dimension(width, height));
        frame.pack();
        gp.startGame();
    }
}
