import java.util.*;
import java.io.*;

public class results{

    public void run() throws FileNotFoundException{
        Scanner f = new Scanner(new File("Teams.dat"));
        HashMap<String, String> teams = new HashMap<>();
        while(f.hasNext()){
            String[] ln = f.nextLine().split("\\s+");
            String name = "";
            String team = ln[ln.length-1];
            for (int i = 0; i < ln.length-1; i++) {
                name+=ln[i]+" ";
            }
            name = name.trim();
            teams.put(team, name);
        }
        ArrayList<Result> advResults = new ArrayList<>();
        ArrayList<Result> novResults = new ArrayList<>();
        f= new Scanner(new File("results".toLowerCase()+".dat"));
        while(f.hasNext()){
            String[] ln = f.nextLine().split("\\s+");
            String team = ln[0];
            int probs = Integer.parseInt(ln[1]);
            int score = Integer.parseInt(ln[2]);
            String name = teams.get(team);
            int teamNumber = Integer.parseInt(team.substring(4));
            if(name==null) continue;
            if(teamNumber<=51) {
                advResults.add(new Result(team, name, probs, score));
            }
            else{
                novResults.add(new Result(team, name, probs, score));
            }
        }
        Collections.sort(advResults);
        Collections.sort(novResults);
        System.out.println("Advanced Results");
        System.out.println("------------------------------");
        for(Result r : advResults){
            System.out.println(r.score);
        }
        System.out.println();
        System.out.println("Novice Results");
        System.out.println("------------------------------");
        for(Result r : novResults){
            System.out.println(r.score);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new results().run();
    }
}
class Result implements Comparable<Result>{
    String team;
    String name;
    int problems;
    int score;
    public Result(String team, String Name, int problems, int score){
        this.team = team;
        this.name = Name;
        this.problems = problems;
        this.score = score;
    }
    public int compareTo(Result r){
        return r.score-score;
    }
    public String toString(){
        return name +": "+score;
    }
}