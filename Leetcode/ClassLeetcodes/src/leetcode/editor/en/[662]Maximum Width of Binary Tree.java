/**
Given the root of a binary tree, return the maximum width of the given tree. 

 The maximum width of a tree is the maximum width among all levels. 

 The width of one level is defined as the length between the end-nodes (the 
leftmost and rightmost non-null nodes), where the null nodes between the end-nodes 
that would be present in a complete binary tree extending down to that level are 
also counted into the length calculation. 

 It is guaranteed that the answer will in the range of a 32-bit signed integer. 


 
 Example 1: 
 
 
Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width exists in the third level with length 4 (5,3,
null,9).
 

 Example 2: 
 
 
Input: root = [1,3,2,5,null,null,9,6,null,7]
Output: 7
Explanation: The maximum width exists in the fourth level with length 7 (6,null,
null,null,null,null,7).
 

 Example 3: 
 
 
Input: root = [1,3,2,5]
Output: 2
Explanation: The maximum width exists in the second level with length 2 (3,2).
 

 
 Constraints: 

 
 The number of nodes in the tree is in the range [1, 3000]. 
 -100 <= Node.val <= 100 
 

 Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 9727
 👎 1326

*/
package leetcode.editor.en;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 */
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode() {}
//    TreeNode(int val) { this.val = val; }
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int maxLen = getMax(root);
        int[] tree = new int[(2 << maxLen-1)-1];
        Arrays.fill(tree, Integer.MAX_VALUE);
        maxLen = tree.length;
        Queue<Object> q = new LinkedList<>();
        q.add(root);
        q.add(0);
        while (!q.isEmpty()) {
            TreeNode node = (TreeNode) q.poll();
            int ind = (int) q.poll();
            if(node == null) continue;
            if(ind >= maxLen) continue;
            tree[ind] = node.val;
            q.offer(node.left);
            q.offer(ind * 2 + 1);
            q.offer(node.right);
            q.offer(ind * 2 + 2);
        }
        int maxDist = -1;
        for (int i = 0; i < tree.length; i= i * 2 +1) {
            int startInd = Integer.MAX_VALUE;
            int endInd = Integer.MIN_VALUE;
            for (int j = i; j < i * 2 + 1; j++) {
                if(tree[j] != Integer.MAX_VALUE) {
                    startInd = Math.min(j, startInd);
                    endInd = Math.max(j, endInd);
                }
            }
            maxDist = Math.max(maxDist, endInd - startInd + 1);
        }
        return maxDist;
    }
    int getMax(TreeNode node){
        if(node == null) return 0;
        return 1+ Math.max(getMax(node.left), getMax(node.right));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
