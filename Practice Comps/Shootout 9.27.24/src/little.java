import java.util.*;
import java.io.*;

public class little{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("little".toLowerCase()+".dat"));

        f.close();
    }
    

    
    public static void main(String[] args) throws FileNotFoundException{
        new little().run();
    }
}
