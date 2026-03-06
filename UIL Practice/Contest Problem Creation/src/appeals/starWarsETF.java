package appeals;

import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class starWarsETF {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("Judge Data\\starWarsETF.dat"));

        int num = sc.nextInt();
        sc.nextLine();

        for (int x = 0; x < num; x++) {
            int profit = 0;
            int numLevels = sc.nextInt();
            sc.nextLine();
            int[] ys = new int[numLevels];
            for (int y = 0; y < numLevels; y++) {
                ys[y] = sc.nextInt();
            }
            if (x != num - 1) {
                sc.nextLine();
            }

            for (int z = 0; z < ys.length-1; z++) {
                if (ys[z + 1] > ys[z]) {
                    profit += ys[z+1] - ys[z];
                }
            }

            System.out.println(profit == 0 ? "This is not the trade you’re looking for" : profit);
        }
    }
}