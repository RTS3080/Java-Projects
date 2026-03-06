import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.util.*;
import java.io.*;

public class reka{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("reka".toLowerCase()+".dat"));

        int cases = f.nextInt();
        for (int i = 1; i <= cases; i++){
            System.out.printf("Case #%d: ",i);
            long strLen = f.nextLong();
            int numClue = f.nextInt();
            HashMap<Long, Character> str = new HashMap<>();

            BigInteger result = BigInteger.ONE;

            long halfLen = 0;
            if (strLen%2 == 1){
                halfLen++;
            }
            halfLen += strLen/2;
            for (int j = 0; j < numClue; j++){
                long check = f.nextLong();
                char charac = f.next().trim().charAt(0);
                if (check > halfLen){
                    check = strLen-check+1;
                }

                if (str.containsKey(check)){
                    if (str.get(check) != charac){
                        result = BigInteger.ZERO;
                        break;
                    }
                }
                else{
                    str.put(check, charac);
                }
            }
            if (result.equals(BigInteger.ZERO)){
                System.out.println(0);
                continue;
            }

            long numMulti = halfLen - str.size();
            System.out.println(numMulti);

            int numTimes = (int) (numMulti/2);
            int remainder = (int)(numMulti-numTimes);

            result = BigInteger.valueOf(26).pow(numTimes).multiply(BigInteger.valueOf(26).pow(remainder));


            System.out.println(result);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new reka().run();
    }
}
