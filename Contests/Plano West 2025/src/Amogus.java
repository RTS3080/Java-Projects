import java.util.*;
import java.io.*;

public class Amogus{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);

        int k =f.nextInt();
        f.nextLine();
        while (k-->0){
            int inn = f.nextInt();
            int crew = f.nextInt();
            int check = f.nextInt();
            int[] bob = new int[crew];
            while (check-->0){
                int person = f.nextInt();
                int in = f.nextInt();
                bob[in-1]++;
            }
            HashSet<Integer> innocent = new HashSet<>();
            for (int i = 0; i < bob.length; i++) {
                if (bob[i] > inn){
                    innocent.add(i+1);
                }
            }
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Amogus().run();
    }
}
