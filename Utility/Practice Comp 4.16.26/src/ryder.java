import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class ryder{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("ryder".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int cases = f.nextInt();
        while (cases-- > 0){
            int N = f.nextInt();
            int max = (N+1) / 2;

            int numSpace = (max + max - 1) + (N-3)/2;
            for (int i = 1; i <= max; i++){
                System.out.print(" ".repeat(numSpace+3*(1-i)));
                for (int j = i; j > 0; j--){
                    System.out.print(j+" ");
                }
                System.out.print(" ".repeat(Math.max(0, -4+2*i)));

                if (i != 1) {
                    String temp = "";
                    for (int j = 1; j <= i; j++) {
                        System.out.print(j + " ");
                    }
                }
                System.out.println();

            }

            if (N%2 == 0){
                System.out.print(" ".repeat(numSpace+3*(1-max)));
                for (int j = max; j > 0; j--){
                    System.out.print(j+" ");
                }
                System.out.print(" ".repeat(Math.max(0, -4+2*max)));

                if (max != 1) {
                    String temp = "";
                    for (int j = 1; j <= max; j++) {
                        System.out.print(j + " ");
                    }
                }
                System.out.println();

            }

            for (int i = max-1; i > 0; i--){
                System.out.print(" ".repeat(numSpace+3*(1-i)));
                for (int j = i; j > 0; j--){
                    System.out.print(j+" ");
                }
                System.out.print(" ".repeat(Math.max(0, -4+2*i)));
                if (i != 1) {
                    String temp = "";
                    for (int j = 1; j <= i; j++) {
                        System.out.print(j + " ");
                    }
                }
                System.out.println();

            }
            System.out.println("*".repeat(10));
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new ryder().run();
    }
}
