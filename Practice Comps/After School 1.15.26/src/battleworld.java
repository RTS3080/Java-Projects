import java.util.*;
import java.io.*;
import java.awt.*;

public class battleworld{
    public void fillMat(char[][] mat, int sr, int sc, int er, int ec, char fill) {
        for (int i = sr; i <= er; i++) {
            for (int j = sc; j <= ec; j++) {
                mat[i][j] = fill;
            }
        }
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("battleworld".toLowerCase()+".dat"));

        String keys = "";
        for (int i = 0; i < 26; i++) {
            keys += (char) ('A' + i);
        }

        for (int i = 0; i < 10; i++) {
            keys += i;
        }

        int keyIdx = 0;
        LinkedHashMap<String, Character> villains = new LinkedHashMap<>();

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int rows = f.nextInt();
            int cols = f.nextInt();
            int entries = f.nextInt();

            char[][] mat = new char[rows][cols];
            for (int i = 0; i < mat.length; i++) {
                Arrays.fill(mat[i], '.');
            }

            while (entries-- > 0) {
                String villain = f.next();

                if (!villains.containsKey(villain)) {
                    villains.put(villain, keys.charAt(keyIdx++));
                }

                int sr = f.nextInt();
                int sc = f.nextInt();
                int er = f.nextInt();
                int ec = f.nextInt();

                char filler = villains.get(villain);
                fillMat(mat, sr, sc, er, ec, filler);
            }

            Arrays.stream(mat).forEach(System.out::println);
            System.out.println("-".repeat(10));
        }

        System.out.println(villains.toString().replaceAll("[^\\w=]+", "\n").trim());
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new battleworld().run();
    }
}
