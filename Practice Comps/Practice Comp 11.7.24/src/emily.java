import java.util.*;
import java.io.*;

public class emily{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("emily".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int n1 = f.nextInt();
            String op = f.next();
            int n2 = f.nextInt();
            int tot = 0;
            boolean hasRem = false;
            int rem = 0;
            switch(op){
                case "+": tot = n1 + n2; break;
                case "-": tot = n1 - n2; break;
                case "*": tot = n1 * n2; break;
                case "x": tot = n1 * n2; break;
                case "X": tot = n1 * n2; break;
                case "/": {
                    tot = n1 / n2;
                    hasRem = true;
                    rem = n1%n2;
                    break;
                }
            }
            if(!hasRem)
                System.out.printf("%d %s %d = %d\n", n1, op, n2, tot);
            else System.out.printf("%d %s %d = %d remainder %d\n", n1, op, n2, tot,rem);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new emily().run();
    }
}
