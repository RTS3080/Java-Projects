import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Andy{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);

        int s = f.nextInt();
        int e = f.nextInt();
        int c = 0;
        for (int i = s; i <=e  ; i++) {
            BigInteger t= new BigInteger(i+"");
            if (t.isProbablePrime(50)){
                c++;
            }else{
                String b = ""+i;
                int sum = 0;
                for (int j = 0; j < b.length(); j++) {
                    sum +=(int)Math.pow(Integer.parseInt(b.charAt(j)+""),b.length()); ;
                }
                if (i==sum){
                    c++;
                }
            }

        }
        System.out.println(c);
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Andy().run();
    }
}
