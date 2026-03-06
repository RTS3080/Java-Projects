import java.util.*;
import java.io.*;

public class dogWalking{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("dog".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int size=f.nextInt();
            char[][] mat = new char[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (i == 0 || i == size - 1) {
                        mat[i][j] = '@';
                    }
                    else{
                        mat[i][j] = ' ';
                        mat[i][0] = '@';
                        mat[i][size-1] = '@';
                    }

                }
            }
            for(char[] ch : mat){
                System.out.println(ch);
            }
            System.out.println();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new dogWalking().run();
    }
}
