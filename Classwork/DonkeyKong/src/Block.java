import java.awt.*;

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
		x = y = w = h = 0;

	}
	
	public Block( int ex, int wy, int wd, int ht)
	{
		x = ex;
		y = wy;
		w = wd;
		h = ht;
	}
	
	// All Blocks will have all of these set and get methods
	//these methods are complete
	public int getX( ){ return x; }
	public void setX( int ex ){ x = ex; }
	public int getY( ){ return y; }
	public void setY( int wy ){ y = wy; }
	public int getW(){ return w; }
	public int getH(){ return h; }
	
	
	public boolean intersects( Block other )
	{
		Rectangle r = new Rectangle(x, y, w, h);
		Rectangle o = new Rectangle(other.getX(), other.getY(), other.getW(), other.getH());
		return r.intersects(o);
	}
}