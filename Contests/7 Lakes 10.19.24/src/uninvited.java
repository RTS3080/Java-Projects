import java.util.*;
import java.io.*;

public class uninvited{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("uninvited".toLowerCase()+".in"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int sum = 0;
            int[] skills = new int[3];
            for (int i = 0; i < 3; i++) {
                skills[i] = f.nextInt();
                sum += skills[i];
            }
            int needed = f.nextInt();
            int res = 0;
            for (int i = 0; i < 3; i++) {
                if (sum - skills[i] >= needed) {
                    res++;
                }
            }
            System.out.println(res);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new uninvited().run();
    }
}
