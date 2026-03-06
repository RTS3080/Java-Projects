import java.util.*;
import java.io.*;
import java.awt.*;

public class cd{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("cd".toLowerCase()+".dat"));
        while(f.hasNext()){
            double d = f.nextDouble();
            int a = (int) d/700;
            double leftOver = 700-d%700;
            if(d%700!=0){
                a++;
            }
            else{
                leftOver=0;
            }
//            a++;
            System.out.printf("%d - %.1f\n", a, leftOver);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new cd().run();
    }
}
