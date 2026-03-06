import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class lavanya{
    ArrayList<Integer> factors;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("lavanya".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            BigInteger n = f.nextBigInteger();
            factors = new ArrayList<>();
            recur(n);
            Collections.sort(factors);
            String s =n+" = ";
            for(int i : factors)
                s+=i+" * ";
            System.out.println(s.substring(0,s.length()-3));
        }
        f.close();
    }

    void recur(BigInteger n){
        if(n.isProbablePrime(100)){
            factors.add(n.intValue());
            return;
        }
        if(n.equals(BigInteger.ONE)){
            return;
        }
//        System.out.println(n);
        BigInteger fac1 = BigInteger.ONE;
        BigInteger i = BigInteger.TWO;
        while(!i.equals(BigInteger.ONE)){
            if(n.mod(i).equals(BigInteger.ZERO)){
                fac1 = i;
                break;
            }
            i = i.add(BigInteger.ONE);
        }
        BigInteger fac2 = n.divide(fac1);

//        System.out.println(fac1 +" "+fac2);
        recur(fac1);
        recur(fac2);
    }



    public static void main(String[] args) throws FileNotFoundException{
        new lavanya().run();
    }
}
