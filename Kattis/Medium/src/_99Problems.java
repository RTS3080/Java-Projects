import java.util.*;
import java.io.*;

public class _99Problems{

    public void run() throws FileNotFoundException{
//        Scanner f= new Scanner(new File("_99Problems".toLowerCase()+".dat"));
        Scanner f = new Scanner(System.in);
//        double n=f.nextDouble();
//        double length = (n+"").length()-2;
//        System.out.println(length);
//        double nSmall = n/Math.pow(10, length-1);
//        nSmall = Math.round(nSmall) * Math.pow(10, Math.abs(1-length));
//        double nBig = nSmall+100;
//        System.out.println((nSmall-1)+" "+n+" "+(nBig-1));
//        System.out.println();
        int n = f.nextInt();
        int big = n;
        int small = n;
        while(big++%100!=98);
        while(small--%100 !=0 && small>=0);
        if(small<99)
            small=Integer.MAX_VALUE;
        int diffSmall = Math.abs(n-small);
        int diffBig = Math.abs(n-big);
//        System.out.println( diffSmall+" "+diffBig);
//        System.out.println(big+" "+small);
//        System.out.println();
        System.out.println(diffBig<=diffSmall?big:small);
        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new _99Problems().run();
    }
}
