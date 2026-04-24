package leetcode.editor.en;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        int maxVal = 0;
        for (int i = 0; i < routes.length; i++) {
            int[] route = routes[i];
            for (int j = 0; j < route.length; j++) {
                map.putIfAbsent(route[j], new HashSet<>());
                maxVal = Math.max(maxVal, route[j]);
                for (int k = 0; k < route.length; k++) {
                    if(k==j) continue;
                    map.get(route[j]).add(route[k]);
                }
            }
        }
        int[] dists = new int[maxVal + 1];
        Arrays.fill(dists, Integer.MAX_VALUE);
        PriorityQueue<int[]> queue = new PriorityQueue<>((int[] a, int[] b)->a[1]-b[1]);
        queue.offer(new int[]{source, 0});
        while (!queue.isEmpty()) {
            int[] nums = queue.poll();
            int cur = nums[0];
            int dist = nums[1];
            if(dists[cur] <=dist) continue;
            if(cur == target) return dist;
            else{
                dists[cur] = dist;
            }
            for(int i : map.get(cur)){
                queue.offer(new int[]{i, dist+1});
            }
        }
        return dists[target]==Integer.MAX_VALUE?-1:dists[target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
