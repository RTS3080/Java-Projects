import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class blue{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("blue".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        while (f.hasNext()){
            f.next();
            int N = f.nextInt();
            test = new StringBuilder(f.next());
            recur(0);
            System.out.println(test);
            f.next();
        }

        f.close();
    }

    StringBuilder test;
    public int recur(int ind){
        if (ind == test.length()) return 0;
        if (test.charAt(ind) == '0') return 0;
        if ((""+test.charAt(ind)).matches("[A-Z]")) {
            int n = recur(ind+1);
            test.replace(ind, ind+1, ""+(n%10));
            return n+1;
        }
        if ((""+test.charAt(ind)).matches("[1-9]")) {
            int nextInd = ind + test.charAt(ind) - '0';
            test.replace(ind, ind+1, ""+(char) (test.charAt(ind)-1));
            if (nextInd < test.length()){
                return recur(nextInd)+1;
            }
            else {
                return recur(ind+1)+1;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws FileNotFoundException{
        new blue().run();
    }
}
