import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class TronGame extends JPanel implements ActionListener {
    private Timer timer;
    private Rider player1;
    private Rider player2;
    private final int DELAY = 100;
    private final int WIDTH = 800;
    private final int HEIGHT = 600;

    public TronGame() {
        initGame();
    }

    private void initGame() {
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        player1 = new Rider(Color.BLUE, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D);
        player2 = new Rider(Color.RED, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
        addKeyListener(new TAdapter());

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawPlayers(g);
    }

    private void drawPlayers(Graphics g) {
        player1.draw(g);
        player2.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player1.move();
        player2.move();
        checkCollisions();
        repaint();
    }

    private void checkCollisions() {
        if (player1.collidesWith(player2) || player2.collidesWith(player1)) {
            timer.stop();
            JOptionPane.showMessageDialog(this, "Game Over!");
        }
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            player1.keyPressed(e);
            player2.keyPressed(e);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tron Game");
        TronGame game = new TronGame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
