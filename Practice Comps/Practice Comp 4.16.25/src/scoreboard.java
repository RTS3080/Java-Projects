import com.sun.security.jgss.GSSUtil;

import java.util.*;
import java.io.*;

public class scoreboard{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("scoreboard".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int[] scores = new int[26];
            int[][] attempts = new int[26][13];
            boolean[][] correct = new boolean[26][13];
            boolean[] submission = new boolean[26];
            int times2=f.nextInt(); f.nextLine();
            while(times2-->0){
                int team = f.nextInt();
                int prob = f.nextInt();
                char judge = f.next().charAt(0);
                if(judge != 'C'){
                    submission[team] = true;
                }
                if (judge == 'I') {
                    attempts[team][prob]++;
                }
                else if (judge == 'A') {
                    correct[team][prob]=true;
                    scores[team]+= Math.max(60-5*attempts[team][prob], 0);
                }
            }
            ArrayList<team> teams = new ArrayList<>();
            for(int i=1;i<26;i++){
                if(submission[i]){
                    int corr =0;
                    for(int j=0;j<13;j++){
                        if(correct[i][j]){
                            corr++;
                        }
                    }
                    teams.add(new team(i, scores[i], corr));
                }
            }
            Collections.sort(teams);
            for(team t : teams){
                System.out.println(t);
            }
            System.out.println();
        }
        f.close();
    }
    class team implements Comparable<team>{
        int name;
        int score;
        int corr;
        public team(int name, int score, int corr){
            this.name=name;
            this.score=score;
            this.corr=corr;
        }
        public int compareTo(team other){
            if(this.score!=other.score)
                return other.score-score;
            return this.name-other.name;
        }
        public String toString(){
            return name+" "+corr+" "+score;
        }
    }


    public static void main(String[] args) throws FileNotFoundException{
        new scoreboard().run();
    }
}
