package leetcode.editor.en;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class point {
        double x;
        double y;
        public point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        void scale(double a){
            x *= a;
            y *= a;
        }

        double magnitude(){
            return Math.sqrt(x*x + y*y);
        }
        void normalize(){
            double mag = magnitude();
            x /= mag;
            y /= mag;
        }
        point normalized(){
            double mag = magnitude();
            return new point(x/mag, y/mag);
        }
        double dist(point p){
            return Math.hypot(x-p.x, y-p.y);
        }

        public String toString(){
            return "(" + x + ", " + y + ")";
        }

    }
    public int numPoints(int[][] dartArr, int r) {
        point[] darts = new point[dartArr.length];
        int n = darts.length;
        for (int i = 0; i < dartArr.length; i++) {
            darts[i] = new point(dartArr[i][0], dartArr[i][1]);
        }
        int maxInCircle = 1;
        for (int i = 0; i < darts.length; i++) {
            double[] dists = new double[darts.length];
            point a = darts[i];
            for (int j = 0; j < n; j++) {
                dists[j] = Math.hypot(a.x-darts[j].x, a.y-darts[j].y);
            }
//            System.out.println(Arrays.toString(dists));
            for (int j = 0; j < n; j++) {
                point b = darts[j];
                if(dists[j] > 2*r || i==j){
                    continue;
                }
                double distLineToCenter = Math.sqrt(r * r - (dists[j]*dists[j])/4);
                point midPoint = new point((a.x+b.x)/2,(a.y+b.y)/2);
                double offsetX = b.y-a.y;
                double offsetY = a.x-b.x;
                double magOffset = Math.sqrt(offsetX*offsetX + offsetY*offsetY);
                point centerOne = new point(midPoint.x +offsetX * distLineToCenter / magOffset,midPoint.y + offsetY * distLineToCenter / magOffset);
                point centerTwo = new point(midPoint.x - offsetX * distLineToCenter / magOffset,midPoint.y - offsetY * distLineToCenter / magOffset);
                int pointsInCircle = 0;
                for (int k = 0; k < n; k++) {
                    if(centerOne.dist(darts[k])<= r){
                        pointsInCircle++;
                    }
                }
                if(pointsInCircle > maxInCircle){
                    maxInCircle = pointsInCircle;
//                    System.out.println("center: "+centerOne+", a:"+a+", b:"+darts[j]);
                }
                pointsInCircle =0;
                for (int k = 0; k < n; k++) {
                    if(centerTwo.dist(darts[k])<= r){
                        pointsInCircle++;
                    }
                }
                if(pointsInCircle > maxInCircle){
                    maxInCircle = pointsInCircle;
//                    System.out.println("center: "+centerOne+", a:"+a+", b:"+darts[j]);
                }
            }
        }
        return maxInCircle;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
