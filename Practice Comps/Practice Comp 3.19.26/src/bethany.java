import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class bethany{

    public void run() throws FileNotFoundException{
        //Scanner f= new Scanner(new File("bethany".toLowerCase()+".dat"));
        Scanner f = new Scanner(new File("bethany.dat"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int num=f.nextInt();
            int factors = f.nextInt();
            long a = 1;
            ArrayList<Long> out = new ArrayList<>();
            while(num > 0){
                int numFactors = getNumFactors(a);
                if(numFactors == factors){
                    out.add(a);
                    num--;
                }
                a++;
            }
            System.out.println(out.toString().replaceAll("[\\[\\],]", ""));
        }
        f.close();
    }
    int getNumFactors(long num){
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if(num % i == 0){
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) throws FileNotFoundException{
        new bethany().run();
    }
}
