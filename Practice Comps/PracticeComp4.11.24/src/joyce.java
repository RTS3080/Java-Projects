import java.util.*;
import java.io.*;

public class joyce{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("joyce".toLowerCase()+".dat"));
        int cases = f.nextInt();
        f.nextLine();
        while (cases-- > 0) {
            String line = f.nextLine().toLowerCase().trim();
            ArrayList<Character> missing = new ArrayList<>();
            boolean single = true;
            for (char ch = 'a'; ch <= 'z'; ch++) {
                int times = 0;
                for (char c : line.toCharArray()) {
                    if (c == ch) times++;
                }
                if (times != 1) single = false;
                if (times == 0) missing.add(ch);
            }
            if (!missing.isEmpty()) {
                System.out.print("missing ");
                for (int i = 0; i < missing.size(); i++) {
                    System.out.print(missing.get(i));
                }
                System.out.println();
            } else if (single) {
                System.out.println("perfect pangram");
            } else System.out.println("pangram");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new joyce().run();
    }
}
