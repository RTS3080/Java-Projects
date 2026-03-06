import java.util.*;
import java.io.*;
import java.awt.*;

public class miningmaximum2{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("miningmaximum2".toLowerCase()+".dat"));

        int cases = f.nextInt();
        while (cases-- > 0){

            int target = f.nextInt();
            f.nextLine();

            int[] arr = Arrays.stream(f.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            Arrays.sort(arr);

            int sum = 0;
            int result = 0;

            for (int i = 0; i < arr.length; i++) {
                if(sum>target) break;
                sum+=arr[i];
                result = i;
            }

            System.out.println(result);

        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new miningmaximum2().run();
    }
}
