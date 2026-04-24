import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Thanh{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Thanh".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int r = f.nextInt();
            int c = f.nextInt();
            char[][] mat  = new char[r][c];
            for (int i = 0; i < r; i++) {
                mat[i] = f.next().toCharArray();
            }
            int times2=f.nextInt();
            while(times2-->0){
                int sr = f.nextInt(), sc = f.nextInt(), er = f.nextInt(), ec = f.nextInt();
                int counted = f.nextInt();
                int count =  0;
//                System.out.println(sr+" "+sc+" "+er+" "+ec);
                for (int i = sr; i <= er; i++) {
                    for (int j = sc; j <= ec; j++) {
                        if(mat[i][j]=='*'){
                            count++;
                        }
                    }
                }
//                System.out.println(count+" "+counted);
                if(count == counted){
                    System.out.println("UIL counting STATE incoming!");
                }
                else{
                    System.out.println("Unc's status.");

                }
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Thanh().run();
    }
}
