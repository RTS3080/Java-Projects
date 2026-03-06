import java.io.*;
import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.math.*;
import java.text.*;
public class House {
	
	public void run() throws Exception{
		
		Scanner f = new Scanner( new File("house.dat") );
		
		while( f.hasNext() )
		{
			System.out.println( f.nextLine() );
		}
	}
	
	public static void main(String[]args)throws Exception{
		new House().run();
	}
}
