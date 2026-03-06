import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class decrypt{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("decrypt".toLowerCase()+".dat"));
        while(f.hasNext()){
            String ln = f.next().trim();
            int num = Integer.parseInt(ln.split(" ")[1]);
            String out = "";
            String msg = "";
            double d = (num*8)/64.;
            int a= (num*8)/64;
            if(d%1>0){
                a++;
            }
            for (int i = 0; i < a; i++) {
                msg+=f.next();
            }
            msg+=" ";
            f.nextLine();
            for (int i = 0; i < (num)*8; i+=8) {
                char ch = (char) Integer.parseInt(msg.substring(0, 8), 2);
                msg = msg.substring(8);
                out += ch;
            }
            System.out.println(ln);
            System.out.println(out);

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new decrypt().run();
    }
}
