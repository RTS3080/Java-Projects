import com.sun.source.tree.Tree;

import java.net.Inet4Address;
import java.util.*;
import java.io.*;

public class Tushar{
    int[][] mat;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Tushar".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int rows = f.nextInt(); int cols = f.nextInt();
            f.nextLine();
            mat = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    mat[i][j]=f.nextInt();
                }
            }
           double total = 0;
            for (int i = 0; i < cols; i++) {
                int w=0;
                int p=i;int r=0;
                while(r>=0 && r<rows && p>=0 && p<cols){
                    total += mat[r][p];
                    r=r+1;
                    p=p+1;
                    w++;
                }
                System.out.printf("%.2f ",total/w);
                total=0;
            }
            for (int i = 1; i < rows; i++) {
                int w=0;
                int p=0;int r=i;
                while(r>=0 && r<rows && p>=0 &&p<cols){
                    total += mat[r][p];
                    r=r+1;
                    p=p+1;
                    w++;
                }
                System.out.printf("%.2f ",total/w);
                total=0;
            }
            System.out.println();
        }
        f.close();
    }

    public static void main(String[] args) throws FileNotFoundException{
        new Tushar().run();
    }
}

