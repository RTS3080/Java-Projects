import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class kevin{
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
        FastScanner f = new FastScanner(new File("kevin.dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int cases = f.nextInt();

        loop:
        while (cases-- > 0){
            int target = f.nextInt();
            String[] line = f.nextLine().trim().split(",");
            int[] arr = new int[line.length];
            for (int i = 0; i < arr.length; i++){
                arr[i] = Integer.parseInt(line[i]);
            }

            HashSet<Integer> set = new HashSet<>();
            set.add(0);

            for (int each:arr){
                HashSet<Integer> copy = new HashSet<>(set);
                for (int inSet : set) copy.add(each+inSet);
                set = copy;
                if (set.contains(target)){
                    System.out.println("true");
                    continue loop;
                }
            }

            System.out.println("false");
        }

    }



    public static void main(String[] args) throws FileNotFoundException{
        long startTime = System.nanoTime();
        new kevin().run();
        System.out.println((System.nanoTime() - startTime) / 1e9);

    }
}
