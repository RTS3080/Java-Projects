import java.util.*;
import java.io.*;

public class filip{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("filip".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        timeloop:
        while(times-->0){
            int r= f.nextInt();
            int c= f.nextInt();
            char ch= f.next().charAt(0);
            boolean filled = f.nextBoolean();
            char[][] mat = new char[r][c];
            if(filled){
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        mat[i][j] = ch;
                    }
                }
            }
            else{
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if(i==0 || i==r-1){
                            mat[i][j] = ch;
                        }
                        else{
                            mat[i][j] = ' ';
                            mat[i][0] = ch;
                            mat[i][c-1] = ch;
                        }
                    }
                }
            }
            for(char[] chars : mat){
                System.out.println(chars);
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new filip().run();
    }
}
