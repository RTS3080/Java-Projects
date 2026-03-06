import java.util.*;
import java.io.*;

public class spring{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("spring".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        timeloop:
        while(times-->0){
            String name = f.next();
            int sales = f.nextInt(); f.nextLine();
            double sum = 0;
            while(sales-->0) {
                String[] ln = f.nextLine().split(" ");
                for(String s : ln){
                    double n = Double.parseDouble(s.substring(1));
                    String t = s.substring(0,1);

                    switch (t){
                        case "T": sum+=(15 * n * .45); break;
                        case "P": sum+=(14*n*.48); break;
                        case "D": sum+=n; break;
                    }
                }
            }
            System.out.printf(name+" "+(sum>500?"OVER ":"")+"$%.2f\n",Math.abs(500-sum));

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new spring().run();
    }
}
