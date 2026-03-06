import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class espionage{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("espionage".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String s = f.nextLine().trim();
            String mod = f.nextLine().trim();
//            if(mod == ""){
//                System.out.println("BAD DATA YOU BUM");
//                continue;
//            }
            String dec = "";
            for (int i = 0; i < s.length(); i++) {
                dec+=s.charAt(i)+0;
            }

            if(mod.equals("0")) System.out.println(dec);
            else {
                BigInteger a = new BigInteger(dec);
                BigInteger b = new BigInteger(mod);
                System.out.println(a.mod(b));
            }

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new espionage().run();
    }
}
