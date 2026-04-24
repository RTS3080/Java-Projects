import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class train{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("train".toLowerCase()+".txt"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int N = f.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = f.nextInt();
            }
            int count = 0;
            for (int i = 0; i < N-1; i++) {

                for (int j = i+1; j < N; j++) {
                    if(arr[i]>arr[j]){
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        count++;
                    }
                }
            }
            System.out.println("Optimal train swapping takes "+count+" swaps.");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new train().run();
    }
}
