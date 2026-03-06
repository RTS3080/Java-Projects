import java.util.*;
import java.io.*;
import java.awt.*;

public class kiran{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("kiran".toLowerCase()+".dat"));
        while(f.hasNext()){
            String teamName= f.next();
            System.out.println("TEAM REPORT: "+teamName);
            System.out.println("-".repeat(48));
            System.out.printf("%-15s%-6s%-6s%s\n", "Player", "K", "D", "Ratio");
            long totKills = 0;
            int times=f.nextInt(); f.nextLine();
            while(times-->0){
                String name = f.next();
                long kills = f.nextLong();
                long deaths = f.nextLong();
                double ratio = (double)kills / Math.max(deaths, 1L);
                if(ratio >=2){
                    name +=" (MVP)";
                }
                System.out.printf("%-15s%-6d%-6d%.2f\n", name, kills, deaths, ratio);
                totKills+=kills;
            }
            System.out.println("-".repeat(48));
            System.out.println("Total Team Kills: "+totKills);
            System.out.println();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new kiran().run();
    }
}
