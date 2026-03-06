import java.util.*;
import java.io.*;
import java.awt.*;

public class suresh{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("suresh".toLowerCase()+".dat"));
        while(f.hasNext()){
            String[] ln = f.nextLine().split("[.?]\\s?");
            String out = "";
            out+=ln.length+" ";
            String[][] sents = new String[ln.length][];
            for (int i = 0; i < ln.length; i++) {
                sents[i] = ln[i].split("[\\s,;:]+");
                out+=sents[i].length+" ";
                int maxLen = 0;
                String max = "";
//                System.out.println(Arrays.toString(sents[i]));
                for(String s : sents[i]){
                    if(s.length()>=maxLen){
                        maxLen = s.length();
                        max = s;
                    }
                }
                out+=max+" ";
            }
            System.out.println(out.trim());
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new suresh().run();
    }
}
