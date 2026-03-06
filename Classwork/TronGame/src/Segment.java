import java.awt.*;


class Segment extends Block
{
    private Color color;
    public Segment(int ex, int wy, int wd, int ht)
    {
        super(ex-wd-1, wy, wd, ht);
    }
    public Segment(int ex, int wy, int wd, int ht, Color color){
        super(ex-wd-1, wy, wd, ht);
        this.color = color;
    }
    public Color getColor(){
        return color;
    }
    public String toString(){
        return super.toString()+","+color.toString();
    }

    public void paint( Graphics window )
    {
        window.setColor(color);
        window.fillRect(getX(), getY(), getWidth(), getHeight());
    }

}