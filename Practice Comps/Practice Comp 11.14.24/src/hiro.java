import java.util.*;
import java.io.*;

public class hiro{

    public void run() throws FileNotFoundException{
        Scanner in= new Scanner(new File("hiro".toLowerCase()+".dat"));

        int N = in.nextInt();
        in.nextLine();

        Map<String, Integer> map = new HashMap<String, Integer>() {{
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);
        }};

        for (int abc = 0; abc < N; abc++) {
            String s = in.next();
            int result = 0;
            int prev = 0;

            for (int i = s.length()-1; i >=0 ; i--) {
                int curr = map.get(s.substring(i, i+1));
                if(curr < prev)
                    result -= curr;
                else result += curr;

                prev = curr;
            }
            System.out.println(result);
        }
    }



    public static void main(String[] args) throws FileNotFoundException{
        new hiro().run();
    }
}
