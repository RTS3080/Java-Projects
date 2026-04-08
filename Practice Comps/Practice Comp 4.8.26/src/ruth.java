import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class ruth{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("ruth".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int numTimes=f.nextInt();
        f.nextLine();

        for(int times = 0; times < numTimes; times++){
            int N = f.nextInt();
            int M = f.nextInt();
            int H = f.nextInt();
            int S = f.nextInt();
            f.nextLine();

            String[] array = f.nextLine().trim().split("\\s+");

            int count = 0;

            for (int i = 0; i < N; i++) {
                if (!array[i].equals("HIT")) continue;
                int plays = 1;
                int hits = 1;
                int score = 1;

                for (int j = i + 1; j < N; j++) {
                    if (array[j].equals("HIT")) {
                        hits++;
                        score++;
                    } else {
                        score--;
                    }

                    plays++;

                    if (plays >= M && hits >= H && array[j].equals("HIT") && score >= S) {
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new ruth().run();
    }
}
