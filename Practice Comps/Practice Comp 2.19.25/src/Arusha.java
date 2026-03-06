import java.util.*;
import java.io.*;

public class Arusha{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Arusha".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String s = f.next();
            char[] rots = f.next().toCharArray();
            char[] chs = s.toCharArray();
            ArrayList<Character> chars = new ArrayList<>();
            for(char c : chs){
                chars.add(c);
            }
            int l = 0;
            int r = 0;
            for(char c : rots){
                if(c=='L'){
                    l++;
                }
                else if(c=='R'){
                    r++;
                }
            }
            Collections.rotate(chars, -l);
            Collections.rotate(chars, r);
            String str ="";
            for(char c : chars){
                str+=c;
            }
            System.out.println(str);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Arusha().run();
    }
}
