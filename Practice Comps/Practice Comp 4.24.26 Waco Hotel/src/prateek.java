import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class prateek{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("prateek".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int cases = f.nextInt();
        for (int CASE = 1; CASE <= cases; CASE++){
            int numWords = f.nextInt();
            int storeWord = f.nextInt();
            int storeDiff = f.nextInt();
            int costPerDiff = f.nextInt();

            ArrayList<String> words = new ArrayList<>();
            words.add("");
            for (int i = 0; i < numWords; i++){
                words.add(f.next());
            }

            PriorityQueue<Edge> pq = new PriorityQueue<>();
            for (int i = 1; i < words.size(); i++){
                pq.offer(new Edge(0, i, storeWord));
            }

            for (int i = 1; i < words.size(); i++){
                for (int j = 1; j < words.size(); j++){
                    int cost = storeDiff + costPerDiff * editDis(words.get(i), words.get(j));
                    pq.offer(new Edge(i, j, cost));
                }
            }

            DSU dsu = new DSU(words.size());
            int result = 0;
            while (!pq.isEmpty()){
                Edge check = pq.poll();
                boolean merged = dsu.union(check.c1, check.c2);
                if (merged) result += check.cost;
            }

            System.out.printf("Case #%d: %d\n", CASE, result);
        }

        f.close();
    }

    class DSU{
        int[] store;
        public DSU(int size){
            store = new int[size];
            Arrays.fill(store, -1);
        }

        public int find(int ind){
            if (store[ind] == -1) return ind;
            return store[ind] = find(store[ind]);
        }

        public boolean union(int one, int two){
            int pOne = find(one);
            int pTwo = find(two);

            if (pOne == pTwo) return false;
            store[pOne] = pTwo;
            return true;
        }
    }

    public int editDis(String word1, String word2){
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int r = 0; r < dp.length; r++) dp[r][0] = r;
        for (int c = 0; c < dp[0].length; c++) dp[0][c] = c;

        for (int r = 1; r < dp.length; r++){
            for (int c = 1; c < dp[r].length; c++){
                if (word1.charAt(r-1) == word2.charAt(c-1)) dp[r][c] = dp[r-1][c-1];
                else {
                    dp[r][c] = Math.min(Math.min(dp[r-1][c], dp[r][c-1]), dp[r-1][c-1])+1;
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }

    class Edge implements Comparable<Edge>{
        int c1, c2;
        int cost;
        public Edge(int c1, int c2, int cost){
            this.c1 = c1;
            this.c2 = c2;
            this.cost = cost;
        }
        public int compareTo(Edge e){
            return cost - e.cost;
        }

        public String toString(){
            return c1+" "+c2+" - "+cost;
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        new prateek().run();
    }
}
