import java.util.*;
import java.io.*;

public class mother{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("mother".toLowerCase()+".dat"));

        int k = f.nextInt();
        f.nextLine();
        for (int x = 0; x < k; x++) {
            long n = f.nextLong();
            f.nextLine();
            if (n<=3){
                System.out.println(0);
                continue;
            }else{
                long sum =0;
                n-=3;
                for (long i = n; i >0; i-=2) {
                    sum+=((i)*(i+1))/2;
                }
                System.out.println(sum);
            }
        }

        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new mother().run();
    }
}
