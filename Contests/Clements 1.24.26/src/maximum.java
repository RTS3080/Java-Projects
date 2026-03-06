import java.util.*;
import java.io.*;

public class maximum{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("maximum".toLowerCase()+".in"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int totDamage1 = f.nextInt() + f.nextInt() + f.nextInt();
            int totKills1 = f.nextInt() + f.nextInt() + f.nextInt();
            int totDamage2 = f.nextInt() + f.nextInt() + f.nextInt();
            int totKills2 = f.nextInt() + f.nextInt() + f.nextInt();
            int diffDamage = totDamage1 - totDamage2;
            int diffKills = totKills1 - totKills2;
            if(diffDamage > 0){
                System.out.println("TEAM 1");
            }
            else if(diffDamage < 0){
                System.out.println("TEAM 2");
            }
            else if (diffDamage == 0){
                if(diffKills > 0){
                    System.out.println("TEAM 1");
                }
                else if(diffKills < 0){
                    System.out.println("TEAM 2");
                }
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new maximum().run();
    }
}
