import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class clarabelle{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("clarabelle".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            char[] word = f.next().toCharArray();
            TreeSet<String> words = new TreeSet<>();
            for (int i = 0; i < word.length-2; i++) {
                if(word[i] == word[i+2]){
                    words.add(""+word[i]+word[i+1]+word[i+2]);
                }
            }
            if(words.size() == 0){
                System.out.println("NONE");
            }
            else{
                String out = "";
                for(String s: words){
                    out+=s+" ";
                }
                System.out.println(out.trim());
            }

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new clarabelle().run();
    }
}
