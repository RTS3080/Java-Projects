import org.w3c.dom.ls.LSOutput;

import java.awt.geom.Ellipse2D;
import java.util.*;
import java.awt.*;
import java.io.*;


public class tronPlayer extends Block{
    double xVelocity;
    double yVelocity;
    String up = "w";
    String down = "s";
    String left = "a";
    String right = "d";
    String moves = "wasd";

    public tronPlayer(){
        super();
        xVelocity = 0;
        yVelocity = 0;
    }
    public tronPlayer(int x, int y, int w, int h, double xVel, double yVel){
        super(x, y, w, h);
        xVelocity = xVel;
        yVelocity = yVel;
    }
    public void run(){
        KeyBox key = new KeyBox();

    }
}
