import java.util.*;
import java.io.*;

public class Melissa{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Melissa".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int n = f.nextInt();
            int num = n;
            String nStr = ""+n;
            int a = 1;
            while(nStr.length()>1){
                nStr=nStr.replaceAll("0","");
                n=Integer.parseInt(nStr);
//                System.out.println(n);
                for (int i = 0; i < nStr.length(); i++) {
                    a*=n%10;
                    n/=10;
                }
                n=a;
                nStr=""+a;
                a=1;
            }
            System.out.println(num+" -> "+n);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Melissa().run();
    }
}
