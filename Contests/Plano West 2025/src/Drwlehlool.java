import java.util.*;
import java.io.*;

public class Drwlehlool{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);

        int k = f.nextInt();
        f.nextLine();

        while(k-->0){
            String res = "";
            String in = f.nextLine();
            int mid = in.length()/2;
            int min = mid-1;
            int max = mid+1;
            res+=""+in.charAt(mid);
            while(min>=0||max<in.length()){
                if (min>=0){
                    res+=""+in.charAt(min);
                    min--;
                }
                if (max<in.length()){
                    res+=""+in.charAt(max);
                    max++;
                }
            }
            System.out.println(res);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Drwlehlool().run();
    }
}
