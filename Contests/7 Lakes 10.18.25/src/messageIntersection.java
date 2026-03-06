import java.util.*;
import java.io.*;

public class messageIntersection{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);

        int T = f.nextInt();
        int N = f.nextInt();

        Item[] items = new Item[T];

        for (int i = 0; i < T; i++){
            items[i] = new Item(f.next());
        }

        Arrays.sort(items);

        for (Item each:items){
            System.out.println(each.name);
        }

        f.close();
    }

    class Item implements Comparable<Item>{
        String name;

        public Item(String name){
            this.name = name;
        }

        public int getVal(){
            int thisVal = 0;

            for (int i = 1; i < name.length()-1; i++){
                int prev = Integer.parseInt(name.substring(i-1,i));
                int cur = Integer.parseInt(name.substring(i,i+1));
                int next = Integer.parseInt(name.substring(i+1,i+2));

                if (cur > prev && cur > next) thisVal++;
            }

            return thisVal;
        }

        public int compareTo(Item o){
            int thisVal = this.getVal();
            int oVal = o.getVal();

            return oVal - thisVal;
        }
    }



    public static void main(String[] args) throws FileNotFoundException{
        new messageIntersection().run();
    }
}
