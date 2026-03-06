import java.util.*;
import java.io.*;

public class scammers {

    public static void main(String[] args) throws Exception {
        new scammers().run();
    }

    public void run() throws Exception {
        Scanner in = new Scanner(new File("scammers.dat"));
        int cases = in.nextInt();
        in.nextLine();

        String l = "";

        for (int i = 0; i < cases; i++) {
            String line = "";
            if(l.isEmpty()){
                line+=in.nextLine()+" ";
            }
            else{
                line = l;
            }

            while(in.hasNext()){
                String t = in.nextLine();
                if(t.contains(":")){
                    l = t;
                    break;
                }
                line+=t+" ";
            }

            System.out.println(line.trim().toLowerCase().matches(".*s.*c.*a.*m.*") ? line.substring(0, line.indexOf(":")) + " is a scammer!" : line.substring(0, line.indexOf(":")) + " is safe to text.");
        }

    }
}
