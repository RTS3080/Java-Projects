import java.util.*;
import java.io.*;

public class Caroline{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Caroline".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            Scanner ln = new Scanner(f.nextLine());
            int even = 0;
            int odd = 0;
            for (int i = 0; i < 10; i++) {
                int n = ln.nextInt();
                if(n%2==0){
                    even+=n;
                }
                else{
                    odd+=n;
                }
            }
            System.out.println(even>odd?"Evens win by "+(even-odd)+" point(s)":odd>even?"Odds win by "+(odd-even)+" point(s)":"It's a tie!!!");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Caroline().run();
    }
}
