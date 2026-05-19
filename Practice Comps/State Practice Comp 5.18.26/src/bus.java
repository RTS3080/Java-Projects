import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class bus{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("bus".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        while(f.hasNext()){
            f.next();
            int N = f.nextInt();
            f.nextLine();
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int[] sums = new int[N];

            for (int i = 0; i < N; i++) {
                String[] line = f.nextLine().trim().split("\\s+");
                ArrayList<Integer> temp = new ArrayList<>();
                int sum = 0;
                for (String each : line){
                    temp.add(Integer.parseInt(each));
                    sum += Integer.parseInt(each);
                }
                sums[i] = sum;
                list.add(temp);
            }

            int check = f.nextInt();

            int res = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++){
                int mod = check % sums[i];
                int tempSum = 0;
                int tempMin = Integer.MAX_VALUE;

//                System.out.println(mod);

                for (int each:list.get(i)){
                    tempSum += each;
                    if (tempSum >= mod) {
                        tempMin = Math.min(tempMin, tempSum - mod);
                        break;
                    }
                }
                res = Math.min(res, tempMin);
            }
            System.out.println(res );
            f.next();
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new bus().run();
    }
}
