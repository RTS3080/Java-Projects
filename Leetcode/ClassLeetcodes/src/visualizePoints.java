import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class visualizePoints extends JPanel {

    private List<Point> points;

    public visualizePoints(List<Point> points) {
        this.points = points;
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);

        int padding = 50;
        int scale = 50;

        for (Point p : points) {
            int x = padding + p.x * scale;
            int y = getHeight() - (padding + p.y * scale);

            g2.fillOval(x - 4, y - 4, 8, 8);
            g2.drawString("(" + p.x + "," + p.y + ")", x + 5, y - 5);
        }
    }

    public static void main(String[] args) {
//[[3,0],[4,0],[5,0],[6,1],[7,2],[7,3],[7,4],[6,5],[5,5],[4,5],[3,5],[2,5],[1,4],[1,3],[1,2],[2,1],[4,2],[0,3]]
        ArrayList<Point> pts = new ArrayList<>();
        Scanner f = new Scanner(System.in);
        String ln = f.nextLine().trim();
        ln = ln.substring(1, ln.length() - 1);
        String[] points = ln.split("],\\[");
        for(String s : points){
            s = s.replaceAll("[\\[\\]]", "");
            String[] split = s.split(",");
            Point p = new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            pts.add(p);
        }


        JFrame frame = new JFrame("Point Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.add(new visualizePoints(pts));
        frame.setVisible(true);
    }
}
