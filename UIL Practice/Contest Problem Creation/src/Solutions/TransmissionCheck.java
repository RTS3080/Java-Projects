import java.io.*;
import java.util.*;

public class TransmissionCheck{

    public static void main(String[] args) throws Exception {
        String inputFile = "transmissionCheckJudge.dat";
        if (args.length >= 1) inputFile = args[0];
        Scanner sc = new Scanner(new File(inputFile));
        int T = Integer.parseInt(sc.nextLine().trim());
        for (int t = 0; t < T; t++) {
            String s = sc.nextLine();
            if (hasAllDigits(s)) {
                System.out.println("Transmission complete.");
            } else {
                System.out.println("Signal corrupted.");
            }
        }
        sc.close();
    }

    private static boolean hasAllDigits(String s) {
        boolean[] seen = new boolean[10];
        int count = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                int d = c - '0';
                if (!seen[d]) {
                    seen[d] = true;
                    count++;
                    if (count == 10) return true;
                }
            }
        }
        return false;
    }
}