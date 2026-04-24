import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class minecraft{
    char[][] mat;
    int[][] shadow;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("minecraft".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int r = f.nextInt();
            int c = f.nextInt();
            int hunger = f.nextInt();
            boolean hasBoots = f.nextBoolean();
            int sr = -1, sc = -1, er = -1, ec = -1;

            mat = new char[r][c];
            ArrayList<int[]> ghasts = new ArrayList<>();
            ArrayList<int[]> blazes = new ArrayList<>();
            ArrayList<int[]> piglins = new ArrayList<>();
            int hoglinCount = 0;
            for (int i = 0; i < r; i++) {
                mat[i] = f.next().toCharArray();
                for (int j = 0; j <c; j++) {
                    char cur = mat[i][j];
                    switch(cur){
                        case '.' -> mat[i][j] = '1';
                        case 'W' -> mat[i][j] = '#';
                        case 'S' -> {
                            mat[i][j] = '1';
                            sr = i;
                            sc = j;
                        }
                        case 's' -> mat[i][j] = hasBoots? '1' : '2';
                        case 'O' -> {
                            mat[i][j] = '1';
                            er = i;
                            ec = j;
                        }
                        case 'G' -> ghasts.add(new int[]{i, j});
                        case 'b' -> blazes.add(new int[]{i, j});
                        case 'p' -> piglins.add(new int[]{i, j});
                        case 'H' -> hoglinCount++;
                    }
                }
            }
            shadow = new int[r][c];
            for (int j = 0; j < r; j++) {
                Arrays.fill(shadow[j], Integer.MIN_VALUE);
            }
            for(int[] arr : ghasts){
                fillMat(arr[0],arr[1],3);
            }
            for(int[] arr : blazes){
                fillMat(arr[0],arr[1],2);
            }
            for(int[] arr : piglins){
                fillMat(arr[0],arr[1],hasBoots ? 2 : 0);
            }
            dfs( sr, sc,1,  hunger, -1);
            int max = Integer.MIN_VALUE;
            max = Math.max(max, shadow[er][ec]);
            System.out.println(max);
        }
        f.close();
    }
    void fillMat(int r, int c, int size){
        for(int i = max(r-size, 0); i < min(r+size, mat.length-1);i++){
            for(int j = max(c-size, 0); j < min(c+size, mat[i].length-1);j++){
                mat[i][j] = '#';
            }
        }
    }
    void dfs(int r, int c, int moves, int hunger, int fortressIndex){
        if( r< 0 || c < 0 || r>=mat.length || c>=mat[0].length || mat[r][c] == '#' || hunger < shadow[r][c] || hunger < 2){
            return;
        }
        int change = 1;
        while(moves >=5){
            moves-=5;
            hunger--;
        }
        shadow[r][c] = hunger;
        if( mat[r][c] == 'H'){
            mat[r][c] = '.';
            dfs(r, c, moves+1,hunger + 6, fortressIndex);
            mat[r][c] = 'H';
        }
        if(mat[r][c] == 'f'){
            change=1;
            if(fortressIndex == -1){
                fortressIndex = moves%5;
            }
            else{
                if(fortressIndex == moves%5){
                    hunger--;
                }

            }
        }
        else{
            fortressIndex=-1;
        }
        if(Character.isDigit(mat[r][c])){
            change = mat[r][c]-'0';
        }
        dfs( r+1, c, moves+change,hunger, fortressIndex);
        dfs( r-1, c, moves+change,hunger, fortressIndex);
        dfs( r, c+1, moves+change,hunger, fortressIndex);
        dfs( r, c-1, moves+change,hunger, fortressIndex);
    }


    public static void main(String[] args) throws FileNotFoundException{
        new minecraft().run();
    }
}
