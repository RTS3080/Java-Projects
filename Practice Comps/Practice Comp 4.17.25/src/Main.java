import javax.sound.sampled.Line;
import java.awt.*;
import java.awt.geom.*;

public class Main {
    public static void main(String[] args) {
        Line2D l = new Line2D.Double(2,1,2,2);
        Line2D a = new Line2D.Double(-1,-1,2,2);
        System.out.println(l.intersectsLine(a));
        System.out.println("Hello world!");
    }
}