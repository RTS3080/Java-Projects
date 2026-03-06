import java.awt.*;
import java.util.*;

public class Tail{
    ArrayList<Segment> segments;
    String side;
    public Tail(){
        segments = new ArrayList<>();
    }
    public Tail(String side){
        segments = new ArrayList<>();
        this.side = side;
    }
    public Tail(ArrayList<Segment> segments){
        this.segments = segments;
    }
    public void addSegment(Segment segment){
        segments.add(segment);
    }
    public Segment getEndSegment(){
        return segments.removeLast();
    }
    public ArrayList<Segment> getSegments(){
        return segments;
    }
    public String getSide(){
        return side;
    }
    public void setSide(String side){
        this.side = side;
    }
    public boolean intersects(Rider o) {
        for(Segment seg : segments){
            if(o.intersects(seg)){
                return true;
            }
        }
        return false;
    }
    public void paint(Graphics g){

        for(Segment seg : segments){
            g.setColor(seg.getColor());
            g.fillRect(seg.x,seg.y,seg.w,seg.h);
        }
    }


}
