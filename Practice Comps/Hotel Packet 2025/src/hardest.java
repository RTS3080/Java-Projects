import java.util.*;
import java.io.*;
import java.awt.*;

public class hardest{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("hardest".toLowerCase()+".dat"));
        while(f.hasNext()){
            String ln = f.nextLine();
            if(ln.equals("ENDOFINPUT")) return;
            String str = f.nextLine().trim();
            String out = "";
            for (int i = 0; i < str.length(); i++) {
                if(Character.isLetter(str.charAt(i))) {
                    char c = str.charAt(i);
                    int pos = c-'A';
                    pos = (pos+21)%26;
                    out += (char)('A'+pos);
                }
                else{
                    out += str.charAt(i);
                }
            }
            System.out.println(out);
            f.nextLine();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new hardest().run();
    }
}
