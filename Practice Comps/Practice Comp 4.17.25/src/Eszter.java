import java.util.*;
import java.io.*;

public class Eszter{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Eszter".toLowerCase()+".dat"));
        int ts=f.nextInt();
        for(int cs=1;cs<=ts;cs++){
            String line = f.next();
            String[] prices =  line.substring(1,line.length()-1).split(",");
            int n = prices.length;
            double[] price = new double[n+1];

            for(int i=0;i<n;i++){
                price[i+1] = Double.parseDouble(prices[i]);
            }
            //System.out.println(Arrays.toString(price))  ;

            for(int j=2;j<=n;j++){
                for(int k=1;k<j;k++){
                    price[j] = Math.max(price[j],price[k] + price[j-k]);
                }
            }
            System.out.printf("Maximum profit is $%.2f\n",price[n]);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Eszter().run();
    }
}

