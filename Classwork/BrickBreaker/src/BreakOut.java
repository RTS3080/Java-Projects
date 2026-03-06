import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

class BreakOut extends JPanel implements Runnable, KeyListener
{
	private boolean[] keys; // this stores booleans for when a key is pressed or not.

	//PROCESS EACH ONE OF THESE ONE AT A TIME
	private Brick testBrick;  //this is only here to make sure the basics work

	private Paddle pad;	// this is the paddle that moves across the bottom of the screen

	private Ball ball; // this is the ball that bounces around the screen

	private ArrayList< Brick > brickedUp; // this is the list of bricks that are to be drawn on the screen
      

	public BreakOut() // create all instance in here
	{
		setBackground(Color.WHITE);

		//make the keys array big enough to store all keys pressed
		keys = new boolean[3];		// scroll down to see the keyPressed method

      
      	//Step 1
		//make a new Brick
		testBrick = new Brick( 100,100,100,50,2 );
		//go to paint and draw the Brick


		//Step 2
		//make a new Paddle
		//initialize the Paddle, put the paddle close to the bottom of the screen.
		pad = new Paddle(600,600,150,50,10);
		//go to paint and draw the Paddle


		//Step 3
		//make a new Ball
		//initialize the Ball
		//go to paint and draw the Ball
		ball=new Ball(600,600,25,25,15,15);

		//Step 4
		//make an ArrayList of Bricks

		brickedUp=new ArrayList<>();

		//Step 5
		//make a for loop to add Bricks to your ArrayList< Brick >
		// 		bricks.add( new Brick( x, y , w, h ) );
		// 		each brick will need to have different x & y coordinates, but same width and height
		// 		the x & y coordinates should be based on the width and height you choose
		//go to paint and draw the ArrayList of bricks
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 11; j++) {
				brickedUp.add(new Brick((j-1)*100+j*35,(i-1)*50+i*35,100,50,5));
			}
		}



		addKeyListener( this );   	//
		setFocusable( true );		// Do NOT DELETE these three lines
		new Thread(this).start();	//
	}

	public void paint( Graphics window )// all other paint methods and game logic goes in here.
	{
		window.setColor(Color.WHITE); window.fillRect( 0,0, 1440, 850); // makes the background white
		window.setColor(Color.BLACK); window.drawRect( 0,0, 1440, 850); // draws a black box around the outside

		window.setColor(Color.BLUE); // to change fonts, color, etc: go to the Graphics Intro Folder

		window.drawString("Mouse  coordinates " + "(" + MouseInfo.getPointerInfo().getLocation().x + "   " + MouseInfo.getPointerInfo().getLocation().y + ")", 250, 30 );
		
		if(keys[0]) // space is pressed
		{
			//You will add code here for the ball.

		}
		if(keys[1]) // Left Arrow is pressed
		{
			//move the paddle left
			pad.goLeft();
			keys[1] = false;
		}
		if(keys[2]) // Right Arrow is pressed
		{	
			//move the paddle right
			pad.goRight();
			keys[2] = false;
		}


		//make stuff move
		for (int i = 0; i < brickedUp.size(); i++) {
			int inter=ball.intersects(brickedUp.get(i));
			if(inter>0){
//				if(inter==1)

			}
		}
		// draw stuff

		//draw a Brick
//		testBrick.paint(window)
		for (Brick b:brickedUp) {
			b.paint(window);
		}
		//draw a Paddle
		pad.paint(window);
		//draw a Ball
		ball.paint(window);
	}
	

// only edit if you would like to add more key functions	
	public void keyPressed(KeyEvent e)
	{   
		
		if( e.getKeyCode()  == KeyEvent.VK_SPACE )
		{
			keys[0]=true;
			ball.setY(pad.getY()-pad.getH());
			ball.setX(pad.getX()+(pad.getW()/2)-ball.getW()/2);
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