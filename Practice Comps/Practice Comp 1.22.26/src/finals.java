import java.util.*;
import java.io.*;
import java.awt.*;

public class finals{
    Random gen;
    class Player implements Comparable<Player> {
//        Random gen;

        String first, last;
        int minp, maxp;
        int minr, maxr;
        int mina, maxa;
        int minb, maxb;
        int mins, maxs;

        int[] statTotals;
        double games;

        public Player(Scanner f, Random gen, long seed) {
//            this.gen = new Random(seed);
//            this.gen = gen;
            this.first = f.next();
            this.last = f.next();

            statTotals = new int[5];
            games = 0;

            String str = f.next();
            String[] data = str.split(",");
            minp = Integer.parseInt(data[0].substring(1));
            maxp = Integer.parseInt(data[1].substring(0, data[1].length() - 1));

            str = f.next();
            data = str.split(",");
            minr = Integer.parseInt(data[0].substring(1));
            maxr = Integer.parseInt(data[1].substring(0, data[1].length() - 1));

            str = f.next();
            data = str.split(",");
            mina = Integer.parseInt(data[0].substring(1));
            maxa = Integer.parseInt(data[1].substring(0, data[1].length() - 1));

            str = f.next();
            data = str.split(",");
            minb = Integer.parseInt(data[0].substring(1));
            maxb = Integer.parseInt(data[1].substring(0, data[1].length() - 1));

            str = f.next();
            data = str.split(",");
            mins = Integer.parseInt(data[0].substring(1));
            maxs = Integer.parseInt(data[1].substring(0, data[1].length() - 1));
        }

        public int genStats() {
            games++;

//            // Sammy's Way:
//            int p = minp + gen.nextInt(maxp - minp + 1);
//            int r = minr + gen.nextInt(maxr - minr + 1);
//            int a = mina + gen.nextInt(maxa - mina + 1);
//            int b = minb + gen.nextInt(maxb - minb + 1);
//            int s = mins + gen.nextInt(maxs - mins + 1);

            // My Way
            int p = gen.nextInt(minp, maxp + 1);
            int r = gen.nextInt(minr, maxr + 1);
            int a = gen.nextInt(mina, maxa + 1);
            int b = gen.nextInt(minb, maxb + 1);
            int s = gen.nextInt(mins, maxs + 1);

            statTotals[0] += p;
            statTotals[1] += r;
            statTotals[2] += a;
            statTotals[3] += b;
            statTotals[4] += s;

            return p;
        }

        public int compareTo(Player o) {
            double stats1 = Arrays.stream(statTotals).summaryStatistics().getSum() / games;
            double stats2 = Arrays.stream(o.statTotals).summaryStatistics().getSum() / games;

            return Double.compare(stats2, stats1);
        }

        public String toString() {
            return String.format("%s %s %.1f %.1f %.1f %.1f %.1f", first, last, statTotals[0] / games, statTotals[1] / games, statTotals[2] / games, statTotals[3] / games, statTotals[4] / games);
        }
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("finals".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int team1Count = f.nextInt();
            int team2Count = f.nextInt();

            long seed = f.nextLong();

            gen = new Random(seed);

            Player[] players1 = new Player[team1Count];
            Player[] players2 = new Player[team2Count];

            f.nextLine();
            String team1Name = f.nextLine().trim();
            for (int i = 0; i < team1Count; i++) {
                players1[i] = new Player(f, gen, seed);
            }

            f.nextLine();
            String team2Name = f.nextLine().trim();
            for (int i = 0; i < team2Count; i++) {
                players2[i] = new Player(f, gen, seed);
            }

            int team1Wins = 0;
            int team2Wins = 0;

            while (team1Wins < 4 && team2Wins < 4) {
                int score1 = 0;
                int score2 = 0;

                for (int i = 0; i < players1.length; i++) {
                    score1 += players1[i].genStats();
                }

                for (int i = 0; i < players2.length; i++) {
                    score2 += players2[i].genStats();
                }

                if (score1 > score2) {
                    team1Wins++;
                } else {
                    team2Wins++;
                }
            }

            if (team1Wins > team2Wins) {
                System.out.println(team1Name + " " + team1Wins + "-" + team2Wins);

                Arrays.sort(players1);
                System.out.println(players1[0]);
            } else {
                System.out.println(team2Name + " " + team2Wins + "-" + team1Wins);

                Arrays.sort(players2);
                System.out.println(players2[0]);
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new finals().run();
    }
}
