import java.util.*;
import java.io.*;
import java.awt.*;

public class ralph{

    String result;
    char[] target;

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("ralph".toLowerCase()+".dat"));

        while (f.hasNext()){
            result = "-1";

            target = f.next().toCharArray();
            Arrays.sort(target);

            recur("", new HashSet<Integer>());

            if (result.equals("-1")){
                System.out.println("EXCEEDS MAX VALUE");
            }
            else {
                System.out.println(Integer.parseInt(result));
            }
        }

        f.close();
    }

    public void recur(String str, HashSet<Integer> set){
        if (str.length() == target.length) {
            if (Integer.parseInt(str) > 32767) return;
            if (Integer.parseInt(str) > Integer.parseInt(result)) result = str;
        }


        for (int i = 0; i < target.length; i++){
            if (set.contains(i)) continue;

            HashSet<Integer> copy = new HashSet<>(set);
            copy.add(i);

            recur(str+target[i], copy);
        }
    }



    public static void main(String[] args) throws FileNotFoundException{
        new ralph().run();
    }
}
