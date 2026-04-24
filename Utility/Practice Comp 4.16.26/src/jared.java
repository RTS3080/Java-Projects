import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class jared{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("jared".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int cases = f.nextInt();
        f.nextLine();

        while(cases-->0){
            String[] line = f.nextLine().split("\\+");
            String[] one = line[0].trim().split("[\\s/]+");
            String[] two = line[1].trim().split("[\\s/]+");

//            System.out.println(Arrays.toString(one));
//            System.out.println(Arrays.toString(two));

            BigInteger[] oneF = parse(one);
            BigInteger[] twoF = parse(two);

//            System.out.println(Arrays.toString(oneF));
//            System.out.println(Arrays.toString(twoF));

            BigInteger GCD = oneF[1].gcd(twoF[1]);
            BigInteger LCM = oneF[1].divide(GCD).multiply(twoF[1]);

//            System.out.println(LCM);

            BigInteger finalNum = LCM.divide(oneF[1]).multiply(oneF[0]);
            finalNum = finalNum.add(LCM.divide(twoF[1]).multiply(twoF[0]));

//            System.out.println(finalNum);
            if (finalNum.abs().compareTo(LCM) >= 0){

                if (finalNum.mod(LCM).compareTo(BigInteger.ZERO) == 0){
                    System.out.println(finalNum);
                }
                else {

                    System.out.print(finalNum.divide(LCM) + " ");
                    System.out.print(finalNum.mod(LCM) + "/");
                    System.out.println(LCM);
                }
            }
            else {
                System.out.println(finalNum + "/" + LCM);
            }
        }

        f.close();
    }

    public BigInteger[] parse(String[] check){
        BigInteger num = new BigInteger("0");
        BigInteger denom = new BigInteger("0");
        if (check.length == 1){
            num = new BigInteger(check[0]);
            denom = BigInteger.ONE;
        }
        if (check.length == 2){
            num = new BigInteger(check[0]);
            denom = new BigInteger(check[1]);
        }
        if (check.length == 3){
            num = new BigInteger(check[0]).multiply(new BigInteger(check[2]));
            num = num.add(new BigInteger(check[1]));
            denom = new BigInteger(check[2]);
        }
        return new BigInteger[]{num, denom};
    }



    public static void main(String[] args) throws FileNotFoundException{
        new jared().run();
    }
}
