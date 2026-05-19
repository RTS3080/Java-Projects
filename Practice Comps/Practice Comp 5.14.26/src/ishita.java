import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class ishita{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("ishita".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int cases = f.nextInt();
        while (cases-- > 0){
            String check = f.next();
            int frontBrackets = 0;
            boolean valid = true;
            int numCuts = 0;
            for (char each:check.toCharArray()){
                if (each == '(') frontBrackets++;
                else{
                    if (frontBrackets == 0){
                        valid = false;
                        break;
                    }
                    frontBrackets--;
                }
                if (frontBrackets == 0) numCuts++;
            }
            if (frontBrackets > 0) valid = false;
            if (!valid) System.out.println(0);
            else System.out.println((1 << numCuts-1)-1);
//            System.out.println(numCuts);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new ishita().run();
    }
}
