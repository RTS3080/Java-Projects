import java.util.*;
import java.io.*;

public class prob14{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("prob14".toLowerCase()+".in.txt"));
        f.nextLine();
        f.nextLine();
        int[] ups = Arrays.stream(f.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        f.nextLine();
        int[] lows = Arrays.stream(f.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] uppers = new String[ups.length];
        String[] lowers = new String[lows.length];
        String uppercase = "";
        String lowercase = "";
        while(f.hasNext()) {
            String s = f.nextLine().trim();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '-') {
                    uppercase += " ";
                } else if (s.charAt(i) == '=') {
                    lowercase += " ";
                } else if (s.substring(i, i + 1).matches("[A-Z]")) {
                    uppercase += s.substring(i, i + 1);
                } else if (s.substring(i, i + 1).matches("[a-z]")) {
                    lowercase += s.substring(i, i + 1);
                }
            }

        }
        int j = 0;
        for (int i = 0; i < ups.length; i++) {
            int len = ups[i];
            String str = "";
            while(len-->0){
                str+=uppercase.charAt(j++);

            }
            System.out.println(str);
        }
        System.out.println();
        j = 0;
        for (int i = 0; i < lows.length; i++) {
            int len = lows[i];
            String str = "";
            while(len-->0){
                str+=lowercase.charAt(j++);

            }
            System.out.println(str);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob14().run();
    }
}
