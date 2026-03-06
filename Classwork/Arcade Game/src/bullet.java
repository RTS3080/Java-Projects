import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class bullet extends Block{

    public bullet(int x, int y,int velo) {
        super(x, y, 5,15,velo);
    }

    public void paint(Graphics g) {
        Image img = new ImageIcon("galaga bullet.png").getImage();
        g.drawImage(img, getX(), getY(), getW(), getH(), this);
    }
}
