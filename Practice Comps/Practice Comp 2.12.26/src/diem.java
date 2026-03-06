import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class diem{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("diem".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int n = f.nextInt(); f.nextLine();

            String[] strings = new String[n];
            for (int i = 0; i < n; i++) {
                strings[i] = f.nextLine();
            }


            int count = 0;

            for (int i = 0; i < n - 1; i++) {
                String min = strings[i];
                int idx = i;

                for (int j = i + 1; j < n; j++) {
                    if (strings[j].compareTo(min) < 0) {
                        min = strings[j];
                        idx = j;
                    }
                }

                if (i != idx) count++;
                String temp = strings[idx];
                strings[idx] = strings[i];
                strings[i] = temp;
            }

            System.out.println(count);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new diem().run();
    }
}
