import java.util.*;
import java.io.*;

public class knapsack{

    int[] vals;
    int wts[];
    boolean[] bestSpot;
    int maxWeight;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("knapsack".toLowerCase()+".dat"));
        maxWeight = f.nextInt(); f.nextLine();
        String[] valLn = f.nextLine().split(" ");
        String[] wtLn = f.nextLine().split(" ");
        vals = new int[valLn.length];
        wts = new int[wtLn.length];
        for (int i = 0; i < vals.length; i++) {
            vals[i] = Integer.parseInt(valLn[i]);
            wts[i] = Integer.parseInt(wtLn[i]);
        }
        bestSpot = new boolean[maxWeight * vals.length];
        System.out.println(recur(0,0,0));

        f.close();
    }


    public int recur(int weight, int i, int totVal){
        if(i>= wts.length){
            return 0;
        }
        if(weight>= maxWeight)
            return 0;
        System.out.println(weight+" "+i+" "+vals[i]);
        int use = weight + wts[i];
        int useRecur = recur(use, i+1, totVal+vals[i]);
        int noUse = recur(weight, i+1, totVal);
        return Math.max(useRecur, noUse);
    }
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new knapsack().run();
    }
}
