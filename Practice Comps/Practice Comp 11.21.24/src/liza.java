import java.util.*;
import java.io.*;

public class liza{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("liza".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String title = f.nextLine();
            int times2=f.nextInt(); f.nextLine();
            ArrayList<person> ppl = new ArrayList<>();
            double mean = 0;
            int n = 0;
            while(times2-->0){
                String[] ln = f.nextLine().split(",");
                int score = Integer.parseInt(ln[2]);
                ppl.add(new person(ln[1],ln[0], score));
                n++;
                mean +=score;
            }
            Collections.sort(ppl);
            System.out.println(title);
            for (int i = 0; i < 3; i++) {
                System.out.println(ppl.get(i));
            }
            mean/=n;
            double median;
            if(n %2 ==1){
                median = ppl.get(ppl.size()/2).score;
            }
            else median = ((double)(ppl.get(ppl.size() / 2 - 1).score) + (double)(ppl.get(ppl.size() / 2).score)) /2;
            System.out.printf("MEAN SCORE: %.2f\n",mean);
            System.out.printf("MEDIAN SCORE: %.1f\n", median);
            System.out.println();
        }
        f.close();
    }

    class person implements Comparable<person>{
        String first;
        int score;
        String last;
        public person(String first,String last, int score){
            this.first=first;
            this.last=last;
            this.score=score;
        }
        public int compareTo(person p){
            if(score!=p.score) return p.score-score;
            if(!last.equals(p.last)) return last.compareTo(p.last);
            else return first.compareTo(p.first);
        }
        public String toString(){
            return first+" "+last+": "+score;
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        new liza().run();
    }
}
