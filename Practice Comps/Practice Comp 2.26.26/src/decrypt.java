import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class decrypt{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("decrypt".toLowerCase()+".in"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String[] ln = f.nextLine().trim().split(" ");
            char[] letters = new char[ln.length];
            for (int i = 0; i < ln.length; i++) {
                int val = Integer.parseInt(ln[i], 16);
                String binary = Integer.toString(val, 2);
                binary = binary.substring(binary.length()-8);
                String flipped ="";
                for (int j = 0; j < binary.length(); j++) {
                    if(binary.charAt(j) == '1'){
                        flipped+="0";
                    }
                    else if(binary.charAt(j) == '0'){
                        flipped+="1";
                    }
                }
                val = Integer.parseInt(flipped, 2);
                letters[i] = (char)val;
            }
            System.out.println(letters);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new decrypt().run();
    }
}
