import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class koa{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("koa".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int cases = f.nextInt();
        while (cases-- > 0){
            N = f.nextInt();
            arr = new int[N];

            long sum = 0;
            for (int i = 0; i < N; i++) sum += (arr[i] = f.nextInt());


            if (sum % 4 != 0){
                System.out.println("I need to call Jade Chen for help!");
                continue;
            }

            target = sum / 4;

            set = new HashSet<>();

            set.add(new Four(new long[]{0, 0, 0, 0}));

            for (int i = 0; i < N; i++){
                HashSet<Four> copy = new HashSet<>(set);
                for (Four each : set){
                    for (int j = 0; j < 4; j++){
                        long[] cc = Arrays.copyOf(each.arr, each.arr.length);
                        cc[j] += arr[i];

                        Arrays.sort(cc);
                        if (cc[3] > target) continue;

                        copy.add(new Four(cc));
                    }
                }
                set = copy;
            }

//            System.out.println(set);

            System.out.println(set.contains(new Four(new long[]{target, target, target, target})) ?
                    "Aha, I can make a square." : "I need to call Jade Chen for help!");
        }

        f.close();
    }
    HashSet<Four> set;
    int[] arr;
    int[][][][][] dp;
    long target;
    int N;

    class Four{
        long[] arr;
        public Four(long[] arr){
            Arrays.sort(arr);
            this.arr = arr;
        }

        public int hashCode(){
//            Arrays.sort(arr);
            return Objects.hash(arr[0], arr[1], arr[2], arr[3]);
        }

        public boolean equals(Object o){
//            Arrays.sort(arr);
            return Arrays.equals(arr, ((Four)o).arr);
        }

        public String toString(){
            return Arrays.toString(arr);
        }
    }

    public void recur(int ind, long[] arr){
        Arrays.sort(arr);
        if (arr[3] > target) return;
        if (ind == N){
            for (int i = 0; i < 4; i++) if (arr[i] != target) return;
            set.add(new Four(arr));
        }

//        System.out.println(Arrays.toString(arr));

        if (set.contains(new Four(arr))) return;
        set.add(new Four(arr));

        for (int i = 0; i < 4; i++){
            long[] copy = Arrays.copyOf(arr, arr.length);
            copy[i] += this.arr[ind];
            recur(ind + 1, copy);
        }
    }



    public static void main(String[] args) throws FileNotFoundException{
        new koa().run();
    }
}
