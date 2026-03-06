import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

class runner extends JFrame
{
    private static final int WIDTH = 1440;
    private static final int HEIGHT = 850;

    public runner()
    {
        super("BreakOut");

        setSize(WIDTH,HEIGHT);

        //use the ClassTester to test your classes
        //before you start to write the full game
//		getContentPane().add( new ClassTester() );

        //uncomment this to make the game
        getContentPane().add( new runner() );

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main( String args[] )
    {
        runner run = new runner();
    }
}