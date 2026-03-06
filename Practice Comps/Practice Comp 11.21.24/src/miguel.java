import java.util.*;
import java.io.*;

public class miguel{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("miguel".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String str = f.nextLine();
            char[] ch = str.replaceAll("[^a-zA-Z]", "").toLowerCase().toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);
            String res = "";
            int j = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.substring(i, i+1).matches("[a-zA-Z]")) {
                    if (Character.isUpperCase(str.charAt(i)))
                        res += (sorted.charAt(j++) + "").toUpperCase();
                    else res += sorted.charAt(j++);
                } else res += str.charAt(i);
            }
            System.out.println(res);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new miguel().run();
    }
}
