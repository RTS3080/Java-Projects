import java.util.*;
import java.io.*;

public class pattern{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("pattern".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String[] pat = f.nextLine().split("");
            String[] words = f.nextLine().split(" ");
            if(pat.length!=words.length){
                System.out.println("Does Not Match");
                continue;
            }
            HashMap<String, String> map = new HashMap<>();
            ArrayList<String> wds = new ArrayList<>();
            boolean match = true;
            for (int i = 0; i < pat.length; i++) {
                if(!map.containsKey(pat[i])){
                    if(wds.contains(words[i])){match = false;}
                    map.put(pat[i], words[i]);
                    wds.add(words[i]);
                }
                else {
                    if(!map.get(pat[i]).equals(words[i])){
                        match = false;
                    }
                }
            }
            System.out.println(match? "Matches" : "Does Not Match");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new pattern().run();
    }
}
