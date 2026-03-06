import java.util.*;
import java.io.*;

public class brawler{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("brawler".toLowerCase()+".in"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String name = f.next();
            boolean b = true;
            b &= name.length() >=2 && name.length() <= 10;
            b &= Character.isUpperCase(name.charAt(0));
            b &= name.toLowerCase().matches(".*[aeiou].*");
            b &= !name.matches(".*(.)(\\1)(\\1).*");
            System.out.println(b ? "VALID" : "REJECTED");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new brawler().run();
    }
}
