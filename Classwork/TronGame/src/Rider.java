import java.awt.event.KeyEvent;
import java.util.*;
import java.io.*;
import java.awt.*;

public class Rider extends Block{
    String side;
    Tail tail;
    KeyEvent LastKeyPressed;
    HashMap<Integer, String > keybinds;
    public Rider(){
        super(-1,-1,20,8);
        side = "good";
        tail = new Tail();
        keybinds = new HashMap<>();
    }
    public Rider(String side, Tail tail) {
        super(-1,-1,20,8);
        this.side = side;
        keybinds = new HashMap<>();
        this.tail = tail;
    }
    public Rider(int x, int y, String side) {
        super(x, y, 12, 12);
        this.side = side;
        keybinds = new HashMap<>();
        keybinds.put(KeyEvent.VK_W, "Up");
        keybinds.put(KeyEvent.VK_A, "Left");
        keybinds.put(KeyEvent.VK_S, "Down");
        keybinds.put(KeyEvent.VK_D, "Right");
        keybinds.put(KeyEvent.VK_UP, "Up");
        keybinds.put(KeyEvent.VK_LEFT, "Left");
        keybinds.put(KeyEvent.VK_DOWN, "Down");
        keybinds.put(KeyEvent.VK_RIGHT, "Right");
        this.tail = new Tail(side);
    }


    public String getSide(){
        return side;
    }
    public void setSide(String side){
        this.side = side;
    }
    public Tail getTail(){
        return tail;
    }
    public void setTail(Tail tail){
        this.tail = tail;
    }
    public void move(KeyEvent key, int TILE_SIZE,Color c){
        String s = keybinds.get(key.getKeyCode());
        switch (s) {
            case "Up" ->{
                y -= TILE_SIZE;
                tail.addSegment(new Segment(x+w,y,w,TILE_SIZE,c));
            }
            case "Right" -> {
                x += TILE_SIZE;
                tail.addSegment(new Segment(x-w,y,TILE_SIZE,h,c));
            }
            case "Down" -> {
                y += TILE_SIZE;
                tail.addSegment(new Segment(x+w,y-h,w,TILE_SIZE,c));
            }
            case "Left" -> {
                x -= TILE_SIZE;
                tail.addSegment(new Segment(x+w*2,y,TILE_SIZE,h,c));
            }
            default -> System.out.println("fix your code retard");
        }
    }
    public void directionSwap(KeyEvent key,KeyEvent PrevKey, int TILE_SIZE,Color c){
        String prev = keybinds.get(PrevKey.getKeyCode());
        String s = keybinds.get(key.getKeyCode());


    }

    public boolean intersects(Tail t, int TILE_SIZE){
        Rectangle rect = new Rectangle(x,y,w,h);
        for (int i = 0; i < t.getSegments().size(); i++) {
            Segment s = t.getSegments().get(i);
            Rectangle o  = new Rectangle(s.x,s.y,s.w,s.h);
            if(side.equals(t.getSide())){
                if(i>=t.getSegments().size()-w/TILE_SIZE-1){
                    continue;
                }
            }
            if(rect.intersects(o)){
                return true;
            }
        }
        return false;
    }
    public boolean intersects(Rider r){
        return new Rectangle(x,y,w,h).intersects(new Rectangle(r.x,r.y,r.w,r.h));
    }

    @Override
    public void paint(Graphics g) {


        if(side.equals("good")){
            g.setColor(Color.cyan);
            tail.paint(g);
        }
        else{
            g.setColor(Color.MAGENTA);
            tail.paint(g);
        }

        if(side.equals("good")) {
            g.setColor(Color.BLUE);
        }
        else{
            g.setColor(Color.RED);
        }
        g.fillRect(x,y,w,h);
        g.setColor(Color.GRAY);
        g.fillRect(x+w/4,y+h/4,w/2,h/2);


    }


}
