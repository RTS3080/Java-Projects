//import java.util.*;
//
//public class redundantConnections {
//}
//class Solution {
//    public int[] findRedundantConnection(int[][] edges) {
//        DSU dsu = new DSU(edges.length);
//        ArrayList<Integer> redundant = new ArrayList<>();
//        for(int[] edge : edges) {
//            int a=  edge[0];
//            int b=  edge[1];
//            if(dsu.connected(a, b)){
//                redundant.add(a);
//                redundant.add(b);
//            }
//            else{
//                dsu.union(a, b);
//            }
//        }
//        int[] out = new int[redundant.size()];
//        for(int i = 0; i < redundant.size(); i++){
//            out[i] = redundant.get(i);
//        }
//        return out;
//    }
//}
//class DSU{
//    int[] parent;
//    int[] rank;
//    public DSU(int n){
//        parent = new int[n];
//        rank = new int[n];
//        for(int i=0; i<n; i++){
//            parent[i] = i;
//            rank[i] = 0;
//        }
//    }
//    int find(int x) {
//        if(parent[x] != x){
//            parent[x] = find(parent[x]);
//        }
//        return parent[x];
//    }
//    void union(int a, int b){
//        int rootA = find(a);
//        int rootB = find(b);
//        if(rootA == rootB){
//            return;
//        }
//        if(rank[rootA] > rank[rootB]){
//            parent[rootB] = rootA;
//        }
//        else if(rank[rootA] < rank[rootB]){
//            parent[rootA] = rootB;
//        }
//        else{
//            parent[rootA] = rootB;
//            rank[rootA]++;
//        }
//    }
//    boolean connected(int a, int b){
//        return find(a) == find(b);
//    }
//}
