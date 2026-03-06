import java.util.*;
import java.io.*;

public class Hannah{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Hannah".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int nteams = f.nextInt();
            HashMap<String, Team> teams = new HashMap<>();
            for(int abc = 0;abc<nteams;abc++){
                String name = f.next();
                int classi = Integer.parseInt(f.next().substring(0,1));
                int score = 0;
                for (int i = 0; i < 12; i++) {
                    score += f.nextInt();
                }
                teams.put(name, new Team(name, classi, score));
            }
            for(int abc = 0;abc<nteams;abc++){
                String name = f.next();
                int s =0;
                for (int i = 0; i < 3; i++) {
                    s+=f.nextInt();
                }
                teams.get(name).score+=s;
            }
            ArrayList<Team>[] classes = new ArrayList[6];
            for (int i = 0; i < 6; i++) {
                classes[i] = new ArrayList<>();
            }
            for(Team t :teams.values()){
                classes[t.classi-1].add(t);
            }
            for (int i = 0; i < 6; i++) {
                Collections.sort(classes[i]);
            }

            for (int i = 0; i < 6; i++) {
                System.out.println("Classification "+(i+1)+"A Results");
                for(Team t : classes[i]){
                    System.out.println(t);
                }
            }
            System.out.println("=".repeat(25));
        }
        f.close();
    }
    class Team implements Comparable<Team>{
        public String name;
        public int classi;
        public int score;
        public Team(String name, int classi, int score){
            this.name=name;
            this.classi=classi;
            this.score=score;
        }
        @Override
        public int compareTo(Team o) {
            return -Integer.compare(this.score, o.score);
        }
        public String toString(){
            return name+" "+score;
        }
    }


    public static void main(String[] args) throws FileNotFoundException{
        new Hannah().run();
    }
}
