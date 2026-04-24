import java.util.*;
import java.io.*;
import java.util.stream.Stream;

import static java.lang.Math.*;

public class maxAura{
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

        System.out.println(Arrays.toString(LIS(new int[]{1, 2, 4, 3, 5})));

        int N = f.nextInt();

        int[] nums = f.nextIntArray(N);
        int[] left = new int[N];
        int[] right = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    right[i] = Math.max(right[i], right[j]);
            } right[i]++;
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = i + 1; j < N; j++) {
                if (nums[i] > nums[j]) {
                    left[i] = Math.max(left[i], left[j]);
                }
            } left[i]++;
        }

        String res = "";
        for (int i = 0; i < N; i++) {
            res += right[i] + left[i] - 1 + " ";
        }

        System.out.println(res.trim());
    }


    public int[] LIS(int[] arr){
        TreeMap<Integer, Integer> map = new TreeMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        map.put(0, 0);
        map2.put(0,0);

        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++){
            int val = map.floorKey(arr[i]);
            int temp = map.get(val)+1;

            System.out.println(i+" "+val+" "+temp);

            if (map2.getOrDefault(temp, Integer.MAX_VALUE) > val){
                map2.put(temp, val);
            }
            map.put(map2.get(temp), val);
            result[i] = temp;
        }

        return result;
    }


    public static void main(String[] args) throws FileNotFoundException{
        new maxAura().run();
    }
}
