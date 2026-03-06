import java.util.*;
import java.io.*;

public class kamil{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("kamil".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        timeloop:
        while(times-->0){
            String[] ln = f.nextLine().split(" ");
            ArrayList<String> words = new ArrayList<>();
            for(String str: ln){
                StringBuilder s = new StringBuilder();
                s = s.append(str);
                s = s.reverse();
                words.add(s.toString());
            }
            Collections.sort(words);
            for(String word: words){
                StringBuilder s = new StringBuilder(word);
                System.out.print(s.reverse()+" ");
            }
            System.out.println();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new kamil().run();
    }
}
