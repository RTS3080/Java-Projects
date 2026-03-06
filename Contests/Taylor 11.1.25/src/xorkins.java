import java.util.*;
import java.io.*;
import java.awt.*;

public class xorkins{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("xorkins".toLowerCase()+".in"));
        int len = f.nextInt(); f.nextLine();
        int[] start = new int[len];
        for (int i = 0; i < len; i++) {
            start[i] = f.nextInt();
        }
//        System.out.println(Arrays.toString(start));
        int[][] tree = new int[start.length][];
        tree[0] = start;
        for(int i = 1; i< start.length; i++){
            tree[i] = new int[start.length-i];
//            System.out.println(Arrays.deepToString(tree));
            for(int j = 0; j< tree[i].length; j++){
                tree[i][j] = tree[i-1][j]^tree[i-1][j+1];
            }
        }
        System.out.println(tree[tree.length-1][0]);
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new xorkins().run();
    }
}
