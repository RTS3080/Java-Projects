import java.util.*;
import java.io.*;

public class Joan{

    public void run() throws FileNotFoundException {
        Scanner f = new Scanner(new File("Joan".toLowerCase() + ".dat"));
        int words = 0;
        double len = 0;
        while (f.hasNext()) {
            String[] ln = f.nextLine().split(" ");
            words += ln.length;
            for(String s : ln)
                len+=s.length();
        }
        System.out.printf("%d words with an average length of %.0f letters\n", words, len/words);
    }

    public static void main(String[] args) throws FileNotFoundException{
        new Joan().run();
    }
}
