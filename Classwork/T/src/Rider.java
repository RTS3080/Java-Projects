import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;


class Rider {
    private int x, y;
    private int dx, dy;
    private List<Point> trail;
    private Color color;
    private int up, down, left, right;

    public Rider(Color color, int up, int down, int left, int right) {
        this.color = color;
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        this.x = 400;
        this.y = 300;
        this.dx = 1;
        this.dy = 0;
        this.trail = new ArrayList<>();
        trail.add(new Point(x, y));
    }

    public void move() {
        x += dx;
        y += dy;
        trail.add(new Point(x, y));
    }

    public void draw(Graphics g) {
        g.setColor(color);
        for (Point p : trail) {
            g.fillRect(p.x, p.y, 10, 10);
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == up) {
            dx = 0;
            dy = -1;
        } else if (key == down) {
            dx = 0;
            dy = 1;
        } else if (key == left) {
            dx = -1;
            dy = 0;
        } else if (key == right) {
            dx = 1;
            dy = 0;
        }
    }

    public boolean collidesWith(Rider other) {
        for (Point p : trail) {
            if (p.equals(other.getHead())) {
                return true;
            }
        }
        return false;
    }

    public Point getHead() {
        return new Point(x, y);
    }
}
