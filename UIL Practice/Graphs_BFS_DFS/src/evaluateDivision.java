import java.util.*;
import java.io.*;

public class evaluateDivision{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("evaluateDivision".toLowerCase()+".dat"));
        
        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new evaluateDivision().run();
    }
}
