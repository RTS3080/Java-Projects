import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class deal{
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
    public void run() throws FileNotFoundException{
        FastScanner f = new FastScanner();
        int[] cards = new int[15];
        for (int i = 2; i < 15; i++) {
            cards[i] = 4;
        }
        int[] given =f.nextIntArray(3);
        int count = 0;
        for(int i : given){
            if(i !=0){
                cards[i]--;
                count++;
            }
        }
        double ev = 0;
        for (int i = 2; i < 15; i++) {
            ev+=i * cards[i];
        }
        ev/=(52.-count);
        ev*=3-count;
        for(int i : given){
            ev+=i;
        }
        System.out.printf("%.2f\n", ev);

    }



    public static void main(String[] args) throws FileNotFoundException{
        new deal().run();
    }
}
