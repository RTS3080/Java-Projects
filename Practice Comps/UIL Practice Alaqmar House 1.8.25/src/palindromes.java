import java.util.*;
import java.io.*;

public class palindromes{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("pals".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        timeloop:
        while(times-->0){
            int a = f.nextInt();
            int digis = f.nextInt();
            int start =(int) Math.pow(10,digis-1)/a;
            start++;
            int count = 0;
            for (int i = start; (a*i+"").length()==digis; i++) {
                if(isPal(a*i))
                    count++;
            }
            System.out.println(count);
        }
        f.close();
    }

    public boolean isPal(int a){
        String n = ""+a;
        for (int i = 0; i < n.length(); i++) {
            if(n.charAt(i)!=n.charAt(n.length()-1-i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException{
        new palindromes().run();
    }
}
