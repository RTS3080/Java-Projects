import java.util.*;
import java.io.*;
import java.awt.*;

public class botany{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("botany".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int rowsAvailable = f.nextInt();
            int colsAvailable = f.nextInt();
            int yieldRequired = f.nextInt();
            int seasonRequired = 0;
            String season = f.next();
            String[] seasons = "Winter Spring Summer Fall".split(" ");
            for (int i = 0; i < seasons.length; i++) {
                if (seasons[i].equals(season)) {
                    seasonRequired = i;
                    break;
                }
            }

            int[][] spaceRequired = new int[][] {{1, 1}, {2, 1}, {2, 2}, {3, 1}, {3, 2}, {4, 1}};
            int[][] seasonalYields = new int[][] {{1, 1, 1, 1}, {2, 2, 2, 4}, {0, 2, 3, 0}, {2, 4, 6, 2}, {4, 5, 6, 5}, {2, 5, 7, 4}};

            String[] crops = {"Carrots", "Potatoes", "Tomatoes", "Corn", "Squash", "Beans"};

            int[] yields = new int[6];
            ArrayList<Integer> res = new ArrayList<>();

            for (int i = 0; i < 6; i++) {
                int rowsPossible = rowsAvailable / spaceRequired[i][0];
                int colsPossible = colsAvailable / spaceRequired[i][1];
                int yield = 0;
                if (rowsPossible > 0 && colsPossible > 0) {
                    yield = rowsPossible * colsPossible;
                }

                rowsPossible = colsAvailable/spaceRequired[i][0];
                colsPossible = rowsAvailable/spaceRequired[i][1];
                if (rowsPossible > 0 && colsPossible > 0) {
                    yield = Math.max(yield, rowsPossible * colsPossible);
                }

                yield *= seasonalYields[i][seasonRequired];

                yields[i] = yield;
                if (yield >= yieldRequired) {
                    res.add(i);
                }


                System.out.println(crops[i] + " " + yield);
            }

            res.sort(Comparator.comparingInt((a) -> -yields[a]));

            if (res.isEmpty()) {
                System.out.println("It's space, it doesn't cooperate.");
            } else {
                System.out.println("I am the greatest botanist on this planet");
                String output = "";
                for (int idx : res) {
                    output += crops[idx] + ", ";
                }
                System.out.println(output.substring(0, output.length() - 2));
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new botany().run();
    }
}
