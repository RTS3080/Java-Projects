import java.awt.*; /*this must be imported to use Graphics */
import java.awt.event.*;/*must be imported to use KeyEvents */
import java.awt.event.KeyListener; /*must be imported in the KeyListener*/

// this is only to test if the keys are pressed.
public class KeyBox extends Canvas implements KeyListener
{
	private String keys_typed;
	private String key;

	
		//this is the constructor
	public KeyBox( )
	{	
		key = "NO KEY PRESSED YET";

		keys_typed = "";
		
		addKeyListener( this ); /*all keyListeners must have this in the constructor*/
		
		setFocusable( true );
	}
	

	public void paint( Graphics window )
	{

		
	}
	
/*KeyListeners must have these 3 methods:
 * You do not have to have code in any of these, they can be empty.
 * But they all must be in your KeyListener for it to work.
 */
	
	/*1 */
	public void keyTyped(KeyEvent e)
	{


	}
	
	/*2*/
	public void keyPressed(KeyEvent e)
	{
		/*KeyEvent key codes: https://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyEvent.html */
		if(e.getKeyCode() == KeyEvent.VK_D ) {
			key = "right";
		}
		else if(e.getKeyCode() == KeyEvent.VK_A ) {
			key = "left";
		}
		else if(e.getKeyCode() == KeyEvent.VK_W ) {
			key = "up";
		}
		else if(e.getKeyCode() == KeyEvent.VK_S ) {
			key = "down";
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE ) {
			key = "space";
		}
		//add another else if to check if another key was pressed..
		else {
			key = "Key " + e.getKeyCode() + " is pressed!";
		}
		repaint();
	}
	
	/*3*/	
	public void keyReleased(KeyEvent e)
	{

		repaint();
	}

}