import java.util.*;
import java.io.*;

public class Joseph{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Joseph".toLowerCase()+".dat"));
        String[] init1 = f.nextLine().split(" ");
        PriorityQueue<Date> q = new PriorityQueue<>();
        for(int i=0; i<init1.length; i++){
            q.add(new Date(init1[i], f.nextInt(), true));
        }
        f.nextLine();
        String[] init2 = f.nextLine().split(" ");
//        System.out.println(Arrays.toString(init1));
//        System.out.println(Arrays.toString(init2));
        for(int i=0; i<init2.length; i++){
            q.add(new Date(init2[i], f.nextInt(), false));
        }

        PriorityQueue<Date> q1 = new PriorityQueue<>();
        PriorityQueue<Date> q2 = new PriorityQueue<>();
        PriorityQueue<Match> out = new PriorityQueue<>();
        while (!q.isEmpty()){
            Date d = q.poll();
            while (!q1.isEmpty() && d.score-q1.peek().score > 10)
                q1.poll();
            while (!q2.isEmpty() && d.score-q2.peek().score > 10)
                q2.poll();

            PriorityQueue<Date> o = d.q1 ? q2 : q1;

            for (Date d2 : o)
                out.add(new Match(d2, d));
            if (d.q1)
                q1.add(d);
            else
                q2.add(d);
        }
        while(!out.isEmpty()){
            System.out.println(out.poll());
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Joseph().run();
    }
}
class Date implements Comparable<Date>{
    String n;
    int score;
    boolean q1;
    public Date(String n, int score, boolean q1){
        this.n=n;
        this.score=score;
        this.q1=q1;
    }

    @Override
    public int compareTo(Date o) {
        return score - o.score;
    }
}
class Match implements Comparable<Match>{
    String q1,q2;
    int score;
    public Match(Date d1, Date d2){
        if (d1.q1){
            q1=d1.n;
            q2=d2.n;
        }
        else{
            q1=d2.n;
            q2=d1.n;
        }
        score = Math.abs(d1.score-d2.score);

    }
    public String toString(){
        return q1+" "+q2+" "+score;
    }

    @Override
    public int compareTo(Match o) {
        if (score != o.score)
            return score - o.score;
        return toString().compareTo(o.toString());
    }
}
