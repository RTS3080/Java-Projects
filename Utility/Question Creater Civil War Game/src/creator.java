import java.util.*;
import java.io.*;

public class creator{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Questions.txt"));

        while(f.hasNext()){
            String ln = f.nextLine();
            System.out.println(ln);
            if(ln.matches("Unit \\d+")){
                continue;
            }
            System.out.println(f.nextLine());
        }
        f.close();

    }



    public static void main(String[] args) throws FileNotFoundException{
        new creator().run();
    }
}
