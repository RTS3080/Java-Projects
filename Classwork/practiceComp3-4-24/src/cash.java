import java.util.*;
import java.io.*;

public class cash{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner f= new Scanner(new File("cash".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int numCoins=f.nextInt();
            int cash=f.nextInt();
            int prnt=cash;
            int[] coins=new int[numCoins];
            for (int i = 0; i < numCoins; i++) {
                coins[i]=f.nextInt();
            }
            int pos=0;
            while(cash>0 && pos<coins.length){
                if(cash>=coins[pos]){
                    cash-=coins[pos];
                }
                pos++;
            }
            System.out.println((prnt + " is " +( cash > 0 ? "not " : "" )+ "possible"));
        }
        f.close();
    }
}