import java.util.*;
import java.io.*;

public class prob04{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("prob04".toLowerCase()+".in.txt"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String ln = f.nextLine();
            int rock = 0;
            int paper = 0;
            int scissors = 0;
            for(int i = 0; i < ln.length(); i++){
                if(ln.charAt(i) == 'P'){
                    paper++;
                }
                else if(ln.charAt(i) == 'S'){
                    scissors++;
                }
                else if(ln.charAt(i) == 'R'){
                    rock++;
                }
            }
            boolean r = !ln.contains("P");
            boolean p = !ln.contains("S");
            boolean s = !ln.contains("R");
//            System.out.println(r+" "+p+" "+s);
            if(rock==1&& !p && !s && r){
                System.out.println("ROCK");
            }
            else if(!r && paper==1 && !s && p){
                System.out.println("PAPER");
            }
            else if(!r && !p && scissors==1 && s){
                System.out.println("SCISSORS");
            }
            else System.out.println("NO WINNER");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob04().run();
    }
}
