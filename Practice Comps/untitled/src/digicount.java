import java.util.*;
import java.io.*;

public class digicount{

    public void run() throws FileNotFoundException{
        Scanner a= new Scanner(new File("digicount".toLowerCase()+".dat"));
        Scanner f = new Scanner(a.nextLine());
        while(f.hasNext()) {
            HashMap<Integer, Integer> digis = new HashMap<>();
            for (int i = 0; i < 10; i++) {
                digis.put(i, 0);
            }
            int n = f.nextInt();
            for (int i = 1; i <= n; i++) {
                String s = "" + i;
                for (char c : s.toCharArray()) {
                    digis.put(c - '0', digis.get(c - '0') + 1);
                }
            }
            for (int i = 0; i < 10; i++) {
                System.out.print(digis.get(i) + " ");
            }
            System.out.println();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new digicount().run();
    }
}
