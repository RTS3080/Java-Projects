import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class spiral{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("spiral".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        while(f.hasNext()){
            int n = f.nextInt();
            int cnt = 1;
            while(cnt * cnt <= n-1){
                cnt++;
            }
            int[][] mat = new int[cnt][cnt];
            int r = cnt/2, c = cnt/2;
            int currMoves =0;
            int count= 1;
            int remMoves = 0;
            int currChange = 3;
            int[][] change = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
            while(!(r==0 && c== cnt+1) && count <= cnt*cnt){
                if(remMoves==0){
                    if(currChange%2==1){
                        currMoves++;
                    }
                    remMoves = currMoves;
                    currChange = (currChange+1)%4;
                }
//                System.out.println(count);
//                for (int i = 0; i < mat.length; i++) {
//                    System.out.println(Arrays.toString(mat[i]));
//                }
//                System.out.println();
                mat[r][c] = count++;
                r+=change[currChange][0];
                c+=change[currChange][1];
                remMoves--;
            }
            int outR = -1;
            int outC = -1;
            for (int i = 0; i < cnt; i++) {
                for (int j = 0; j < cnt; j++) {
                    if(mat[i][j] == n){
                        outR = i+1;
                        outC = j+1;
                    }
                }
            }
//            for (int i = 0; i < mat.length; i++) {
//                    System.out.println(Arrays.toString(mat[i]));
//                }
//                System.out.println();
            System.out.println(outR+" "+outC);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new spiral().run();
    }
}
