import java.awt.*;
import javax.swing.*;

class ClassTester extends JPanel
{
    //instance variables

    //define a Brick

    //define a Paddle

    //define a Ball


    public ClassTester() // create all instance in here
    {
        setBackground(Color.WHITE);


        //make a new Brick

        //make a new Paddle

        //make a new Ball



        setFocusable( true );		// Do NOT DELETE these three lines
    }

    public void paint( Graphics window )// all other paint methods and game logic goes in here.
    {
        window.setColor(Color.WHITE); window.fillRect( 0,0, 800, 600); // makes the background white
        window.setColor(Color.BLACK); window.drawRect( 0,0, 800, 600); // draws a black box around the outside

        window.setColor(Color.BLUE); // to change fonts, color, etc: go to the Graphics Intro Folder

        window.drawString("Class Tester ", 50, 30 );

        //draw a Brick

        //draw a Paddle

        //draw a Ball



    }
}