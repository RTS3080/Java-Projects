import java.util.*;
import java.io.*;

public class lucas{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("lucas".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            Scanner ln = new Scanner(f.nextLine());
            ArrayList<Integer> secs = new ArrayList<>();
            ArrayList<Integer> mins = new ArrayList<>();
            HashMap<Integer,Integer> secsAfter = new HashMap<>();
            while(ln.hasNext()){
                secs.add(ln.nextInt());
            }
            Collections.sort(secs);
            if(secs.size()>=3){
                secs.removeLast();
                secs.removeFirst();
            }
            int avg = 0;
            for(int i :secs)
                avg+=i;
            avg/=secs.size();
            System.out.printf("%02d:%02d\n",avg/60,avg%60);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new lucas().run();
    }
}
