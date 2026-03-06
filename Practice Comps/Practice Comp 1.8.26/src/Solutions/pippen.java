package Solutions;

import java.util.*;
import java.io.*;

public class pippen {
    int[][][][] shadow;
    char[][] m;
    int[] vr = {-1,1,0,0,-1,-1,1,1};
    int[] vc = {0,0,-1,1,-1,1,-1,1};
    String door;
    public static void main(String[] args) throws Exception {
        new pippen().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("pippen.dat"));
//        Scanner f = new Scanner(System.in);
        int t = f.nextInt();
        f.nextLine();
        while (t-- > 0) {
            int row = f.nextInt(), col = f.nextInt(), charge = f.nextInt();
            m = new char[row][col];
            door = "";
            int[][] coor = new int[2][2];
            for (int i = 0; i < 2; i++) {
                Arrays.fill(coor[i], -1);
            }
            for (int i = 0; i < row; i++) {
                m[i] = f.next().toCharArray();
                for (int j = 0; j < col; j++) {
                    if(m[i][j] == ']'){
                        coor[0] = new int[]{i,j};
                    }
                    if(m[i][j] == '['){
                        coor[1] = new int[]{i,j};
                    }
                    if ((m[i][j] + "").matches("[a-z]")) {
                        char d = Character.toUpperCase(m[i][j]);
                        if(!door.contains(d+""))door += d;
                    }
                }
            }
            boolean good = true;
            for (int i = 0; i < 2; i++) {
                if(coor[i][0] == -1 && coor[i][1] == -1) {
                    good = false;
                    break;
                }
            }
            if(good){
                shadow = new int[charge + 1][1 << door.length()][row][col];
                for (int i = 0; i <= charge; i++) {
                    for (int j = 0; j < 1 << door.length(); j++) {
                        for (int k = 0; k < row; k++) {
                            Arrays.fill(shadow[i][j][k], Integer.MAX_VALUE);
                        }
                    }
                }
                recur(coor[0][0], coor[0][1], 0, 0, 0);
                int min = Integer.MAX_VALUE;
                for(int i = 0;i <= charge;i++){
                    for(int j = 0;j < 1 << door.length();j++){
                        min = Math.min(min, shadow[i][j][coor[1][0]][coor[1][1]]);
                    }
                }
                if(min== Integer.MAX_VALUE) System.out.println("Failed :(");
                else System.out.println("Success in " + min + " step(s).");
            }
            else System.out.println("Failed :(");
        }
        f.close();
    }
    public void recur(int r, int c,int step, int charge, int key){
        if(r>=0&&c>=0&&r<m.length&&c<m[r].length &&m[r][c]!='#' && step < shadow[charge][key][r][c]){

            // check if there is no corresponding key in the maze at all
            if(Character.isUpperCase(m[r][c]) && !door.contains(m[r][c]+"")) return;

            // if first check passed means we have corresponding key in the maze but need to check if we currently have that key
            if(Character.isUpperCase(m[r][c]) && (key & 1 << door.indexOf(m[r][c])) == 0) return;

            shadow[charge][key][r][c] = step;

            // pick key up
            if (Character.isLowerCase(m[r][c])) {
                key |= 1 << door.indexOf(Character.toUpperCase(m[r][c]));
            }
            shadow[charge][key][r][c] =step;
            if(charge + 1 < shadow.length){
                for(int i = 4;i < 8;i++){
                    recur(r + vr[i], c + vc[i], step + 1, charge + 1, key);
                }
            }
            for (int i = 0; i < 4; i++) {
                recur(r + vr[i], c + vc[i], step + 1, charge, key);
            }
        }
    }
}