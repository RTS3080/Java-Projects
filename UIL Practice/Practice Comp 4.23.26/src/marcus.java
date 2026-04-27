import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class marcus{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("marcus".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int n = f.nextInt();
            long r = f.nextLong();
            int rot= (int) (r % n);
            String[] ln = f.next().split(",");
            ArrayList<String> al = new ArrayList<>(Arrays.asList(ln));
            Collections.rotate(al, rot);
            System.out.println(al.toString().replaceAll("[\\[\\] ]", ""));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new marcus().run();
    }
}
