import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class bango{
    class player implements Comparable<player>{
        String name;
        String rank;
        int rankInd;
        double winRate;
        double combat;
        double headshot;
        public player(String name, String rank, double winRate, double combat, double headshot){
            this.name = name;
            this.rank = rank;
            this.winRate = winRate;
            this.combat = combat;
            this.headshot = headshot;
            HashMap<String, Integer> ranks = new HashMap<>();
            String[] rankRegister = "Diamond Platinum Gold Silver Bronze".split(" ");
            for(int i = 0; i < rankRegister.length; i++){
                ranks.put(rankRegister[i], i);
            }
            rankInd = ranks.getOrDefault(rank, Integer.MAX_VALUE);
        }
        public int compareTo(player p){
            if(rankInd != p.rankInd){
                return rankInd - p.rankInd;
            }
            if(winRate != p.winRate){
                return -Double.compare(winRate, p.winRate);
            }
            if(combat != p.combat){
                return -Double.compare(combat, p.combat);
            }
            if(headshot != p.headshot){
                return -Double.compare(headshot, p.headshot);
            }
            return name.compareTo(p.name);
        }
    }
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("bango".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        ArrayList<player> players = new ArrayList<>();
        int numTimes=f.nextInt();
        for(int times = 0; times < numTimes; times++){
            String name = f.next();
            String rank = f.next();
            int wins = f.nextInt();
            int losses = f.nextInt();
            int elims = f.nextInt();
            int deaths = f.nextInt();
            int assists = f.nextInt();
            int headshots = f.nextInt();
            double winRate = (double) wins * 100. / max(1,(wins + losses));
            double combat = ((double) elims + assists * .5) / (max(deaths, 1));
            double headshotRate = (double) headshots * 100. / (max(elims, 1));
            players.add(new player(name, rank, winRate, combat, headshotRate));
        }
        Collections.sort(players);
        System.out.println("-".repeat(72));
        System.out.println("PLACE  | USERNAME               | RANK       | WIN%     | COMBAT   | HS%");
        System.out.println("-".repeat(72));
        for (int i = 0; i < players.size(); i++) {
            player p = players.get(i);
            System.out.printf("#%-6d| %-23s| %-11s| %-9.2f| %-9.2f| %.2f\n",i+1, p.name, "["+p.rank+"]", p.winRate, p.combat, p.headshot);
        }
        System.out.println("-".repeat(72));

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new bango().run();
    }
}
