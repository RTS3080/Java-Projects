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
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        queue.offer(0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int dist = queue.poll();
            if(dists[cur] <=dist) continue;
            if(cur == target) return dist;
            else{
                dists[cur] = dist;
            }
            for(int i : map.get(cur)){
                queue.offer(i);
                queue.offer(dist+1);
            }
        }
        return dists[target]==Integer.MAX_VALUE?-1:dists[target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
