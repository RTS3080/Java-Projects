import java.util.*;
import java.io.*;

public class speedlimit{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String[] ln = f.nextLine().split("\\s+");
            String str = "";
            for(String s : ln){
                int n = Integer.parseInt(s);
                if(n >= 10 && n <=100){
                    str+="safe";
                }
                else str+="unsafe";
                str+=" ";
            }
            System.out.println(str.trim());
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new speedlimit().run();
    }
}
