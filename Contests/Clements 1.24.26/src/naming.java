import java.util.*;
import java.io.*;

public class naming{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("naming".toLowerCase()+".in"));

        int times=f.nextInt(); f.nextLine();

        String a = f.next();
        String b = f.next();

        while(times-->0){
            int action = f.nextInt();
            if (action == 1) {
                int k = f.nextInt() - 1;
                int i = f.nextInt() - 1;
                String ch = f.next();

                if (k == 0) {
                    a = a.substring(0, i) + ch + a.substring(i + 1);
                } else {
                    b = b.substring(0, i) + ch + b.substring(i + 1);
                }
            } else {
                int i = f.nextInt() - 1;
                int j = f.nextInt() - 1;
                int len = f.nextInt();

                if (a.substring(i, i + len).equals(b.substring(j, j + len))) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new naming().run();
    }
}
