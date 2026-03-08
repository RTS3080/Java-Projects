import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class prob05{

    public void run() throws FileNotFoundException{
        //Scanner f= new Scanner(new File("prob05".toLowerCase()+".dat"));
        Scanner f = new Scanner(new File("input.txt"));
        String s= f.nextLine();
        int a = f.nextInt();
        if(s.equals("Bop")){
            a = 0;
        }
        if(s.equals("Pull")){
            a = 1;
        }
        if(s.equals("Twist")){
            if(a==0){
                a=1;
            }
            else{
                a=0;
            }
        }
        System.out.println(a);
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob05().run();
    }
}
