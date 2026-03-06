import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class octahedron{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("octahedron".toLowerCase()+".in"));

        int moves = f.nextInt();
        if (moves <= 1) System.out.println("0");
        else{
            double topAndBottom = 0.0;
            double middle = 0.25;
            for (int i = 1; i < moves; i++){
                topAndBottom = middle;
                double totalMiddle = (1 - 2 * topAndBottom);
                middle = totalMiddle/4;
            }
            System.out.println(topAndBottom);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new octahedron().run();
    }
}
