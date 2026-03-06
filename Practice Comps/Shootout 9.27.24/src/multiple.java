import java.util.*;
import java.io.*;

public class multiple{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("multiple".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            long num = f.nextLong();
            String noDigi = f.next();
            int i = 2;
            while(true){
                long a = num * i;
                if(!(""+a).matches(".*["+noDigi+"].*")){
                    System.out.println(a);
                    break;
                }
                i++;
            }
        }
        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new multiple().run();
    }
}
