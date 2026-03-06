import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class power{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        long times=f.nextLong(); f.nextLine();
        long maxPower = 0;
        long maxNum = 0;
        for (long i = 1; i <=times ; i++) {
            long num = f.nextLong();
            long power = sumDigits(num)*i;
            if(power > maxPower){
                maxPower = power;
                maxNum = num;
            }
        }
        System.out.println(maxNum);
        f.close();
    }
    long sumDigits(long n){
        if(n/10 ==0){
            return n;
        }
        long sum=0;
        while(n!=0){
            sum+=n%10;
            n/=10;
        }
        return sumDigits(sum);
    }



    public static void main(String[] args) throws FileNotFoundException{
        new power().run();
    }
}
