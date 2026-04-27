import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class tyson{
    class Team {
        String name;
        int rank;
        int seed;

        public Team(String name, int seed, int rank) {
            this.name = name;
            this.rank = rank;
            this.seed = seed;
        }

        public String toString() {
            return name;
        }
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("tyson".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int N = f.nextInt();
            int maxRank = (int) (Math.log(N) / Math.log(2));

            Team[] teams = new Team[N];
            HashMap<String, Team> teamMap = new HashMap<>();

            for (int i = 0; i < N; i++) {
                Team team = new Team(f.next(), f.nextInt(), maxRank);
                teamMap.put(team.name, team);
                teams[i] = team;
            }

            ArrayList<String> upsets = new ArrayList<>();

            for (int i = 0; i < N - 1; i++) {
                Team teama = teamMap.get(f.next());
                teama.rank--;
                Team teamb = teamMap.get(f.next());

                if (teamb.seed < teama.seed) upsets.add(teama + " over " + teamb);
            }

            Arrays.sort(teams, (a, b) -> {
                if (a.rank != b.rank) return a.rank - b.rank;
                return a.name.compareTo(b.name);
            });

            int rankNum = 0;
            int curRank = 0;
            int rank = 0;

            System.out.println("STANDINGS:");
            for (Team team : teams) {
                if (team.rank != curRank) {
                    rank = rankNum;
                    curRank++;
                }
                rankNum++;
                System.out.println(rank + 1 + ". " + team);
            }


            System.out.println("UPSETS:");

            if (upsets.isEmpty()) System.out.println("None");
            else {
                upsets.forEach(System.out::println);
            }

            System.out.println();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new tyson().run();
    }
}
