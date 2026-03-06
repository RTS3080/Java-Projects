import java.util.*;
import java.io.*;

public class arya{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("arya".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int low = 1;
            int high = f.nextInt();
            int target = f.nextInt();

            while (low <= high) {
                int mid = (low + high) / 2;
                System.out.println(low + "-" + mid + "-" + high);

                if (mid == target) {
                    break;
                }

                if (mid < target) {
                    low = mid + 1;
                } else high = mid - 1;
            }
            System.out.println("GOT IT!!!");
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new arya().run();
    }
}
