import java.util.*;
import java.io.*;

public class caroline{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("caroline".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        timeloop:
        while(times-->0){
            int even = 0;
            int odd = 0;
            String[] ln = f.nextLine().split(" ");
            for(String s : ln){
                int n = Integer.parseInt(s);
                if(n%2==0){
                    even +=n;
                }
                else odd +=n;
            }
            if(even > odd){
                System.out.println("Evens win by "+(even-odd)+" point(s)");
            }
            else if(odd>even){
                System.out.println("Odds win by "+(odd-even)+" point(s)");
            }
            else System.out.println("It's a tie!!!");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new caroline().run();
    }
}
