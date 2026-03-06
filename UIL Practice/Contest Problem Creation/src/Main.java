import java.util.*;
import java.io.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.out;

public class Main{

    public void run() throws FileNotFoundException{
        String d = "jz-num:212fdua0-fslnum432:"
                + "142fja423:7391fak_num:243dfs";
        Pattern p =
                Pattern.compile(
                        "num:(\\d+)");
        Matcher m = p.matcher(d);
        int x = 0;
        while (m.find()) {
            x += Integer.parseInt(m.group(1));
        } out.println(x);

    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new Main().run();
    }
}
