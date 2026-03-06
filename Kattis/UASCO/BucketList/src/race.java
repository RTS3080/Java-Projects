import java.util.*;
import java.io.*;

public class race{
    int finishLine;
    ArrayList<Integer> time;
    int x;
    int timer;
    static int a;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("race".toLowerCase()+".in"));
        PrintWriter pw= new PrintWriter(new File("race".toLowerCase()+".out"));
        finishLine=f.nextInt();
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            a=0;
            x=f.nextInt();
            time = new ArrayList<>();
            recur(0,0,0);
            int min = Integer.MAX_VALUE;
            for(int i :time){
                if(i<min)
                    min=i;
            }
            System.out.println(min);
//            System.out.println(a);
        }
        pw.close();
        f.close();
    }
    void recur(int velo, int meters, int t){
//        for(int i :time){
//            if(t>i)
//                return;
//        }
        if(!time.isEmpty()){
            return;
        }
        if(velo<0) {
            return;
        }
//        if(finishLine-meters<velo-x){
//            return;
//        }
        a++;
        if(meters>=finishLine){
            if(velo>x) {
                return;

            }
            time.add(t);
//            System.out.println("ended "+t);
            return;
        }
//        System.out.println(velo+" "+meters);
//        System.out.println(meters);
        recur(velo + 1, meters+velo+1, t + 1);
        recur(velo, meters+velo, t + 1);
        recur(velo - 1, meters+velo-1   , t + 1);
    }

    
    
    public static void main(String[] args) throws FileNotFoundException{
        new race().run();
    }
}
