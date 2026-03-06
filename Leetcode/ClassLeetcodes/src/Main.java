//import java.util.*;
//import java.io.*;
//import static java.lang.Math.*;
//
//class Solution {
//    public int countRestrictedPaths(int n, int[][] edges) {
//        HashMap<Integer, ArrayList<int[]>> graph = new HashMap<>();
//        for(int[] arr : edges){
//            int a = arr[0];
//            int b = arr[1];
//            int cost = arr[2];
//            graph.putIfAbsent(a, new ArrayList<>());
//            graph.putIfAbsent(b, new ArrayList<>());
//            graph.get(a).add(new int[]{b, cost});
//            graph.get(b).add(new int[]{a, cost});
//        }
//        int[] minDistToEnd = new int[n+1];
//        for(int i =1; i <= n ;i++){
//            int[] dists = new int[n+1];
//            Arrays.fill(dists, Integer.MAX_VALUE);
//            Queue<int[]> q = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
//            q.offer(new int[]{i, 0});
//            while(!q.isEmpty()){
//                int[] arr = q.poll();
//                int node = arr[0];
//                int cost = arr[1];
//                dists[node] = Math.min(cost, dists[node]);
//                for(int[] edge : graph.get(node)){
//                    int nextNode = edge[0];
//                    int edgeCost = edge[1];
//                    if(cost < dists[nextNode]){
//                        q.offer(new int[]{nextNode, edgeCost+cost});
//                    }
//                }
//            }
//            minDistToEnd[i] = dists[n];
//        }
//        int count = 0;
//        Queue<Integer> q = new PriorityQueue<>((a, b) -> (minDistToEnd[a] - minDistToEnd[b]));
//        q.offer(1);
//        while(!q.isEmpty()){
//            int node = q.poll();
//            int distToEnd = minDistToEnd[node];
//            if(node == n){
//                count++;
//            }
//            for(int[] edge : graph.get(node)){
//                if(distToEnd > minDistToEnd[edge[0]]){
//                    q.offer(edge[0]);
//                }
//            }
//
//        }
//        return (int)round(count % (1E9 + 7));
//    }
//}