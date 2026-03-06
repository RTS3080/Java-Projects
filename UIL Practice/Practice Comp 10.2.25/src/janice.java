import java.util.*;
import java.io.*;
import java.awt.*;
import java.util.List;

public class janice{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("janice".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String s1 = f.nextLine().toUpperCase();
            String s2 = f.nextLine().toUpperCase();
            int difference = -s1.charAt(0)+s2.charAt(0);
            List<String> shift = Arrays.asList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));
            Collections.rotate(shift, difference);
            String str = f.nextLine();
            String out = "";
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i)!=' ') {
                    out += shift.get(str.charAt(i) - 'A');
                }
                else out+=" ";
            }
            System.out.println(out.trim());
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new janice().run();
    }
}
