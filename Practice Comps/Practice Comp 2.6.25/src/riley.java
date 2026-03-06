import java.util.*;
import java.io.*;

public class riley{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("riley".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int r = f.nextInt();
            int c = f.nextInt();
            int[][] mat = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    mat[i][j] = f.nextInt();
                }
            }
            for (int i = 0; i < Math.min((r+1)/2,(c+1)/2); i++) {
                int cnt = 0;
                double sum = 0;
                for (int j = i; j <= mat.length-i-1; j++) {
                    if(j == i || j == mat.length-1-i){
                        for (int k = i; k < c-i; k++) {
                            cnt++;
                            sum += mat[j][k];
//                            System.out.print(mat[j][k]+" ");
                        }
//                        System.out.println();
                    }
                    else{
                        cnt+=2;
                        sum += mat[j][i];
                        sum+=mat[j][mat[j].length-1-i];
//                        System.out.println(mat[j][i]+" "+mat[mat.length-1-j][i]+" "+j+" "+i);
                    }

                }
                System.out.printf("%.2f ",sum/cnt);

            }
            System.out.println();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new riley().run();
    }
}