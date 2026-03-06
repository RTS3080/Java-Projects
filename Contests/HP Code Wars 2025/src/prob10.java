import java.util.*;
import java.io.*;

public class prob10{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        ArrayList<String> strs = new ArrayList<>();
        while(f.hasNext()){
            String s=f.nextLine().trim();
            if(s.equals("000")) break;
            strs.add(s);
        }
        for(String s : strs){
            String str = "";
            for(int i=0; i<s.length(); i++){
                if(Character.isAlphabetic(s.charAt(i))){
                    String a = s.substring(i,i+1);
                    if(a.equals(a.toUpperCase())){
                        str+=a.toLowerCase();
                    }
                    else{
                        str+=a.toUpperCase();
                    }
                }
                else str+=s.charAt(i);
            }
            System.out.println(str);
        }
         f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob10().run();
    }
}
