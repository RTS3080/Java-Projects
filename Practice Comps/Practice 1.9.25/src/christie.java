import com.sun.security.jgss.GSSUtil;

import java.util.*;
import java.io.*;

public class christie{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("christie".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        timeloop:
        while(times-->0){
            int start = f.nextInt();
            int end = f.nextInt();
            boolean printed = false;
            for(int i=start; i<=end; i++){
                String n = ""+i;
                int sum = 0;
                for(char c : n.toCharArray()){
                    int a = c-'0';
                    sum+=a*a;
                }
                String s = Math.sqrt(sum)+"";
                if(s.matches("[0-9]*\\.0+")){
                    System.out.print(i+" ");
                    printed = true;
                }
            }
            if(!printed){
                System.out.println("NONE");
            }
            System.out.println();
        }
        f.close();
    }




    public static void main(String[] args) throws FileNotFoundException{
        new christie().run();
    }
}
