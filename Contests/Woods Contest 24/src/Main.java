import java.util.Scanner;
import java.util.*;

public class Main {
    public void m() {
        int[] nums = {1,2,3,4,5};
        int a = 0;
        Arrays.stream(nums).forEach(i->i=i+1);
        System.out.println(Arrays.toString(nums));
        ArrayList<test> arr = new ArrayList<>();
        arr.add(new test("A",2));
        arr.add(new test("B",2));
        arr.add(new test("C",2));
        arr.add(new test("D",4));
        int n = arr.size();
        for (int i = 1; i < n; ++i) {
            test key = arr.get(i);
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr.get(j).compareTo(key)<0) {
                arr.set(j+1,arr.get(j));
                j = j - 1;
            }
            arr.set(j+1,key);
            System.out.println(arr);
        }
    }
    class test implements Comparable<test>{
        String a;
        int i;
        public test(String a, int i){
            this.a = a;
            this.i = i;
        }
        public int compareTo(test t){
            if(this.a.equals("D"))
                return -1;
            if(i!=t.i)
                return i-t.i;
            return -a.compareTo(t.a);
        }
        public String toString(){
            return a+" "+i;
        }
    }
    public static void main(String[] args) {
        System.out.println('S'^'H');

        Main a =new Main();
        a.m();
    }

}