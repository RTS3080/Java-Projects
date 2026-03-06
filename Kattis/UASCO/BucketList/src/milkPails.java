import java.util.*;
import java.io.*;

public class milkPails{

    int m;
    int s;
    int totMilk;
    ArrayList<Integer> milks;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Pails".toLowerCase()+".in"));
        PrintWriter pw= new PrintWriter(new File("Pails".toLowerCase()+".out"));
        s = f.nextInt();
        m = f.nextInt();
        milks = new ArrayList<>();
        totMilk = f.nextInt();
        int max =0;
        recur(0);
        for(int i : milks){
            if(i>max && i<=totMilk)
                max = i;
        }
        pw.println(max);
        pw.close();
        f.close();
    }
    void recur(int milk){
        if(milks.contains(totMilk)) {
            return;
        }
        if(milk+s>totMilk) {
            milks.add(milk);
//            System.out.println(milk);
            return;
        }
        if(!milks.contains(milk+s)) {
            recur(milk + s);
        }
        if(!milks.contains(milk+m)) {
            recur(milk + m);
        }

    }



    
    
    public static void main(String[] args) throws FileNotFoundException{
        new milkPails().run();
    }
}
