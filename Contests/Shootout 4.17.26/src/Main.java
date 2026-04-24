import java.util.*;
import java.io.*;

import static java.lang.Math.*;

public class Main {
    class FastScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastScanner(File file) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(file));
        }

        public FastScanner(String filename) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(filename));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;   // EOF
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public boolean hasNext() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null) return false;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return true;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public float nextFloat() {
            return Float.parseFloat(next());
        }

        public boolean nextBoolean() {
            return Boolean.parseBoolean(next());
        }

        public char nextChar() {
            return next().charAt(0);
        }

        public String nextLine() {
            st = null;
            try {
                return br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        public long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }

        public double[] nextDoubleArray(int n) {
            double[] a = new double[n];
            for (int i = 0; i < n; i++) a[i] = nextDouble();
            return a;
        }

        public char[] nextCharArray(int n) {
            return next().toCharArray();
        }

        public String[] nextStringArray(int n) {
            String[] a = new String[n];
            for (int i = 0; i < n; i++) a[i] = next();
            return a;
        }

        public int[][] nextIntGrid(int n, int m) {
            int[][] g = new int[n][m];
            for (int i = 0; i < n; i++) g[i] = nextIntArray(m);
            return g;
        }

        public String[][] nextStringGrid(int n, int m) {
            String[][] g = new String[n][m];
            for (int i = 0; i < n; i++) g[i] = nextStringArray(m);
            return g;
        }

        public double[][] nextDoubleGrid(int n, int m) {
            double[][] g = new double[n][m];
            for (int i = 0; i < n; i++) g[i] = nextDoubleArray(m);
            return g;
        }

        public long[][] nextLongGrid(int n, int m) {
            long[][] g = new long[n][m];
            for (int i = 0; i < n; i++) g[i] = nextLongArray(m);
            return g;
        }

        public char[][] nextCharGrid(int n, int m) {
            char[][] g = new char[n][m];
            for (int i = 0; i < n; i++) g[i] = nextCharArray(m);
            return g;
        }

        public void close() {
            try {
                br.close();
            } catch (IOException ignored) {
            }
        }
    }

    public void run() throws FileNotFoundException {
        FastScanner f = new FastScanner();

    }


    public static void main(String[] args) throws FileNotFoundException {
        new Main().run();
    }
}
