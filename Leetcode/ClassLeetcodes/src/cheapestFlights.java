//import java.util.*;
//
//class Solution {
//    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//        HashMap<Integer, ArrayList<int[]>> graph = new HashMap<>();
//        for(int[] flight : flights){
//            int a = flight[0];
//            int b= flight[1];
//            int cost = flight[2];
//            graph.putIfAbsent(a, new ArrayList<>());
//            graph.get(a).add(new int[]{b, cost});
//        }
//        for(Map.Entry e : graph.entrySet()){
//            System.out.print(e.getKey() + " = ");
//            for(int[] arr : (ArrayList<int[]>) e.getKey()){
//                System.out.print(Arrays.toString(arr) + " ");
//            }
//            System.out.println();
//        }
//
//
//        int[] minCosts = new int[n];
//        Arrays.fill(minCosts, Integer.MAX_VALUE);
//        Queue<int[]> q = new PriorityQueue<>((a,b) -> (a[2]-b[2]));
//        q.offer(new int[]{src, -1, 0});
//        while(!q.isEmpty()){
//            int[] arr = q.poll();
//            int node = arr[0];
//            int moves = arr[1];
//            int cost = arr[2];
//            if(minCosts[node]<=cost || moves > k){
//                continue;
//            }
//            minCosts[node] = cost;
//            for(int[] ar : graph.getOrDefault(node, new ArrayList<>())){
//                q.offer(new int[]{ar[0], moves+1, cost + ar[1]});
//            }
//        }
//        System.out.println(Arrays.toString(minCosts));
//        return minCosts[dst] == Integer.MAX_VALUE ? -1 : minCosts[dst];
//    }
//}