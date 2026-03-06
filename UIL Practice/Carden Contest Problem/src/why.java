import java.util.*;
import java.io.*;
import java.math.*;

public class why{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("braden".toLowerCase()+".dat"));
        while(f.hasNext()){
            String a = f.next().trim();
            BigInteger num;
            System.out.println(a);
            if(!a.contains("^")){
                num = new BigInteger(a);
            }
            else{
                String[] ln = a.split("\\^");
                System.out.println(ln[0] +" "+ln[1]);
                num = new BigInteger(ln[0]);
                num = num.pow(Integer.parseInt(ln[1]));
            }
            while(num.compareTo(new BigInteger("1"))>0){
                if(num.mod(BigInteger.ONE).equals(BigInteger.ZERO)){
                    num.divide(BigInteger.TWO);
                }
                else{
                    num = num.multiply(new BigInteger("3"));
                    num = num.add(BigInteger.ONE);
                }
            }
            System.out.println(num.toString());
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new why().run();
    }
}
