import java.util.*;
import java.io.*;

public class candy{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("candy".toLowerCase()+".dat"));
        int cases = f.nextInt();
        while(cases-->0){
            int money = f.nextInt();
            int candies = f.nextInt();
            ArrayList<int[]> items = new ArrayList<>();
            for (int i = 0; i < candies; i++) {
                f.next();
            }
            for (int i = 0; i < candies; i++) {
                items.add(new int[]{f.nextInt(), 0});
            }
            for (int i = 0; i < candies; i++) {
                items.get(i)[1] = f.nextInt();
            }
            items.sort(Comparator.comparingInt(a -> a[1]));
            int maxamount = 0;
            for(int[] item : items) {
                int stock = item[0];
                int cost = item[1];
                int max = money/cost;
                if(max>stock) {
                    money-=cost*stock;
                    maxamount += stock;
                } else if (max>0) {
                    money-=cost*max;
                    maxamount += max;
                }
                if(money<=0) break;
            }
            System.out.println(maxamount);

        }
        f.close();
    }





    public static void main(String[] args) throws FileNotFoundException{
        new candy().run();
    }
}

