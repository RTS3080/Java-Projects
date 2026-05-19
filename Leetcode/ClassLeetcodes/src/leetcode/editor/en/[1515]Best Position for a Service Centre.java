package leetcode.editor.en;

import java.math.BigDecimal;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double getMinDistSum(int[][] positions) {
        double x = 1;
        double y = 1;
        for(int[] pos : positions) {
            if(pos[0] != 0)
                x *=pos[0];
            if(pos[1] != 0)
                y *=pos[1];
        }
        x = Math.pow(x, 1./positions.length);
        y = Math.pow(y, 1./positions.length);
        double dist = 0;
        for(int[] pos : positions) {
            dist += Math.hypot(pos[0] - x , pos[1] - y);
        }
        System.out.println(x+" "+y);
        return dist;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
