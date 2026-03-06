import java.util.*;
import java.io.*;
import java.awt.*;

public class Ben{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Ben".toLowerCase()+".dat"));
        HashMap<String, Integer> vals = new HashMap<>();
        vals.put("A", 11);
        vals.put("K", 10);
        vals.put("Q", 10);
        vals.put("J", 10);
        for (int i = 2; i <= 10; i++) {
            vals.put(i+"", i);
        }
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String[] ln = f.nextLine().trim().split("\\s+");
            int aces = 0;
            int val = 0;
            for(String s : ln){
                if(s.equals("A")) aces++;
                val+=vals.get(s);
            }
            while(val > 21 && aces > 0){
                val-=10;
                aces--;
            }
            if(val == 21){
                System.out.println("Blackjack");
            }
            else if(val >21){
                System.out.println("Bust");
            }
            else{
                System.out.println("Score: "+val);
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Ben().run();
    }
}
