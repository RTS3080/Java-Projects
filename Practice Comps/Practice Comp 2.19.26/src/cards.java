import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class cards{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("cards".toLowerCase()+".dat"));

        int cases = f.nextInt();
        while (cases-- > 0) {
            int numCards = f.nextInt();
            int target = f.nextInt();

            int[] dp = new int[target+1];
            Arrays.fill(dp,Integer.MAX_VALUE);
            dp[0] = 0;

            //ALEX
            for (int i = 0; i < numCards; i++) {
                String card = f.next();
                for (int ind = target; ind >= 0; ind--) {
                    if (dp[ind] == Integer.MAX_VALUE) continue;

                    if (card.matches("[1-9]")){
                        int add = Integer.parseInt(card);
                        if (ind + add <= target){
                            dp[ind+add] = Math.min(dp[ind+add], dp[ind] + 1);
                        }
                    }
                    if (card.matches("[TJQK]")){
                        int add = 10;
                        if (ind + add <= target){
                            dp[ind+add] = Math.min(dp[ind+add], dp[ind] + 1);
                        }
                    }
                    if (card.matches("A")){
                        int add = 1;
                        if (ind + add <= target){
                            dp[ind+add] = Math.min(dp[ind+add], dp[ind] + 1);
                        }

                        add = 11;
                        if (ind + add <= target){
                            dp[ind+add] = Math.min(dp[ind+add], dp[ind] + 1);
                        }
                    }
                }
            }

            int alexScore = dp[target];

            Arrays.fill(dp,Integer.MAX_VALUE);
            dp[0] = 0;

            //BEN
            for (int i = 0; i < numCards; i++) {
                String card = f.next();
                for (int ind = target; ind >= 0; ind--) {
                    if (dp[ind] == Integer.MAX_VALUE) continue;

                    if (card.matches("[1-9]")){
                        int add = Integer.parseInt(card);
                        if (ind + add <= target){
                            dp[ind+add] = Math.min(dp[ind+add], dp[ind] + 1);
                        }
                    }
                    if (card.matches("[TJQK]")){
                        int add = 10;
                        if (ind + add <= target){
                            dp[ind+add] = Math.min(dp[ind+add], dp[ind] + 1);
                        }
                    }
                    if (card.matches("A")){
                        int add = 1;
                        if (ind + add <= target){
                            dp[ind+add] = Math.min(dp[ind+add], dp[ind] + 1);
                        }

                        add = 11;
                        if (ind + add <= target){
                            dp[ind+add] = Math.min(dp[ind+add], dp[ind] + 1);
                        }
                    }
                }
            }

            int benScore = dp[target];

            if (alexScore < benScore){
                System.out.println("Alex Wins!");
            }
            else if (alexScore > benScore){
                System.out.println("Ben Wins!");
            }
            else{
                System.out.println("Tie Game!");
            }
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new cards().run();
    }
}
