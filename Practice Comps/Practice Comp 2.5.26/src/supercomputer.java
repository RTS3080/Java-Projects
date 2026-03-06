import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class supercomputer{
    public void insert(int[][][] mat, int idx) {
        int i = idx / 16 % 4;
        int j = idx / 4 % 4;
        int k = idx % 4;

        mat[i][j][k]++;
    }

    public int[][][] rotateA(int[][][] mat) {
        int[][][] copy = new int[4][4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    copy[i][k][3 - j] = mat[i][j][k];
                }
            }
        }

//        mat = copy;
//        copy = new int[4][4][4];
//
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                for (int k = 0; k < 4; k++) {
//                    copy[i][k][3 - j] = mat[i][j][k];
//                }
//            }
//        }
//
//        mat = copy;
//        copy = new int[4][4][4];
//
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                for (int k = 0; k < 4; k++) {
//                    copy[i][k][3 - j] = mat[i][j][k];
//                }
//            }
//        }

        return copy;
    }

    public int[][][] rotateB(int[][][] mat) {
        int[][][] copy = new int[4][4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    copy[k][j][3 - i] = mat[i][j][k];
                }
            }
        }

        mat = copy;
        copy = new int[4][4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    copy[k][j][3 - i] = mat[i][j][k];
                }
            }
        }
////
        mat = copy;
        copy = new int[4][4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    copy[k][j][3 - i] = mat[i][j][k];
                }
            }
        }

        return copy;
    }

    public int[][][] rotateC(int[][][] mat) {
        int[][][] copy = new int[4][4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    copy[j][3 - i][k] = mat[i][j][k];
                }
            }
        }

        mat = copy;
        copy = new int[4][4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    copy[j][3 - i][k] = mat[i][j][k];
                }
            }
        }

        mat = copy;
        copy = new int[4][4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    copy[j][3 - i][k] = mat[i][j][k];
                }
            }
        }

        return copy;
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("supercomputer".toLowerCase()+".dat"));

        while (f.hasNext()){
            String[] tokens = f.nextLine().trim().split(" +");
            int[][][] grid = new int[4][4][4];

            String rotations = "";

            for (String str : tokens) {
                switch (str.charAt(0)) {
                    case 'A' -> {
                        grid = rotateA(grid);
                        grid = rotateA(grid);
                    }
                    case 'B' -> {
                        grid = rotateB(grid);
                        grid = rotateB(grid);
                    }
                    case 'C' -> {
                        grid = rotateC(grid);
                        grid = rotateC(grid);
                    }
                    default -> insert(grid, Integer.parseInt(str));
                }
            }

            int[][] sums = new int[4][4];

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 4; k++) {
                        sums[j][k] += grid[i][j][k];
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                String out = "";
                for (int j = 0; j < 4; j++) {
                    out += sums[i][j] + " ";
                }
                System.out.println(out.trim());
            }
            System.out.println();
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new supercomputer().run();
    }
}
