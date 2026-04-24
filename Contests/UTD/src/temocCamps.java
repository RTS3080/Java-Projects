import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class temocCamps{

    public void run() throws FileNotFoundException{
//        Scanner f= new Scanner(new File("temocCamps".toLowerCase()+".dat"));
        Scanner f = new Scanner(System.in);

        int cases = f.nextInt();

        while (cases-- > 0){
        int N = f.nextInt();
        int K = f.nextInt();

        int chooseNum = (int) Math.ceil((double) N/K);

        System.out.println("Choose"+ chooseNum);

        int result = 0;
        for (int i = chooseNum; i <= N; i++) {
            System.out.println(i+": "+" "+N+" "+i);
            System.out.println("CycleLen should be: "+(Math.ceil((double) N/i)));
            System.out.println(nChoosek(N, i));
            System.out.println("-".repeat(10));
//            result += nChoosek(N, i);


            result += nChoosek(N, i) * (Math.max(1, (int) (Math.ceil((double) N/i)) - 1));

//            System.out.println(nChoosek());

//            System.out.println(result * (Math.floor((double) N/i)));
        }

        System.out.println(result);
        }

        f.close();
    }

    public int fact(int i){
        int result = 1;
        for (int j = 1; j <= i; j++) {
            result *= j;
        }
        return result;
    }

    public int nChoosek(int n, int k){
        int top = 1;
        for (int i = 1; i <= n; i++) top *= i;

        int bottom = 1;
        for (int i = 1; i <= k; i++) bottom *= i;
        for (int i = 1; i <= n-k; i++) bottom *= i;

        return top/bottom;
    }

    public int nPermK(int n, int k){
        int top = 1;
        for (int i = 1; i <= n; i++) top *= i;

        int bottom = 1;
        for (int i = 1; i <= n-k; i++) bottom *= i;

        return top/bottom;
    }



    public static void main(String[] args) throws FileNotFoundException{
        new temocCamps().run();
    }
}
