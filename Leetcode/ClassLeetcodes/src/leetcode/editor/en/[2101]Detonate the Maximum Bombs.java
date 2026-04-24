package leetcode.editor.en;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumDetonation(int[][] bombs) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for (int i = 0; i < bombs.length; i++) {
            graph.putIfAbsent(i, new HashSet<>());
            for (int j = 0; j < bombs.length; j++) {
                if(i==j) continue;
                double dist = Math.hypot(bombs[i][0]-bombs[j][0],bombs[i][1]-bombs[j][1]);
                if(dist <= bombs[i][2]){
                    graph.get(i).add(j);
                }
            }
        }
        int maxBombs = 1;
        for (int i = 0; i < bombs.length; i++) {
            Queue<Integer> q = new LinkedList<>();
            HashSet<Integer> visited = new HashSet<>();
            visited.add(i);
            q.add(i);
            while (!q.isEmpty()) {
                int cur = q.poll();
                for(int j : graph.get(cur)){
                    if(!visited.contains(j)){
                        visited.add(j);
                        q.add(j);
                    }
                }
            }
            maxBombs = Math.max(maxBombs, visited.size());
        }
        return maxBombs;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
