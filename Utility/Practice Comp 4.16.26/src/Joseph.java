import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Joseph{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Joseph".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int size=f.nextInt();
            int[] arr = new int[size];
            int[] maxes = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = f.nextInt();
            }
            String out = "";
            for (int i = 0; i < arr.length; i++) {
                boolean found = false;
                for (int j = i+1; j < arr.length; j++) {
                    if(arr[j]>arr[i]){
                        out+=arr[j]+" ";
                        found=true;
                        break;
                    }
                }
                if(!found) out+="-1 ";
            }
            System.out.println(out.trim());
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Joseph().run();
    }
}
