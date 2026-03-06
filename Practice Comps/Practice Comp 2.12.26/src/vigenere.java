import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class vigenere{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("vigenere".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String s= f.next().trim();
            String key = f.next().trim();
            while(key.length()< s.length()){
                key+=key;
            }
            String out = "";
            for (int i = 0; i < s.length(); i++) {
                int ind = (s.charAt(i) - key.charAt(i))%26;
                if(ind<0){
                    ind+=26;
                }
                out+=(char)('A'+ind);
            }
            System.out.println(out);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new vigenere().run();
    }
}
