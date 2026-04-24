import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class outputToDesmos{
//[[1,2],[3,5],[1,-1],[2,3],[4,1],[1,3]]
    public void run() throws FileNotFoundException{
        Scanner f = new Scanner(System.in);
        String ln = f.nextLine();
        ln = ln.substring(2, ln.length()-2).replaceAll("\\s+", "");
        String[] pts = ln.split("\\],\\[");
        String out = "";
        for(String s : pts){
            int[] nums = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
            out+= "("+nums[0]+","+nums[1]+")\n";
        }
        System.out.println(out);
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new outputToDesmos().run();
    }
}
