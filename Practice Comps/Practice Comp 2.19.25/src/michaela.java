import java.util.*;
import java.io.*;

public class michaela{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("michaela".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        for(int abc = 1; abc <= times; abc++){
            String s = f.nextLine().toUpperCase();
            System.out.printf("Message #%d:", abc);
            for(char c : s.toCharArray()){
                String bin = Integer.toBinaryString(c);
                bin = bin.replaceAll("0", ".");
                bin = bin.replaceAll("1", "-");
                System.out.print(bin+" ");
            }
            System.out.println();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new michaela().run();
    }
}
