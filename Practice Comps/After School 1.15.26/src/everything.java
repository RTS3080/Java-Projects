import javax.xml.transform.sax.SAXSource;
import java.util.*;
import java.io.*;
import java.awt.*;

public class everything{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("everything".toLowerCase()+".dat"));

        int cases = f.nextInt();
        while(cases-->0){
            int numProb = f.nextInt();
            int numTime = f.nextInt();
            int numReed = f.nextInt();

            int[][][] dp = new int[numProb+1][numTime+1][numReed+1];
            ArrayList<String>[][][] chosen = new ArrayList[numProb+1][numTime+1][numReed+1];
            for (int i = 0; i < numProb+1; i++){
                for (int j = 0; j < numTime+1; j++){
                    for (int k = 0; k < numReed+1; k++){
                        chosen[i][j][k] = new ArrayList<String>();
                    }
                }
            }

            int max = 0;
            ArrayList<String> result = new ArrayList<>();

            for (int i = 1; i < numProb+1; i++){
                String name = f.next().trim();
                int time = f.nextInt();
                int reed = f.nextInt();
                int value = f.nextInt();

                for (int r = 1; r < numTime+1; r++){
                    for (int c = 1; c < numReed+1; c++){
                        dp[i][r][c] = dp[i-1][r][c];

                        chosen[i][r][c] = new ArrayList<String>(chosen[i-1][r][c]);

                        if (r - time >= 0 && c - reed >= 0){
                            if (dp[i-1][r - time][c - reed] + value > dp[i][r][c]){
                                dp[i][r][c] = dp[i-1][r - time][c - reed] + value;

                                ArrayList<String> temp = new ArrayList<>(chosen[i-1][r - time][c - reed]);
                                chosen[i][r][c] = temp;
                                temp.add(name);
                            }
                        }

                        if (dp[i][r][c] > max){
                            max = dp[i][r][c];
                            result = chosen[i][r][c];
                        }
                    }
                }
            }

            Collections.sort(result);

            System.out.print(max+":");
            for (String s : result){
                System.out.print(" "+s);
            }
            System.out.println();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new everything().run();
    }
}
