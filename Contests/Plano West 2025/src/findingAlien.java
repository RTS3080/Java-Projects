import java.util.*;
import java.io.*;

public class findingAlien{
    int[][] dp;

    public class DNA implements Comparable<DNA>{
        int common;
        String dna;

        public DNA(String dna, int c) {
            this.dna = dna;
            common = c;
        }

        @Override
        public int compareTo(DNA o) {
            return o.common - this.common;
        }

        public String toString() {
            return dna;
        }
    }

    public int getLCS(int i, char[] s1, int j, char[] s2) {
        if (i == s1.length || j == s2.length) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1[i] == s2[j]) {
            dp[i][j] = 1 + getLCS(i + 1, s1, j + 1, s2);
        }

        return dp[i][j] = Math.max(dp[i][j], Math.max(
                getLCS(i + 1, s1, j, s2),
                getLCS(i, s1, j + 1, s2)
        ));
    }

    public boolean isFather(String s) {
        return s.replaceAll("[AG]", "").length() >= (s.length() + 1) / 2;
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        char[] child = (new StringBuilder(f.next())).reverse().toString().toCharArray();
        TreeSet<DNA> mothers = new TreeSet<>();
        TreeSet<DNA> fathers = new TreeSet<>();
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String str = f.next();
            char[] dna = str.toCharArray();
            dp = new int[dna.length][child.length];
            for (int i = 0; i < dna.length; i++) {
                Arrays.fill(dp[i], -1);
            }
            DNA d = new DNA(str, getLCS(0, dna, 0, child));
            if (isFather(str)) {
                fathers.add(d);
            } else {
                mothers.add(d);
            }
        }

        System.out.println(mothers.pollFirst());
        System.out.println(fathers.pollFirst());
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new findingAlien().run();
    }
}
