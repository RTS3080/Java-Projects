import java.util.*;
import java.io.*;

public class bucketlist{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("blist.in"));
        PrintWriter pw = new PrintWriter("blist.out");
        int times=f.nextInt(); f.nextLine();
        ArrayList<cow> cows = new ArrayList<>();
        int endAllTime = 0;
        int startTime=Integer.MAX_VALUE;
        while(times-->0){

            int sTime = f.nextInt();
            int endTime = f.nextInt();
            int b = f.nextInt();
            startTime=Math.min(startTime,sTime);
            endAllTime = Math.max(endAllTime, endTime);
            cows.add(new cow(sTime,endTime,b));
        }
        Collections.sort(cows);
        int buckets=0;
        int maxBuckets=0;
        for (int i = startTime; i <= endAllTime; i++) {
            for(cow c: cows){
                if(i>=c.sTime && i<=c.eTime && !c.added){
                    buckets+=c.buckets;
                    c.added=true;
//                    System.out.print("added cow "+c.sTime+" "+c.eTime+"'s buckets, ");
                }
                else if(i>c.eTime && c.added) {
                    buckets -= c.buckets;
                    c.added=false;
                }
                maxBuckets=Math.max(maxBuckets,buckets);
            }
//            System.out.println(i+ " buckets = "+buckets);
        }
        pw.println(maxBuckets);
        f.close();
        pw.close();
    }
    class cow implements Comparable<cow>{
        public int sTime;
        public int eTime;
        public int buckets;
        public boolean added;
        public cow(int sTime, int eTime, int buckets){
            this.sTime=sTime;
            this.eTime=eTime;
            this.buckets=buckets;
            added=false;
        }
        @Override
        public int compareTo(cow o) {
            return Integer.compare(this.sTime, o.sTime);
        }
    }
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new bucketlist().run();
    }
}
