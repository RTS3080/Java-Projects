import java.util.*;
import java.io.*;
import java.awt.*;

public class shreya{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("shreya".toLowerCase()+".dat"));

        int cases = f.nextInt();
        f.nextLine();

        while(cases-->0){
            String[] line = f.nextLine().split("\\s+");
            int[] coins = new int[line.length];

            for(int i = 0; i < line.length; i++){
                coins[i] = Integer.parseInt(line[i]);
            }

            int target = f.nextInt();
            f.nextLine();

            boolean[] possible = new boolean[target+1];
            possible[0] = true;

            for (int coin:coins){
                for (int i = target; i >= 0; i--) {
                    if (i + coin <= target && possible[i]){
                        possible[i+coin] = true;
                    }
                }
            }

            System.out.println(possible[target] ? "Business as usual." : "Dine and Dash.");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new shreya().run();
    }
}
