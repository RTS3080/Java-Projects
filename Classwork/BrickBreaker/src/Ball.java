import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

/*
 *	Directions: extend the Block class to use the Block methods
 *
 *				Override the paint method to draw a Ball
 *				
 *				Make an xspeed and a yspeed instance variable in order to make the ball bounce
 *				
 *				Create a Ball constructor, using the Paddle constructor as an example, it can still take
 *				in just one speed, then set both instance variables to that one speed.
 *				
 *				Create a bounce method that keeps the ball on the screen but bounces around the screen.
 *				Do NOT test if the ball is touching the bricks or the paddle in this method, you will do that
 *				in the game logic in BreakOut.java.
 *
 *				Go to BreakOut and do Step 2 and test it in the runner.
 *
 *				If all works then move on to Brick
 *				
 */

class Ball extends Block
{
	private int xSpeed;
    private int ySpeed;
	public Ball(int ex, int ey, int ew,int eh, int spx,int spy){
        super(ex,ey,ew,eh);
        xSpeed=spx;
        ySpeed=spy;
    }

    public int getXSpeed(){
        return xSpeed;
    }
    public int getYSpeed(){
        return ySpeed;
    }
    public void move(){
        setX(getX()+xSpeed);
        setY(getY()+ySpeed);
//        if(intersects())
    }
    public void moveSwap(){

    }
    public void bounce(){

    }
    public void paint(Graphics window){
        window.setColor(Color.GREEN);
//        window.drawString("Ball",200,50);
//        window.fillArc(getX()-getW()/2,getY()-getH()/2,getW(),getH(),0,360);
        Image img=Toolkit.getDefaultToolkit().getImage("mrA.png");
        window.drawImage(img,getX(),getY(),getW(),getH(),this);
    }
}