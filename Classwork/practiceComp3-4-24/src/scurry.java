import java.util.*;
import java.io.*;

public class scurry {
    public void run()throws Exception
    {
        Scanner f = new Scanner(new File("scurry.dat"));
        int times=f.nextInt(); f.nextLine();
        for(int z = 1;z<=times;z++) {
            int r = f.nextInt();
            int c = f.nextInt();
            f.nextLine();
            char[][] mat = new char[r][c];
            for (int i = 0; i < r; i++) {
                mat[i] = f.nextLine().trim().toCharArray();
            }
            ArrayList<Integer> north = new ArrayList<>();
            ArrayList<Integer> west = new ArrayList<>();
            ArrayList<Integer> east = new ArrayList<>();
            ArrayList<Integer> south = new ArrayList<>();

            //north
            for (int i = 0; i < c; i++) {
                boolean pillar = false;
                for (int j = 0; j < r; j++) {
                    if (mat[j][i] == '#') {
                        pillar = true;
//                        System.out.println(j+" "+i);
                    }

                    if (pillar && mat[j][i] != '#')
                        north.add(j * r + i);
                }
            }

            //west
            for (int i = 0; i < r; i++) {
                boolean pillar = false;
                for (int j = 0; j < c; j++) {
                    if (mat[i][j] == '#') {
                        pillar = true;
//                        System.out.println(i+" "+j);
                    }
                    if (pillar && mat[i][j] != '#')
                        west.add(i * r + j);
                }
            }

            //east
            for (int i = 0; i < r; i++) {
                boolean pillar = false;
                for (int j = c - 1; j >= 0; j--) {
                    if (mat[i][j] == '#') {
                        pillar = true;
//                        System.out.println(i+" "+j);
                    }
                    if (pillar && mat[i][j] != '#')
                        east.add(i * r + j);
                }
            }

            //south
            for (int i = 0; i < c; i++) {
                boolean pillar = false;
                for (int j = r - 1; j >= 0; j--) {
                    if (mat[j][i] == '#') {
                        pillar = true;
//                        System.out.println(j+" "+i);
                    }
                    if (pillar && mat[j][i] != '#')
                        south.add(j * r + i);
                }
            }
            Collections.sort(north);
            Collections.sort(south);
            Collections.sort(east);
            Collections.sort(west);
            System.out.print("Testcase " + z + " NORTH: ");
            for (int i : north)
                System.out.print(i + " ");
            System.out.println();
            System.out.print("Testcase " + z + " EAST : ");
            for (int i : east)
                System.out.print(i + " ");
            System.out.println();
            System.out.print("Testcase " + z + " SOUTH: ");
            for(int i:south)
                System.out.print(i+" ");
            System.out.println();
            System.out.print("Testcase " + z + " WEST : ");
            for(int i:west)
                System.out.print(i+" ");
            System.out.println();
        }
        f.close();
    }

    public static void main(String[] args)throws Exception
    {
        new scurry().run();
    }


}
