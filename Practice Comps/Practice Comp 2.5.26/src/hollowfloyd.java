import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class hollowfloyd{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("hollowfloyd".toLowerCase()+".dat"));
        while(f.hasNext()){
            int a= f.nextInt();
            if(a == 0) continue;
            System.out.println("*");
            for(int i = 1; i < a-1; ++i){
                System.out.println("*"+" ".repeat(i-1)+"*");
            }
            System.out.println("*".repeat(a));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new hollowfloyd().run();
    }
}
