import java.util.*;
import java.io.*;
import java.awt.*;

public class luthor{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("luthor".toLowerCase()+".dat"));

        int cases = f.nextInt();
        while (cases-- > 0){
            int s = f.nextInt();
            int m = f.nextInt();

            f.nextLine();

            int result = 0;

            for (int i = 0; i < s; i++){
                int[] stocks = Arrays.stream(f.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                for (int j = 0; j < stocks.length-1; j++){
                    if (stocks[j+1] > stocks[j]) result += stocks[j+1] - stocks[j];
                }
            }

            if (m >= result) System.out.println("Lexcellent");
            else System.out.println("Metro-boring-olis");

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new luthor().run();
    }
}
