import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Biles{
    class Gymnast implements Comparable<Gymnast> {
        String name;;
        double[] scores;
        double[] sorted;
        double score;
        int wins;

        public Gymnast(String n, double...s) {
            scores = new double[s.length];
            sorted = new double[s.length];

            for (int i = 0; i < s.length; i++) {
                score += scores[i] = sorted[i] = s[i];
            }

            Arrays.sort(sorted);
            name = n;
        }

        public int compareTo(Gymnast o) {
            if (score != o.score) return -Double.compare(score, o.score);
            if (wins != o.wins) return -Integer.compare(wins, o.wins);

            for (int i = scores.length - 1; i >= 0; i--) {
                if (sorted[i] != o.sorted[i]) return -Double.compare(sorted[i], o.sorted[i]);
            }

            return name.compareTo(o.name);
        }

        public String toString() {
            return String.format("%s %.1f", name, score);
        }
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Biles".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int N = f.nextInt();

            Gymnast[] gymnasts = new Gymnast[N];

            for (int i = 0; i < N; i++) {
                gymnasts[i] = new Gymnast(f.next(), f.nextDouble() + f.nextDouble(), f.nextDouble() + f.nextDouble(), f.nextDouble() + f.nextDouble(), f.nextDouble() + f.nextDouble());
            }
            ArrayList<Integer> bestVault = new ArrayList<>();
            ArrayList<Integer> bestBars = new ArrayList<>();
            ArrayList<Integer> bestBeam = new ArrayList<>();
            ArrayList<Integer> bestFloor = new ArrayList<>();
            double bestVaultScore = Integer.MIN_VALUE, bestBarsScore = Integer.MIN_VALUE, bestBeamScore = Integer.MIN_VALUE, bestFloorScore = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                if (bestVaultScore < gymnasts[i].scores[0]) {
                    bestVaultScore = gymnasts[i].scores[0];
                }

                if (bestBarsScore < gymnasts[i].scores[1]) {
                    bestBarsScore = gymnasts[i].scores[1];
                }

                if (bestBeamScore < gymnasts[i].scores[2]) {
                    bestBeamScore = gymnasts[i].scores[2];
                }

                if (bestFloorScore < gymnasts[i].scores[3]) {
                    bestFloorScore = gymnasts[i].scores[3];
                }
            }

            for (int i = 0; i < N; i++) {
                if(gymnasts[i].scores[0] == bestVaultScore){
                    bestVault.add(i);
                }
                if(gymnasts[i].scores[1] == bestBarsScore){
                    bestBars.add(i);
                }
                if(gymnasts[i].scores[2] == bestBeamScore){
                    bestBeam.add(i);
                }
                if(gymnasts[i].scores[3] == bestFloorScore){
                    bestFloor.add(i);
                }
            }
            for(int i : bestVault){
                gymnasts[i].wins++;
            }
            for(int i : bestBars){
                gymnasts[i].wins++;
            }
            for(int i : bestBeam){
                gymnasts[i].wins++;
            }
            for(int i : bestFloor){
                gymnasts[i].wins++;
            }

            Arrays.sort(gymnasts);

            for (int i = 0; i < N; i++) {
                System.out.println(1 + i + ". " + gymnasts[i]);
            }
            System.out.println();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Biles().run();
    }
}
