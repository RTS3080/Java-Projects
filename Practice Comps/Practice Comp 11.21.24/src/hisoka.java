import java.util.*;
import java.io.*;

public class hisoka{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("hisoka".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            double p = f.nextDouble();
            double r = f.nextDouble()/100/12;
            double n = f.nextDouble()*12;
            double sum = p * n;

            double interest = p * (Math.pow(r+1,n)-1)/r;
//            for (int i = 0; i < ; i++) {
//
//            }
            double tot = interest-sum;
            System.out.printf("%.2f %.2f %.2f\n", sum, tot, interest);

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new hisoka().run();
    }
}
