import java.util.*;
import java.io.*;

public class paula{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("paola".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int start = f.next().charAt(0)-'A';
            int levels = f.nextInt(); f.nextLine();
            int count = 0;
            for (int i = levels-1; i>=0; i--) {
                System.out.print(" ".repeat(i));
                for(int j = i;j<levels;j++){
                    char c = (char)((start+count++)%26 + 'A');
                    System.out.print(c);
                }
                System.out.println();
            }
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new paula().run();
    }
}
