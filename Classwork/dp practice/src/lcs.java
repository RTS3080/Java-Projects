import java.util.*;
import java.io.*;

public class lcs{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("lcs".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String s1 = f.next();
            String s2=f.next();
            System.out.println(recur(s1,s2,s1.length(),s2.length()));
        }
        f.close();
    }

    int recur(String s1, String s2, int n,int m){
        if(n==0 || m==0){
            return 0;
        }
        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return 1+ recur(s1,s2,n-1,m-1);
        }
        return Math.max(recur(s1,s2,n-1,m),recur(s1,s2,n,m-1));
    }
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new lcs().run();
    }
}
