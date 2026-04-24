package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class edge implements Comparable<edge> {
        int id1;
        int id2;
        int dist;
        public edge(int id1, int id2, int dist){

            this.id1 = id1;
            this.id2 = id2;
            this.dist = dist;
        }
        public int compareTo(edge e){
            return Integer.compare(this.dist, e.dist);
        }
    }
    public int minCostConnectPoints(int[][] points) {
        ArrayList<edge> edges = new ArrayList<edge>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                edges.add(new edge(i,j,Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1])));
            }
        }
        Collections.sort(edges);
        DSU dsu = new DSU(points.length);
        int dist = 0;
        for (int i = 0; i < edges.size(); i++) {
            edge e = edges.get(i);
            if(dsu.connected(e.id1, e.id2)) {
                continue;
            }
            dsu.union(e.id1, e.id2);
            dist += e.dist;
        }
        return dist;
    }
    class DSU{
        public int[] par;
        public DSU(int n){
            par = new int[n];
            for (int i = 0; i < n; i++) {
                par[i] = i;
            }
        }
        public int find(int x){
            if(par[x] == x) return x;
            return par[x] = find(par[x]);
        }
        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX != rootY){
                par[rootX] = rootY;
            }
        }
        boolean connected(int x, int y){
            return find(x) == find(y);
        }
    }
}



//leetcode submit region end(Prohibit modification and deletion)
