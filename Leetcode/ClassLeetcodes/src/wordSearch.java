//import java.util.*;
//
//public class wordSearch {
//}
//class Solution {
//    boolean[][] shadow;
//    char[][] mat;
//    String targetWord;
//    boolean found;
//    public boolean exist(char[][] board, String word) {
//        mat = board;
//        targetWord = word;
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                shadow = new boolean[board.length][board[0].length];
//                found = false;
//                dfs(i, j, "");
//                if(found) return true;
//            }
//        }
//        return false;
//
//    }
//
//    void dfs(int r, int c, String str){
//        if(r <0 || c<0 || r >= mat.length || c >= mat[0].length ||
//                str.length() > targetWord.length() || shadow[r][c]
//                || !str.equals(targetWord.substring(0, str.length()))) return;
//        if(str.equals(targetWord)){
//            found = true;
//            return;
//        }
//        shadow[r][c] = true;
//        str += mat[r][c];
//        dfs(r+1, c, str);
//        dfs(r-1, c, str);
//        dfs(r, c+1, str);
//        dfs(r, c-1, str);
//    }
//
//}
