import java.util.*;
import java.io.*;

public class probability{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("probability".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            double p1 = f.nextDouble();
            double p2 = f.nextDouble();
            int n = f.nextInt();
            double[] arr1 = new double[n+1];
            double[] arr2 = new double[n+1];
            arr1[1] = p1;
            arr2[1] = p2;
            for (int i = 2; i <= n; i++) {
//                arr1[i] = (1-p1)*(1-p2)*p1;
                arr1[i] = (1-arr1[i-1])*(1-arr2[i-1])*arr1[i-1];
                arr2[i] = (1-arr1[i-1])*(1-arr2[i-1])*arr1[i-1];
            }
            System.out.print("[");
            for(int i=1; i<=n; i++){
                System.out.printf("%.4f ", arr1[i]);
            }
            System.out.println("]");
            System.out.print("[");
            for(int i=1; i<=n; i++){
                System.out.printf("%.4f ", arr2[i]);
            }
            System.out.println("]");
            System.out.printf("%.4f\n", arr1[n]);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new probability().run();
    }
}
