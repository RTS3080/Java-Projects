import java.util.*;
import java.io.*;

public class planetx{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int gleeb = 0;
            int glorb = 0;
            String s= f.nextLine();
            for (int i = 0; i < s.length()-5; i++) {
                if(s.substring(i,i+5).equals("glorb")){
                    glorb++;
                }
                if(s.substring(i,i+5).equals("gleeb")){
                    gleeb++;
                }
            }
            System.out.println(gleeb+" "+glorb);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new planetx().run();
    }
}
