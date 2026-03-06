import javax.swing.*;

class TronGameRunner extends JFrame
{
    private static final int WIDTH = 820;
    private static final int HEIGHT = 640;

    public TronGameRunner()
    {
        super("TronGame");

        setSize(WIDTH,HEIGHT);

        getContentPane().add( new TronGame() );


        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main( String args[] )
    {
        TronGameRunner run = new TronGameRunner();
    }
}