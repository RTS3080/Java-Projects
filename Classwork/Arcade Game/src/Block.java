import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

abstract class Block extends Canvas
{
    private int x, y, w, h;
    private double velo;
    public Block()
    {
        x=0;y=0;w=10;h=10;
        velo=0;
    }

    public Block( int ex, int wy, int wd, int ht, double velo )
    {
        x=ex;y=wy;w=wd;h=ht;
        this.velo=velo;
    }

    public int getX( ){ return x; }
    public void setX( int ex ){ x = ex; }
    public int getY( ){ return y; }
    public void setY( int wy ){ y = wy; }
    public int getW(){ return w; }
    public int getH(){ return h; }
    public double getVelo(){ return velo; }
    public void setVelo(double velo){ this.velo=velo; }


    public boolean intersects( Block other )
    {
        Rectangle rect=new Rectangle(x,y,w,h);
        Rectangle test=new Rectangle(other.getX(),other.getY(),other.getW(),other.getH());
        return test.intersects(rect);
    }
}