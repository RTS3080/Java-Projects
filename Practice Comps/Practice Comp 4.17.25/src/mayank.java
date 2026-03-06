import com.sun.security.jgss.GSSUtil;

import java.util.*;
import java.io.*;

public class mayank{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("mayank".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        String lets = "ABCDEFGHJKLMNPRSTUVWXYZ";
        int[] vals  = Arrays.stream("12345678123457923456789".split("")).mapToInt(Integer::parseInt).toArray();
        int[] weights = Arrays.stream("87654320098765432".split("")).mapToInt(Integer::parseInt).toArray();
        weights[7] = 10;
        for(int b = 1; b<=times; b++){
            String s = f.nextLine().trim();
            char check = s.charAt(8);
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int val = 0;
//                System.out.println(c);
                if(Character.isDigit(c)){
                    val = c-'0';
                }
                else{
                    val = vals[lets.indexOf(c+"")];
                }
                int weight = weights[i];
                sum +=weight * val;
            }
            sum%=11;
            boolean good = false;
            if(sum == 10){
                good = check =='X';
            }
            else{
                good = check-'0' == sum;
            }
            System.out.print("#"+b+": ");
            if(good){
                System.out.println("VALID");
            }
            else{
                System.out.println("INVALID "+(sum == 10 ? "X" : sum));
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new mayank().run();
    }
}
