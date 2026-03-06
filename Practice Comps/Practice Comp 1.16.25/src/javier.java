import java.util.*;
import java.io.*;

public class javier{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("javier".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        timeloop:
        while(times-->0){
            int start = f.nextInt();
            int end = f.nextInt();
            String c = f.next();
            char side = f.next().toUpperCase().charAt(0);
            f.nextLine();
            int len = Math.abs(end-start)+1;
            if (end > start) {
                for (int i = 0; i < len; i++) {
                    if (side == 'L') {
                        System.out.println(c.repeat(i + start));
                    }
                    if (side == 'R') {
                        System.out.println(" ".repeat(end-i-start) + c.repeat(i + start));
                    }
                }
            }
            else{
                for(int i = len-1;i>=0;i--){
                    if (side == 'L') {
                        System.out.println(c.repeat(i + end));
                    }
                    if (side == 'R') {
                        System.out.println(" ".repeat(start - i-end) + c.repeat(i + end));
                    }
                }
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new javier().run();
    }
}
