import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

class gamin extends JPanel implements Runnable, KeyListener
{
    private boolean[] keys; // this stores booleans for when a key is pressed or not.

    //PROCESS EACH ONE OF THESE ONE AT A TIME


    public gamin() // create all instance in here
    {
        setBackground(Color.WHITE);

        keys = new boolean[3];



        addKeyListener( this );   	//
        setFocusable( true );		// Do NOT DELETE these three lines
        new Thread(this).start();	//
    }

    public void paint( Graphics window )// all other paint methods and game logic goes in here.
    {
        window.setColor(Color.WHITE); window.fillRect( 0,0, 1440, 850); // makes the background white
        window.setColor(Color.BLACK); window.drawRect( 0,0, 1440, 850); // draws a black box around the outside

        window.setColor(Color.BLUE); // to change fonts, color, etc: go to the Graphics Intro Folder

//        window.drawString("Mouse  coordinates " + "(" + MouseInfo.getPointerInfo().getLocation().x + "   " + MouseInfo.getPointerInfo().getLocation().y + ")", 250, 30 );


    }


    // only edit if you would like to add more key functions
    public void keyPressed(KeyEvent e)
    {

        if( e.getKeyCode()  == KeyEvent.VK_SPACE )
        {
            keys[0]=true;
        }

        if( e.getKeyCode()  == KeyEvent.VK_A || e.getKeyCode()==KeyEvent.VK_LEFT)
        {
            keys[1]=true;
        }

        if( e.getKeyCode()  == KeyEvent.VK_D || e.getKeyCode()==KeyEvent.VK_RIGHT )
        {
            keys[2]=true;
        }
    }
    /*****~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*****/
// do not edit anything from this point on!!!
    public void keyTyped(KeyEvent e)
    {
        keyPressed( e );
    }
    public void keyReleased(KeyEvent e)
    {

    }

    public void run()
    {
        try
        {
            while( true )
            {
                Thread.sleep( 10 );
                repaint();
            }
        }
        catch( Exception e )
        {
        }
    }
}