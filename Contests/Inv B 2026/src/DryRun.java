
import java.util.*;
import java.io.*;

public class DryRun
{
    public static void main( String[] args )  throws Exception
    {
      Scanner f = new Scanner( new File("dryrun.dat" ) ) ;
      int t = f.nextInt();   //read in the number of data sets
           
      for( int bob = 0; bob < t; bob++ )   //read in each data set
      {
         String s = f.next();  //for this problem - each data set is single string of letters
         System.out.println( "I like " + s + "." );      
      }          
    }
}
