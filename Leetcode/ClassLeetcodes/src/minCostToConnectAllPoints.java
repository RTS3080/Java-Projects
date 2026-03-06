//import java.util.*;
//
//class Solution {
//    public int minCostConnectPoints(int[][] points) {
//        int[][] graph = new int[points.length][points.length];
//        int[] vis = new int[points.length];
//        for(int i = 0; i< points.length;i++){
//            int x1= points[i][0];
//            int y1 = points[i][1];
//            for(int j =0; j< points.length;j++){
//                int x2 = points[j][0];
//                int y2 = points[j][1];
//                graph[i][j] = Math.abs(x2-x1)+ Math.abs(y2-y1);
//            }
//        }
//        Queue<int[]>q = new LinkedList<>();
//
//        return 0;
//    }
//}