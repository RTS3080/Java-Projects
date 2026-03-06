import java.util.*;
import java.io.*;

public class hutt{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        int times=f.nextInt(); f.nextLine();
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sevens = 7777777;
        while(times-->0){
            int n = f.nextInt();
            if (map.getOrDefault(n, 0) > 0) {
                res++;
                map.remove(n);
            } else {
                map.put(sevens - n, map.getOrDefault(sevens - n, 0) + 1);
            }
        }

        System.out.println(res);
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new hutt().run();
    }
}
