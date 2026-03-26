import java.util.*;

public class processQueries {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        DSU dsu = new DSU(c+1);
        for(int[] conn : connections){
            dsu.union(conn[0], conn[1]);
        }
        boolean[] disabled = new boolean[c+1];
        ArrayList<Integer> out = new ArrayList<>();
        for(int ii = 0; ii< queries.length; ii++){
            int[] query = queries[ii];
            int type = query[0];
            int n = query[1];
            if(type == 2){
                disabled[n] = true;
                continue;
            }
            if(disabled[n] == false){
                out.add(n);
                continue;
            }
            int found = Integer.MAX_VALUE;
            for(int i = dsu.parent.length-1; i>0;i--){
                if(dsu.connected(i, n) && !disabled[i]){
                    found = i;
                }
            }
            if(found == Integer.MAX_VALUE){
                found = -1;
            }
            out.add(found);
        }
        int[] o = new int[out.size()];
        for (int i = 0; i < o.length; i++) {
            o[i] = out.get(i);
        }
        return o;
    }
    class DSU{
        int[] parent;
        int[] rank;
        public DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }
        public int find(int x){
            if(parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }
        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                return;
            }
            if(rank[rootX] > rank[rootY]){
                parent[rootY] = rootX;
            }
            else if(rank[rootX] < rank[rootY]){
                parent[rootX] = rootY;
            }
            else{
                parent[rootY] = rootX;
                rank[rootY]++;
            }
        }
        public boolean connected(int x, int y){
            return find(x) == find(y);
        }
    }
}
