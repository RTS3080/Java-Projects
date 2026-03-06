import java.awt.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

class ClassTester extends JPanel
{
    //instance variables

    //define a Brick
//    Brick a;
    ArrayList<Brick> briks;
    //define a Paddle
    Paddle pad;
    //define a Ball
    Ball b;

    public ClassTester() // create all instance in here
    {
        setBackground(Color.WHITE);


        //make a new Brick
//        a=new Brick(100,100,100,50,5);
        briks=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            briks.add(new Brick(100,100+i*60,100,50,i+1));
        }
        //make a new Paddle
        pad=new Paddle(200,100,100,40,5);
        //make a new Ball
        b=new Ball(300,100,50,50,10,10);


        setFocusable( true );		// Do NOT DELETE these three lines
    }

    public void paint( Graphics window )// all other paint methods and game logic goes in here.
    {
        window.setColor(Color.WHITE); window.fillRect( 0,0, 1200, 800); // makes the background white
        window.setColor(Color.BLACK); window.drawRect( 0,0, 1200, 800); // draws a black box around the outside

        window.setColor(Color.BLUE); // to change fonts, color, etc: go to the Graphics Intro Folder

        window.drawString("Class Tester ", 50, 30 );
//        Brick a=new Brick(100,100,20,40,1);
//        Paddle pad=new Paddle(0,400,30,10,5);
//        Ball b=new Ball(200,200,10,10,10,10);

        //draw a Brick
//        a.paint(window);
        for (Brick a:briks) {
           a.paint(window);
        }
        //draw a Paddle
        pad.paint(window);
        //draw a Ball
        b.paint(window);
        System.out.println();
    }
}