import java.util.*;
import java.io.*;

public class spooky{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("spooky".toLowerCase()+".dat"));
        while(f.hasNext()){
           long n=f.nextLong();
           long rulesBroken = 0;
            String s = n+"";
            if(s.charAt(s.length()-1)=='4' || s.charAt(s.length()-1)=='9'){
                rulesBroken++;
            }
            String hex =Long.toHexString(n).toUpperCase();
            if(hex.contains("F13"))
                rulesBroken++;
            if(n%17 ==0 || n%39 ==0 || n%43 ==0) {
                rulesBroken++;
//                System.out.println("%");
            }
            if(s.contains("666"))
                rulesBroken++;
//            System.out.println(s+" "+hex);
            System.out.print(n+" ");
            if(rulesBroken>=2)
                System.out.println("AAAA!");
            else if(rulesBroken==1)
                System.out.println("BOO!");
            else System.out.println("Candy");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new spooky().run();
    }
}
