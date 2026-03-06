import java.util.*;
import java.io.*;

public class pic{
    public static void main(String[] args) throws FileNotFoundException{
//        Scanner f= new Scanner(new File("pic".toLowerCase()+".dat"));
//        f.close();
        String s="racecar";
        char[][] mat=new char[s.length()][s.length()];
        for (int i = 0; i < mat.length; i++) {
            Arrays.fill(mat[i],' ');
        }

        int n=mat.length-1;
        for (int i = 0; i < n+1; i++) {
            mat[0][i]=s.charAt(i);
            mat[i][0]=s.charAt(i);
            mat[i][i]=s.charAt(i);
            mat[i][n]=s.charAt(i);
            mat[n][i]=s.charAt(i);
            mat[n-i][i]=s.charAt(i);
        }
        for(char[] ch:mat){
            for(char c:ch){
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
