import java.util.*;
import java.io.*;

public class largestRectangleArea{
//    int largestArea = 0;
//    ArrayList<Integer[]> usedpairs;
//    public int largestRectangleArea(int[] heights) {
//        sizes = heights;
//        int max = 0;
//        for(int i : heights){
//            max = Math.max(max, i);
//        }
//        boolean allSame = true;
//        for(int i : heights){
//            if(i!=max) {
//                allSame = false;
//                break;
//            }
//        }
//        if(allSame){
//            return max * heights.length;
//        }
//        usedpairs = new ArrayList<>();
//        recur(0,0);
//        System.out.println(largestArea);
//        return largestArea;
//    }
//
//    public boolean search(int start, int end){
//        for(Integer[] i : usedpairs){
//            if(i[0] == start && i[1] == end) return true;
//        }
//        return false;
//    }
//
//    public void recur(int start, int end) {
//        if(start<0 || end<start || end>=sizes.length || search(start, end)) return;
//        usedpairs.add(new Integer[]{start, end});
//        int smallest = Integer.MAX_VALUE;
//        for (int i = start; i <= end; i++) {
//            if(sizes[i] < smallest) smallest = sizes[i];
//        }
//        int a = smallest * (end-start+1);
////        System.out.println(start+" "+end+" "+ ": "+ a);
//        if(a>largestArea) largestArea = a;
//        recur(start, end-1);
//        recur(start, end+1);
//        recur(start+1, end);
//        recur(start-1, end);
//    }

    public int largestRectangleArea(int[] heights) {
        int largestArea = 0;
        ArrayList<Integer[]> usedpairs = new ArrayList<>();
        int max = 0;
        for(int i : heights){
            max = Math.max(max, i);
        }
        boolean allSame = true;
        for(int i : heights){
            if(i!=max) {
                allSame = false;
                break;
            }
        }
        if(allSame){
            return max * heights.length;
        }
        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    if(heights[k] < min) {
                        min = heights[k];
                    }
                }
                int area = min * (j - i+1);
                if(area > largestArea) {
                    largestArea = area;
                }
            }
        }
//        System.out.println( largestArea);
        return largestArea;
    }

    public static void main(String[] args) {
        new largestRectangleArea().largestRectangleArea(new int[]{2,1,5,6,2,3});
    }


}
