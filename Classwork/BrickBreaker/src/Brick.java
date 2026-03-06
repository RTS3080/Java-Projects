import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

/*
 *	Directions:
 *              Make sure you have completed Block first.
 *
 *				Make the brick extend Block
 *
 *				Write the Brick constructor that takes an x, y, w, h to create a block.
 *
 *				Override the paint method to draw a Brick

				Choose to draw or import an image.
 *
 *				use the ClassTester to make sure your Brick works.
 */

class Brick extends Block
{

    int health;


    public Brick( int ex, int wy, int wd, int ht, int sp)
    {
        //write the code for the Brick constructor
        //must have a super constructor call
        super(ex,wy,wd,ht);
        health=sp;
    }
    public void hit(){
        health--;
    }

    //overidde paint to draw your Paddle
    public void paint( Graphics window )
    {
//        window.drawString("Brick Class ", 50, 150 );

        // drawing methods for Java:
        // go to the Graphics Intro Folder

//		window.setColor(Color.RED);
//		window.fillRect(getX(), getY(), getW(), getH());
//		window.setColor(Color.BLACK);
//		window.drawRect(getX(), getY(), getW(), getH());


        //find and image for your paddle and put it here
//        Graphics2D g2 = (Graphics2D) window;
        Color[] a={new Color(255,0,0,50),new Color(255, 75, 0,50),new Color(255, 255, 0,50),new Color(0,255,0,50),new Color(0,0,255,50)};
        ArrayList<Color> colors=new ArrayList<>();
        for(Color c:a)
            colors.add(c);

        Image img1 = Toolkit.getDefaultToolkit().getImage("Supreme Brick.png"); //use .gif or .png, you can choose the image

        window.drawImage(img1, getX(), getY(), getW(), getH(), this);
//        Rectangle rect=new Rectangle(getX(),getY(),getW(),getH());
        window.setColor(colors.get(health-1));
        window.fillRect(getX(),getY(),getW(),getH());
    }

}