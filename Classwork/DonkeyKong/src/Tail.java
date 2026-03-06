import java.util.*;
import java.io.*;
import java.awt.*;

public class Tail extends Canvas{
    ArrayList<Rectangle> segmentList;
    Color color;
    public Tail(){
        super();
        this.segmentList = new ArrayList<>();
        this.color = Color.BLUE;
        
    }
    
    public Tail(ArrayList<Rectangle> segmentList, Color color) {
        this.segmentList = segmentList;
        this.color = color;
    }
    public Tail (Color color) {
        this.segmentList = new ArrayList();
        this.color = color;
    }
    public ArrayList<Rectangle> getSegmentList() {
        return segmentList;
    }
    public void addSegment(int x, int y, int w, int h){
        segmentList.add(new Rectangle(x,y,w,h));
    }
    public void paint(Graphics g,int w, int h){
        g.setColor(this.color);
        for (int i = 0; i < segmentList.size(); i++) {
            Rectangle r = segmentList.get(i);
            if(i == segmentList.size() - 1){
                r.setBounds(r.x,r.y, (int) (w-r.getWidth()),(int)(h-r.getHeight()));
                segmentList.set(i,r);
            }

            g.fillRect((int) r.getX(), (int) r.getY(), (int) r.getWidth(), (int) r.getHeight());
        }
        repaint();
    }
    public boolean intersects(Rectangle o){
        for(Rectangle r : segmentList){
            if(r.intersects(o)){
                return true;
            }
        }
        return false;
    }
}
