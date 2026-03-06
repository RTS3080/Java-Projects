import java.util.*;
import java.io.*;

public class teamcuts{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("teamcuts".toLowerCase()+".in"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            HashSet<Character> visited = new HashSet<>();
            String str = "a".repeat(10000);

            for (int i = 0; i < str.length(); i++) {
                int idx = str.indexOf(str.charAt(i)+"", i + 1);
                if ( idx == -1 || visited.contains(str.charAt(i))) {
                    continue;
                }
                visited.add(str.charAt(i));
                str = str.substring(0, i) + str.substring(i + 1, idx) + str.substring(idx + 1);
                i--;
            }

            System.out.println(str);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new teamcuts().run();
    }
}
