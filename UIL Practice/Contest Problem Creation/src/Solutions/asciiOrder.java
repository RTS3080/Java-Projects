package Solutions;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class asciiOrder {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("asciiOrder.dat"));

        // Keep going until we run out of test cases
        while (input.hasNextInt()) {
            int n = input.nextInt(); // number of values
            ArrayList<Integer> asciiList = new ArrayList<>();

            // read n integers
            for (int i = 0; i < n; i++) {
                if (input.hasNextInt()) {
                    asciiList.add(input.nextInt());
                }
            }

            // sort them
            Collections.sort(asciiList);

            // print characters on one line
            for (int value : asciiList) {
                System.out.print((char) value);
            }
            System.out.println(); // move to next line for next test case
        }

        input.close();
    }
}