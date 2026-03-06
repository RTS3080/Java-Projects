import java.util.*;
import java.io.*;

public class danger{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("danger".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        ArrayList<person> ppl = new ArrayList<>();
        while(times-->0){
            String[] time = f.next().split(":");
            String name = f.next();
            int mins = Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
            ppl.add(new person(name, mins));
        }
        Collections.sort(ppl);
        for(person p: ppl){
            System.out.printf("%02d:%02d %s\n", p.time/60,p.time%60,p.name);
        }
        f.close();
    }
    class person implements Comparable<person>{
        String name;
        int time;
        public person(String name, int time){
            this.name=name;
            this.time=time;
        }
        public int compareTo(person p){
            if(this.time!=p.time){
                return this.time-p.time;
            }
            return name.compareTo(p.name);
        }
        public String toString(){
            return time/60 +":"+time%60+" "+name;
        }
    }



    public static void main(String[] args) throws FileNotFoundException{
        new danger().run();
    }
}

