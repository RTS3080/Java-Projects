import java.util.*;
import java.io.*;

public class status{
    int[] arr;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("status".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String[] ln =f.nextLine().split(" ");
            arr=new int[ln.length];
            for (int i = 0; i < ln.length; i++) {
                String s = ln[i];
                arr[i]=Integer.parseInt(s);
            }
            ArrayList<Value> vals=new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                int less = numLess(arr[i]);
                vals.add(new Value(arr[i], less + i));
            }
            Collections.sort(vals);
            for(Value i : vals){
                System.out.print(i);
            }
            System.out.println();
        }
        f.close();
    }

    public int numLess(int n){
        int count = 0;
        for(int i : arr){
            if(i<n){
                count++;
            }
        }
        return count;
    }
    public class Value implements Comparable<Value>{
        int sorter;
        int val;
        public Value(int val, int sorter){
            this.sorter = sorter;
            this.val = val;
        }
        public int compareTo(Value v){
            int comp = Integer.compare(sorter, v.sorter);
            if(comp==0){
                return Integer.compare(val, v.val);
            }
            return comp;
        }
        public String toString(){
            return val+" ";
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        new status().run();
    }
}
