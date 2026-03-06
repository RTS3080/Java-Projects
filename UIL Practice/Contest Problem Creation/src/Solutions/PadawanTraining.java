import java.util.*;
import java.io.*;

public class PadawanTraining {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("PadawanTrainingJudge.dat"));
        int t = sc.nextInt();
        for (int test = 0; test < t; test++) {
            int n = sc.nextInt();
            int[] levels = new int[n];
            for (int i = 0; i < n; i++) {
                levels[i] = sc.nextInt();
            }
            if (n == 0) {
                System.out.println(0);
                continue;
            }
            int maxStreak = 1;
            int currentStreak = 1;

            for (int i = 1; i < n; i++) {
                if (levels[i] > levels[i - 1]) {
                    currentStreak++;
                    maxStreak = Math.max(maxStreak, currentStreak);
                } else {
                    currentStreak = 1;
                }
            }

            System.out.println(maxStreak);
        }
        sc.close();
    }
}
