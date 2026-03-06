package Solutions;

import java.io.*;
import java.util.*;

public class chen {
    /**
     * The mod value
     */
    final int MOD = 100000007;

    /**
     * Stores the boolean expression.
     */
    char[] exp;

    /**
     * Stores all the results of the recursive calls.
     * Dimension 0 stores 'Dark' values, dimension 1 stores 'Light' values.
     */
    long[][][] dp;

    public static void main(String[] args) throws FileNotFoundException{
        new chen().run();
    }

    public void run() throws FileNotFoundException {
        Scanner f = new Scanner(new File("chen.dat"));
//        Scanner f = new Scanner(System.in);

        PrintWriter out = new PrintWriter(new File("chen.out"));

        int cases = f.nextInt();
        f.nextLine();

        while (cases-- > 0) {
            String[] line = f.nextLine().trim().split("\\s+");

            exp = new char[line.length];
            for (int i = 0; i < line.length; i++) exp[i] = line[i].charAt(0);

            int N = exp.length;

            dp = new long[2][N][N];
            for (int i = 0; i < 2; i++) for (long[] each:dp[i]) Arrays.fill(each, -1);
            for (int i = 0; i < N; i++) if ("LD".contains(""+exp[i])) dp[exp[i] == 'L' ? 1 : 0][i][i] = 1;

            System.out.println(recur(0, N - 1, 1));
        }
        out.flush();
    }

    /**
     * Recursive function to figure out how many ways to make a value "target" from the interval
     * [start, end] - both inclusive - from the original expression.
     * @param start Start index of the interval
     * @param end End index of the interval
     * @param target The target boolean value, 0 means false (D) and 1 means true (L)
     * @return Returns how many distinct ways there are to make "target" from [start, end]
     */
    public long recur(int start, int end, int target) {
        if (dp[target][start][end] != -1) return dp[target][start][end];

        //Stores the distinct ways.
        long temp = 0;

        //'i' iterates through the different operators.
        for (int i = start + 1; i <= end - 1; i += 2) {
            long startFalses = recur(start, i - 1, 0);
            long startTrues = recur(start, i - 1, 1);

            long endFalses = recur(i + 1, end, 0);
            long endTrues = recur(i + 1, end, 1);

            if (eval(false, false, exp[i]) == (target == 1)) temp += (startFalses * endFalses) % MOD;
            if (eval(false, true, exp[i]) == (target == 1)) temp += (startFalses * endTrues) % MOD;
            if (eval(true, false, exp[i]) == (target == 1)) temp += (startTrues * endFalses) % MOD;
            if (eval(true, true, exp[i]) == (target == 1)) temp += (startTrues * endTrues) % MOD;

            temp %= MOD;
        }

        return dp[target][start][end] = temp;
    }

    /**
     * Returns the boolean result of the expression, evaluating {one [op] two}
     *
     * @param one First boolean value
     * @param two Second boolean value
     * @param op The boolean operation
     * @return
     */
    public boolean eval(boolean one, boolean two, char op) {
        return switch (op) {
            case '&' -> one && two;
            case '|' -> one || two;
            case '^' -> one ^ two;
            default -> false;
        };
    }
}



