import java.util.*;
import java.io.*;

public class janice{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("janice".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String actual = f.nextLine();
            String encoded = f.nextLine();
            String str = f.nextLine();

            int shift = 0;
            for (int i = 0; i < actual.length(); i++) {
                if (actual.charAt(i) >= 'A' && actual.charAt(i) <= 'Z') {
                    shift = actual.charAt(i) - encoded.charAt(i);
                    break;
                }
            }

            String res = "";
            for (char ch : str.toCharArray()) {
                if (ch >= 'A' && ch <= 'Z') res += (char)((26 + ch - 'A' + shift) % 26 + 'A');
                else res += ch;
            }
            System.out.println(res);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new janice().run();
    }
}
