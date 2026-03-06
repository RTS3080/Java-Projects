import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class spreadsheet{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("spreadsheetcolumns".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            BigInteger cost = f.nextBigInteger();
            String r = f.next().trim();
            String c = f.next().trim();
            BigInteger rows = parse(r);
            BigInteger cols = parse(c);

            System.out.println(cost.multiply(rows).multiply(cols));
        }
        f.close();
    }
    public BigInteger parse(String s){
        BigInteger cost = BigInteger.ZERO;
        BigInteger t = BigInteger.valueOf(26);
        for(int i = s.length()-1; i>=0; i--){
            int a = 0;
            if((s.charAt(i)+"").matches("[A-Z]")){
                a = s.charAt(i)-'A'+1;
            }
            else if((s.charAt(i)+"").matches("[0-9]")){
                a = s.charAt(i)-'0';
            }
            cost=cost.add(BigInteger.valueOf(a).multiply(t.pow(s.length() -1-i)));
        }
        return cost;
    }


    public static void main(String[] args) throws FileNotFoundException{
        new spreadsheet().run();
    }
}
