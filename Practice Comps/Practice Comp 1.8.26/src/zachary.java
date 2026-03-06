import java.util.*;
import java.io.*;
import java.awt.*;

public class zachary{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("./judge/zachary".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            long[] oranges = Arrays.stream(f.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
            long[] cap = Arrays.stream(f.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();

            for (int i = 0; i < oranges.length; i++) {
                boolean flag = false;
                for (int j = 0; j < i; j++) {
                    if (cap[j] >= oranges[i]){
                        cap[j] = -1;
                        System.out.print(j + 1 + " ");
                        flag = true;
                        break;
                    }
                }

                if (!flag) System.out.print("-1 ");
            }

            System.out.println();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new zachary().run();
    }
}
