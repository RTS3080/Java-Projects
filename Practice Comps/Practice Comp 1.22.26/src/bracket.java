import java.util.*;
import java.io.*;
import java.awt.*;

public class bracket{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("bracket".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        int count = 2025;
        while(times-->0){
            System.out.println((count++)+" Playoffs");
            int g = f.nextInt();
            int t = f.nextInt();
            int playoffTeams = f.nextInt(); f.nextLine();
            ArrayList<Game> games = new ArrayList<>();
            HashSet<String> teamNames = new HashSet<>();
            for(int i = 0; i < g; i++){
                String[] ln = f.nextLine().trim().split(" ");
                String team1 = ln[0];
                String team2 = ln[1];
                String[] score = ln[2].trim().split("-");
                boolean divisional = ln.length==4;
                int t1score = Integer.parseInt(score[0]);
                int t2score = Integer.parseInt(score[1]);
                int diff = t1score - t2score;
                games.add(new Game(team1, team2, diff, divisional));
                teamNames.add(team1);
                teamNames.add(team2);
            }
            ArrayList<Team> teams = new ArrayList<>();
            for(String s : teamNames){
                teams.add(new Team(games, s));
            }
            Collections.sort(teams);
            for (int i = 0; i < teams.size() && i < playoffTeams; i++) {
                Team team = teams.get(i);
                int[] arr = team.record;
                System.out.println((i+1)+": "+team.name+" "+arr[0]+"-"+arr[1]);
            }
            if(times!=0){
                System.out.println("=".repeat(10));
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new bracket().run();
    }
}
class Game{
    String team1;
    String team2;
    int diff;
    boolean divisional;
    public Game(String team1, String team2, int diff, boolean divisional){
        this.team1 = team1;
        this.team2 = team2;
        this.diff = diff;
        this.divisional = divisional;
    }
}
class Team implements Comparable<Team>{
    ArrayList<Game> games;
    int[] divisionalRecord;
    int[] record;
    String name;
    double winPercentage;
    double divisionalPercentage;
    int numDivisional;
    public Team(ArrayList<Game> games, String name){
        this.games = games;
        this.name = name;
        numDivisional = 0;
        record = new int[2];
        divisionalRecord = new int[2];
        for(Game g: games){
            int win = -1;
            if(g.team1.equals(name)){
                win = g.diff > 0 ? 0 : 1;
            }
            if(g.team2.equals(name)){
                win = g.diff < 0 ? 0 : 1;
            }
            if(win !=-1){
                record[win]++;
                if(g.divisional){
                    divisionalRecord[win]++;
                    numDivisional++;
                }
            }
        }
        winPercentage = evaluateRecord(record);
        divisionalPercentage = evaluateRecord(divisionalRecord);
    }
    double evaluateRecord(int[] record){
        if(record[0] + record[1] == 0) return -1;
        return (double) record[0] / (record[1] + record[0]);
    }
    public int compareTo(Team o){
        int[] h2h = new int[2];
        int h2hDiff = 0;
        for(Game g: games){
            if(g.team1.equals(name) && g.team2.equals(o.name)){
                if(g.diff > 0){
                    h2h[0]++;
                }
                else{
                    h2h[1]++;
                }
            }
            if(g.team2.equals(name) && g.team1.equals(o.name)){
                if(g.diff < 0){
                    h2h[0]++;
                }
                else{
                    h2h[1]++;
                }
            }
        }
        if(winPercentage != o.winPercentage){
            return -Double.compare(winPercentage, o.winPercentage);
        }
        if(divisionalPercentage != o.divisionalPercentage){
            return -Double.compare(divisionalPercentage, o.divisionalPercentage);
        }
        double h2hPercent = evaluateRecord(h2h);
        if(h2hPercent < .5){
            return 1;
        }
        if(h2hPercent > .5){
            return -1;
        }
        if(h2hDiff != 0){
            return -h2hDiff;
        }
        return name.compareTo(o.name);
    }
}

