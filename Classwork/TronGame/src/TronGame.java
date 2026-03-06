import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class TronGame extends JPanel implements Runnable, KeyListener {
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private final int TILE_SIZE = 5;
    private boolean isGameOver = false;

    private Rider player1;
    private Rider player2;

    private Rider winner;

    private KeyEvent P1LastKeyPressed;
    private KeyEvent P2LastKeyPressed;

    private boolean[] keys; // For key inputs

    public TronGame() {

        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        // Initialize players
        player1 = new Rider(200, 300, "good");
        player2 = new Rider(600, 300, "evil");


        keys = new boolean[256]; // Handles all key codes

        new Thread(this).start();
    }

    public void paint(Graphics window) {
        window.setColor(Color.BLACK);
        window.fillRect(0, 0, WIDTH, HEIGHT);

        // Draw players and their trails
        if(P1LastKeyPressed!=null) {
            player1.move(P1LastKeyPressed, TILE_SIZE, Color.CYAN);
        }


        if(P2LastKeyPressed!=null) {
            player2.move(P2LastKeyPressed, TILE_SIZE,Color.MAGENTA);
        }
        player1.paint(window);
        player2.paint(window);
        window.drawString("Mouse  coordinates " + "(" + MouseInfo.getPointerInfo().getLocation().x + "   " + MouseInfo.getPointerInfo().getLocation().y + ")", 250, 30 );

        // Debug: Print player positions
        System.out.println("Player 1 Position: " + player1.getX() + ", " + player1.getY());
        System.out.println("Player 2 Position: " + player2.getX() + ", " + player2.getY());

        // Player 1 movement
        if(P1LastKeyPressed!=null) {
            player1.move(P1LastKeyPressed, TILE_SIZE, Color.CYAN);
        }


        if(P2LastKeyPressed!=null) {
            player2.move(P2LastKeyPressed, TILE_SIZE,Color.MAGENTA);
        }


        checkCollisions();




        // Display game over message if applicable
        if (isGameOver) {
            window.setColor(Color.RED);
            window.setFont(new Font("Arial", Font.BOLD, 50));
            window.drawString("Game Over!", WIDTH / 2 - 150, HEIGHT / 2);
        }
    }



    private void checkCollisions() {
        // Wall collisions
        if (player1.getX() < 0 || player1.getX() >= WIDTH || player1.getY() < 0 || player1.getY() >= HEIGHT) {
            System.out.println("Player 1 hit the wall!");
            winner = player1;
            isGameOver = true;
        }
        if (player2.getX() < 0 || player2.getX() >= WIDTH || player2.getY() < 0 || player2.getY() >= HEIGHT) {
            System.out.println("Player 2 hit the wall!");
            winner = player2;
            isGameOver = true;
        }

        // Tail collisions
        if (player1.intersects(player2.getTail(),TILE_SIZE)) {
            System.out.println("Player 1 collided with Player 2's trail!");
            winner = player2;
            isGameOver = true;
        }
        if (player2.intersects(player1.getTail(),TILE_SIZE)) {
            System.out.println("Player 2 collided with Player 1's trail!");
            winner = player1;
            isGameOver = true;
        }

        // Self-collision
        if (player1.intersects(player1.getTail(),TILE_SIZE)) {
            System.out.println("Player 1 collided with their own trail!");
            winner = player2;
            isGameOver = true;
        }
        if (player2.intersects(player2.getTail(),TILE_SIZE)) {
            System.out.println("Player 2 collided with their own trail!");
            winner = player1;
            isGameOver = true;
        }
        if(player2.intersects(player1)) {
            winner = null;
            isGameOver = true;
            System.out.println("The Players collided with each other");
        }
    }



    public void run() {
        try {
            while (!isGameOver) {
                Thread.sleep(25);
                if(keys[KeyEvent.VK_ESCAPE]) {
                    System.exit(0);

                }
                repaint();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        if(e.getKeyCode()>= 65 && e.getKeyCode()<= 87) P1LastKeyPressed = e;
        if(e.getKeyCode()<= 40 && e.getKeyCode() >= 37) P2LastKeyPressed = e;
    }

    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    public void keyTyped(KeyEvent e) {
    }

}
