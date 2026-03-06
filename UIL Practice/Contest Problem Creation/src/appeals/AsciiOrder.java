package appeals;

import java.io.*;
import java.util.*;

public class AsciiOrder {
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(new File("Judge Data\\asciiOrder.dat")); //placeholder for the actual .dat file

        while (input.hasNextLine()) {
            int asciiCodes = input.nextInt();
            int[] nums = new int[asciiCodes];
            for (int i = 0; i < asciiCodes; i++) {
                nums[i] = input.nextInt();
            }

            Arrays.sort(nums);
            for (int i = 0; i < asciiCodes; i++) {
                System.out.print((char) nums[i]);

            }
            System.out.println();
        }

        input.close();
    }
}
