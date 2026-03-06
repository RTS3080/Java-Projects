import java.util.*;
import java.io.*;
public class gupta{
    public void run() throws FileNotFoundException{
        Scanner f = new Scanner(new File("gupta".toLowerCase()+".dat"));
//        Scanner f = new Scanner(System.in);

        PrintWriter pw = new PrintWriter(new File("gupta.out"));
        
        int cases = f.nextInt();
        while (cases-- > 0){
            int numWords = f.nextInt();
            int cost = f.nextInt();

            String[] words = new String[numWords];
            for (int i = 0; i < numWords; i++) words[i] = f.next();

            PriorityQueue<Edge> pq = new PriorityQueue<>();

            for (int i = 0; i < numWords; i++) {
                for (int j = i+1; j < numWords; j++){
                    Edge edge = new Edge(i, j, editDistance(words[i], words[j]));
                    pq.offer(edge);
                }
            }

            DSU dsu = new DSU(numWords);

            int result = 0;

            while (!pq.isEmpty()){
                Edge check = pq.poll();

                boolean diffSet = dsu.union(check.origin, check.target);
                if (diffSet) result += check.cost * cost;
            }
            System.out.println(result);
        }

        pw.flush();
    }

    class DSU{
        int[] dsu;
        public DSU(int size){
            dsu = new int[size];
            Arrays.fill(dsu, -1);
        }

        public int find(int ind){
            if (dsu[ind] == -1) return ind;
            return dsu[ind] = find(dsu[ind]);
        }

        /**
         * Returns true if it successfully unites, and was never part of the same set.
         */
        public boolean union(int ind1, int ind2){
            int origin1 = find(ind1);
            int origin2 = find(ind2);

            if (origin1 == origin2) return false;

            dsu[origin2] = origin1;
            return true;
        }
    }

    public int editDistance(String str1, String str2){
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for (int r = 0; r <= str1.length(); r++) dp[r][0] = r;
        for (int c = 0; c <= str2.length(); c++) dp[0][c] = c;

        for (int r = 1; r <= str1.length(); r++) {
            for (int c = 1; c <= str2.length(); c++) {
                if (str1.charAt(r-1) == str2.charAt(c-1)) dp[r][c] = dp[r-1][c-1];
                else{
                    int min = Math.min(dp[r-1][c], dp[r][c-1]);
                    min = Math.min(min, dp[r-1][c-1]);

                    dp[r][c] = min + 1;
                }
            }
        }

        return dp[str1.length()][str2.length()];
    }

    class Edge implements Comparable<Edge>{
        int origin, target;
        int cost;

        public Edge(int origin, int target, int cost){
            this.origin = origin;
            this.target = target;
            this.cost = cost;
        }

        public int compareTo(Edge check){
            return cost - check.cost;
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException{
        new gupta().run();
    }
}