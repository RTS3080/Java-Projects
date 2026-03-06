import java.util.*;
import java.io.*;

public class news{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("news".toLowerCase()+".dat"));
        String[] villians = "Magneto Juggernaut Apocalypse Mystique Sentinels".split(" ");
        String[] threats = "Thanos Galactus Kang Ultron Graviton".split(" ");
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String ln = f.nextLine();
            boolean vil = false;
            boolean thr = false;
            for(String s : villians){
                for(String str : ln.split(" ")){
                    vil|=str.equals(s);
                }
            }
            for(String s : threats){
                for(String str : ln.split(" ")){
                    thr|=str.equals(s);
                }
            }
            if(thr){
                System.out.println("Calling All Heroes.");
            }
            else if(vil){

                System.out.println("Sharpen Your Claws Wolverine.");
            }
            else System.out.println("Business as Usual.");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new news().run();
    }
}
