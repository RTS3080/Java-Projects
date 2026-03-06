import java.util.*;
import java.io.*;
import java.awt.*;

public class neelam{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("neelam".toLowerCase()+".dat"));
        while (f.hasNext()){
            String testStr= f.next();
            System.out.println(testStr);
            char[][] topRow = new char[2][testStr.length()];
            for (char[] each:topRow) Arrays.fill(each, 'o');

            for (int i = 0; i < testStr.length(); i++){
                if (Integer.parseInt(testStr.substring(i,i+1)) >= 5){
                    topRow[0][i] = '|';
                }
                else{
                    topRow[1][i] = '|';
                }
            }
            for (char[] each:topRow) System.out.println(each);
            System.out.println("=".repeat(testStr.length()));

            char[][] bottomRow = new char[5][testStr.length()];
            for (char[] each:bottomRow) Arrays.fill(each, 'o');

            for (int i = 0; i < testStr.length(); i++){
                int test = Integer.parseInt(testStr.substring(i,i+1));
                test %= 5;

                bottomRow[test][i] = '|';

            }

            for (char[] each:bottomRow) System.out.println(each);
            System.out.println();
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new neelam().run();
    }
}
