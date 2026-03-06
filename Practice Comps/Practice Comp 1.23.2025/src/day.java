import java.util.*;
import java.io.*;

public class day{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("dayJob".toLowerCase()+".dat"));
        int times=f.nextInt();
        int cnt = 0;
        while(times-->0){
            String[] ln = f.nextLine().split("\\s+");
            if(ln[ln.length-1].equals("GMO"))
                cnt++;
        }
        System.out.printf("%d food(s) contain(s) GMOs\n", cnt);
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new day().run();
    }
}
