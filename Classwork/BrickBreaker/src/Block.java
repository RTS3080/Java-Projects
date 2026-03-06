import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

/*
 *	Directions:
 *
 *		Write the intersects method below.
 *
 *		Then move on to Block
 */

abstract class Block extends Canvas
{
	private int x, y, w, h; //these are instance variables

	public Block()
	{
		//complete this constructor
		x=0;y=0;w=10;h=10;
	}
	
	public Block( int ex, int wy, int wd, int ht)
	{
		x=ex;y=wy;w=wd;h=ht;
	}
	
	// All Blocks will have all of these set and get methods
	//these methods are complete
	public int getX( ){ return x; }
	public void setX( int ex ){ x = ex; }
	public int getY( ){ return y; }
	public void setY( int wy ){ y = wy; }
	public int getW(){ return w; }
	public int getH(){ return h; }
	
	
	public int intersects( Block other )
	{
		/* Easy Way:
		 * 		Copy and Paste the following URL in google chrome
		 *		https://docs.oracle.com/javase/8/docs/api/java/awt/Rectangle.html
		 *		make new Rectangle, using this Block's x,y,w,h
		 *		make new Rectangle, using the other Block's x,y,w,h
		 *		return if the two rectangles intersect, use the Rectangle's intersects method.
		 */
//		Rectangle o= new Rectangle()
		Rectangle rect=new Rectangle(x,y,w,h);
		Rectangle test=new Rectangle(other.getX(),other.getY(),other.getW(),other.getH());
		Point[] pts=new Point[4];
		pts[0]=new Point(x,y);
		pts[1]=new Point(x+w,y);
		pts[2]=new Point(x+w,y+h);
		pts[3]=new Point(x,y+h);
//		Point[] oPts=new Point[4];
//		oPts[0]=new Point(test.x,test.y);
//		oPts[1]=new Point(test.x+test.width,test.y);
//		oPts[2]=new Point(test.x+test.width,test.y+test.height);
//		oPts[3]=new Point(test.x,test.y+test.height);
		for (int i = 1; i <= pts.length; i++) {
			if(test.contains(pts[i-1]))
				return i;
		}
		return 0;

//		return rect.intersects(test);

		/* Hard Way:
		 *		Write your own intersects logic!! Return if the two blocks are intersecting.
		 */
		
//		return false;
	}
}