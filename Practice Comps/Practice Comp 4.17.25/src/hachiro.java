import java.util.*;
import java.io.*;

public class hachiro{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("hachiro".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        HashMap<String, team> teams = new HashMap<>();
        while(times-->0){
            String[] ln = f.nextLine().split("\\s+");
//            System.out.println(Arrays.toString(ln));
            int goalsOne = Integer.parseInt(ln[1]);
            int goalsTwo = Integer.parseInt(ln[3]);
            teams.putIfAbsent(ln[0], new team(ln[0], 0, 0, 0, 0, 0));
            teams.putIfAbsent(ln[2], new team(ln[2], 0, 0, 0, 0, 0));
            teams.get(ln[0]).diff +=goalsOne-goalsTwo;
            teams.get(ln[2]).diff +=goalsTwo-goalsOne;
            if(goalsOne > goalsTwo){
                teams.get(ln[0]).wins++; teams.get(ln[0]).pointsFor+=3;
                teams.get(ln[2]).losses++;
            } else if (goalsTwo > goalsOne) {
                teams.get(ln[0]).losses++;
                teams.get(ln[2]).wins++;
                teams.get(ln[2]).pointsFor+=3;
            }
            else{
                teams.get(ln[0]).ties++;
                teams.get(ln[2]).ties++;
                teams.get(ln[0]).pointsFor+=1;
                teams.get(ln[2]).pointsFor+=1;
            }
        }
        ArrayList<team> ts = new ArrayList<>();
        for(team t : teams.values()){
            ts.add(t);
        }
        Collections.sort(ts);
        System.out.println("6A District 33 Soccer Table");
        System.out.println("Team       W   T   L   P   GD");
        for(team t : ts){
            System.out.println(t);
        }
        f.close();
    }
    class team implements Comparable<team>{
        String name;
        int wins;
        int ties;
        int losses;
        int pointsFor;
        int pointsAgainst;
        int diff;
        public team(String name, int wins, int ties, int losses, int pointsFor, int pointsAgainst){
            this.name=name;
            this.wins=wins;
            this.ties=ties;
            this.losses=losses;
            this.pointsFor=pointsFor;
            this.pointsAgainst=pointsAgainst;
            this.diff=pointsFor-pointsAgainst;
        }
        public int compareTo(team other){
            if(wins != other.wins){
                return other.wins - wins;
            }
            if(pointsFor != other.pointsFor){
                return other.pointsFor-pointsFor;
            }
            return other.diff-diff;
        }
        public String toString(){
            return String.format("%-8s %3d %3d %3d %3d %4d", name, wins, ties, losses, pointsFor, diff);
        }
    }


    public static void main(String[] args) throws FileNotFoundException{
        new hachiro().run();
    }
}
