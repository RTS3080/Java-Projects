package leetcode.editor.en;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
double r;
double x;
double y;
    public Solution(double radius, double x_center, double y_center) {
        r = radius;
        x = x_center;
        y = y_center;
    }
    
    public double[] randPoint() {
        double genX = Math.random() * 2 * r - x;
        double genY = Math.random() * 2 * r - y;
        while(Math.hypot(genX-x, genY-y) > r){
            genX = Math.random() * 2 * r - x;
            genY = Math.random() * 2 * r - y;
        }
        return new double[]{genX, genY};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
//leetcode submit region end(Prohibit modification and deletion)
