import java.util.*;
import java.io.*;

public class shapeTesting{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("shapeTesting".toLowerCase()+".dat"));

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new shapeTesting().run();
    }
}
