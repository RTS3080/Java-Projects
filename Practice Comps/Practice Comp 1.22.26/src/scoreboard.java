import java.util.*;
import java.io.*;
import java.awt.*;

public class scoreboard{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("scoreboard".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        int[] scores = new int[3];
        while(times-->0){
            int a = f.nextInt();
            int b = f.nextInt();
            if(a > b){
                System.out.println("Win");
                scores[0]++;
            }
            else if(b > a){
                System.out.println("Loss");
                scores[2]++;
            }
            else{
                System.out.println("Tie");
                scores[1]++;
            }
        }
        System.out.println(scores[0]+"-"+scores[1]+"-"+scores[2]);
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new scoreboard().run();
    }
}
