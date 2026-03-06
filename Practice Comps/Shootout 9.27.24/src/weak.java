import java.util.*;
import java.io.*;

public class weak{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("weak".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String ln = f.nextLine();
            boolean digit=ln.matches(".*\\d.*");
            boolean vowel = ln.matches(".*[aeiouAEIOU].*");
            boolean consonant = ln.matches(".*[^aeiouAEIOU].*");
            boolean consecutive = ln.matches(".*[aeiouAEIOU]{3}.*");
            boolean len = ln.length()<8;
//            System.out.println(ln);
//            System.out.printf("%b %b %b %b %d\n", digit, vowel, consonant, consecutive,ln.length());
            if(!digit || !vowel || !consonant || consecutive || len){
                System.out.println("WEAK");
            }
            else System.out.println("VALID");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new weak().run();
    }
}
