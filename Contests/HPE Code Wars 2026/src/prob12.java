import java.sql.SQLOutput;
import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class prob12{

    public void run() throws FileNotFoundException{
        //Scanner f= new Scanner(new File("prob12".toLowerCase()+".dat"));
        Scanner f = new Scanner(new File("input.txt"));
        ArrayList<int[]> allowed = new ArrayList<>();
        allowed.add(new int[]{1, 2});
        allowed.add(new int[]{1, 3});
        allowed.add(new int[]{4, 2});
        allowed.add(new int[]{4, 3});
        for (int i = 2; i < 4; i++) {
            for (int j = 1; j < 5; j++) {
                allowed.add(new int[]{i, j});
            }
        }
        char[][] mat = new char[6][6];
        for (int i = 0; i < 6; i++) {
            mat[i] = f.nextLine().toCharArray();
        }
        for(int[] a : allowed){
            System.out.println(Arrays.toString(a));
        }
        boolean pass = true;
        for(char[] c : mat){
            System.out.println(c);
        }
        for(int[] i : allowed){
            int a=  i[0];
            int b = i[1];
            System.out.println(a+" "+b);
            if(mat[a][b] == '-') {
                pass = false;
                mat[a][b] = '!';
            }
        }
        if(pass){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAIL");
            for(char[] c : mat){
                System.out.println(c);
            }

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob12().run();
    }
}
