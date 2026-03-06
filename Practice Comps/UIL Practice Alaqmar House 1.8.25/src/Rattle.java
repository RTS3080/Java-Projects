import java.util.*;
import java.io.*;

public class Rattle{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Rattle".toLowerCase()+".dat"));
        int k = f.nextInt();
        f.nextLine();
        for (int x = 0; x < k; x++) {
            String in = f.nextLine();
            int l = (int)Math.sqrt(in.length());
            String[][] dec = new String[l][l];
            int c = 0;
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < l; j++) {
                    dec[i][j] = in.charAt(c)+"";
                    c++;
                }
            }
            String temp = "";
            for (int i = 0; i < l; i+=2) {
                temp = dec[0][i];
                for (int j = 1; j < l; j++) {
                    dec[j-1][i]=dec[j][i];
                }
                dec[l-1][i]=temp;
            }
            for (int i = 1; i < l; i+=2) {
                temp = dec[l-1][i]+"";
                for (int j = l-2; j >=0 ; j--) {
                    dec[j+1][i]=dec[j][i];
                }
                dec[0][i]=temp;
            }
            String res = "";
            bob:
            for (int i = 0; i < l ; i++) {
                for (int j = 0; j < l; j++) {
                    if (dec[i][j].equals("*")) {
                        break bob;
                    }else {
                        res+=dec[i][j];
                    }
                }
            }
            System.out.println(res);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Rattle().run();
    }
}
