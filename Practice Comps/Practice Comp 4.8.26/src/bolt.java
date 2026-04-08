import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class bolt{
    class Player {
        String name;
        double[] relays;

        public Player(String n, String r) {
            name = n;
            String[] arr = r.trim().split(" +");

            relays = new double[4];

            for (int i = 0; i < 4; i++) {
                relays[i] = Double.parseDouble(arr[i]);
            }
        }

        public String toString() {
            return name;
        }
    }

    public void dfs(ArrayList<ArrayList<String>> teams, String cur, ArrayList<String> team, HashMap<String, HashSet<String>> rivals, HashMap<String, Player> players) {
        if (team.contains(cur)) return;

        for (String player : team) {
            if (rivals.getOrDefault(cur, new HashSet<>()).contains(player)) return;
        }

        team.add(cur);

        if (team.size() == 4) {
            teams.add(new ArrayList<>(team));
            team.remove(cur);
            return;
        }

        for (String next : players.keySet()) {
            dfs(teams, next, team, rivals, players);
        }

        team.remove(cur);
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("bolt".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            HashMap<String, Player> players = new HashMap<>();
            HashMap<String, HashSet<String>> rivals = new HashMap<>();

            int N = f.nextInt();
            int R = f.nextInt();

            for (int i = 0; i < N; i++) {
                String name = f.next();
                players.put(name, new Player(name, f.nextLine()));
            }

            for (int i = 0; i < R; i++) {
                String a = f.next();
                String b = f.next();
                rivals.putIfAbsent(a, new HashSet<>());
                rivals.putIfAbsent(b, new HashSet<>());
                rivals.get(a).add(b);
                rivals.get(b).add(a);
            }

            ArrayList<ArrayList<String>> teams = new ArrayList<>();
            players.keySet().forEach(x -> {
                dfs(teams, x, new ArrayList<>(), rivals, players);
            });

            double best = Double.POSITIVE_INFINITY;

            for (ArrayList<String> x : teams) {
                double sum = 0;

                for (int i = 0; i < x.size(); i++) {
                    sum += players.get(x.get(i)).relays[i];
                }

                best = Math.min(sum, best);
            }

            double finalBest = best;
            teams.removeIf(x -> {
                double sum = 0;

                for (int i = 0; i < x.size(); i++) {
                    sum += players.get(x.get(i)).relays[i];
                }

                return sum > finalBest;
            });

            teams.sort((a, b) -> {
                String str1 = a.toString();
                String str2 = b.toString();

                return str1.compareTo(str2);
            });

            if (teams.isEmpty()) {
                System.out.println("No valid team");
                System.out.println();
            } else {
                ArrayList<String> team = teams.getFirst();

                double sum = 0;
                for (int i = 0; i < team.size(); i++) {
                    sum += players.get(team.get(i)).relays[i];
                }

                System.out.printf("%.2f\n", sum);
                team.forEach(System.out::println);
                System.out.println();
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new bolt().run();
    }
}
