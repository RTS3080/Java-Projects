/**
You are given an array trees where trees[i] = [xi, yi] represents the location 
of a tree in the garden. 

 Fence the entire garden using the minimum length of rope, as it is expensive. 
The garden is well-fenced only if all the trees are enclosed. 

 Return the coordinates of trees that are exactly located on the fence 
perimeter. You may return the answer in any order. 

 
 Example 1: 
 
 
Input: trees = [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
Output: [[1,1],[2,0],[4,2],[3,3],[2,4]]
Explanation: All the trees will be on the perimeter of the fence except the 
tree at [2, 2], which will be inside the fence.
 

 Example 2: 
 
 
Input: trees = [[1,2],[2,2],[4,2]]
Output: [[4,2],[2,2],[1,2]]
Explanation: The fence forms a line that passes through all the trees.
 

 
 Constraints: 

 
 1 <= trees.length <= 3000 
 trees[i].length == 2 
 0 <= xi, yi <= 100 
 All the given positions are unique. 
 

 Related Topics Array Math Geometry 👍 1542 👎 649

*/
package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    record vector(int x, int y, int id) implements Comparable<vector>{
        public int compareTo(vector o) {
            return o.x == x ? o.y - y : o.x - x;
        }
        public boolean equals(Object o){
            return (o instanceof vector) && compareTo((vector)o) == 0;
        }
    };
    public int[][] outerTrees(int[][] trees) {
        int n = trees.length;
        if(n<=3) return trees;
        vector[] nodes = new vector[n];
        for (int i = 0; i < n; i++) {
            vector node = new vector(trees[i][0], trees[i][1], i);
            nodes[i]= node;
        }
        Arrays.sort(nodes);
        
        Stack<vector> hull = new Stack<>();

        // Build Lower Hull
        for (int i = 0; i < n; i++) {
            while (hull.size() >= 2 && cross(hull.get(hull.size()-2), hull.peek(), nodes[i]) < 0) hull.pop();
            hull.push(nodes[i]);
        }

        // Build Upper Hull
        for (int i = n - 2, t = hull.size() + 1; i >= 0; i--) {
            while (hull.size() >= t && cross(hull.get(hull.size()-2), hull.peek(), nodes[i]) < 0) hull.pop();
            hull.push(nodes[i]);
        }
        Collections.sort(hull);
        for(int i = hull.size()-1;i>0;i--){
            if(hull.get(i).equals(hull.get(i-1))){
                hull.remove(i);
            }
        }
        int[][] res = new int[hull.size()-1][2];
        for (int i = 0; i < res.length; i++) {
            res[i][0] = hull.get(i).x;
            res[i][1] = hull.get(i).y;
        }
        return res;
    }
    double cross(vector a, vector b, vector c){
        vector ab = new vector(b.x-a.x, b.y-a.y, 0);
        vector bc = new vector(c.x-b.x, c.y-b.y, 0);
        return (ab.x * bc.y) - (ab.y * bc.x);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
