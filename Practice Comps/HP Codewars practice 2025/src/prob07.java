import java.util.*;
import java.io.*;

public class prob07{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("prob07".toLowerCase()+".in.txt"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int times2=f.nextInt(); f.nextLine();
            boolean[] good = new boolean[times2];
            Arrays.fill(good, true);
            for (int j = 0; j < times2; j++) {
                String s= f.nextLine().toLowerCase();
                for(int i=0; i<s.length()/2; i++){
                    if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                        good[j]=false;
                    }
                }
            }
            boolean allGood=true;
            for(int i=0; i<good.length; i++){
                allGood&=good[i];
            }
            if(allGood){
                System.out.println("True");
            }
            else{
                System.out.print("False - ");
                String bad = "";
                for(int i=0; i<good.length; i++){
                    if(!good[i]){
                        bad+=i+1+", ";
                    }
                }
                System.out.println(bad.substring(0,bad.length()-2));
            }
        }
        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new prob07().run();
    }
}
