import java.awt.*;


abstract class Block extends Canvas
{
	int x, y, w, h; //these are instance variables

	public Block()
	{
		this.x = 0;
		this.y = 0;
		this.w = 50;
		this.h = 50;

	}
	
	public Block( int ex, int wy, int wd, int ht)
	{
		this.x = ex;
		this.y = wy;
		this.w = wd;
		this.h = ht;
	}
	
	// All Blocks will have all of these set and get methods
	//these methods are complete
	public int getX( ){ return x; }
	public void setX( int ex ){ x = ex; }
	public int getY( ){ return y; }
	public void setY( int wy ){ y = wy; }
	public int getW(){ return w; }
	public void setW( int wd ){ this.w = wd; }
	public int getH(){ return h; }
	public void setH( int ht ){ this.h = ht; }
	public String toString(){
		return ""+x+","+y+","+w+","+h;
	}
	
	public boolean intersects( Block other )
	{
		Rectangle b = new Rectangle(x, y, w, h);
		Rectangle o = new Rectangle(other.x, other.y, other.w, other.h);
		return b.intersects(o);

	}
}