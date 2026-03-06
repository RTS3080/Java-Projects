import java.util.*;
import java.io.*;

public class traffic{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("traffic".toLowerCase()+".in"));
        PrintWriter pw= new PrintWriter(new File("traffic".toLowerCase()+".out"));
        ArrayList<Action> actions = new ArrayList<>();
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String op=f.next();
            int first = f.nextInt(); int second = f.nextInt();
            actions.add(new Action(op,first,second));
        }
        int[] startEnd={Integer.MAX_VALUE,0,Integer.MAX_VALUE,0}; //startmin,startmax,endmin,endmax
        int[] mods = new int[4];
        for(Action a : actions){
            if (a.op.equals("none")) {

            }
            else if(a.op.equals("on")){

            }
            else if(a.op.equals("off")){
//
            }
        }
        System.out.println(Arrays.toString(startEnd));
        for (int i = 0; i < 4; i++) {
//            System.out.println(startEnd[i]+" "+mods[i]);
            startEnd[i] +=mods[i];
            startEnd[i] = Math.max(startEnd[i],0);
        }
//        System.out.println();
        System.out.println(startEnd[0]+" "+startEnd[1]);
        System.out.println(startEnd[2]+" "+startEnd[3]);
        System.out.println(Arrays.toString(mods));

        pw.println(startEnd[0]+" "+startEnd[1]);
        pw.println(startEnd[2]+" "+startEnd[3]);
        pw.close();
        f.close();
    }
    class Action{
        String op;
        int first;
        int second;
        public Action(String op, int first, int second){
            this.op=op;
            this.first=first;
            this.second=second;
        }
    }
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new traffic().run();
    }
}
