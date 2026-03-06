import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class Oath {
	
	public void run() throws Exception
	{
		Scanner f = new Scanner( new File("oath.dat") );
		
		while( f.hasNext() )
		{
			int x = f.nextInt();
			for( int z = 1; z<=x; z++)
			{
				System.out.println( x + " MEAN GREEN");
			}
			
		}
	}
	
	public static void main(String[]args)throws Exception{
		new Oath().run();
	}
}
