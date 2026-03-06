import java.util.*;
import java.io.*;

public class blob1{

    char[][] mat;
    boolean[][] shadow;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("blob1".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int sizeRow=f.nextInt(); int sizeCol=f.nextInt();
            f.nextLine();
            mat=new char[sizeRow][sizeCol];
            shadow=new boolean[sizeRow][sizeCol];
            for(int i=0;i<sizeRow;i++){
                mat[i] = f.nextLine().toCharArray();
                Arrays.fill(shadow[i],false);
            }

            int[] three = new int[3];
            for (int i = 0; i < 3; i++) {
                int r = f.nextInt();
                int c = f.nextInt();
                three[i] = (recur(r, c));
            }
            int largest = 0;
            for(int i : three){
                if((""+i).length() > largest)
                    largest = (""+i).length();
            }
            for(int i : three) {
                System.out.printf("%" + largest + "d%n", i);
            }
            System.out.println();
        }
        f.close();
    }
    
    int recur(int r, int c){
        if(r<0 || c<0 || r>=mat.length || c>=mat[0].length || mat[r][c] == '0' || shadow[r][c]){
            return 0;
        }
        shadow[r][c]=true;
        return 1+recur(r+1,c)+recur(r,c+1)+recur(r-1,c)+recur(r,c-1);
    }

    
    public static void main(String[] args) throws FileNotFoundException{
        new blob1().run();
    }
}
