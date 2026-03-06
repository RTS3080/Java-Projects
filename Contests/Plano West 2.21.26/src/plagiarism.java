import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class plagiarism{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("plagiarism".toLowerCase()+".in"));
        ArrayList<String> restricted = new ArrayList<>();
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String s= f.nextLine().trim();
            restricted.add(s);
        }
        times=f.nextInt(); f.nextLine();
        while(times-->0){
            String ln = f.nextLine();
            boolean ok = true;
            for(String str: restricted){
                if(str.equals(ln)){
                    ok = false;
                }
            }
            if(ok){
                System.out.println(ln);
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new plagiarism().run();
    }
}
