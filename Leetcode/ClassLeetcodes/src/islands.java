import java.util.*;
import java.awt.*;

class islands {
    char[][] mat;
    public int numIslands(char[][] grid) {
        mat = grid;
        int count = 0;
        while(isOne(grid)){
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[i].length; j++) {
                    count +=recur(i,j)>0 ? 1 : 0;
                }
            }
        }
        return count;
    }

    public int recur(int r, int c){
        if(r<0 || r>=mat.length || c<0 || c>=mat[0].length || mat[r][c] == '0'){
            return 0;
        }
        mat[r][c] = '0';
        return 1+recur(r+1, c) + recur(r, c+1)+recur(r-1, c) + recur(r, c-1);
    }

    public boolean isOne(char[][] grid){
        for(char[] chs : grid){
            for(char c : chs){
                if(c == '1')
                    return true;
            }
        }
        return false;
    }
}