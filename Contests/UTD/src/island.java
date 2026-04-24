import java.util.*;
import java.io.*;

import static java.lang.Math.*;

public class island {
    class FastScanner {
        private final BufferedReader br;
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


        public void close() {
            try {
                br.close();
            } catch (IOException ignored) {
            }
        }
    }
    int[][] mat;
    public void run() throws FileNotFoundException {
        FastScanner f = new FastScanner();

        int r = f.nextInt();
        int c = f.nextInt();
        mat = f.nextIntGrid(r, c);
        int maxNum = 1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                maxNum = Math.max(maxNum, mat[i][j]);
            }
        }
        int[] islandCounts = new int[maxNum + 1];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(mat[i][j] > 0){
                    islandCounts[mat[i][j]]++;
                    dfs(i, j, mat[i][j]);
                }
            }
        }
        boolean isIsland = false;
        for (int i = 1; i < islandCounts.length; i++) {
            if(islandCounts[i] >0){
                System.out.println(i+" "+islandCounts[i]);
                isIsland = true;
            }
        }
        if(!isIsland){
            System.out.println(0);
        }
    }

    void dfs(int i, int j, int st) {
        Stack<Integer> stack = new Stack<>();
        stack.push(i);
        stack.push(j);
        stack.push(st);
        while(!stack.isEmpty()){
            int start = stack.pop();
            int c = stack.pop();
            int r = stack.pop();
            if (r < 0 || c < 0 || r >= mat.length || c>= mat[r].length || mat[r][c] !=start) continue;
            mat[r][c]=0;
            int[] dx = {1,-1,0,0};
            int[] dy = {0,0,1,-1};
            for (int k = 0; k < 4; k++) {
                stack.push(r+dx[k]);
                stack.push(c+dy[k]);
                stack.push(start);
            }
        }


    }


    public static void main(String[] args) throws FileNotFoundException {
        new island().run();
    }
}
