import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class rufus{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("rufus".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int numStudents = f.nextInt();
        int numQuiz = f.nextInt();

        f.nextLine();

        while (numQuiz-- > 0){
            String correctAns = f.nextLine().trim();

            String[] words = new String[numStudents];
            for (int i = 0; i < numStudents; i++) words[i] = f.nextLine().trim();

            double score = 0.0;
            for (int i = 0; i < numStudents; i++){
                int editDis = editDis(correctAns.toUpperCase(), words[i].toUpperCase());
                score += correctAns.length() - editDis;
            }


            System.out.printf("%s Quiz Average: %.2f\n", correctAns, score/numStudents);
        }

        f.close();
    }

    public int editDis(String str1, String str2){
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for (int r = 0; r < dp.length; r++) dp[r][0] = r;
        for (int c = 0; c < dp[0].length; c++) dp[0][c] = c;

        for (int r = 1; r < dp.length; r++){
            for (int c = 1; c < dp[0].length; c++){
                dp[r][c] = Integer.MAX_VALUE;
                if (str1.charAt(r-1) == str2.charAt(c-1)){
                    dp[r][c] = dp[r-1][c-1];
                }
                dp[r][c] = Math.min(dp[r][c], dp[r-1][c]+1);
                dp[r][c] = Math.min(dp[r][c], dp[r][c-1]+1);
                dp[r][c] = Math.min(dp[r][c], dp[r-1][c-1]+1);

            }
        }

        return dp[str1.length()][str2.length()];
    }



    public static void main(String[] args) throws FileNotFoundException{
        new rufus().run();
    }
}
