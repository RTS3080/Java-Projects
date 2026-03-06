import java.util.*;
import java.io.*;
public class duel{
    public void run() throws FileNotFoundException{
        Scanner f = new Scanner(new File("duel".toLowerCase()+".dat"));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) System.out.println(f.nextInt() % 3 == 0 ? "What a loser." : "Obi-Wan won!");
    }
    
    public static void main(String[] args) throws FileNotFoundException{
        new duel().run();
    }
}