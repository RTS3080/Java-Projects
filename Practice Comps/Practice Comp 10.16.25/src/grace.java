import java.util.*;
import java.io.*;
import java.awt.*;

public class grace{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("grace".toLowerCase()+".dat"));
        while(f.hasNext()){
            double d = f.nextDouble();
            if(d%3==0){
                System.out.printf("%.1f\n",d*d);
            }
            else if(d%3==1){
                System.out.printf("%.1f\n", Math.sqrt(d));
            }
            else if (d%3==2){
                System.out.printf("%.1f\n", Math.cbrt(d));
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new grace().run();
    }
}
