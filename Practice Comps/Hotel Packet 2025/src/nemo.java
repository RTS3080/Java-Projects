import java.util.*;
import java.io.*;
import java.awt.*;

public class nemo{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("nemo".toLowerCase()+".dat"));
        while(f.hasNext()){
            f.next();
            int r = f.nextInt();
            int c = f.nextInt();
            int l = f.nextInt(); f.nextLine();
            char[][][] mat = new char[l+1][r+1][c+1];
            String[] d = f.nextLine().trim().split(" ");
            String[] fs = f.nextLine().trim().split(" ");
            int[][] dynamite = new int[d.length][3];
            for (int i = 0; i < d.length; i++) {
                String[] a = d[i].trim().split(",");
                dynamite[i][0] = Math.min(Integer.parseInt(a[2]), l-1);
                dynamite[i][1] = Integer.parseInt(a[0]);
                dynamite[i][2] = Integer.parseInt(a[1]);
            }
            int[][] fish = new int[fs.length][3];
            for (int i = 0; i < fs.length; i++) {
                String[] a = fs[i].trim().split(",");
                fish[i][0]= Integer.parseInt(a[2]);
                fish[i][1]= Integer.parseInt(a[0]);
                fish[i][2]= Integer.parseInt(a[1]);
                mat[fish[i][0]][fish[i][1]][fish[i][2]] = 'F';
            }
            int count = 0;
            for(int[] dyn : dynamite){
//                System.out.println(Arrays.toString(dyn));
                for (int i = Math.max(0,dyn[0]-1); i <= Math.min(dyn[0]+1, l); i++) {
                    for (int j = Math.max(0,dyn[1]-1); j <= Math.min(dyn[1]+1, r); j++) {
                        for (int k = Math.max(0,dyn[2]-1); k <= Math.min(dyn[2]+1, c); k++) {
                            if(mat[i][j][k] == 'F'){
                                double dist  = Math.sqrt(Math.pow(dyn[0]-i,2) + Math.pow(dyn[1]-j,2) + Math.pow(dyn[2]-k,2));
                                if(dist<=1){
                                    count++;
                                    mat[i][j][k] = 'O';
                                }
                            }
                        }
                    }
                }
            }
            f.nextLine();
            System.out.println(count >0 ? "AIEE, I got "+count+" fish, me!" : "None of dem fish blowed up!");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new nemo().run();
    }
}
