import java.util.*;
import java.io.*;

public class compression{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("compression".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String s= f.nextLine().trim();
            int i = 0;
            while(i<s.length()){
                char c = s.charAt(i);
                int count =0;
                while(i < s.length() && s.charAt(i)==c){
                    count++;
                    i++;
                }
                System.out.print(count+""+c);
//                i++;
            }
            System.out.println();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new compression().run();
    }
}
