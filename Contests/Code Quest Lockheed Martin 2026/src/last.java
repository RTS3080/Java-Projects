import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class last{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("last".toLowerCase()+".in"));
        int numTimes=f.nextInt(); f.nextLine();
        for(int times = 0; times < numTimes; times++){
            String ln = f.nextLine().trim();
            char letter = (char) 0;
            for(int i = ln.length()-1; i >= 0; i--){
                if(Character.isLetter(ln.charAt(i))){
                    letter = ln.charAt(i);
                    break;
                }
            }
            if(letter == 0){
                System.out.println("No Letter Found");
            }
            else{
                System.out.println(letter);
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new last().run();
    }
}
