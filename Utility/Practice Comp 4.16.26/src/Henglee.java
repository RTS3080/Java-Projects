import java.util.*;
import java.io.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.*;


public class Henglee{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Henglee".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            String[] s = f.nextLine().split("\\|", 2);
            String out = "";
            int count = 0;
            for (int i = 1; i < s.length; i++) {
                Pattern p = Pattern.compile(s[i]);
                Matcher m = p.matcher(s[0]);
                while(m.find()){
                    out+=m.group()+",";
                    count++;
                }
            }

            if(count==0){
                System.out.println(0);
            }
            else {
                System.out.println(count + " " + out.substring(0, out.length() - 1));
            }

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Henglee().run();
    }
}
