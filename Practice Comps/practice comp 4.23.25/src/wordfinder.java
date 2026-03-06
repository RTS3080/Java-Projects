import java.util.*;
import java.io.*;

public class wordfinder{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("wordfinder".toLowerCase()+".dat"));
        int times=f.nextInt();
        int times2 = f.nextInt();
        int[][] wordCounts = new int[times][26];
        f.nextLine();
        for (int i = 0; i < times; i++) {
            String word = new String(f.nextLine().toCharArray());
            for(char c : word.toCharArray()){
                wordCounts[i][c-'a']++;
            }
        }
        for (int i = 0; i < times2; i++) {
            int[] counts = new int[26];
            String word = new String(f.nextLine().toCharArray());
            for(char c : word.toCharArray()){
                counts[c-'a']++;
            }
            int count = 0;
            for (int j = 0; j < times; j++) {
                boolean good = true;
                for (int k = 0; k < 26; k++) {
                    if(wordCounts[j][k] > counts[k]) good = false;
                }
                if(good) count++;
            }
            System.out.println(count);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new wordfinder().run();
    }
}
