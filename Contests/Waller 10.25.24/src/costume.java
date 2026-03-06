import java.util.*;
import java.io.*;

public class costume{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("costume".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            ArrayList<player> players = new ArrayList<>();
            int times2=f.nextInt(); f.nextLine();
            while(times2-->0){
                String name = f.nextLine();
                int score = 0;
                String[] nums  = f.nextLine().split(" ");
                for(String s : nums){
                    score += Integer.parseInt(s);
                }
                players.add(new player(name, score));
            }
            Collections.sort(players);
            Collections.reverse(players);
            int max = 0;
            for(player p :players){
                max = Math.max(max,p.score);
            }
            int len = (""+max).length();
            int count = 1;
            for(player p : players){
                System.out.printf("%d. (%2d) - %s\n",count,p.score,p.name);
                count++;
            }
            System.out.println("-".repeat(16));
        }
        f.close();
    }
    public class player implements Comparable<player>{
        String name;
        int score;
        public player(String name, int score){
            this.name=name;
            this.score=score;
        }
        public int compareTo(player p){
            return Integer.compare(this.score,p.score);
        }
        public String toString(){
            return "("+score+")"+" - "+ name;
        }
    }


    public static void main(String[] args) throws FileNotFoundException{
        new costume().run();
    }
}
