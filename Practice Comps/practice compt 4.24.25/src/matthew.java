import java.util.*;
import java.io.*;

public class matthew{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("matthew".toLowerCase()+".dat"));
        while(f.hasNext()) {
            String[] words = f.nextLine().trim().split("\\s+");
            int times=f.nextInt(); f.nextLine();
            while(times-->0){
                String reg = f.nextLine().trim();
                reg = reg.replaceAll("\\*", ".*");
                reg = reg.replaceAll("\\?", ".");
                String out = "";
                for(String s : words){
                    if(s.matches(reg)) out+=s+" ";
                }
                if(out.equals("")) System.out.println("NONE");
                else {
                    System.out.println(out.trim());
                }
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new matthew().run();
    }
}
