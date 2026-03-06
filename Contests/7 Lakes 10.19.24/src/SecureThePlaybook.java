import java.util.*;
import java.io.*;

public class SecureThePlaybook{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("SecureThePlaybook".toLowerCase()+".in"));
        int times=f.nextInt(); f.nextLine();
        String a ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";
        String z ="ZYXWVUTSRQPONMLKJIHGFEDCBAzyxwvutsrqponmlkjihgfedcba ";
        while(times-->0){
            String ln=f.nextLine();
            String out = "";

            for(char c : ln.toCharArray()){
                if((c+"").matches("[A-Za-z]")) {
                    out += z.charAt(a.indexOf(c));
                }
                else out+=c;
            }
            System.out.println(out);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new SecureThePlaybook().run();
    }
}
