import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

//old UTD problem

public class Diana {
    public static void main(String[] args) throws IOException {
        new Diana().run();
    }

    private void run() throws IOException {
        BufferedReader file = new BufferedReader(new FileReader("diana.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        solve(file, out);

        file.close();
        out.close();
    }

    private static final int MOD = 1_000_000_007;

    public void solve(BufferedReader file, PrintWriter out) throws IOException {
        int T = Integer.parseInt(file.readLine());
        while (T-- > 0) {
            long n = Long.parseLong(file.readLine());

            if (n == 0) {
                out.println(0);
            } else if (n < 3) {
                out.println(1);
            } else {
                // Matrix exponentiation for tribonacci
                long[][] mat = { { 1, 1, 1 }, { 1, 0, 0 }, { 0, 1, 0 } };
                long[][] result = pow(mat, n - 2);

                out.println((result[0][0] + result[0][1]) % MOD);
            }
        }
    }

    // O(n^3 log(p)) in general, but O(log(p)) with constant matrix size
    public long[][] pow(long[][] mat, long p) {
        long[][] ans = new long[mat.length][mat.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i][i] = 1;
        }
        // Quick way to get a copy of the matrix
        long[][] curr = mult(ans, mat);
        // Fast expo
        while (p != 0) {
            if (p % 2 == 1) {
                ans = mult(curr, ans);
            }
            curr = mult(curr, curr);
            p >>= 1;
        }
        return ans;
    }

    // Optimization: simply define the 9 multiplications that are required.
    // O(n^3) in general, but O(1) since we are guaranteed that we will do 9
    // calculations.
    public long[][] mult(long[][] A, long[][] B) {
        long[][] C = new long[A.length][B[0].length];
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C[0].length; j++) {
                for (int k = 0; k < A[i].length; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                    C[i][j] %= MOD;
                }
            }
        }
        return C;
    }
}
