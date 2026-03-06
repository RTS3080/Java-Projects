import java.util.*;
import java.io.*;
import java.awt.*;

public class tomas{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("tomas".toLowerCase()+".dat"));

        char[][] keypad = {
                {' '},
                {},
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'},
                {'J', 'K', 'L'},
                {'M', 'N', 'O'},
                {'P', 'Q', 'R', 'S'},
                {'T', 'U', 'V'},
                {'W', 'X', 'Y', 'Z'}
        };

        int cases = f.nextInt();
        f.nextLine();

        while (cases-- > 0){
            f.nextLine();
            String[] line = f.nextLine().trim().split("\\s+");
            String result = "";

            for (String each:line){
                int ind1 = Integer.parseInt(""+each.charAt(0));
                int ind2 = (each.length() - 1) % keypad[ind1].length;

                result += keypad[ind1][ind2];
            }

            System.out.println(result);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new tomas().run();
    }
}
