import java.util.*;
import java.io.*;

public class catherine{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("catherine".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String left = f.next();
            String right = f.next();
            for (int i = 0; i < 5; i++) {
                if(left.charAt(i)==right.charAt(i)){
                    System.out.print(left.substring(i,i+1).toUpperCase());
                }
                else if(left.contains(right.substring(i,i+1))){
                    System.out.print(right.substring(i,i+1));
                }
                else System.out.print("*");
            }
            System.out.println();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new catherine().run();
    }
}
