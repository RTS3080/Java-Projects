import java.util.*;
import java.io.*;

public class johnny{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("johnny".toLowerCase()+".dat"));
        ArrayList<String> lns = new ArrayList<>();
        HashMap<String, Character> dict = new HashMap<>();
        while(f.hasNext()){
            String s = f.nextLine().trim();
            if(s.matches("[^A-Za-z0-9] .+")){
                char c = s.charAt(0);
                String[] strs = s.substring(2).split("/");
                for(String str : strs){
                    dict.put(str, c);
                }
            }
            else{
                lns.add(s);
            }
        }
//        System.out.println(dict);
        for(String str : lns){
            String[] s = str.split(" ");
            String fin = "";
            for(String str2 : s){
                fin+=dict.get(str2);
            }
            System.out.println(fin);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new johnny().run();
    }
}
